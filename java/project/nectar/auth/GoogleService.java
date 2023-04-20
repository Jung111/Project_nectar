package project.nectar.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import project.nectar.domain.UserDto;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GoogleService {

    private OAuth20Service oauthService;
    private String profileUrl;

    public GoogleService(SnsValue sns) {
        this.oauthService = new ServiceBuilder(sns.getClientId())
                .apiSecret(sns.getClientSecret())
                .callback(sns.getRedirectUrl())
                .scope("profile")
                .build(sns.getApi20Instance());

        this.profileUrl = sns.getProfileUrl();

    }

    public UserDto getUserProfile(String code) throws IOException, ExecutionException, InterruptedException {

        OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
        OAuthRequest request = new OAuthRequest(Verb.GET, this.profileUrl);
        oauthService.signRequest(accessToken, request);
        Response response = oauthService.execute(request);
        return parseJson(response.getBody());

    }


    private UserDto parseJson(String body) throws IOException {

        UserDto user = new UserDto();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(body);


        String email = rootNode.get("email").asText();
        String pwd = rootNode.get("sub").asText();
        String name = rootNode.get("name").asText();
        String picture = rootNode.get("picture").asText();

        user.setUser_email(email);
        user.setUser_pwd(pwd);
        user.setUser_name(name);
        user.setUser_picture(picture);

        return user;

    }
}

package project.nectar.auth;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.DefaultApi20;
import lombok.Data;

@Data
public class SnsValue implements SnsUrl {

    private String service;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private DefaultApi20 api20Instance;
    private String profileUrl;

    public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) {
        this.service = service;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
        this.api20Instance = GoogleApi20.instance();
        this.profileUrl = GOOGLE_PROFILE_URL;

    }

}

package project.nectar.auth;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;



import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import project.nectar.domain.UserDto;

import javax.servlet.http.HttpSession;


public class KakaoService {
    public static String getReturnAccessToken(String code) {
        String access_token = "";
        String refresh_token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //HttpURLConnection 설정 값 셋팅
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);


            // buffer 스트림 객체 값 셋팅 후 요청
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();

            sb.append("grant_type=authorization_code");
            sb.append("&client_id="+CLIENT_ID);  //앱 KEY VALUE
            sb.append("&redirect_uri="+REDIRECT_URI); // 앱 CALLBACK 경로
            sb.append("&code=" + code);

            bw.write(sb.toString());
            bw.flush();


            //  RETURN 값 result 변수에 저장
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String br_line = "";
            String result = "";

            while ((br_line = br.readLine()) != null) {
                result += br_line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);


            // 토큰 값 저장 및 리턴
            access_token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();

            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        return access_token + refresh_token;
        return access_token;
    }



    public static UserDto getUserInfo(String access_token) {
//        HashMap<String, Object> resultMap = new HashMap<>();
        UserDto userInfo = new UserDto();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String br_line = "";
            String result = "";

            while ((br_line = br.readLine()) != null) {
                result += br_line;
            }
            System.out.println("response:" + result);


            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            System.out.println("element:: " + element);

            // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();


            String user_email = kakao_account.getAsJsonObject().get("email").getAsString();
            String user_pwd = element.getAsJsonObject().get("id").getAsString();
            String user_name = properties.getAsJsonObject().get("nickname").getAsString();
//            String user_picture = properties.getAsJsonObject().get("profile_image_url").getAsString();

            System.out.println("user_email:: " + user_email);
            System.out.println("user_pwd:: " + user_pwd);
            System.out.println("user_name:: " + user_name);
//            System.out.println("user_picture:: " + user_picture);

            userInfo.setUser_email(user_email);
            userInfo.setUser_pwd(user_pwd);
            userInfo.setUser_name(user_name);
//            userInfo.setUser_picture(user_picture);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }





    private final static String CLIENT_ID = "795e0accee261f79ea3ba9064a0c8cda";

    private final static String REDIRECT_URI = "http://localhost:8080/nectar/login/auth/kakao/callback";

    public static String getAuthorizationUrl() {
        String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?" + "client_id=" + CLIENT_ID + "&redirect_uri="
                + REDIRECT_URI + "&response_type=code";
        return kakaoUrl;
    }


}
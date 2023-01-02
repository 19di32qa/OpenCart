package demoOpenCard.Tools;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.poi.poifs.crypt.agile.AgileEncryptionVerifier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API {
    private final String myIP = "127.0.0.1";
    public String url ="http://"+myIP+"/demoOpenCard/upload/index.php?route=";
    private final String username = "Demo";
    private final String key = "JcDwlKiZqymPEiOjtHkiXeqc7PNj3tcYMHjYRytWMF2C3RDVIQ3FfrJPjhZfFLSe3xsTBJ8784YZwGlmNmuhAndS7786Y4vxoBRqPArFuiww0FFmxFBHHn8mP0TPT67DNudcq7ELmHtBiX1h0xUyzBIsKtJU3RiT3G64f66qLZTGlAPCgGqnnjVNYdGwcghjcux6JkQ75g5MEvvj0MGgdsnvHsCKHKBWlpNy5GNHiTKKh5G3B3NobKudQURlalxX";
    public String apiToken ="";



    @BeforeClass
    public void SetSession() {
        //String key = "Ikj8Iro5SN4wRc7XaXifVdloDJOOvvMWWiun4AMICJ8DiOAqXGQZxRr38lsg63VHXkWiPRlAczPzaHTcFNxduSbBoWOETnwCZ1Cz85qd5fFec7jpbLEapJRsHA1XWyml8aDNi7MGM0MP6oY2jbo8IqUtBDKSk8vv3KAGcJ7PHc3yUsDaSBHuFXY861TYbA8OifTAGNqtqewLTdwX5bIjbSXcxymr6SNat5BkjVOrqHFzotCKTLm2HX6NognhwrjJ";

        Response response= given().contentType("multipart/form-data").multiPart("username",username).multiPart("key",key)
                .when().post(url+"=api/account/login");
        JsonPath jsonPath = response.body().jsonPath();
        //System.out.println((String) jsonPath.get("api_token"));
        apiToken = jsonPath.get("api_token");
        System.out.println(apiToken);
    }
}

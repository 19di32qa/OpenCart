package demoOpenCard.TestCases;

import demoOpenCard.Tools.API;
import demoOpenCard.Tools.BaseClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC21_Reward extends API {

    @Test
    public void addRewardTest() {
        given().queryParam("api_token",apiToken)
                .post(url+"api/sale/reward").then().assertThat()
                .body("success", equalTo("Success: Your reward points discount has been removed!"));
    }
    @Test
    public void rewardMaxTest() {
        given().queryParam("api_token",apiToken)
                .post(url+"api/sale/reward.maximum").then().log().body();
    }
    @Test
    public void rewardAvailableTest() {
        given().queryParam("api_token",apiToken)
                .post(url+"api/sale/reward.available").then().log().body();
    }
}

package demoOpenCard.TestCases;

import demoOpenCard.Tools.API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC20_OrderDelete extends API {

    @Test
    public void setOrderTest() {
        given().queryParam("api_token",apiToken)
                .post(url+"api/sale/order.delete").then().assertThat()
                .body("success", equalTo("Success: You have modified orders!"));

    }
}

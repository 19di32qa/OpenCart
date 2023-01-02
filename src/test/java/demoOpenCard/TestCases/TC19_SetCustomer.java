package demoOpenCard.TestCases;

import demoOpenCard.Tools.API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC19_SetCustomer extends API {
    @Test
    public void setCustomerTest() {
        given().queryParam("api_token",apiToken).contentType("multipart/form-data")
                .multiPart("firstname","John").multiPart("lastname","Snow")
                .multiPart("email","JohnSnow+1@example.com")
                .post(url+"api/sale/customer").then().log().body();
        applyVoucher();

    }
    public void applyVoucher() {
        given().queryParam("api_token",apiToken).contentType("multipart/form-data")
                .multiPart("voucher","12345678")
                .post(url+"api/sale/voucher").then().log().body();
    }

}

package demoOpenCard.TestCases;

import demoOpenCard.Tools.API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC22_PaymentAddress extends API {
    @Test
    public void paymentAddressTest() {
        given().queryParam("api_token",apiToken).contentType("multipart/form-data")
                .multiPart("firstname","John").multiPart("lastname","Snow")
                .multiPart("address_1","JohnSnow+1@example.com").multiPart("city","LON")
                .multiPart("country_id","UK").multiPart("zone_id","344")
                .post(url+"api/sale/payment_address").then().assertThat().body("success",equalTo("Success: Payment address has been set!")).log().body();
    }

}

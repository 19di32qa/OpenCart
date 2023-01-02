package demoOpenCard.TestCases;

import demoOpenCard.Tools.API;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC18_AddProductToCart extends API {

    @Test
    public void addProductTest() {
        given().queryParam("api_token",apiToken).contentType("multipart/form-data")
                .multiPart("product_id","32").multiPart("quantity","1")
                .post(url+"api/sale/cart.add").then().assertThat()
                .body("success",equalTo("Success: You have modified your shopping cart!")).log().body();
        String cart_id = getCartTest("1");
        deleteCartTest(cart_id);
    }

    public String getCartTest(String num) {
        RequestSpecification request = RestAssured.given();
        Response response = request.queryParam("api_token",apiToken)
                .get(url+"api/sale/cart");
        String cart_id = "";
        JsonPath jsonPath = response.getBody().jsonPath();
        cart_id = jsonPath.getString("products[0].cart_id");
        System.out.println(cart_id);
        Assert.assertEquals(jsonPath.get("products[0].quantity"),num);
        return cart_id;
    }
    public void deleteCartTest(String cart_id) {
        given().queryParam("api_token",apiToken).contentType("multipart/form-data").multiPart("key",cart_id)
                .post(url+"api/sale/cart.remove").then().log().body();
    }
}

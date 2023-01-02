package demoOpenCard.TestCases;

import demoOpenCard.Tools.API;
import demoOpenCard.Tools.DataBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TC17_ChangeCurrencyViaApi extends API {

    // looks like there is bug because we can't use all currencies that in database;

    @Test(priority = 2)
    public void changeCurrencyTest() {
        given().queryParam("api_token",apiToken).contentType("multipart/form-data").multiPart("currency","GBP")
                .post(url+"api/localisation/currency").then().log().body();
    }
    @Test(priority = 1)
    public void changeCurrencyFromDataBase() throws SQLException {
        DataBase dataBase = new DataBase();
        dataBase.SetUp();
        ResultSet resultSet = dataBase.executeStatement("SELECT code FROM oc_currency;");
        ArrayList<String> codes = getDataFromResultSet(resultSet);
        SoftAssert softAssert = new SoftAssert();
        for (int i =0;i<codes.size();i++) {
            changeCurrency(codes.get(i),softAssert);
        }
        softAssert.assertAll();

    }
    public void changeCurrency(String code, SoftAssert softAssert) {
        RequestSpecification request = RestAssured.given();
        Response response = request.queryParam("api_token",apiToken).contentType("multipart/form-data").multiPart("currency",code)
                .post(url+"api/localisation/currency");
        JsonPath jsonPath = response.jsonPath();
        ArrayList<String>invalidCurrency = new ArrayList<>();
        softAssert.assertEquals(jsonPath.get("success"),"Success: Your currency has been changed!");
//        try {
//            Assert.assertEquals((String) jsonPath.get("success"),"Success: Your currency has been changed!");
//        }
//        catch (AssertionError error) {
//            invalidCurrency.add(code);
//            System.out.println(invalidCurrency);
//        }
    }
    public ArrayList<String> getDataFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<String> codes = new ArrayList<>();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("code"));
            codes.add(resultSet.getString("code"));
        }
        return codes;
    }


}

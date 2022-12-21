package demoOpenCard.TestCases;

import demoOpenCard.Tools.DataBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TC6_CheckCustomersInDataBase {

    @Test
    public void dataBaseTest() throws SQLException {
        String emails[] = {"customer1@example.com","customer2@example.com","customer3@example.com"};
        int j =0;
        DataBase dataBase = new DataBase();
        for (int i =1;i<=3;i++) {
            ResultSet resultSet = dataBase.executeStatement("select * from oc_customer where email = \"customer"+i+
                    "@example.com\"");
            testResultSet(resultSet,"customer"+i+"@example.com");
        }
    }
    public void testResultSet(ResultSet resultSet, String email) throws SQLException {
        while (resultSet.next()) {
            Assert.assertEquals(resultSet.getString("email"),email);
        }
    }
}


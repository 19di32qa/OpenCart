package demoOpenCard.TestCases;

import demoOpenCard.Tools.DataBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TC24_Banner extends DataBase {

    @Test(priority = 1)
    public void addBannerTest() throws SQLException {
        String query = "INSERT INTO oc_banner\n" +
                "(banner_id,name,status)\n" +
                "VALUES(9,\"custom\",1);";
        connection.prepareStatement(query).execute();

    }

}

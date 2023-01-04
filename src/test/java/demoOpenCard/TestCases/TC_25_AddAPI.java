package demoOpenCard.TestCases;

import demoOpenCard.Tools.DataBase;
import demoOpenCard.Tools.KeyAPIGenerator;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TC_25_AddAPI extends DataBase {

    @Test
    public void addAPI() throws SQLException {
        String string = KeyAPIGenerator.generateApiKey();
        System.out.println(string);
        connection.prepareStatement("INSERT INTO oc_api " +
                "(api_id, date_added, date_modified, oc_api.key, oc_api.status, username) " +
                "VALUES (4, NOW(), NOW(), \""+string+"\" , 1, 'USER1');").execute();
    }
}

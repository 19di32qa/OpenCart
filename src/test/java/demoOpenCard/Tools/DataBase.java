package demoOpenCard.Tools;

import org.testng.annotations.BeforeClass;

import java.sql.*;

public class DataBase {
    private  final String dataBaseUrl = "jdbc:mysql://127.0.0.1:3306/opencard";
    Statement statement;
    Connection connection;
    @BeforeClass
    public void SetUp() throws SQLException {
        connection = DriverManager.getConnection(dataBaseUrl,"root","");
        System.out.println("Database connected");
    }
    public ResultSet executeStatement(String query) throws SQLException {
        connection = DriverManager.getConnection(dataBaseUrl,"root","");
        statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        return resultSet;
    }


}

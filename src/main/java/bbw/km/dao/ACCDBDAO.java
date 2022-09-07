package bbw.km.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ACCDBDAO {
    public static void selectAllJokes() throws SQLException, ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String connectionURL = "jdbc:ucanaccess://D:\\bbw_modules\\Modul_151_DB_anbinden\\04_DataAccessObject\\JokeDB.accdb";
        Connection connection = DriverManager.getConnection(connectionURL);
        String sql = "SELECT * FROM Joke";
        java.sql.Statement statement = connection.createStatement();
        java.sql.ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("jokeid") + " " + resultSet.getString("content") + " " + resultSet.getDate("date") + " " + resultSet.getInt("rating"));
        }
        connection.close();
    }
}

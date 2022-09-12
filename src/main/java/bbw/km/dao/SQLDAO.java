package bbw.km.dao;

import bbw.km.model.JokeBook;

import java.sql.*;

/**
 * Class SQL DAO
 *
 * @author marco
 * @version 01.09.2022
 */
public class SQLDAO implements JokeDAO {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://localhost:3306/jokedb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionURL, "root", "root");
        return connection;
    }

    @Override
    public JokeBook getAllJokes() {
        JokeBook jokeBook = new JokeBook();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet foundEntries = statement.executeQuery("SELECT * FROM joke");

            while (foundEntries.next()) {
                jokeBook.addJoke(JokeFillerSQL.createJoke(foundEntries));
            }
            foundEntries.close();
            statement.close();
            getConnection().close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jokeBook.printJokeBook();
        return jokeBook;
    }

}

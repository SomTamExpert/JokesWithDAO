package bbw.km.dao;

import bbw.km.model.Joke;
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
//        String connectionURL = "jdbc:sqlite:D:\\bbw_modules\\Modul_151_DB_anbinden\\04_DataAccessObject\\JokeDB.db";
//        String connectionURL = "jdbc:odbc:Driver={Microsoft dBase Driver (*.dbf)};SourceType=DBF;SourceDB=D:\\bbw_modules\\Modul_151_DB_anbinden\\04_DataAccessObject\\JokeDB.dbf;Exclusive=No;NULL=NO;DELETED=NO;BACKGROUNDFETCH=NO;";
//        String connectionURL = "jdbc:odbc:Driver={Microsoft Text Driver (*.txt; *.csv)};Dbq=D:\\bbw_modules\\Modul_151_DB_anbinden\\04_DataAccessObject\\JokeDB.csv;Extensions=asc,csv,tab,txt;Persist Security Info=False";
        Connection connection = DriverManager.getConnection(connectionURL, "root", "root");
        return connection;
    }

    @Override
    public JokeBook getAllJokes() {
        System.out.println("SQLDAO.getAllJokes");
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

    public void createJoke(Joke joke) {
        System.out.println("SQLDAO.createJoke");
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO joke (id, joke, date, rating) VALUES (?, ?, ?, ?)");
            statement.setInt(1, joke.getId());
            statement.setString(2, joke.getJoke());
            statement.setDate(3, (Date) joke.getDate());
            statement.setInt(4, joke.getRating());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new joke was inserted successfully!");
            }
            getAllJokes();
            statement.close();
            getConnection().close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJoke(Joke joke) {
        System.out.println("SQLDAO.updateJoke");
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE joke SET joke = ?, date = ?, rating = ? WHERE id = ?");
            statement.setString(1, joke.getJoke());
            statement.setDate(2, (Date) joke.getDate());
            statement.setInt(3, joke.getRating());
            statement.setInt(4, joke.getId());

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("An existing joke was updated successfully!");
            }
            getAllJokes();
            statement.close();
            getConnection().close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJoke(Joke joke) {
        System.out.println("SQLDAO.deleteJoke");
        try {
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM joke WHERE id = ?");
            statement.setInt(1, joke.getId());

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("A joke was deleted successfully!");
            }
            getAllJokes();
            statement.close();
            getConnection().close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

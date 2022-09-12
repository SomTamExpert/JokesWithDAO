package bbw.km.dao;

import bbw.km.model.JokeBook;

import java.sql.*;

public class ACCDBDAO implements JokeDAO {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String connectionURL = "jdbc:ucanaccess://D:\\bbw_modules\\Modul_151_DB_anbinden\\04_DataAccessObject\\JokeDB.accdb";
        return DriverManager.getConnection(connectionURL);
    }

    @Override
    public JokeBook getAllJokes() {
        JokeBook jokeBook = new JokeBook();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet foundEntries = statement.executeQuery("SELECT * FROM joke");

            while (foundEntries.next()) {
                jokeBook.addJoke(JokeFillerMDB.createJoke(foundEntries));
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

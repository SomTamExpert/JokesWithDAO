package bbw.km.dao;

import bbw.km.model.Joke;
import bbw.km.model.JokeBook;

import java.sql.*;

/**
 * Class ACCDBDAO
 *
 * @author marco
 * @version 13.09.2022
 */
public class ACCDBDAO implements JokeDAO {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String connectionURL = "jdbc:ucanaccess://D:\\bbw_modules\\Modul_151_DB_anbinden\\04_DataAccessObject\\JokeDB.accdb";
        return DriverManager.getConnection(connectionURL);
    }

    @Override
    public JokeBook getAllJokes() {
        System.out.println("ACCDBDAO.getAllJokes");
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

    @Override
    public void createJoke(Joke joke) {
        System.out.println("ACCDBDAO.createJoke");
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO joke (jokeid, content, rating, date) VALUES (?, ?, ?, ?)");
            statement.setInt(1, joke.getId());
            statement.setString(2, joke.getJoke());
            statement.setInt(3, joke.getRating());
            statement.setDate(4, (Date) joke.getDate());

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
        System.out.println("ACCDBDAO.updateJoke");
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE joke SET content = ?, rating = ?, date = ? WHERE jokeid = ?");
            statement.setString(1, joke.getJoke());
            statement.setInt(2, joke.getRating());
            statement.setDate(3, (Date) joke.getDate());
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

    public void deleteJoke(int id) {
        System.out.println("ACCDBDAO.deleteJoke");
        try {
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM joke WHERE jokeid = ?");
            statement.setInt(1, id);

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

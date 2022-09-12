package bbw.km.dao;

import bbw.km.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerSQL {

    public static void fillJoke(Joke joke, ResultSet resultset) throws SQLException {
        joke.setId(resultset.getInt("id"));
        joke.setJoke(resultset.getString("joke"));
        joke.setDate(resultset.getDate("date"));
        joke.setRating(resultset.getInt("rating"));
    }

    public static Joke createJoke(ResultSet resultset) throws SQLException {
        Joke joke = new Joke();
        fillJoke(joke, resultset);
        return joke;
    }
}

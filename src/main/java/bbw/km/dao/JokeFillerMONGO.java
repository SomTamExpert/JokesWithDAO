package bbw.km.dao;

import bbw.km.model.Joke;

import netscape.javascript.JSObject;
import org.bson.Document;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.bson.types.ObjectId;


public class JokeFillerMONGO {
    public static void fillJoke(Joke joke, Document document) {
        joke.setId(document.getInteger("id"));
        joke.setJoke(document.getString("joke"));
        joke.setDate(document.getDate("date"));
        joke.setRating(document.getInteger("rating"));
    }

    public static Joke createJoke(Document document) throws ParseException {
        Joke joke = new Joke();
        fillJoke(joke, document);
        return joke;
    }
}

package bbw.km.gui.dao;
import bbw.km.gui.model.Joke;
import org.bson.Document;
import java.text.ParseException;


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

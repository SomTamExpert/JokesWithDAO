package bbw.km.gui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class JokerBook
 *
 * @author marco
 * @version 13.09.2022
 */

public class JokeBook {
    private List<Joke> jokes;

    public JokeBook() {
        super();
        jokes = new ArrayList<Joke>();
    }

    public void addJoke(Joke joke) {
        jokes.add(joke);
    }

    public String printJokeBook() {
        String jokeString = "";
        for (Joke joke : jokes) {
            jokeString += joke.toString() + " " + "\n";
        }
        System.out.println(jokeString);
        return jokeString;
    }
}


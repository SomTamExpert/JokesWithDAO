package bbw.km.dao;

import bbw.km.model.Joke;
import bbw.km.model.JokeBook;


/**
 * Interface JokerDAO
 *
 * @author marco
 * @version 13.09.2022
 */
public interface JokeDAO {


    void createJoke(Joke joke);

    void updateJoke(Joke joke);

    void deleteJoke(Joke joke);


    JokeBook getAllJokes();
}


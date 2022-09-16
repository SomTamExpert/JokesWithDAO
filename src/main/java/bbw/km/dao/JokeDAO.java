package bbw.km.gui.dao;

import bbw.km.gui.model.Joke;
import bbw.km.gui.model.JokeBook;


/**
 * Interface JokerDAO
 *
 * @author marco
 * @version 13.09.2022
 */
public interface JokeDAO {


    void createJoke(Joke joke);

    void updateJoke(Joke joke);

    void deleteJoke(int id);


    JokeBook getAllJokes();
}


package bbw.km.dao;

import bbw.km.model.Joke;
import bbw.km.model.JokeBook;

import java.util.List;

public interface JokeDAO {


    void createJoke(Joke joke);

    void updateJoke(Joke joke);

    void deleteJoke(Joke joke);


    JokeBook getAllJokes();
}


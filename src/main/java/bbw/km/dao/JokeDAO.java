package bbw.km.dao;

import bbw.km.model.Joke;

import java.util.List;

public interface JokeDAO {


    void addJoke(Joke joke);

    void updateJoke(Joke joke);

    void deleteJoke(Joke joke);

    List getAllJokes();

    Object getJokeById(int id);
}


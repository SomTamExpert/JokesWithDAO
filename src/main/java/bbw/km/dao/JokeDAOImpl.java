package bbw.km.dao;

import bbw.km.model.Joke;
import bbw.km.model.JokeBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Class JokerDAOImpl
 *
 * @author marco karpf
 * @version 07.09.2022
 */
public class JokeDAOImpl implements JokeDAO {

    private JokeBook jokes;

    public JokeDAOImpl() {
        jokes = new JokeBook();
    }

    @Override
    public void addJoke(Joke joke) {
        jokes.addJoke(joke);
    }

    @Override
    public void updateJoke(Joke joke) {
        jokes.updateJoke(joke, joke.getId());
    }

    @Override
    public void deleteJoke(Joke joke) {
        jokes.deleteJoke(joke);
    }

    @Override
    public List getAllJokes() {
        return jokes.getAllJokes();
    }

    @Override
    public Joke getJokeById(int id) {
        return jokes.getJokeById(id);
    }

}

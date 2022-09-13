package bbw.km.model;

import java.util.ArrayList;
import java.util.List;

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
//
//    public void deleteJoke(Joke joke) {
//        jokes.remove(joke);
//    }
//
//    public List<Joke> getAllJokes() {
//        return jokes;
//    }
//
//    public void updateJoke(Joke joke, int id) {
//        for (int i = 0; i < jokes.size(); i++) {
//            if (jokes.get(i).getId() == id) {
//                jokes.set(i, joke);
//            }
//        }
//    }
//
//    public Joke getJokeById(int id) {
//        for (int i = 0; i < jokes.size(); i++) {
//            if (jokes.get(i).getId() == id) {
//                return jokes.get(i);
//            }
//        }
//        return null;
//    }
}


package bbw.km;

import bbw.km.dao.DBAccessFactory;
import bbw.km.dao.JokeDAO;
import bbw.km.model.Joke;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Class App
 *
 * @author marco
 * @version 13.09.2022
 */
public class App {
    public static void main(String[] args) {

        // instantiate the factory
        DBAccessFactory dbAccessFactory = new DBAccessFactory();


        // get the DAO and choose sql database
        JokeDAO sqldao = dbAccessFactory.getDataBaseAccess("SQL");

        //get all jokes from sql database
        sqldao.getAllJokes();

        //adding new joke to sql database
        Joke joke = new Joke();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2022-09-13";

        try {
            joke.setUpJoke(6, "To which artist's concert does one computer desperately want tickets? It obviously has to be A Dell!", new Date(formatter.parse(dateString).getTime()), 3);
            sqldao.createJoke(joke);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //updating joke in sql database
        joke.setRating(9);
        sqldao.updateJoke(joke);

        //deleting joke from sql database
        sqldao.deleteJoke(joke);


        // get the DAO and choose mdb database
        JokeDAO accdbdao = dbAccessFactory.getDataBaseAccess("MDB");

        //get all jokes from mdb database
        accdbdao.getAllJokes();

        //adding new joke to mdb database
        Joke joke2 = new Joke();
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd.MM.yyyy");
        String dateString2 = "13.10.2022";
        try {
            joke2.setUpJoke(6, "To which artist's concert does one computer desperately want tickets? It obviously has to be A Dell!", new Date(formatter2.parse(dateString2).getTime()), 6);
            accdbdao.createJoke(joke2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //updating joke in mdb database
        joke2.setRating(2);
        accdbdao.updateJoke(joke2);

        //deleting joke from mdb database
        accdbdao.deleteJoke(joke2);


    }
}

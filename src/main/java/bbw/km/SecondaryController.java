package bbw.km.gui;

import bbw.km.gui.dao.DBAccessFactory;
import bbw.km.gui.dao.JokeDAO;
import bbw.km.gui.dao.MONGODAO;
import bbw.km.gui.model.Joke;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class SecondaryController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public static void toDo() {
        // get the DAO and choose mdb database
        DBAccessFactory dbAccessFactory = new DBAccessFactory();
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
        accdbdao.deleteJoke(joke2.getId());

        // get the DAO and choose mongo database
        MONGODAO mongodao = (MONGODAO) dbAccessFactory.getDataBaseAccess("MONGO");
        mongodao.getAllJokes();

        //adding new joke to mongo database
        Joke joke3 = new Joke();
        try {
            joke3.setUpJoke(6, "What did the router say to the doctor? 'It hurts when IP'", new java.util.Date(), 3);
            mongodao.createJoke(joke3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //updating joke in mongo database
        joke3.setRating(9);
        mongodao.updateJoke(joke3);

        //deleting joke from mongo database
        mongodao.deleteJoke(joke3.getId());

    }
}

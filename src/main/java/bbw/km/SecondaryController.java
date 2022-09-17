package bbw.km;

import bbw.km.dao.DBAccessFactory;
import bbw.km.dao.JokeDAO;
import bbw.km.dao.MONGODAO;
import bbw.km.model.Joke;
import bbw.km.model.JokeBook;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class SecondaryController {

    @FXML
    private Text lblOut;

    @FXML
    private TextField txtJoke;

    @FXML
    private TextField txtRating;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtId;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToThirdly() throws Exception {
        App.setRoot("thirdly");
    }

    Joke joke = new Joke();

    DBAccessFactory dbAccessFactory = new DBAccessFactory();
    JokeDAO accdbdao = dbAccessFactory.getDataBaseAccess("MDB");


    @FXML
    public void listAllJokes() {
        JokeBook jokeBook = accdbdao.getAllJokes();
        lblOut.setText(jokeBook.printJokeBook());
        lblOut.wrappingWidthProperty().set(950);
        lblOut.setFont(new javafx.scene.text.Font(16));
    }

    @FXML
    public void addJoke() {
        if (txtJoke.getText().isEmpty() || txtRating.getText().isEmpty() || txtDate.getText().isEmpty() || txtId.getText().isEmpty()) {
            lblOut.setText("Please fill in all fields!");
        } else {
            try {
                joke.setUpJoke(Integer.parseInt(txtId.getText()), txtJoke.getText(), Date.valueOf(txtDate.getText()), Integer.parseInt(txtRating.getText()));
                accdbdao.createJoke(joke);
                lblOut.setText("Joke added!");
            } catch (Exception e) {
                lblOut.setText("Please enter a valid date!");
            }
        }
    }

    @FXML
    public void updateJoke() {
        if (txtJoke.getText().isEmpty() || txtRating.getText().isEmpty() || txtDate.getText().isEmpty() || txtId.getText().isEmpty()) {
            lblOut.setText("Please fill in all fields!");
        } else {
            try {
                joke.setUpJoke(Integer.parseInt(txtId.getText()), txtJoke.getText(), Date.valueOf(txtDate.getText()), Integer.parseInt(txtRating.getText()));
                accdbdao.updateJoke(joke);
                lblOut.setText("Joke updated!");
            } catch (Exception e) {
                lblOut.setText("Please enter a valid date!");
            }
        }
    }

    @FXML
    public void deleteJoke() {
        if (txtId.getText().isEmpty()) {
            lblOut.setText("Please fill in the ID field!");
        } else {
            accdbdao.deleteJoke(joke.getId());
            lblOut.setText("Joke deleted!");
        }
    }
}


//        // get the DAO and choose mongo database
//        MONGODAO mongodao = (MONGODAO) dbAccessFactory.getDataBaseAccess("MONGO");
//        mongodao.getAllJokes();
//
//        //adding new joke to mongo database
//        Joke joke3 = new Joke();
//        try {
//            joke3.setUpJoke(6, "What did the router say to the doctor? 'It hurts when IP'", new java.util.Date(), 3);
//            mongodao.createJoke(joke3);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //updating joke in mongo database
//        joke3.setRating(9);
//        mongodao.updateJoke(joke3);
//
//        //deleting joke from mongo database
//        mongodao.deleteJoke(joke3.getId());




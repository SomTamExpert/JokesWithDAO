package bbw.km;

import bbw.km.dao.JokeDAO;
import bbw.km.dao.DBAccessFactory;
import bbw.km.model.Joke;
import bbw.km.model.JokeBook;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Date;

public class PrimaryController {

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
    private void switchToSecondary() throws Exception {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToThirdly() throws Exception {
        App.setRoot("thirdly");
    }

    Joke joke = new Joke();
    DBAccessFactory dbAccessFactory = new DBAccessFactory();

    JokeDAO sqldao = dbAccessFactory.getDataBaseAccess("SQL");

    @FXML
    public void listAllJokes() {
        JokeBook jokeBook = sqldao.getAllJokes();
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
                sqldao.createJoke(joke);
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
                sqldao.updateJoke(joke);
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
            sqldao.deleteJoke(Integer.parseInt(txtId.getText()));
            lblOut.setText("Joke deleted!");
        }
    }
}

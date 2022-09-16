package bbw.km.gui;
import bbw.km.gui.dao.DBAccessFactory;
import bbw.km.gui.dao.JokeDAO;
import bbw.km.gui.model.Joke;
import bbw.km.gui.model.JokeBook;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Date;

public class PrimaryController {

    @FXML
    private Label lblOut;

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

    Joke joke = new Joke();
    DBAccessFactory dbAccessFactory = new DBAccessFactory();

    JokeDAO sqldao = dbAccessFactory.getDataBaseAccess("SQL");

    @FXML
    public void listAllJokes() {
        JokeBook jokeBook = sqldao.getAllJokes();
        lblOut.setText(jokeBook.printJokeBook());
    }

    @FXML
    public void addJoke() {
        if(txtJoke.getText().isEmpty() || txtRating.getText().isEmpty() || txtDate.getText().isEmpty() || txtId.getText().isEmpty()) {
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
        if(txtJoke.getText().isEmpty() || txtRating.getText().isEmpty() || txtDate.getText().isEmpty() || txtId.getText().isEmpty()) {
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
        if(txtId.getText().isEmpty()) {
            lblOut.setText("Please fill in the ID field!");
        } else {
                sqldao.deleteJoke(Integer.parseInt(txtId.getText()));
                lblOut.setText("Joke deleted!");
        }
    }
}

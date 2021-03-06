package mychamp.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mychamp.GUI.Model.GroupParser;
import mychamp.GUI.Model.Model;
import mychamp.GUI.Model.TeamParser;

public class MainViewController implements Initializable
{

    /**
     * Gets the singleton instance of the model.
     */
    Model model = Model.getInstance();
    /**
     * Gets the singleton instance of the team parser.
     */
    TeamParser teamParser = TeamParser.getInstance();
    /**
     * Gets the singleton instance of the group parser.
     */
    GroupParser groupParser = GroupParser.getInstance();

    @FXML
    private Button btnNew;

    Scene scene;

    @FXML
    private Button btnContinue;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    /**
     * Runs the newTournament method.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleNewTournament(ActionEvent event) throws IOException
    {
        newTournament();
    }

    @FXML
    private void newTourPressed(KeyEvent event) throws IOException
    {
        if (event.getCode() == KeyCode.ENTER)
        {
            newTournament();
        }
    }

    /**
     * Runs the changeView method and closes this stage.
     *
     * @param event
     * @throws IOException
     */
    private void newTournament() throws IOException
    {
        teamParser.clearAllFiles();
        model.changeView("MyChamp - Create tournament", "GUI/View/GeneratorView.fxml", "Generator", null, null);

        // Closes the primary stage
        Stage stage = (Stage) btnNew.getScene().getWindow();
        stage.close();
    }

    /**
     * Runs the contTournament method.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleContinueTournament(ActionEvent event) throws IOException
    {
        contTournament();

    }

    @FXML
    private void contTourPressed(KeyEvent event) throws IOException
    {
        if (event.getCode() == KeyCode.ENTER)
        {
            contTournament();
        }
    }

    /**
     * Runs the changeView method and closes this stage.
     *
     * @param event
     * @throws IOException
     */
    private void contTournament() throws IOException
    {
        if (groupParser.getIsContTour() == true)
        {

            model.changeView("MyChamp - Continue tournament", "GUI/View/GroupStageOverview.fxml", "GroupStageOverview", null, null);

            Stage stage = (Stage) btnContinue.getScene().getWindow();
            stage.close();
        } else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("Currently there are no saved tournament.");
            alert.show();
        }
    }

}

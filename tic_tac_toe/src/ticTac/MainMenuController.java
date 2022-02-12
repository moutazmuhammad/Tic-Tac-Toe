package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Zaina
 */
public class MainMenuController implements Initializable {
    
    @FXML
    private void singleModeButtonAction(ActionEvent event) throws IOException{
         MainScreen mainScreen = new MainScreen();
         mainScreen.changeScene("SingleGameScreen.fxml");
        
    }
    
    @FXML
    private void MultiModeButtonAction(ActionEvent event) throws IOException{
         MainScreen mainScreen = new MainScreen();
         mainScreen.changeScene("MultiGameScreen.fxml");
        
    }
    
    @FXML
    private void LeaderBoardButtonAction(ActionEvent event) throws IOException{
         MainScreen mainScreen = new MainScreen();
         mainScreen.changeScene("LeaderBoard.fxml");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

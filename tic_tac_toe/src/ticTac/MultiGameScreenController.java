package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Ahmed
 */
public class MultiGameScreenController implements Initializable {
    

    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("mainMenu.fxml");
    }
    
    @FXML
    private void PauseButtonAction(ActionEvent event) throws IOException {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

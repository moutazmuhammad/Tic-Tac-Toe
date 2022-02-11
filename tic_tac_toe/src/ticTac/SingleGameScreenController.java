
package ticTac;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class SingleGameScreenController implements Initializable {
    
    
    @FXML
    private void BackButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void ScreenshotButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void PauseButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

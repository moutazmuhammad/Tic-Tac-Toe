package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Moutaz
 */
public class SignUpController implements Initializable {
    
    private TextField username;
    private TextField password;
    private Label usernameValid;
    private Label passwordValid;
    
    @FXML
    private void changeToLoginScreen(ActionEvent event) throws IOException {
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("login.fxml");
 
    }
    
    /* When this method is called, it will change the scene
       to Login screen */
    @FXML
    private void SignUpButtonAction(ActionEvent event) throws IOException {
        
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("mainMenu.fxml");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }




}

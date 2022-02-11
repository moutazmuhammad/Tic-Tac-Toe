package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Moutaz
 */
public class SignUpController implements Initializable {
    
    private TextField username;
    private TextField password;
    private Hyperlink loginHyperlink;
    private Button signUp;
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
        System.out.println("You clicked me!");
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("MainMenu.fxml");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
    
}

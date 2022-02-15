package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Moutaz
 */
public class LoginController implements Initializable {
    
    
    private TextField username;
    private TextField password;
    private Hyperlink signUpHyperlink;
    private Button loginButton;
    private Label usernameValid;
    private Label passwordValid;
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException{
         MainScreen mainScreen = new MainScreen();
         mainScreen.changeScene("mainMenu.fxml");
        
    }
    
    /* When this method is called, it will change the scene
       to sign up screen */
    public void changeToSignUpScreen(ActionEvent event) throws IOException{
        
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("signUp.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    
    
    
}

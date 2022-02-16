package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Moutaz
 */
public class SignUpController implements Initializable {
    @FXML
    private TextField username,password;
 
    @FXML
    private Label usernameValid, passwordValid, passwdAndUser;

    
    @FXML
    private void changeToLoginScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
 
    }
    
    /* When this method is called, it will change the scene
       to Login screen */
    @FXML
    private void SignUpButtonAction(ActionEvent event) throws IOException {

        //Make sure the user doesn't leave the username or password empty
        if(username.getText().isEmpty() || password.getText().isEmpty()){    
            passwdAndUser.setVisible(true);
            //Once he/she starts writing, invalid label disappears
            username.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event) {
                    passwdAndUser.setVisible(false);
                }
        });
            //Same with password
            password.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event) {
                    passwdAndUser.setVisible(false);
                }
                
            });
        }else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();

            Scene fxmlViewScene = new Scene(fxmlViewChild);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);

            window.show();
        }

        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }




}

package controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Moutaz
 */
public class SignUpController implements Initializable {
    @FXML
    private TextField username,password;
 
    @FXML
    private Button signUp;
    
    @FXML
    private Label usernameValid, passwordValid, passwdAndUser;

    
    @FXML
    private void changeToLoginScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/login.fxml"));
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
            loader.setLocation(getClass().getResource("/fxml/mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();

            Scene fxmlViewScene = new Scene(fxmlViewChild);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);

            window.show();
        }

        
    }
    
       @FXML
    private void signUpOnHover(MouseEvent event){
        signUp.setPrefWidth(163);
        signUp.setPrefHeight(35);
        signUp.setLayoutY(250);
           audio("btnHover.mp3");
    }
    
    @FXML
    private void signUpOnExit(MouseEvent event){
        signUp.setPrefWidth(153);
        signUp.setPrefHeight(25); 
        signUp.setLayoutY(255);
    }
    
    
    @FXML
    private void signUpOnPress(MouseEvent event){
         signUp.setPrefWidth(153);
        signUp.setPrefHeight(25); 
        signUp.setLayoutY(255);
           audio("btnClick.mp3");
    }
    
    @FXML
    private void signUpOnRelease(MouseEvent event){
         signUp.setPrefWidth(163);
        signUp.setPrefHeight(35);
        signUp.setLayoutY(250);
    }
    
    private void audio(String soundEffect){
        Media sound = new Media(getClass().getResource("/audio/"+soundEffect).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }




}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    @FXML
    private void changeToLoginScreen(ActionEvent event) throws IOException {
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("login.fxml");
        
    }
    
    @FXML
    private void SignUpButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
    
}

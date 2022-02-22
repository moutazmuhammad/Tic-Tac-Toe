/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.transaction.TransactionRequiredException;

/**
 * FXML Controller class
 *
 * @author Moutaz
 */
public class StartScreenController implements Initializable {
    @FXML
    private ImageView myImage;
    @FXML
    private StackPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(5000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.play();
    }    
    
    class SplashScreen extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                    }
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(StartScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}

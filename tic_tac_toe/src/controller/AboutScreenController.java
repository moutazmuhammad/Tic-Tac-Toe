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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Zaina
 */
public class AboutScreenController implements Initializable {
    
    @FXML
    Button backButton, circle1, circle2, circle3, circle4,circle5, circle6;
    

    @FXML
    private void backButtonAction(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();
            
            Scene fxmlViewScene = new Scene(fxmlViewChild);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);
            
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(LeaderBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void backOnHover(MouseEvent event){
        audio("btnHover.mp3");
    }
    
    @FXML
    private void backOnPress(MouseEvent event){
        backButton.setPrefWidth(198);
        backButton.setPrefHeight(21);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void backOnRelease(MouseEvent event){
        backButton.setPrefWidth(218);
        backButton.setPrefHeight(31);
    }
    
     @FXML
    private void c1OnHover(MouseEvent event){
        circle1.setPrefWidth(200);
        circle1.setPrefHeight(175);
        circle1.setStyle("-fx-background-color: rgba(238, 245, 219, 1);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color:  #8b0bbf;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
         audio("circles.wav");
    }
    
    @FXML
    private void c1OnExit(MouseEvent event){
        circle1.setPrefWidth(183);
        circle1.setPrefHeight(157);
                circle1.setStyle("-fx-background-color: rgba(238, 245, 219, 0.7);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color:  #8b0bbf;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
    }
    
     @FXML
    private void c2OnHover(MouseEvent event){
        circle2.setPrefWidth(175);
        circle2.setPrefHeight(160);
        circle2.setStyle("-fx-background-color: rgba(238, 245, 219, 1);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #dd0189 ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
         audio("circles.wav");
    }
    
    @FXML
    private void c2OnExit(MouseEvent event){
         circle2.setPrefWidth(158);
        circle2.setPrefHeight(144);
        circle2.setStyle("-fx-background-color: rgba(238, 245, 219, 0.7);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #dd0189 ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
    }
    
     @FXML
    private void c3OnHover(MouseEvent event){
        circle3.setPrefWidth(186);
        circle3.setPrefHeight(171);
        circle3.setStyle("-fx-background-color: rgba(238, 245, 219, 1);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #3103ab ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
         audio("circles.wav");
    }
    
    @FXML
    private void c3OnExit(MouseEvent event){
        circle3.setPrefWidth(166);
        circle3.setPrefHeight(151);
        circle3.setStyle("-fx-background-color: rgba(238, 245, 219, 0.7);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #3103ab ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
    }
    
    @FXML
    private void c4OnHover(MouseEvent event){
        circle4.setPrefWidth(186);
        circle4.setPrefHeight(171);
        circle4.setStyle("-fx-background-color: rgba(238, 245, 219, 1);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #0176fc ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
         audio("circles.wav");
    }
    
    @FXML
    private void c4OnExit(MouseEvent event){
        circle4.setPrefWidth(166);
        circle4.setPrefHeight(151);
        circle4.setStyle("-fx-background-color: rgba(238, 245, 219, 0.7);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #0176fc ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
    }
    
     @FXML
    private void c5OnHover(MouseEvent event){
        circle5.setPrefWidth(173);
        circle5.setPrefHeight(171);
        circle5.setStyle("-fx-background-color: rgba(238, 245, 219, 1);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #138901 ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
         audio("circles.wav");
    }
    
    @FXML
    private void c5OnExit(MouseEvent event){
       circle5.setPrefWidth(153);
        circle5.setPrefHeight(151);
        circle5.setStyle("-fx-background-color: rgba(238, 245, 219, 0.7);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #138901 ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px"); 
    }
    
      @FXML
    private void c6OnHover(MouseEvent event){
        circle6.setPrefWidth(173);
        circle6.setPrefHeight(171);
        circle6.setStyle("-fx-background-color: rgba(238, 245, 219, 1);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #c2a500 ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
         audio("circles.wav");
    }
    
    @FXML
    private void c6OnExit(MouseEvent event){
         circle6.setPrefWidth(153);
        circle6.setPrefHeight(151);
        circle6.setStyle("-fx-background-color: rgba(238, 245, 219, 0.7);"
                + " -fx-background-radius: 50%;"
                + " -fx-border-color: #c2a500 ;"
                + " -fx-border-radius: 50%;"
                + " -fx-border-insets: 4;"
                + " -fx-border-width: 3px");
    }
    
    private void audio(String soundEffect){
        Media sound = new Media(getClass().getResource("/audio/"+soundEffect).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}

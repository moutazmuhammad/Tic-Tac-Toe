package controller;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Moutaz
 */
public class RecordedGames implements Initializable {
    @FXML
    private Button BackButton, resumeButton;
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException{
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/PlayerInvitationScreen.fxml"));
            Parent fxmlViewChild = loader.load();

            Scene fxmlViewScene = new Scene(fxmlViewChild);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);

            window.show();
            
    }    

    
    @FXML
    private void resumeGameButtonAction(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/playerVsPlayer.fxml"));
        Parent fxmlViewChild = loader.load();

        Scene fxmlViewScene = new Scene(fxmlViewChild);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);

        window.show();
            
    }

    
    //Animation and Sound Effects
     @FXML
    private void backOnHover(MouseEvent event){
        audio("btnHover.mp3");
    }
    
    @FXML
    private void backOnPress(MouseEvent event){
        BackButton.setPrefWidth(52);
        BackButton.setPrefHeight(15); 
        audio("btnClick.mp3");
    }
    
    @FXML
    private void backOnRelease(MouseEvent event){
        BackButton.setPrefWidth(72);
        BackButton.setPrefHeight(25); 
    }
    
    
    @FXML
    private void resumeOnHover(MouseEvent event){
        resumeButton.setPrefWidth(198);
        resumeButton.setPrefHeight(49);
        resumeButton.setLayoutX(464);
        resumeButton.setLayoutY(335);
        audio("btnHover.mp3");
    }
    
    @FXML
    private void resumeOnExit(MouseEvent event){
        resumeButton.setPrefWidth(188);
        resumeButton.setPrefHeight(39);
        resumeButton.setLayoutX(454);
        resumeButton.setLayoutY(340);
    }
    
    @FXML
    private void resumeOnPress(MouseEvent event){
        resumeButton.setPrefWidth(178);
        resumeButton.setPrefHeight(29);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void resumeOnRelease(MouseEvent event){
        resumeButton.setPrefWidth(188);
        resumeButton.setPrefHeight(39);
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

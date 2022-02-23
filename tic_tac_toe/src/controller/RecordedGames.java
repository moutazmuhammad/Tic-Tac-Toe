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

    
    
         @FXML
    private void backOnHover(MouseEvent event){
        BackButton.setPrefWidth(82);
        BackButton.setPrefHeight(35);
    }
    
    @FXML
    private void backOnExit(MouseEvent event){
        BackButton.setPrefWidth(72);
        BackButton.setPrefHeight(25); 
    }
    
    
         @FXML
    private void resumeOnHover(MouseEvent event){
        resumeButton.setPrefWidth(198);
        resumeButton.setPrefHeight(49);
        resumeButton.setLayoutX(464);
        resumeButton.setLayoutY(335);
    }
    
    @FXML
    private void resumeOnExit(MouseEvent event){
        resumeButton.setPrefWidth(188);
        resumeButton.setPrefHeight(39);
        resumeButton.setLayoutX(454);
        resumeButton.setLayoutY(340);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    
    
    
}

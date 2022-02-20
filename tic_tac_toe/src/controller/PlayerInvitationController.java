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
public class PlayerInvitationController implements Initializable {
    @FXML
    private Button BackButton, InvitePlayerButton, AcceptButton,recordedGamesButton;
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException{
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();

            Scene fxmlViewScene = new Scene(fxmlViewChild);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);

            window.show();
            
    }
    
    @FXML
    private void inviteButtonAction(ActionEvent event) throws IOException{
       
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/MultiGameScreen.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
        
    }
    
    @FXML
    private void acceptInvitaionButtonAction(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/MultiGameScreen.fxml"));
        Parent fxmlViewChild = loader.load();

        Scene fxmlViewScene = new Scene(fxmlViewChild);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);

        window.show();
            
    }
    
    @FXML
    private void recordedGamesButtonAction(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("recordedGames.fxml"));
        Parent fxmlViewChild = loader.load();

        Scene fxmlViewScene = new Scene(fxmlViewChild);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);

        window.show();
            
    }
    
    
       @FXML
    private void inviteOnHover(MouseEvent event){
         //aboutButton
        InvitePlayerButton.setPrefWidth(199);
        InvitePlayerButton.setPrefHeight(49);
        InvitePlayerButton.setLayoutX(448);
        InvitePlayerButton.setLayoutY(296);
    }
    
    @FXML
    private void inviteOnExit(MouseEvent event){
        //aboutButton
        InvitePlayerButton.setPrefWidth(188);
        InvitePlayerButton.setPrefHeight(39);
        InvitePlayerButton.setLayoutX(458);
        InvitePlayerButton.setLayoutY(301);
    }
    
    
       @FXML
    private void acceptOnHover(MouseEvent event){
         //aboutButton
        AcceptButton.setPrefWidth(198);
        AcceptButton.setPrefHeight(49);
        AcceptButton.setLayoutX(40);
        AcceptButton.setLayoutY(296);
    }
    
    @FXML
    private void acceptOnExit(MouseEvent event){
        //aboutButton
        AcceptButton.setPrefWidth(188);
        AcceptButton.setPrefHeight(39);
        AcceptButton.setLayoutX(50);
        AcceptButton.setLayoutY(301);
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
    private void recordOnHover(MouseEvent event){
        recordedGamesButton.setPrefWidth(132);
        recordedGamesButton.setPrefHeight(39);
        //recordedGamesButton.setLayoutX(568);
        recordedGamesButton.setLayoutY(356);
    }
    
    @FXML
    private void recordOnExit(MouseEvent event){
        recordedGamesButton.setPrefWidth(122);
        recordedGamesButton.setPrefHeight(29);
        //recordedGamesButton.setLayoutX(558);
        recordedGamesButton.setLayoutY(361);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    
    
    
}

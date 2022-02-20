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
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Zaina
 */
public class MainMenuController implements Initializable {
    
    @FXML
    private Button singleModeButton, MultiModeButton, hardModeButton, leaderButton, aboutButton;
    @FXML
    private ImageView singleIcon, multiIcon, leaderIcon;

    
    @FXML
    private void singleModeButtonAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SingleModeMenu.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
       
    }
    
    @FXML
    private void MultiModeButtonAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/PlayerInvitationScreen.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
       
        
    }
    
    @FXML
    private void LeaderBoardButtonAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/LeaderBoard.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
       
        
    }
    
    @FXML
    private void singleOnHover(MouseEvent event){
        //SingleModeButton
        singleModeButton.setPrefWidth(270);
        singleModeButton.setPrefHeight(45);
        singleModeButton.setLayoutX(215);
        singleModeButton.setLayoutY(164);
        singleIcon.setLayoutY(165);
       
    }
    
    @FXML
    private void singleOnExit(MouseEvent event){
        //SingleModeButton
        singleModeButton.setPrefWidth(250);
        singleModeButton.setPrefHeight(35);
        singleModeButton.setLayoutX(225);
        singleModeButton.setLayoutY(164);
        singleIcon.setLayoutY(160);
        
        
    }
    
    @FXML
    private void multiOnHover(MouseEvent event){
         //MultiModeButton
        MultiModeButton.setPrefWidth(270);
        MultiModeButton.setPrefHeight(45);
        MultiModeButton.setLayoutX(216);
        MultiModeButton.setLayoutY(216);
        multiIcon.setLayoutY(218);
    }
    
    @FXML
    private void multiOnExit(MouseEvent event){
        //MultiModeButton
        MultiModeButton.setPrefWidth(250);
        MultiModeButton.setPrefHeight(35);
        MultiModeButton.setLayoutX(226);
        MultiModeButton.setLayoutY(216);
        multiIcon.setLayoutY(213);
    }
    
    @FXML
    private void leaderOnHover(MouseEvent event){
         //LeaderBoardButton
        leaderButton.setPrefWidth(270);
        leaderButton.setPrefHeight(45);
        leaderButton.setLayoutX(216);
        leaderButton.setLayoutY(270);
        leaderIcon.setLayoutY(266);
    }
    
    @FXML
    private void leaderOnExit(MouseEvent event){
        //LeaderBoardButton
        leaderButton.setPrefWidth(250);
        leaderButton.setPrefHeight(35);
        leaderButton.setLayoutX(226);
        leaderButton.setLayoutY(270);
        leaderIcon.setLayoutY(263);
    }
    
    
     @FXML
    private void aboutOnHover(MouseEvent event){
         //aboutButton
        aboutButton.setPrefWidth(270);
        aboutButton.setPrefHeight(45);
        aboutButton.setLayoutX(216);
        aboutButton.setLayoutY(328);
    }
    
    @FXML
    private void aboutOnExit(MouseEvent event){
        //aboutButton
        aboutButton.setPrefWidth(250);
        aboutButton.setPrefHeight(35);
        aboutButton.setLayoutX(226);
        aboutButton.setLayoutY(328);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

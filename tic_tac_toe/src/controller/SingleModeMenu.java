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
public class SingleModeMenu implements Initializable {
    
    @FXML
    private Button simpleModeButton, mediumModeButton;
    

    
    @FXML
    private void simpleModeButtonAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SingleGameScreen.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
       
    }
    
    @FXML
    private void mediumModeButtonAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SingleGameMediumScreen.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
       
        
    }
    
    @FXML
    private void hardModeButtonAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SingleGameHardScreen.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
       
        
    }
    
    @FXML
    private void singleOnHover(MouseEvent event){
        //hardModeButton
        simpleModeButton.setPrefWidth(270);
        simpleModeButton.setPrefHeight(45);
        simpleModeButton.setLayoutX(215);
        simpleModeButton.setLayoutY(164);
       
    }
    
    @FXML
    private void singleOnExit(MouseEvent event){
        //hardModeButton
        simpleModeButton.setPrefWidth(250);
        simpleModeButton.setPrefHeight(35);
        simpleModeButton.setLayoutX(225);
        simpleModeButton.setLayoutY(164);
        
        
    }
    
    @FXML
    private void multiOnHover(MouseEvent event){
         //mediumModeButton
        mediumModeButton.setPrefWidth(270);
        mediumModeButton.setPrefHeight(45);
        mediumModeButton.setLayoutX(216);
        mediumModeButton.setLayoutY(216);
    }
    
    @FXML
    private void multiOnExit(MouseEvent event){
        //mediumModeButton
        mediumModeButton.setPrefWidth(250);
        mediumModeButton.setPrefHeight(35);
        mediumModeButton.setLayoutX(226);
        mediumModeButton.setLayoutY(216);
    }
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/mainMenu.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

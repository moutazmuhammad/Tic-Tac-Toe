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
 * @author Ahmed
 */
public class MultiGameScreenController implements Initializable {
    
    @FXML
    private Button backButton, pauseButton;

    
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
    
    @FXML
    private void PauseButtonAction(ActionEvent event) throws IOException {
        
    }
    
    
    @FXML
    private void backOnHover(MouseEvent event){
        backButton.setPrefWidth(85);
        backButton.setPrefHeight(35);
        backButton.setLayoutY(358);
    }
    
    @FXML
    private void backOnExit(MouseEvent event){
        backButton.setPrefWidth(75);
        backButton.setPrefHeight(25); 
        backButton.setLayoutY(362);
    }
    
    @FXML
    private void pauseOnHover(MouseEvent event){
        pauseButton.setPrefWidth(102);
        pauseButton.setPrefHeight(35);
        pauseButton.setLayoutY(354);
    }
    
    @FXML
    private void pauseOnExit(MouseEvent event){
        pauseButton.setPrefWidth(92);
        pauseButton.setPrefHeight(25); 
        pauseButton.setLayoutY(359);
      }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

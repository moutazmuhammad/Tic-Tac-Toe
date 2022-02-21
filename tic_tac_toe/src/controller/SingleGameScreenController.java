
package controller;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Moutaz
 */
public class SingleGameScreenController implements Initializable {
    @FXML
    private Button backButton, resetButton, screenshotBtn;
    
    Dialog<ButtonType> dialog = new Dialog<>(); 
            
    @FXML
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8;
    
    @FXML
    private Label ur_score, cump_score;
    
    
    private int your_score=0; //Score of player
    private int computer_score=0; //Score of computer
    private int flage=1; //use to know if someone won --> if still equal (1) means tie game
    
    private int buttonPosition[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //This array have all postions of game
    
    private int xPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //This array is used to know if the player win
    private int oPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //This array is used to know if the computer win
    
    private void updateComputerScore(){ //calculate the score of computer
        computer_score++;
        String cScore = ""+computer_score;
        cump_score.setText(cScore);
    }
    
    private void updatePlayerScore(){ //calculate the score of player
        your_score++;
        String score = ""+your_score;
        ur_score.setText(score);
    }
    
    private int checkFillPositions(){ //Get number of empty postions
        int counter = 0;
        for (int i=0; i<buttonPosition.length; i++){
            if (buttonPosition[i]==1){
                counter +=1;
            }
        }
        return counter;
    }
    
    private void fillPositions(){
        for (int i=0; i<buttonPosition.length; i++){
            buttonPosition[i]=1;
        }
    }
    
    private void drawAction() throws IOException{ //case tie
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/draw.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); 
        dialog.setTitle("Draw");
        dialog.show();
    }
    
    private void xWinnerAction() throws IOException{ //case player is the winner
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/xWinner.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); 
        dialog.setTitle("Winner");
        dialog.show();
    }
    
    
    private void oWinnerAction() throws IOException{ //case computer is the winner
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/oWinner.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); 
        dialog.setTitle("Game Over");
        dialog.show();
    }
    
    
    private void checkPlayer(){ //check if player won
        int xResult= xPlayerWonGame();
        if (xResult == 1){
            try {
                flage=0;
                updatePlayerScore();
                
                fillPositions();
                xWinnerAction();
            } catch (IOException ex) {
                Logger.getLogger(SingleGameScreenMediumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void computer (){ //move of computer & check if computer won
        computerPlayer();
        int oResult= computerWonGame();
        if (oResult == 1){
            try {
                flage=0;
                updateComputerScore();

                fillPositions();
                oWinnerAction();
            } catch (IOException ex) {
                Logger.getLogger(SingleGameScreenMediumController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }  
    }
    
    private void checkTie(){
        if (flage==1 && checkFillPositions()==9){
            try {
                fillPositions();
                drawAction();
            } catch (IOException ex) {
                Logger.getLogger(SingleGameScreenMediumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    @FXML
    private void b0ButtonAction(ActionEvent event)  {
        
        if (buttonPosition[0]==0){
            b0.setText("X");
            b0.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[0]=1;
            xPlayerWon[0]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b1ButtonAction(ActionEvent event) {
        
        if (buttonPosition[1]==0){
            b1.setText("X");
            b1.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[1]=1;
            xPlayerWon[1]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b2ButtonAction(ActionEvent event) {
        
        if (buttonPosition[2]==0){
            b2.setText("X");
            b2.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[2]=1;
            xPlayerWon[2]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b3ButtonAction(ActionEvent event){
        
        if (buttonPosition[3]==0){
            b3.setText("X");
            b3.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[3]=1;
            xPlayerWon[3]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b4ButtonAction(ActionEvent event){
        
        if (buttonPosition[4]==0){
            b4.setText("X");
            b4.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[4]=1;
            xPlayerWon[4]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b5ButtonAction(ActionEvent event) {
        
        if (buttonPosition[5]==0){
            b5.setText("X");
            b5.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[5]=1;
            xPlayerWon[5]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b6ButtonAction(ActionEvent event){
        
        if (buttonPosition[6]==0){
            b6.setText("X");
            b6.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[6]=1;
            xPlayerWon[6]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b7ButtonAction(ActionEvent event){
        
        if (buttonPosition[7]==0){
            b7.setText("X");
            b7.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[7]=1;
            xPlayerWon[7]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b8ButtonAction(ActionEvent event){
        
        if (buttonPosition[8]==0){
            b8.setText("X");
            b8.setStyle("-fx-background-color: #f5fb4f");
            buttonPosition[8]=1;
            xPlayerWon[8]=1;

            checkPlayer();
            computer();
            checkTie ();
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
   
    
    private void computerPlayer(){
        Vector<Integer> emptyPositions = new Vector<>(); //empty postions
        
        for (int index=0; index < buttonPosition.length; index++){
            if (buttonPosition[index] == 0){
                emptyPositions.add(index);
            }
        }
        int computerPosition = (int) (Math.random()*emptyPositions.size()); //To get Random position
     
        if (! emptyPositions.isEmpty()){
            if (emptyPositions.get(computerPosition) == 0){
                b0.setText("O");
                b0.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 1){
                b1.setText("O");
                b1.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 2){
                b2.setText("O");
                b2.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 3){
                b3.setText("O");
                b3.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 4){
                b4.setText("O");
                b4.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 5){
                b5.setText("O");
                b5.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 6){
                b6.setText("O");
                b6.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 7){
                b7.setText("O");
                b7.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 8){
                b8.setText("O");
                b8.setStyle("-fx-background-color: #ee7070");
            }
            
            oPlayerWon[emptyPositions.get(computerPosition)]=1;
            buttonPosition[emptyPositions.get(computerPosition)]=1;
        }
    }
    
    private int xPlayerWonGame(){
        if ((xPlayerWon[0]==1 && xPlayerWon[1]==1 && xPlayerWon[2]==1)||
                (xPlayerWon[3]==1 && xPlayerWon[4]==1 && xPlayerWon[5]==1)||
                (xPlayerWon[6]==1 && xPlayerWon[7]==1 && xPlayerWon[8]==1)||
                (xPlayerWon[0]==1 && xPlayerWon[3]==1 && xPlayerWon[6]==1)||
                (xPlayerWon[1]==1 && xPlayerWon[4]==1 && xPlayerWon[7]==1)||
                (xPlayerWon[2]==1 && xPlayerWon[5]==1 && xPlayerWon[8]==1)||
                (xPlayerWon[0]==1 && xPlayerWon[4]==1 && xPlayerWon[8]==1)||
                (xPlayerWon[2]==1 && xPlayerWon[4]==1 && xPlayerWon[6]==1)){
            return 1;
        }
        return 0;
    }
    
    int computerWonGame(){
        if ((oPlayerWon[0]==1 && oPlayerWon[1]==1 && oPlayerWon[2]==1)||
                (oPlayerWon[3]==1 && oPlayerWon[4]==1 && oPlayerWon[5]==1)||
                (oPlayerWon[6]==1 && oPlayerWon[7]==1 && oPlayerWon[8]==1)||
                (oPlayerWon[0]==1 && oPlayerWon[3]==1 && oPlayerWon[6]==1)||
                (oPlayerWon[1]==1 && oPlayerWon[4]==1 && oPlayerWon[7]==1)||
                (oPlayerWon[2]==1 && oPlayerWon[5]==1 && oPlayerWon[8]==1)||
                (oPlayerWon[0]==1 && oPlayerWon[4]==1 && oPlayerWon[8]==1)||
                (oPlayerWon[2]==1 && oPlayerWon[4]==1 && oPlayerWon[6]==1)){
            return 1;
        }
        return 0;
    }
    
    @FXML
    private void playAgainButtonAction(ActionEvent event) { //reset the game
        b0.setText("");
        b0.setStyle("-fx-background-color: TRANSPARENT");
        b1.setText("");
        b1.setStyle("-fx-background-color: TRANSPARENT");
        b2.setText("");
        b2.setStyle("-fx-background-color: TRANSPARENT");
        b3.setText("");
        b3.setStyle("-fx-background-color: TRANSPARENT");
        b4.setText("");
        b4.setStyle("-fx-background-color: TRANSPARENT");
        b5.setText("");
        b5.setStyle("-fx-background-color: TRANSPARENT");
        b6.setText("");
        b6.setStyle("-fx-background-color: TRANSPARENT");
        b7.setText("");
        b7.setStyle("-fx-background-color: TRANSPARENT");
        b8.setText("");
        b8.setStyle("-fx-background-color: TRANSPARENT");
        
        flage=1;
        for (int i=0 ; i<9 ; i++){
            buttonPosition[i] = 0;
            xPlayerWon[i] = 0;
            oPlayerWon[i] = 0;
        }
        
    }
    
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/SingleModeMenu.fxml"));
        Parent fxmlViewChild = loader.load();
        
        Scene fxmlViewScene = new Scene(fxmlViewChild);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);
        
        window.show();
        
    }
    
    @FXML
    private void ScreenshotButtonAction(ActionEvent event) throws AWTException, IOException {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File("screenshot.png"));
        
        System.out.println("done");
    }
    
    
    
    //Animating Buttons
    @FXML
    private void backOnHover(MouseEvent event){
        backButton.setPrefWidth(85);
        backButton.setPrefHeight(35);
        backButton.setLayoutY(354);
    }
    
    @FXML
    private void backOnExit(MouseEvent event){
        backButton.setPrefWidth(75);
        backButton.setPrefHeight(25); 
        backButton.setLayoutY(359);
    }
    
    @FXML
    private void resetOnHover(MouseEvent event){
        resetButton.setPrefWidth(102);
        resetButton.setPrefHeight(35);
        resetButton.setLayoutY(354);
    }
    
    @FXML
    private void resetOnExit(MouseEvent event){
        resetButton.setPrefWidth(92);
        resetButton.setPrefHeight(25); 
        resetButton.setLayoutY(359);
    }
    
      @FXML
    private void screenOnHover(MouseEvent event){
        screenshotBtn.setPrefWidth(102);
        screenshotBtn.setPrefHeight(35);
        screenshotBtn.setLayoutY(354);
    }
    
    @FXML
    private void screenOnExit(MouseEvent event){
        screenshotBtn.setPrefWidth(92);
        screenshotBtn.setPrefHeight(25); 
        screenshotBtn.setLayoutY(359);
      }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

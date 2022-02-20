
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Moutaz
 */
public class SingleGameScreenMediumController implements Initializable {
    @FXML
    private Button backButton, resetButton, screenshotBtn;
    
    Dialog<ButtonType> dialog = new Dialog<>(); 
    
    private int computerPosition=0;
    
    private int turnPosition = 2; //To get the correct position of X and O
    
    @FXML
    private ImageView b0, b1, b2, b3, b4, b5, b6, b7, b8;
    
    @FXML
    private Label ur_score, cump_score;
    
    
    Image X = new Image(getClass().getResourceAsStream("/images/x.png"));
    Image O = new Image(getClass().getResourceAsStream("/images/oO.png"));
    
    private int your_score=0;
    private int computer_score=0;
    private int flage=1;
    
    private int buttonPosition[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    private int xPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //player
    private int oPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //computer
    
    private void showDialog (){
        int xResult= xPlayerWonGame();
                if (xResult == 1){
            try {
                flage=0;
                updatePlayerScore();
                
                xWinnerAction();
                dialog.show();
            } catch (IOException ex) {
                Logger.getLogger(SingleGameScreenMediumController.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        try {
                            flage=0;
                            updateComputerScore();
                            
                            fillPositions();
                            oWinnerAction();
                            dialog.show();
                        } catch (IOException ex) {
                            Logger.getLogger(SingleGameScreenMediumController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }  
                }
                if (flage==1 &&checkFillPositions()==9){
            try {
                fillPositions();
                drawAction();
                dialog.show();
            } catch (IOException ex) {
                Logger.getLogger(SingleGameScreenMediumController.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    }
    
    
    private void updateComputerScore(){
        computer_score++;
        String cScore = ""+computer_score;
        cump_score.setText(cScore);
    }
    
    private void updatePlayerScore(){
        your_score++;
        String score = ""+your_score;
        ur_score.setText(score);
    }
    
    private int checkFillPositions(){
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
    
    private void drawAction() throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/draw.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); 
        dialog.setTitle("Draw");
    }
    
    private void xWinnerAction() throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/xWinner.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); 
        dialog.setTitle("Winner");
    }
    
    
    private void oWinnerAction() throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/oWinner.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); 
        dialog.setTitle("Game Over");
    }
    
    @FXML
    private void b0ButtonAction(MouseEvent event)  {
        
        if (buttonPosition[0]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b0.setImage(X);
                audio("btnClick.mp3");
               // b0.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[0]=1;
                xPlayerWon[0]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b1ButtonAction(MouseEvent event) {
        
        if (buttonPosition[1]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b1.setImage(X);
                audio("btnClick.mp3");
               // b1.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[1]=1;
                xPlayerWon[1]=1;
                
                showDialog();
                
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b2ButtonAction(MouseEvent event) {
        
        if (buttonPosition[2]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b2.setImage(X);
                audio("btnClick.mp3");
                //b2.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[2]=1;
                xPlayerWon[2]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b3ButtonAction(MouseEvent event) {
        
        if (buttonPosition[3]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b3.setImage(X);
                audio("btnClick.mp3");
                //b3.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[3]=1;
                xPlayerWon[3]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b4ButtonAction(MouseEvent event) {
        
        if (buttonPosition[4]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b4.setImage(X);
                audio("btnClick.mp3");
                //b4.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[4]=1;
                xPlayerWon[4]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b5ButtonAction(MouseEvent event) {
        
        if (buttonPosition[5]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b5.setImage(X);
                audio("btnClick.mp3");
                //b5.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[5]=1;
                xPlayerWon[5]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b6ButtonAction(MouseEvent event) {
        
        if (buttonPosition[6]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b6.setImage(X);
                audio("btnClick.mp3");
                //b6.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[6]=1;
                xPlayerWon[6]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b7ButtonAction(MouseEvent event) {
        
        if (buttonPosition[7]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b7.setImage(X);
                audio("btnClick.mp3");
                //b7.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[7]=1;
                xPlayerWon[7]=1;
                
                showDialog();
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b8ButtonAction(MouseEvent event) {
        
        if (buttonPosition[8]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b8.setImage(X);
                audio("btnClick.mp3");
                //b8.setStyle("-fx-background-color: #f5fb4f");
               
                buttonPosition[8]=1;
                xPlayerWon[8]=1;
                
                showDialog();
            }
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
        computerPosition = (int) (Math.random()*emptyPositions.size()); //To get Random position
        System.out.println("computerPosition" + computerPosition);
        
        if (oPlayerWon[0] == 1 && oPlayerWon[1] == 1 && xPlayerWon[2]== 0 && oPlayerWon[2]== 0){
            turnPosition++; //To Skep the next index
            b2.setImage(O);
            //b2.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[2]=1;
            buttonPosition[2]=1;
        }
        else if (oPlayerWon[1] == 1 && oPlayerWon[2] == 1 && xPlayerWon[0]== 0 && oPlayerWon[0]== 0){
            turnPosition++; //To Skep the next index
            b0.setImage(O);
            //b0.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[0]=1;
            buttonPosition[0]=1;
        }
        else if (oPlayerWon[0] == 1 && oPlayerWon[2] == 1 && xPlayerWon[1]== 0 && oPlayerWon[1]== 0){
            turnPosition++; //To Skep the next index
            b1.setImage(O);
            //b1.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[1]=1;
            buttonPosition[1]=1;
        }
        else if (oPlayerWon[3] == 1 && oPlayerWon[4] == 1 && xPlayerWon[5]== 0 && oPlayerWon[5]== 0){
            turnPosition++; //To Skep the next index
            b5.setImage(O);
            //b5.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[5]=1;
            buttonPosition[5]=1;
        }
        else if (oPlayerWon[3] == 1 && oPlayerWon[5] == 1 && xPlayerWon[4]== 0 && oPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
            //b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (oPlayerWon[4] == 1 && oPlayerWon[5] == 1 && xPlayerWon[3]== 0 && oPlayerWon[3]== 0){
            turnPosition++; //To Skep the next index
            b3.setImage(O);
           // b3.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[3]=1;
            buttonPosition[3]=1;
        }
        else if (oPlayerWon[6] == 1 && oPlayerWon[7] == 1 && xPlayerWon[8]== 0 && oPlayerWon[8]== 0){
            turnPosition++; //To Skep the next index
            b8.setImage(O);
            //b8.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[8]=1;
            buttonPosition[8]=1;
        }
        else if (oPlayerWon[7] == 1 && oPlayerWon[8] == 1 && xPlayerWon[6]== 0 && oPlayerWon[6]== 0){
            turnPosition++; //To Skep the next index
            b6.setImage(O);
            //b6.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[6]=1;
            buttonPosition[6]=1;
        }
        else if (oPlayerWon[6] == 1 && oPlayerWon[8] == 1 && xPlayerWon[7]== 0 && oPlayerWon[7]== 0){
            turnPosition++; //To Skep the next index
            b7.setImage(O);
            //b7.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[7]=1;
            buttonPosition[7]=1;
        }
        else if (oPlayerWon[2] == 1 && oPlayerWon[4] == 1 && xPlayerWon[6]== 0 && oPlayerWon[6]== 0){
            turnPosition++; //To Skep the next index
            b6.setImage(O);
            //b6.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[6]=1;
            buttonPosition[6]=1;
        }
        else if (oPlayerWon[2] == 1 && oPlayerWon[6] == 1 && xPlayerWon[4]== 0 && oPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
            //b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (oPlayerWon[4] == 1 && oPlayerWon[6] == 1 && xPlayerWon[2]== 0 && oPlayerWon[2]== 0){
            turnPosition++; //To Skep the next index
            b2.setImage(O);
            //b2.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[2]=1;
            buttonPosition[2]=1;
        }
        else if (oPlayerWon[0] == 1 && oPlayerWon[4] == 1 && xPlayerWon[8]== 0 && oPlayerWon[8]== 0){
            turnPosition++; //To Skep the next index
            b8.setImage(O);
            //b8.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[8]=1;
            buttonPosition[8]=1;
        }
        else if (oPlayerWon[0] == 1 && oPlayerWon[8] == 1 && xPlayerWon[4]== 0 && oPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
           // b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (oPlayerWon[4] == 1 && oPlayerWon[8] == 1 && xPlayerWon[0]== 0 && oPlayerWon[0]== 0){
            turnPosition++; //To Skep the next index
            b0.setImage(O);
            b0.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[0]=1;
            buttonPosition[0]=1;
        }    
        
        
        else if (oPlayerWon[0] == 1 && oPlayerWon[3] == 1 && xPlayerWon[6]== 0 && oPlayerWon[6]== 0){
            turnPosition++; //To Skep the next index
            b6.setImage(O);
            b6.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[6]=1;
            buttonPosition[6]=1;
        }
        else if (oPlayerWon[0] == 1 && oPlayerWon[6] == 1 && xPlayerWon[3]== 0 && oPlayerWon[3]== 0){
            turnPosition++; //To Skep the next index
            b3.setImage(O);
            b3.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[3]=1;
            buttonPosition[3]=1;
        }
        else if (oPlayerWon[3] == 1 && oPlayerWon[6] == 1 && xPlayerWon[0]== 0 && oPlayerWon[0]== 0){
            turnPosition++; //To Skep the next index
            b0.setImage(O);
            //b0.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[0]=1;
            buttonPosition[0]=1;
        }     
        
        
        else if (oPlayerWon[1] == 1 && oPlayerWon[4] == 1 && xPlayerWon[7]== 0 && oPlayerWon[7]== 0){
            turnPosition++; //To Skep the next index
            b7.setImage(O);
//            b7.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[7]=1;
            buttonPosition[7]=1;
        }
        else if (oPlayerWon[4] == 1 && oPlayerWon[7] == 1 && xPlayerWon[1]== 0 && oPlayerWon[1]== 0){
            turnPosition++; //To Skep the next index
            b1.setImage(O);
//            b1.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[1]=1;
            buttonPosition[1]=1;
        }
        else if (oPlayerWon[1] == 1 && oPlayerWon[7] == 1 && xPlayerWon[4]== 0 && oPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
//            b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        } 
        
        else if (oPlayerWon[2] == 1 && oPlayerWon[5] == 1 && xPlayerWon[7]== 0 && oPlayerWon[8]== 0){
            turnPosition++; //To Skep the next index
            b8.setImage(O);
//            b8.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[8]=1;
            buttonPosition[8]=1;
        }
        else if (oPlayerWon[5] == 1 && oPlayerWon[8] == 1 && xPlayerWon[2]== 0 && oPlayerWon[2]== 0){
            turnPosition++; //To Skep the next index
            b2.setImage(O);
//            b2.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[2]=1;
            buttonPosition[2]=1;
        }
        else if (oPlayerWon[2] == 1 && oPlayerWon[8] == 1 && xPlayerWon[5]== 0 && oPlayerWon[5]== 0){
            turnPosition++; //To Skep the next index
            b5.setImage(O);
//            b5.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[5]=1;
            buttonPosition[5]=1;
        }
        
        else if (xPlayerWon[0] == 1 && xPlayerWon[1] == 1 && oPlayerWon[2]== 0 && xPlayerWon[2]== 0){
            turnPosition++; //To Skep the next index
            b2.setImage(O);
           // b2.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[2]=1;
            buttonPosition[2]=1;
        }
        else if (xPlayerWon[1] == 1 && xPlayerWon[2] == 1 && oPlayerWon[0]== 0 && xPlayerWon[0]== 0){
            turnPosition++; //To Skep the next index
            b0.setImage(O);
            //b0.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[0]=1;
            buttonPosition[0]=1;
        }
        else if (xPlayerWon[0] == 1 && xPlayerWon[2] == 1 && oPlayerWon[1]== 0 && xPlayerWon[1]== 0){
            turnPosition++; //To Skep the next index
            b1.setImage(O);
            //b1.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[1]=1;
            buttonPosition[1]=1;
        }
        else if (xPlayerWon[3] == 1 && xPlayerWon[4] == 1 && oPlayerWon[5]== 0 && xPlayerWon[5]== 0){
            turnPosition++; //To Skep the next index
            b5.setImage(O);
            //b5.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[5]=1;
            buttonPosition[5]=1;
        }
        else if (xPlayerWon[3] == 1 && xPlayerWon[5] == 1 && oPlayerWon[4]== 0 && xPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
            //b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (xPlayerWon[4] == 1 && xPlayerWon[5] == 1 && oPlayerWon[3]== 0 && xPlayerWon[3]== 0){
            turnPosition++; //To Skep the next index
            b3.setImage(O);
            //b3.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[3]=1;
            buttonPosition[3]=1;
        }
        else if (xPlayerWon[6] == 1 && xPlayerWon[7] == 1 && oPlayerWon[8]== 0 && xPlayerWon[8]== 0){
            turnPosition++; //To Skep the next index
            b8.setImage(O);
            //b8.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[8]=1;
            buttonPosition[8]=1;
        }
        else if (xPlayerWon[7] == 1 && xPlayerWon[8] == 1 && oPlayerWon[6]== 0 && xPlayerWon[6]== 0){
            turnPosition++; //To Skep the next index
            b6.setImage(O);
            //b6.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[6]=1;
            buttonPosition[6]=1;
        }
        else if (xPlayerWon[6] == 1 && xPlayerWon[8] == 1 && oPlayerWon[7]== 0 && xPlayerWon[7]== 0){
            turnPosition++; //To Skep the next index
            b7.setImage(O);
           // b7.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[7]=1;
            buttonPosition[7]=1;
        }
        else if (xPlayerWon[2] == 1 && xPlayerWon[4] == 1 && oPlayerWon[6]== 0 && xPlayerWon[6]== 0){
            turnPosition++; //To Skep the next index
            b6.setImage(O);
           // b6.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[6]=1;
            buttonPosition[6]=1;
        }
        else if (xPlayerWon[2] == 1 && xPlayerWon[6] == 1 && oPlayerWon[4]== 0 && xPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
            //b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (xPlayerWon[4] == 1 && xPlayerWon[6] == 1 && oPlayerWon[2]== 0 && xPlayerWon[2]== 0){
            turnPosition++; //To Skep the next index
            b2.setImage(O);
            //b2.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[2]=1;
            buttonPosition[2]=1;
        }
        else if (xPlayerWon[0] == 1 && xPlayerWon[4] == 1 && oPlayerWon[8]== 0 && xPlayerWon[8]== 0){
            turnPosition++; //To Skep the next index
            b8.setImage(O);
            //b8.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[8]=1;
            buttonPosition[8]=1;
        }
        else if (xPlayerWon[0] == 1 && xPlayerWon[8] == 1 && oPlayerWon[4]== 0 && xPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
            //b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (xPlayerWon[4] == 1 && xPlayerWon[8] == 1 && oPlayerWon[0]== 0 && xPlayerWon[0]== 0){
            turnPosition++; //To Skep the next index
            b0.setImage(O);
           // b0.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[0]=1;
            buttonPosition[0]=1;
        }
        else if (xPlayerWon[0] == 1 && xPlayerWon[3] == 1 && oPlayerWon[6]== 0 && xPlayerWon[6]== 0){
            turnPosition++; //To Skep the next index
            b6.setImage(O);
            //b6.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[6]=1;
            buttonPosition[6]=1;
        }
        else if (xPlayerWon[0] == 1 && xPlayerWon[6] == 1 && oPlayerWon[3]== 0 && xPlayerWon[3]== 0){
            turnPosition++; //To Skep the next index
            b3.setImage(O);
            //b3.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[3]=1;
            buttonPosition[3]=1;
        }
        else if (xPlayerWon[3] == 1 && xPlayerWon[6] == 1 && oPlayerWon[0]== 0 && xPlayerWon[0]== 0){
            turnPosition++; //To Skep the next index
            b0.setImage(O);
            //b0.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[0]=1;
            buttonPosition[0]=1;
        }
        else if (xPlayerWon[1] == 1 && xPlayerWon[4] == 1 && oPlayerWon[7]== 0 && xPlayerWon[7]== 0){
            turnPosition++; //To Skep the next index
            b7.setImage(O);
            //b7.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[7]=1;
            buttonPosition[7]=1;
        }
        else if (xPlayerWon[4] == 1 && xPlayerWon[7] == 1 && oPlayerWon[1]== 0 && xPlayerWon[1]== 0){
            turnPosition++; //To Skep the next index
            b1.setImage(O);
            //b1.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[1]=1;
            buttonPosition[1]=1;
        }
        else if (xPlayerWon[1] == 1 && xPlayerWon[7] == 1 && oPlayerWon[4]== 0 && xPlayerWon[4]== 0){
            turnPosition++; //To Skep the next index
            b4.setImage(O);
            //b4.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[4]=1;
            buttonPosition[4]=1;
        }
        else if (xPlayerWon[2] == 1 && xPlayerWon[5] == 1 && oPlayerWon[8]== 0 && xPlayerWon[8]== 0){
            turnPosition++; //To Skep the next index
            b8.setImage(O);
            //b8.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[8]=1;
            buttonPosition[8]=1;
        }
        else if (xPlayerWon[5] == 1 && xPlayerWon[8] == 1 && oPlayerWon[2]== 0 && xPlayerWon[2]== 0){
            turnPosition++; //To Skep the next index
            b2.setImage(O);
            //b2.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[2]=1;
            buttonPosition[2]=1;
        }
        else if (xPlayerWon[2] == 1 && xPlayerWon[8] == 1 && oPlayerWon[5]== 0 && xPlayerWon[5]== 0){
            turnPosition++; //To Skep the next index
            b5.setImage(O);
            //b5.setStyle("-fx-background-color: #ee7070");
            oPlayerWon[5]=1;
            buttonPosition[5]=1;
        }
        else if (! emptyPositions.isEmpty()){            
            if (emptyPositions.get(computerPosition) == 0){
                b0.setImage(O);
                //b0.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 1){
                b1.setImage(O);
                //b1.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 2){
                b2.setImage(O);
                //b2.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 3){
                b3.setImage(O);
                //b3.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 4){
                b4.setImage(O);
                //b4.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 5){
                b5.setImage(O);
                //b5.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 6){
                b6.setImage(O);
                //b6.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 7){
                b7.setImage(O);
                //b7.setStyle("-fx-background-color: #ee7070");
            }
            else if (emptyPositions.get(computerPosition) == 8){
                b8.setImage(O);
                //b8.setStyle("-fx-background-color: #ee7070");
            }
            turnPosition++; //To Skep the next index
            oPlayerWon[emptyPositions.get(computerPosition)]=1;
            buttonPosition[emptyPositions.get(computerPosition)]=1;
        }
        
    }
    
    private int xPlayerWonGame(){
        if (xPlayerWon[0]==1 && xPlayerWon[1]==1 && xPlayerWon[2]==1){
            return 1;
        }
        if (xPlayerWon[3]==1 && xPlayerWon[4]==1 && xPlayerWon[5]==1){
            return 1;
        }
        if (xPlayerWon[6]==1 && xPlayerWon[7]==1 && xPlayerWon[8]==1){
            return 1;
        }
        if (xPlayerWon[0]==1 && xPlayerWon[3]==1 && xPlayerWon[6]==1){
            return 1;
        }
        if (xPlayerWon[1]==1 && xPlayerWon[4]==1 && xPlayerWon[7]==1){
            return 1;
        }
        if (xPlayerWon[2]==1 && xPlayerWon[5]==1 && xPlayerWon[8]==1){
            return 1;
        }
        if (xPlayerWon[0]==1 && xPlayerWon[4]==1 && xPlayerWon[8]==1){
            return 1;
        }
        if (xPlayerWon[2]==1 && xPlayerWon[4]==1 && xPlayerWon[6]==1){
            return 1;
        }
        return 0;
    }
    
    int computerWonGame(){
        if (oPlayerWon[0]==1 && oPlayerWon[1]==1 && oPlayerWon[2]==1){
            return 1;
        }
        if (oPlayerWon[3]==1 && oPlayerWon[4]==1 && oPlayerWon[5]==1){
            return 1;
        }
        if (oPlayerWon[6]==1 && oPlayerWon[7]==1 && oPlayerWon[8]==1){
            return 1;
        }
        if (oPlayerWon[0]==1 && oPlayerWon[3]==1 && oPlayerWon[6]==1){
            return 1;
        }
        if (oPlayerWon[1]==1 && oPlayerWon[4]==1 && oPlayerWon[7]==1){
            return 1;
        }
        if (oPlayerWon[2]==1 && oPlayerWon[5]==1 && oPlayerWon[8]==1){
            return 1;
        }
        if (oPlayerWon[0]==1 && oPlayerWon[4]==1 && oPlayerWon[8]==1){
            return 1;
        }
        if (oPlayerWon[2]==1 && oPlayerWon[4]==1 && oPlayerWon[6]==1){
            return 1;
        }
        return 0;
    }
    
    @FXML
    private void playAgainButtonAction(ActionEvent event) {
        b0.setImage(null);
        //b0.setStyle("-fx-background-color: TRANSPARENT");
        b1.setImage(null);
        //b1.setStyle("-fx-background-color: TRANSPARENT");
        b2.setImage(null);
        //b2.setStyle("-fx-background-color: TRANSPARENT");
        b3.setImage(null);
        //b3.setStyle("-fx-background-color: TRANSPARENT");
        b4.setImage(null);
        //b4.setStyle("-fx-background-color: TRANSPARENT");
        b5.setImage(null);
        //b5.setStyle("-fx-background-color: TRANSPARENT");
        b6.setImage(null);
        //b6.setStyle("-fx-background-color: TRANSPARENT");
        b7.setImage(null);
        //b7.setStyle("-fx-background-color: TRANSPARENT");
        b8.setImage(null);
        //b8.setStyle("-fx-background-color: TRANSPARENT");
        
        turnPosition = 2;
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
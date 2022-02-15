
package ticTac;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javax.imageio.ImageIO;

/**
 *
 * @author Moutaz
 */
public class SingleGameScreenController implements Initializable {
    
    Dialog<ButtonType> dialog = new Dialog<>(); 
    
    private int computerPosition=0;
    
    private int turnPosition = 2; //To get the correct position of X and O
    
    @FXML
    private Button b0;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    
    @FXML
    private Label ur_score;
    
    @FXML
    private Label cump_score;
    
    private int your_score=0;
    private int computer_score=0;

    private int buttonPosition[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    private int xPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //player
    private int oPlayerWon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //computer
    
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
    
    private void xWinnerAction() throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("xWinner.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.setTitle("Winner");
    }
    
    private void oWinnerAction() throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("oWinner.fxml"));
        DialogPane winner = fxmlLoader.load();
        
        dialog.setDialogPane(winner);
        dialog.setTitle("Game Over");
    }
    
    @FXML
    private void b0ButtonAction(ActionEvent event) throws InterruptedException, IOException {
        
        if (buttonPosition[0]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b0.setText("X");
               
                buttonPosition[0]=1;
                xPlayerWon[0]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();

                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                        
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b1ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[1]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b1.setText("X");
               
                buttonPosition[1]=1;
                xPlayerWon[1]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }
                
                                
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b2ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[2]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b2.setText("X");
               
                buttonPosition[2]=1;
                xPlayerWon[2]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }             
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b3ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[3]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b3.setText("X");
               
                buttonPosition[3]=1;
                xPlayerWon[3]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b4ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[4]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b4.setText("X");
               
                buttonPosition[4]=1;
                xPlayerWon[4]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b5ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[5]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b5.setText("X");
               
                buttonPosition[5]=1;
                xPlayerWon[5]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }              
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b6ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[6]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b6.setText("X");
               
                buttonPosition[6]=1;
                xPlayerWon[6]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b7ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[7]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b7.setText("X");
               
                buttonPosition[7]=1;
                xPlayerWon[7]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }               
            }
        }
        else{
            System.out.println("this button is already used!!!!!");
        }
    }
    
    @FXML
    private void b8ButtonAction(ActionEvent event) throws IOException {
        
        if (buttonPosition[8]==0){
            
            if(turnPosition %2 == 0){
                
                turnPosition++; //To Skep the next index
                b8.setText("X");
               
                buttonPosition[8]=1;
                xPlayerWon[8]=1;
                
                int xResult= xPlayerWonGame();
                
                
                if (xResult == 1){
                    updatePlayerScore();
                    
                    xWinnerAction();
                    dialog.show();
                }
                else{
                    computerPlayer();
                    int oResult= computerWonGame();

                    if (oResult == 1){
                        updateComputerScore();
                        
                        for (int i=0 ; i<buttonPosition.length ; i++){
                            buttonPosition[i]=1;
                        }
                        oWinnerAction();
                        dialog.show();
                    }  
                }                
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
     
        if (! emptyPositions.isEmpty()){
            
            turnPosition++; //To Skep the next index
            
            if (emptyPositions.get(computerPosition) == 0){
                b0.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 1){
                b1.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 2){
                b2.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 3){
                b3.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 4){
                b4.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 5){
                b5.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 6){
                b6.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 7){
                b7.setText("O");
            }
            else if (emptyPositions.get(computerPosition) == 8){
                b8.setText("O");
            }
            
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
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        
        turnPosition = 2;
        for (int i=0 ; i<9 ; i++){
            buttonPosition[i] = 0;
            xPlayerWon[i] = 0;
            oPlayerWon[i] = 0;
        }
        
    }
    
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("mainMenu.fxml");
        
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
    
    @FXML
    private void PauseButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

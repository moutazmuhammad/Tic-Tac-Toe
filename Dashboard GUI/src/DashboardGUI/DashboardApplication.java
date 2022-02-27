/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DashboardGUI;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONObject;


/**
 *
 * @author Zaina
 */

enum DahboardMsg {
  START,
  STOP,
  GETALLPLAYERS,
  CLOSE
}


public class DashboardApplication extends Application {
    
    public static Session session;
    @Override
    public void init(){
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setResizable(false);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
            Image icon = new Image("DashboardGUI/icon.png");
            primaryStage.getIcons().add(icon);
            Scene scene = new Scene(root, 780, 680);
            primaryStage.setScene(scene);
            primaryStage.show();
            session = new Session((DashboardController)loader.getController());
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
    @Override
    public void stop(){
        try {
            super.stop();
            session.CloseConnection();
            session.stop();
        } catch (Exception ex) {
            Logger.getLogger(DashboardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

class Session extends Thread{
    private Socket socket;
    private DataInputStream inputStream;
    private PrintStream printStream;
    DashboardController dashboardController;
    JSONObject Message ;


    public Session(DashboardController dashboardController)
    {
        openConnection();
        this.dashboardController = dashboardController;
        start();
    }

    public void openConnection(){
        try {
            socket = new Socket("127.0.0.1",5004);
            printStream = new PrintStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
        }
    }

    public void CloseConnection(){
        Message = new JSONObject();
        Message.put("type",DahboardMsg.CLOSE);
        printStream.println(Message);
        try {
            printStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void startServer (){
        JSONObject js = new JSONObject();
        js.put("type", DahboardMsg.START);
        printStream.println(js);
    }
    
    public void stopServer (){
        JSONObject js = new JSONObject();
        js.put("type", DahboardMsg.STOP);
        printStream.println(js);
    }
    
    private void getAllPlayers(JSONObject Message){
        String[] name = Message.get("names").toString().split(",");
        String[] score = Message.get("scores").toString().split(",");
        String[] id = Message.get("id").toString().split(",");
        ObservableList<String> online = FXCollections.observableArrayList(Message.get("online").toString().split(","));
        player [] playerList = new player[name.length-1];
        for(int a = 1; a < name.length; a++){
            if(online.contains(id[a])){
                playerList[a-1] = new player(name[a], "online", score[a]);
            }else
                playerList[a-1] = new player(name[a], "offline", score[a]);
        }
        ObservableList<player> list = FXCollections.observableArrayList(playerList);
        dashboardController.insertOnlinePlayers(list);
    }
    
    public void run(){
        while(true){
            try {
            String re = inputStream.readLine();
            if(re == null)
            {
                return;
            }
            JSONObject response = new JSONObject(re);
            DahboardMsg msg = response.getEnum(DahboardMsg.class,"type");
            switch (msg) {
                case GETALLPLAYERS:
                    getAllPlayers(response);
                    break;
            }
            } catch (Exception ex) {
                return;
            }
        }
    }
}
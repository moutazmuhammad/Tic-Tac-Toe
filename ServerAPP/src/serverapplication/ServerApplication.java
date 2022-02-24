/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverapplication;

import db.database;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author amr
 */

enum Status {
  ON,
  OFF
}

enum DahboardMsg {
  START,
  STOP,
  CLOSE
}

enum ClientMsg {
  SIGNIN,
  SIGNUP,
  GET_LEADERBOARD,
  GET_ONLINE_PLAYERS,
  CLOSE_CONNECTION,
  INVETATION_SEND,
  INVETATION_REPLY,
  START_GAME,
  RECORD_GAME,
  GET_GAME,
  GET_RECORDED_GAMES,
  ADD_MOVE,
  SEND_MESSAGE,
  END_GAME
}

public class ServerApplication {
    
    public static Status server_status;
    ClientServer clientServer;
    ServerSocket dashboardServerSocket;
    Socket dashboardSocket;
    DataInputStream dis;
    PrintStream ps;
    database db;
    
    public ServerApplication() {
        db = new database();
        server_status = Status.OFF;
        clientServer = new ClientServer(db);
        try {
            dashboardServerSocket = new ServerSocket(5004);
            while(true){
                dashboardSocket = dashboardServerSocket.accept();
                connectDashboard();
                runDashboard();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void runDashboard(){
        while(true){
            try {
                JSONObject request = new JSONObject(dis.readLine());
                System.out.println(request);
                DahboardMsg msg = request.getEnum(DahboardMsg.class,"type");
                
                switch (msg) {
                    case START:
                        if(server_status == Status.OFF)
                            startServer();
                        break;
                    case STOP:
                        if(server_status == Status.ON)
                            stopServer();
                        break;
                    case CLOSE:
                        closeDashboard();
                        return;
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void connectDashboard(){
        try {
            dis = new DataInputStream(dashboardSocket.getInputStream());
            ps = new PrintStream(dashboardSocket.getOutputStream());
            System.out.println("dashboard added");
        } catch (IOException ex) {
            Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void closeDashboard (){
        try {
            ps.println("closing dashboard");
            dis.close();
            ps.close();
            dashboardSocket.close();
            System.out.println("dashboard removed");
        } catch (IOException ex) {
            Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void startServer(){
        server_status = Status.ON;
        db.connect();
        System.out.println("started");
    }
    
    void stopServer(){
        server_status = Status.OFF;
        ClientHandler.closeServer();
        db.close();
        System.out.println("stopped");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ServerApplication();
    }
    
    
    
    class ClientServer extends Thread{
        public ServerSocket clientsServerSocket;
        database db;
        
        public ClientServer(database _db) {
            db = _db;
            try {
                clientsServerSocket = new ServerSocket(5005);
            } catch (IOException ex) {
                Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            start();
        }

        @Override
        public void run() {
            while(true){
                try {
                    Socket s = clientsServerSocket.accept();
                    new ClientHandler(s,db);
                } catch (IOException ex) {
                    Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

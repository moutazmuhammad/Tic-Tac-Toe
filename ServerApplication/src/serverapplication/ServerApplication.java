/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverapplication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amr
 */

enum status {
  ON,
  OFF
}

public class ServerApplication {
    
    public static status server_status;
    ClientServer clientServer;
    ServerSocket dashboardServerSocket;
    Socket dashboardSocket;
    DataInputStream dis;
    PrintStream ps;
    
    public ServerApplication() {
        server_status = status.OFF;
        clientServer = new ClientServer();
        clientServer.start();
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
                String str = dis.readLine();
                switch (str) {
                    case "start":
                        if(server_status == status.OFF)
                            startServer();
                        break;
                    case "stop":
                        if(server_status == status.ON)
                            stopServer();
                        break;
                    case "close":
                        closeDashboard();
                        return;
                }
            } catch (IOException ex) {
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
            dis.close();
            ps.close();
            dashboardSocket.close();
            System.out.println("dashboard removed");
        } catch (IOException ex) {
            Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void startServer(){
        server_status = status.ON;
        ps.println("started");
    }
    
    void stopServer(){
        server_status = status.OFF;
        ClientHandler.closeServer();
        ps.println("stopped");
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

        public ClientServer() {
            try {
                clientsServerSocket = new ServerSocket(5005);
            } catch (IOException ex) {
                Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            while(true){
                try {
                    Socket s = clientsServerSocket.accept();
                    new ClientHandler(s);
                } catch (IOException ex) {
                    Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapplication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amr
 */
public class ClientHandler extends Thread{
    
    DataInputStream dis;
    PrintStream ps;
    static Vector<ClientHandler> clientsVector = new Vector<ClientHandler>();
    
    public ClientHandler(Socket sc){
        try {
            ps = new PrintStream(sc.getOutputStream());
            dis = new DataInputStream(sc.getInputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run(){
        if(ServerApplication.server_status == status.ON)
        {
            if(log()){
                clientsVector.add(this);
            }else{
                return;
            }
        }
        else{
            ps.println("server is closed");
            closeConnection();
            return;
        }
        
        while(true){
            try {
                String str = dis.readLine();
                switch (str) {
                    case "start game":
                       ps.println("game started");
                        break;
                    case "invite":
                       ps.println("invited");
                       break;
                    case "close":
                       clientsVector.remove(this);
                       closeConnection();
                       return;
                }
               
           } catch (IOException ex) {
               Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
   
    boolean log(){
        while(true){
        try {
            String str = dis.readLine();
            switch (str) {
                case "signin":
                    ps.println("signedin");
                    return true;
                case "signup":
                    ps.println("signedup");
                    return true;
                case "close":
                    closeConnection();
                    return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
    void signIn(){
       
    }

    void signUp(){

    }

    void closeConnection(){
        try {
            dis.close();
            ps.close();
            stop();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeServer(){
        for(ClientHandler c : clientsVector){
            c.closeConnection();
        }
        clientsVector.clear();
    }
    
    void invite(){

    }

}

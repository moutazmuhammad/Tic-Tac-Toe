/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zaina
 */
public class database {
    public static final String DB_URL = "jdbc:postgresql://ec2-3-212-143-188.compute-1.amazonaws.com:5432/d8g9m7j456ubvt";
    public static final String USER = "tzpwkgojaaikyw";
    public static final String PASS = "2ed25f4dd78f0a67b550541a5d69f97cadad779c808dc162a80518a6af591ca1";
    Connection connection;
    Statement statement;
    PreparedStatement preparedSt;
    ResultSet resultSet;
    
    
    public void connect(){
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected Successfully");
        } catch (SQLException ex) {
            System.out.println("Connection Failed!");
        }
    }
    
    public void close(){
        try {
            connection.close();
            System.out.println("Connection Closed Successfully!");
        } catch (SQLException ex) {
            System.out.println("Connection Failed to close!");
        }
    }
    
    int signUp(String username, String password) throws SQLException {
        int status = 0;
        try {
            String insertNewPlayer = new String("insert into player(username, password, score) values(?, ?, ?);");
            preparedSt = connection.prepareStatement(insertNewPlayer);
            preparedSt.setString(1, username);
            preparedSt.setString(2, password);
            preparedSt.setInt(3, 0);
            status = preparedSt.executeUpdate();
        } catch (SQLException ex) {
            status = 0;
        }
        return status;
    }
    
    
    int signIn(String username, String password) {
        try {
            statement = connection.createStatement();
            String siginQuery = new String("select * from player where username = '"+username+"' and password = '"+password+"'");
            resultSet = statement.executeQuery(siginQuery);
            resultSet.next();
            //Check if these credentials are in the database
            if(resultSet.getString(2).equals(username) && resultSet.getString(3).equals(password)){
                System.out.println("Sign-in Authentication Successful!");
                return 1;
            }
        } catch (SQLException ex) {
            System.out.println("Sign-in Authentication Failed!");
        }
        return 0;

    }
    
    public Player getPlayerProfile(int player_id){
        Player playerProfile = new Player();
        try {
            statement = connection.createStatement();
            String siginQuery = new String("select * from player where id = "+player_id);
            resultSet = statement.executeQuery(siginQuery);
            resultSet.next();
            playerProfile.setId(resultSet.getInt(1));
            playerProfile.setUsername(resultSet.getString(2));
            playerProfile.setPassword(resultSet.getString(3));
            playerProfile.setScore(resultSet.getInt(4));
            
            //wins, losses and ties
            //wins
            String winQuery = new String("select count(g.id) as wins from done_games as g where " + player_id +" = player_1 and g.draw = false;");
            resultSet = statement.executeQuery(winQuery);
            resultSet.next();
            playerProfile.setWins(resultSet.getInt(1));
            
            //losses
            String loseQuery = new String("select count(g.id) as losses from done_games as g where " + player_id +" = player_2 and g.draw = false;");
            resultSet = statement.executeQuery(loseQuery);
            resultSet.next();
            playerProfile.setLosses(resultSet.getInt(1));
            
            //ties
            String tieQuery = new String("select count(g.draw) as ties from done_games as g where "+ player_id + " in(g.player_1, player_2) and g.draw = true;");
            resultSet = statement.executeQuery(tieQuery);
            resultSet.next();
            playerProfile.setTies(resultSet.getInt(1));
        } catch (SQLException ex) {
            System.out.println("There is no player with such an id!");
        }
        return playerProfile;
    }
    
    
    public int increaseScore(int player_id){
        int status;
        try {
            String increaseScore = new String("update player set score = score + 5 where id = ?");
            preparedSt = connection.prepareStatement(increaseScore);
            preparedSt.setInt(1, player_id);
            status = preparedSt.executeUpdate();    
        } catch (SQLException ex) {
            ex.printStackTrace();
            status = 0;
        }
        return status;   
    }
    
    
    public int insertDoneGame(int winner, int loser, boolean draw){
        int status = 0;
        try {
            String insertNewGame = new String("insert into done_games(player_1, player_2, draw) values(?, ?, ?);");
            preparedSt = connection.prepareStatement(insertNewGame);
            preparedSt.setInt(1, winner);
            preparedSt.setInt(2, loser);
            preparedSt.setBoolean(3, draw);
            status = preparedSt.executeUpdate();
        } catch (SQLException ex) {
            status = 0;
        }
        return status;
        
    }
    
    public int insertRecordedGame(int player1_id, int player2_id, String moves){
       int status = 0;
       //Save the X moves in a vector and the same for the O moves
       Vector<String> XMoves = new Vector();
       Vector<String> OMoves = new Vector();
       String lastMove = new String();
       int count = 0;
       for(String move: moves.split("\\s"))
       {
           if(count % 2 == 0 && count != 8){
               XMoves.add(move);
           }else if(count % 2 != 0 && count != 8){
               OMoves.add(move);
           }else if(count == 8){
               lastMove = move;
           }
        count++;   
       }
       //Now we insert the recorded game
        try {
            String insertRecordedGame = new String("insert into recorded_games(player_1, player_2, x1, x2, x3, x4, o1, o2, o3, o4, lastmove) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedSt = connection.prepareStatement(insertRecordedGame);
            preparedSt.setInt(1, player1_id);
            preparedSt.setInt(2, player2_id);
            preparedSt.setString(3, XMoves.get(0));
            preparedSt.setString(4, XMoves.get(1));
            preparedSt.setString(5, XMoves.get(2));
            preparedSt.setString(6, XMoves.get(3));
            preparedSt.setString(7, OMoves.get(0));
            preparedSt.setString(8, OMoves.get(1));
            preparedSt.setString(9, OMoves.get(2));
            preparedSt.setString(10, OMoves.get(3));
            preparedSt.setString(11, lastMove);
            status = preparedSt.executeUpdate();
        } catch (SQLException ex) {
            status = 0;
        }
        return status;
    }
    
    public String getRecordedGame(int game_id){
        return null;
        
    }
    
    public String getLeaderBoard (){
        String leaderBoard = new String();
        try {
            statement = connection.createStatement();
            String leaderBoardQuery = new String("select username, score from player where username not in('computer') order by score desc limit 10;");
            resultSet = statement.executeQuery(leaderBoardQuery);
            while(resultSet.next()){
                leaderBoard += resultSet.getString(1)+" ";
                leaderBoard += resultSet.getInt(2)+" ";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return leaderBoard;
        
    }

}

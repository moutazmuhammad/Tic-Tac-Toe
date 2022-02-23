package controller;

public class Player {
    private int score;
    private int ID;
    private String status;
    private String username;


    public Player(String username,int score,int id)
    {
        this.username = username;
        this.score = score;
        ID = id;
    }
    
    

    public Player() {
    }

    public int getID() {return ID;}
    
    public void setID(int id) {this.ID = id;}
    
    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

}

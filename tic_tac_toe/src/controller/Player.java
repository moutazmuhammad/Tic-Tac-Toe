package controller;

public class Player {
    private int score;
    private String status;
    private String username;
    private String password;


    public Player(String username ,String password ,int score)
    {
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public Player() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}

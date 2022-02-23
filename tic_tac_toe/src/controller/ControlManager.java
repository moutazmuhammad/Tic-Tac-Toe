/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.FXMLLoader;

/**
 *
 * @author amr
 */
public class ControlManager {
    private LeaderBoardController leaderBoardController;
    private LoginController loginController ;
    private MultiGameScreenController multiGameScreenController;
    private PlayerInvitationController invitationController;
    private RecordedGames recordedGames;
    private SignUpController signUpController;

    public LeaderBoardController getLeaderBoardController() {
        return leaderBoardController;
    }

    public void setLeaderBoardController(FXMLLoader loader) {
        this.leaderBoardController = (LeaderBoardController)loader.getController();
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(FXMLLoader loader) {
        this.loginController = (LoginController)loader.getController();
    }

    public MultiGameScreenController getMultiGameScreenController() {
        return multiGameScreenController;
    }

    public void setMultiGameScreenController(FXMLLoader loader) {
        this.multiGameScreenController = (MultiGameScreenController)loader.getController();
    }

    public PlayerInvitationController getInvitationController() {
        return invitationController;
    }

    public void setInvitationController(FXMLLoader loader) {
        this.invitationController = (PlayerInvitationController)loader.getController();
    }

    public RecordedGames getRecordedGames() {
        return recordedGames;
    }

    public void setRecordedGames(FXMLLoader loader) {
        this.recordedGames = (RecordedGames)loader.getController();
    }

    public SignUpController getSignUpController() {
        return signUpController;
    }

    public void setSignUpController(FXMLLoader loader) {
        this.signUpController = (SignUpController)loader.getController();
    }
}

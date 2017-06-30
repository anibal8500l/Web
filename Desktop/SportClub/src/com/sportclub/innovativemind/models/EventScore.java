/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ThinkUser001
 */
public class EventScore implements Serializable{
    private int id;
    private int scoreTeam1;
    private int scoreTeam2;

    public EventScore(int id, int scoreTeam1, int scoreTeam2) {
        this.id = id;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    public EventScore() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public static EventScore buildFromResultSet(ResultSet resultSet){
        EventScore eventScore = null;
        try {
            eventScore = new EventScore(
                    resultSet.getInt("event_score_id"),
                    resultSet.getInt("team1_score"),
                    resultSet.getInt("team2_score")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventScore;
    }
}

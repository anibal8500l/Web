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
public class TeamPlayer implements Serializable {
    private int id;
    private Team teamId;
    private User userId;

    public TeamPlayer(int id, Team teamId, User userId) {
        this.id = id;
        this.teamId = teamId;
        this.userId = userId;
    }

    public TeamPlayer() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public static TeamPlayer buildFromResultSet(ResultSet resultSet){
        TeamPlayer teamPlayer = null;
        Team team = new Team();
        User user = new User();
        try {
            team.setId(resultSet.getInt("team_id"));
            user.setId(resultSet.getInt("user_id"));
            
            
            teamPlayer = new TeamPlayer(
                    resultSet.getInt("team_player_id"),
                    team,
                    user
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  teamPlayer;
    }
}

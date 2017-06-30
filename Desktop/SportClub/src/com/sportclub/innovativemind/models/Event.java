/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ThinkUser001
 */
public class Event implements Serializable {
   private int id;
    private Date dateIn;
    private Date dateOut;
    private String description;
    private Team team1Id;
    private Team team2Id;
    private User userCreatorId;
    private Court courtId;

    public Event(int id, Date dateIn, Date dateOut,
                String description, Team team1Id,
                Team team2Id, User userCreatorId,
                Court courtId) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.description = description;
        this.team1Id=team1Id ;
        this.team2Id=team2Id;
        this.userCreatorId=userCreatorId;
        this.courtId=courtId;
    }

    public Event() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Team team1Id) {
        this.team1Id = team1Id;
    }

    public Team getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Team team2Id) {
        this.team2Id = team2Id;
    }

    public User getUserCreatorId() {
        return userCreatorId;
    }

    public void setUserCreatorId(User userCreatorId) {
        this.userCreatorId = userCreatorId;
    }

    public Court getCourtId() {
        return courtId;
    }

    public void setCourtId(Court courtId) {
        this.courtId = courtId;
    }

    public static Event buildFromResultSet(ResultSet resultSet){
        Event event = null;
        Team team1= new Team();
        Team team2 = new Team();
        User user = new User();
        Court court = new Court();
        
        try {
            team1.setId(resultSet.getInt("team1_id"));
            team2.setId(resultSet.getInt("team2_id"));
            user.setId(resultSet.getInt("user_id")); ;
            court.setId(resultSet.getInt("court_id")); ;
            event = new Event(
                    resultSet.getInt("event_id"),
                    resultSet.getDate("date_in"),
                    resultSet.getDate("date_out"),
                    resultSet.getString("description"),
                    team1,
                    team2,
                    user,
                    court
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }
}

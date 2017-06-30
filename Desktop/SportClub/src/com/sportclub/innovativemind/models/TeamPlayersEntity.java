/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinkUser001
 */
public class TeamPlayersEntity extends BaseEntity {

    private static final String QUERY_FIND_ALL =
            "SELECT * FROM team_players ";

    private TeamPlayer findBy(String condition){
        TeamPlayer teamPlayer = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if(resultSet.next()){
                teamPlayer = TeamPlayer.buildFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamPlayer;
    }

    public TeamPlayer findById(int id){
        String query = "WHERE team_player_id = "+id;
        return findBy(query);
    }

    private List<TeamPlayer> findAllByCriteria(String criteria){
        List<TeamPlayer> teamPlayers = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
        if(resultSet!=null){
            teamPlayers= new ArrayList<>();
            try {
                while(resultSet.next()){
                    TeamPlayer teamPlayer = TeamPlayer.buildFromResultSet(resultSet);
                    teamPlayers.add(teamPlayer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teamPlayers;
    }

    public List<TeamPlayer> findAll(){
        return findAllByCriteria("");
    }
    
    public boolean delete(int id){
        String sql ="DELETE FROM team_players WHERE team_player_id = "+id;
        return (executeUpdate(sql) >0);
    }
    
    public boolean update(
            int id,
            Team teamId,
            User userId
    ) {
        return (executeUpdate(
                "UPDATE sportclub.team_players "
                + " SET"
                + " team_player_id = " + id + ","
                + " team_id = " + teamId.getId() + ","
                + " user_id = " + userId.getId()
                + " WHERE team_player_id = " + id + ";"
        ) > 0);

    }

    public boolean add(
            int id,
            Team teamId,
            User userId
    ) {
        return (executeUpdate(
                "INSERT INTO sportclub.team_players"
                + " ("
                //+ " team_player_id,"
                + " team_id,"
                + " user_id"
                + " )"
                + " VALUES"
                + " ("
                //+ id+","
                + teamId.getId() +","
                + userId.getId()
                + " );"
        ) > 0);
    }
}
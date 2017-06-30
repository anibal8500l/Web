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
public class TeamsEntity extends BaseEntity{

    private static final String QUERY_FIND_ALL =
            "SELECT * FROM sportclub.teams ";

    private Team findBy(String condition){
        Team team = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if(resultSet.next()){
                team = Team.buildFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    public Team findById(int id){
        String query = "WHERE team_id = "+id;
        return findBy(query);
    }

    public Team findByName(String name){
        String query = "WHERE team_name = '" + name + "'";
        return  findBy(query);
    }

    private List<Team> findAllByCriteria(String criteria){
        List<Team> teams = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
        if(resultSet!=null){
            teams= new ArrayList<>();
            try {
                while(resultSet.next()){
                    Team team = Team.buildFromResultSet(resultSet);
                    teams.add(team);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teams;
    }

    public List<Team> findAll(){
        return findAllByCriteria("");
    }

    public List<Team> findAllOrderedByName(){
        return findAllByCriteria("ORDER by team_name");
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM sportclub.teams WHERE team_id = " + id;
        return (executeUpdate(sql) > 0);
    }
    
    public boolean update(
            int id,
            String name
    ) {
        return (executeUpdate(
                "UPDATE `sportclub`.`teams`"
                        + " SET"
                        + " `team_id` = " + id + ","
                        + " `name` = '" + name + "'"
                        + " WHERE `team_id` = " + id + ";"
        ) > 0);
    }
    
    public boolean add(
            int id,
            String name
    ) {
        return (executeUpdate(
                "INSERT INTO sportclub.teams ("
                //+ " team_id,"
                + " name"
                + " )"
                + " VALUES ("
                //+ " 12,"
                + " '" + name + "'"
                + ");"
        ) > 0);
    }
}

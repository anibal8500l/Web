/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ThinkUser001
 */
public class EventsEntity extends BaseEntity{
    
    private static final String QUERY_FIND_ALL =
            "SELECT * FROM sportclub.events ";

    private Event findBy(String condition){
        Event event = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if(resultSet.next()){
                event = Event.buildFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    public Event findById(int id){
        String query = "WHERE event_id = "+id;
        return findBy(query);
    }


    private List<Event> findAllByCriteria(String criteria){
        List<Event> events = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
        if(resultSet!=null){
            events= new ArrayList<>();
            try {
                while(resultSet.next()){
                    Event event = Event.buildFromResultSet(resultSet);
                    events.add(event);
                    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return events;
    }

    public List<Event> findAll(){
        return findAllByCriteria("");
    }
    
    
    public boolean delete(int id) {
        String sql = "DELETE FROM events WHERE event_id = " + id;
        return (executeUpdate(sql) > 0);
    }

    
    public boolean update(int id, Date dateIn, Date dateOut,
                          String description, Team team1Id,
                     Team team2id, User userCreatorId,
            Court courtId) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = formateador.format(dateIn);
        String dateOutString = formateador.format(dateOut);
        return (executeUpdate(
                "UPDATE events "
                + " SET"
                + " event_id = " + id + ","
                + " date_in = '" + dateInString + "',"
                + " date_out = '" + dateOutString + "',"
                + " description = '" + description + "',"
                + " team1_id = " + team1Id.getId() + ","
                + " team2_id = " + team2id.getId() + ","
                + " user_id = " + userCreatorId.getId() + ","
                + " court_id = " + courtId.getId()
                + " WHERE event_id = " + id + ";"
        ) > 0);
    }
    
    public boolean add(int id, Date dateIn, Date dateOut,
                          String description, Team team1Id,
                          Team team2id, User userCreatorId,
            Court courtId) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

        return (executeUpdate(
                "INSERT INTO events("
                //+ "event_id,"
                + " date_in,"
                + " date_out,"
                + " description,"
                + " team1_id,"
                + " team2_id,"
                + " user_id,"
                + " court_id) "
                + " VALUES('"
                //+ id + ","
                + formateador.format(dateIn) + "','"
                + formateador.format(dateOut) + "','"
                + description + "', "
                + team1Id.getId() + ", "
                + team2id.getId() + ", "
                + userCreatorId.getId() + ", "
                + courtId.getId() 
                + ")"
        ) > 0);
    }



}

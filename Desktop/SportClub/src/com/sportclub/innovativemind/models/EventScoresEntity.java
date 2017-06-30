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
public class EventScoresEntity extends BaseEntity {

    private static final String QUERY_FIND_ALL
            = "SELECT * FROM event_scores ";

    private EventScore findBy(String condition) {
        EventScore eventScore = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if (resultSet.next()) {
                eventScore = EventScore.buildFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventScore;
    }

    public EventScore findById(int id) {
        String query = "WHERE event_score_id = " + id;
        return findBy(query);
    }

    private List<EventScore> findAllByCriteria(String criteria) {
        List<EventScore> eventScores = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
        if (resultSet != null) {
            eventScores = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    EventScore eventScore = EventScore.buildFromResultSet(resultSet);
                    eventScores.add(eventScore);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eventScores;
    }

    public List<EventScore> findAll() {
        return findAllByCriteria("");
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM event_scores WHERE event_score_id = " + id;
        return (executeUpdate(sql) > 0);
    }

    public boolean update(
            int id,
            int scoreTeam1,
            int scoreTeam2
    ) {
        return (executeUpdate(
                "UPDATE sportclub.event_scores"
                + " SET"
                + " event_score_id = " + id + ","
                + " team1_score = " + scoreTeam1 + ","
                + " team2_score = " + scoreTeam2
                + " WHERE event_score_id = " + id + ";"
        ) > 0);
    }

    public boolean add(
            int id,
            int scoreTeam1,
            int scoreTeam2
    ) {
        return (executeUpdate(
                "INSERT INTO sportclub.event_scores"
                + " ("
                //+ " event_score_id,"
                + " team1_score,"
                + " team2_score"
                + " )"
                + " VALUES"
                + " ("
                //+ id + ","
                + scoreTeam1 + ","
                + scoreTeam2
                + " );"
        ) > 0);
    }
}

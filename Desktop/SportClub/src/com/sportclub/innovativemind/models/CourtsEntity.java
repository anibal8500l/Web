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
public class CourtsEntity extends BaseEntity {

    private static final String QUERY_FIND_ALL
            = "SELECT * FROM courts ";

    private Court findBy(String condition) {
        Court court = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if (resultSet.next()) {
                court = Court.buildFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return court;
    }

    public Court findById(int id) {
        String query = "WHERE court_id = " + id;
        return findBy(query);
    }

    public Court findByName(String name) {
        String query = "WHERE court_name = '" + name + "'";
        return findBy(query);
    }

    private List<Court> findAllByCriteria(String criteria) {
        List<Court> courts = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
        if (resultSet != null) {
            courts = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Court court = Court.buildFromResultSet(resultSet);
                    courts.add(court);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courts;
    }

    public List<Court> findAll() {
        return findAllByCriteria("");
    }

    public List<Court> findAllOrderedByName() {
        return findAllByCriteria("ORDER by court_name");
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM courts WHERE court_id =" + id;
        return (executeUpdate(sql) > 0);
    }

    public boolean add(
            int id,
            String type,
            String image,
            float price,
            int score,
            SportCenter sportCenterId
    ) {

        return (executeUpdate(
                "INSERT INTO sportclub.courts ("
                // + " court_id,"
                + " type,"
                + " image,"
                + " price,"
                + " score,"
                + " sport_center_id"
                + " )"
                + " VALUES ("
                //+ id + ","
                + " '" + type + "',"
                + " '" + image + "',"
                + price + ","
                + score + ","
                + sportCenterId.getId()
                + " );"
        ) > 0);
    }

    public boolean update(
            int id,
            String type,
            String image,
            float price,
            int score,
            SportCenter sportCenterId
    ) {
        
        return (executeUpdate(
                "UPDATE sportclub.courts"
                + " SET"
                //+ " court_id = " + id + ","
                + " type = '" + type + "',"
                + " image = '" + image + "',"
                + " price = " + price + ","
                + " score = " + score + ","
                + " sport_center_id = " + sportCenterId.getId()
                + " WHERE court_id = " + id
                + " ;"
        ) > 0);
    }
}

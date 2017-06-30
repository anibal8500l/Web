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
public class SportCentersEntity extends  BaseEntity{
    private static final String QUERY_FIND_ALL =
            "SELECT * FROM sport_centers ";

    private SportCenter findBy(String condition){
        SportCenter sportCenter = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if(resultSet.next()){
                sportCenter = SportCenter.buildFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sportCenter;
    }

    public SportCenter findById(int id){
        String query = " WHERE sport_center_id = "+id;
        return findBy(query);
    }

    private List<SportCenter> findAllByCriteria(String criteria){
        List<SportCenter> sportCenters = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
        if(resultSet!=null){
            sportCenters= new ArrayList<>();
            try {
                while(resultSet.next()){
                    SportCenter sportCenter = SportCenter.buildFromResultSet(resultSet);
                    sportCenters.add(sportCenter);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sportCenters;
    }

    public List<SportCenter> findAll(){
        return findAllByCriteria("");
    }
    
    public boolean delete( int id){
        String sql = "DELETE FROM sport_centers WHERE sport_center_id = " + id;
        return (executeUpdate(sql) > 0);
    }

    public boolean update(
            int id,
            String name,
            String address,
            String phone,
            String image,
            String description,
            User userId
    ) {
        return (executeUpdate(
                " UPDATE sportclub.sport_centers"
                + " SET"
                //+ " sport_center_id = "+id+","
                + " name = '"+name+"',"
                + " address = '"+address+"',"
                + " phone = '"+phone+"',"
                + " image = '"+image+"',"
                + " description = '"+description+"',"
                + " user_id = " +userId.getId()
                + " WHERE sport_center_id = "+id
                        + ";"
                )>0 );
    }
    
    public boolean add(
            int id,
            String name,
            String address,
            String phone,
            String image,
            String description,
            User userId) {
        return (executeUpdate(
                "INSERT INTO sportclub.sport_centers\n"
                + " ("
                + " sport_center_id,"
                + " name,"
                + " address,"
                + " phone,"
                + " image,"
                + " description,"
                + " user_id"
                + " )"
                + " VALUES"
                + " ("
                + id + ","
                + " '"+name+"',"
                + " '"+address+"',"
                + " '"+phone+"',"
                + " '"+image+"',"
                + " '"+description+"',"
                + userId.getId()
                + " );"
        ) > 0);
    }
}

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
public class Court implements Serializable{
    private int id;
    private String type;
    private String image;
    private float price;
    private int score;
    private SportCenter sportCenterId;

    public Court() {
    }

    public Court(int id, String type, String image, float price, int score, SportCenter sportCenterId) {
        this.id = id;
        this.type = type;
        this.image = image;
        this.price = price;
        this.score = score;
        this.sportCenterId = sportCenterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public SportCenter getSportCenterId() {
        return sportCenterId;
    }

    public void setSportCenterId(SportCenter sportCenterId) {
        this.sportCenterId = sportCenterId;
    }
    
    
    public static Court buildFromResultSet(ResultSet resultSet) {
        Court court = null;
        SportCenter sportCenter = new SportCenter();
        try {
            sportCenter.setId(resultSet.getInt("sport_center_id"));

            court = new Court(
                    resultSet.getInt("court_id"),
                    resultSet.getString("type"),
                    resultSet.getString("image"),
                    resultSet.getFloat("price"),
                    resultSet.getInt("score"),
                   sportCenter
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return court;
    }

    
}
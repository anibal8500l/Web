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
public class SportCenter implements Serializable{
    private int id;
    private String name;
    private String address;
    private String phone;
    private String image;
    private String description;
    private User userId;

    public SportCenter() {
    }

    public SportCenter(int id, String name, String address, String phone, String image, String description, User userId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.description = description;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    
    
 

    public static SportCenter buildFromResultSet (ResultSet resultSet){
        SportCenter sportCenter = null;
        User user = new User();
        try {
            user.setId(resultSet.getInt("user_id"));
            
            sportCenter = new SportCenter(
                    resultSet.getInt("sport_center_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone"),
                    resultSet.getString("image"),
                    resultSet.getString("description"),
                    user
            );
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  sportCenter;
    }
}

package com.sportclub.innovativemind.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Usuario on 19/10/2016.
 */
public class BaseEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected int executeUpdate(String sql){
        int result=0;
        try {
            result = getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected ResultSet getQuery(String query){
        ResultSet resultSet = null;
        try {
            resultSet = getConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    protected boolean modifyWithCriteria(String dml){
        int result = 0;
        try {
            result = getConnection().createStatement().executeUpdate(dml);
            return (result>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

}




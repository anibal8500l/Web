package com.sportclub.innovativemind.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {

    private static final String QUERY_FIND_ALL =
            "SELECT * FROM users ";

    private User findBy(String condition){
        User user = null;
        String query = QUERY_FIND_ALL + condition;
        ResultSet resultSet = getQuery(query);
        try {
            if(resultSet.next()){
                user = User.buildFromResult(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findById(int id){
        String query = "WHERE user_id = "+id;
        return findBy(query);
    }

    public User findByName(String name){
        String query = "WHERE user_name = '" + name + "'";
        return  findBy(query);
    }

    private List<User> findAllByCriteria(String criteria){
        List<User> users = null;
        String query = QUERY_FIND_ALL + criteria;
        ResultSet resultSet = getQuery(query);
            if (resultSet!=null){
                users = new ArrayList<>();
                try {
                    while(resultSet.next()){
                        User user = User.buildFromResult(resultSet);
                        users.add(user);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return users;
    }

    public List<User> findAll(){
        return findAllByCriteria("");
    }

    public List<User> findAllOrderedByName(){
        return findAllByCriteria("ORDER by user_name");
    }

    public boolean update(int id, String email,
            String userName, String password,
            String firstName, String lastName,
            String role) {
        return (executeUpdate(
                "UPDATE users SET "
                + " email= '" + email + "',"
                + " user_name= '" + userName + "' ,"
                // + "password= " + password + " ,"
                + " first_name= '" + firstName + "' ,"
                + " last_name = '" + lastName + "' ,"
                + " role = '" + role + "'  "
                + "WHERE user_id = " + (id)
        ) > 0);
    }

    public boolean add(int id, String email, String userName, String password, String firstName, String lastName, String role){
        return (executeUpdate(
                "INSERT INTO users"
                + "( "
                + "email, "
                + "user_name,"
                + "password,"
                + "first_name,"
                + "last_name,"
                + "role"
                + ")"
                + "VALUES('"
                + email + "','"
                + userName + "','"
                + password + "','"
                + firstName + "','"
                + lastName + "','"
                + role
                + "')"
        ) > 0);
    }
    
    public boolean delete(int id){
        return ( executeUpdate(
                "DELETE FROM users WHERE user_id = "
                + id )
                > 0 );
    }
}

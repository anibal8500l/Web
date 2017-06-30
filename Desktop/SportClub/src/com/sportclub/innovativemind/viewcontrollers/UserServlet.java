/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThinkUser001
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/User"})
public class UserServlet extends HttpServlet {

    SpService service = new SpService();
    public static String USERS_URI_EDIT = "editUser.jsp";
    public static String USERS_URI_NEW = "newUser.jsp";
    public static String USERS_URI_INDEX = "/listUsers.jsp";
    public static String ACTIONS_NEW = "new";
    public static String ACTIONS_EDIT = "edit";
    public static String ACTIONS_CREATE = "create";
    public static String ACTIONS_UPDATE = "update";
    public static String ACTIONS_DELETE = "delete";
    public static String ACTIONS_INDEX = "index";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String actionUri = "";
        String message ="";
        if (ACTIONS_EDIT.equalsIgnoreCase(action)) {
            User user = service.getUser(
                    Integer.parseInt(request.getParameter("id"))
            );
            request.setAttribute("user", user);
            request.setAttribute("action", ACTIONS_EDIT);
            actionUri = USERS_URI_EDIT;
        } else if (ACTIONS_NEW.equalsIgnoreCase(action)) {
            actionUri = USERS_URI_NEW;
            request.setAttribute("action", ACTIONS_NEW);
            actionUri = USERS_URI_NEW;
        } else if (ACTIONS_DELETE.equalsIgnoreCase(action)) {

            if (service.deleteUser(Integer.parseInt(request.getParameter("id")) )) {
                message = "User updated";
            } else {
                message = "Error while updating";
            }
            log(message);
            actionUri = USERS_URI_INDEX;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String actionUri = "";
        String message ="";
        User user;
        if (ACTIONS_UPDATE.equalsIgnoreCase(action)) {
            user = service.getUser(Integer.parseInt(request.getParameter("id")));
            user.setEmail(request.getParameter("email"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setUserName(request.getParameter("userName"));
            user.setRole(request.getParameter("role"));
            user.setPassword("");

            if (service.updateUser(user)) {
                message = "User updated";
            } else {
                message = "Error while updating";
            }
            log(message);
            actionUri = USERS_URI_INDEX;
        } else if (ACTIONS_CREATE.equalsIgnoreCase(action)){
            user = new User();
            user.setId(0);
            user.setEmail(request.getParameter("email"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setUserName(request.getParameter("userName"));
            user.setRole(request.getParameter("role"));
            user.setPassword(request.getParameter("password"));
            
            if(service.addUser(user)){
                message = "User added";
            } else {
                message = "Error while adding";
            }
            log(message);
            actionUri = USERS_URI_INDEX;
            
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

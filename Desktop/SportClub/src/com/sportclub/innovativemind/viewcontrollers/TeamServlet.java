/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.Team;
import com.sportclub.innovativemind.models.TeamPlayer;
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
@WebServlet(name = "TeamServlet", urlPatterns = {"/Team"})
public class TeamServlet extends HttpServlet {

    
    SpService service = new SpService();
    public static String TEAM_URI_EDIT = "editTeam.jsp";
    public static String TEAM_URI_NEW = "/newTeam.jsp";
    public static String TEAM_URI_INDEX = "/listTeam.jsp";
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
        
        if(ACTIONS_EDIT.equalsIgnoreCase(action)){
            Team team = service.getTeam(
                    Integer.parseInt(request.getParameter("id"))
            );
            request.setAttribute("team",team);
            request.setAttribute("action",ACTIONS_EDIT);
            actionUri = TEAM_URI_EDIT;
        } else if( ACTIONS_NEW.equalsIgnoreCase(action)){
            actionUri = TEAM_URI_NEW;
            request.setAttribute("action", ACTIONS_NEW);
        } else if(ACTIONS_DELETE.equalsIgnoreCase(action)){
            if ( service.deleteTeam(
                    Integer.parseInt(request.getParameter("id")))
            ) {
                message = "team deleted";
            } else {
                message = "Error while updating";
            }
            log(message);
            actionUri = TEAM_URI_INDEX;
        }
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String actionUri = "";
        String message = "Error while updating";
        Team team;
        
        
        if( ACTIONS_UPDATE.equalsIgnoreCase(action)){
            team = new Team();

            team= service.getTeam(
                    Integer.parseInt(request.getParameter("id"))
            );

            team.setName(request.getParameter("name"));
            
            if(service.updateTeam(team)){
                message = "team updated";
            } else {
                message = "Error While updating";
            }
            
             log(message);
            actionUri = TEAM_URI_INDEX;
        } else if(ACTIONS_CREATE.equalsIgnoreCase(action)){
            
            team = new Team();
            
            //team.setId(Integer.parseInt(request.getParameter("id")));
            team.setName(request.getParameter("name"));
            
            if(service.addTeam(team)){
                message="team created";
            } else {
                message =" Error while creating";
            }
             log(message);
            actionUri = TEAM_URI_INDEX;
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

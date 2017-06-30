/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.Team;
import com.sportclub.innovativemind.models.TeamPlayer;
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
@WebServlet(name = "TeamPlayerServlet", urlPatterns = {"/TeamPlayer"})
public class TeamPlayerServlet extends HttpServlet {
    
    SpService service = new SpService();
    public static String TEAMPLAYER_URI_EDIT = "editTeamPlayer.jsp";
    public static String TEAMPLAYER_URI_NEW = "newTeamPlayer.jsp";
    public static String TEAMPLAYER_URI_INDEX = "/listTeamPlayer.jsp";
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TeamPlayerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeamPlayerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            TeamPlayer teamPlayer = service.getTeamPlayer(
                    Integer.parseInt(request.getParameter("id"))
            );
            request.setAttribute("teamPlayer", teamPlayer);
            request.setAttribute("action", ACTIONS_EDIT);
            actionUri = TEAMPLAYER_URI_EDIT;
        } else if (ACTIONS_NEW.equalsIgnoreCase(action)) {
            actionUri = TEAMPLAYER_URI_NEW;
            request.setAttribute("action", ACTIONS_NEW);
        } else if (ACTIONS_DELETE.equalsIgnoreCase(action)) {
            if (service.deleteTeamPlayer(
                    Integer.parseInt(request.getParameter("id"))
            )) {
                message = "teamPlayer updated";
            } else {
                message = "Error while updating";
            }
            log(message);
            actionUri = TEAMPLAYER_URI_INDEX;
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String actionUri = "";
        String message = "Error while updating";
        TeamPlayer teamPlayer;
        
        if(ACTIONS_UPDATE.equalsIgnoreCase(action)){
            Team team = new Team();
            User user = new User();
            
            team.setId(Integer.parseInt(request.getParameter("teamId")));
            user.setId(Integer.parseInt(request.getParameter("userId")));
            
            teamPlayer= service.getTeamPlayer(
                    Integer.parseInt(request.getParameter("id"))
            );
            
            teamPlayer.setId( Integer.parseInt(request.getParameter("id")) );
            teamPlayer.setTeamId(team);
            teamPlayer.setUserId(user);
            
            if(service.updateTeamPlayer(teamPlayer)){
                message = "Teamplayer updated";
            } else {
                message="Error while updating";
            }
            
            log(message);
            actionUri = TEAMPLAYER_URI_INDEX;
            
        } else if(ACTIONS_CREATE.equalsIgnoreCase(action)){
            Team team = new Team();
            User user = new User();
            teamPlayer = new TeamPlayer();
            
           team.setId(Integer.parseInt(request.getParameter("teamId")));
            user.setId(Integer.parseInt(request.getParameter("userId")));
            
            //teamPlayer.setId( Integer.parseInt(request.getParameter("id")) );
            teamPlayer.setTeamId(team);
            teamPlayer.setUserId(user);
            
            if(service.addTeamPlayer(teamPlayer)){
                message = "Teamplayer added";
            } else {
                message="Error while adding";
            }
            
            log(message);
            actionUri = TEAMPLAYER_URI_INDEX;
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

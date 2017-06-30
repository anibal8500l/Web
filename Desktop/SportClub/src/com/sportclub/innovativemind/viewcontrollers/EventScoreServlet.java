/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.EventScore;
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
@WebServlet(name = "EventScoreServlet", urlPatterns = {"/EventScore"})
public class EventScoreServlet extends HttpServlet {

    SpService service = new SpService();
    public static String EVENTSCORE_URI_EDIT = "editEventScore.jsp";
    public static String EVENTSCORE_URI_NEW = "newEventScore.jsp";
    public static String EVENTSCORE_URI_INDEX = "/listEventScore.jsp";
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
            EventScore eventScore = service.getEventScore(
                    Integer.parseInt(request.getParameter("id"))
            );
            request.setAttribute("eventScore", eventScore);
            request.setAttribute("action", ACTIONS_EDIT);
            actionUri = EVENTSCORE_URI_EDIT;
        } else if (ACTIONS_NEW.equalsIgnoreCase(action)){
            actionUri =EVENTSCORE_URI_NEW;
            request.setAttribute("action",ACTIONS_NEW);
            
        } else if(ACTIONS_DELETE.equalsIgnoreCase(action)){
            if(service.deleteEventScore(
            Integer.parseInt(request.getParameter("id")))){
                  message = "EventScore updated";
            } else {
                message = "Error while updating";
            }
            log(message);
            actionUri = EVENTSCORE_URI_INDEX;
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
        EventScore eventScore;
        if(ACTIONS_UPDATE.equalsIgnoreCase(action)){
            eventScore = service.getEventScore(
                Integer.parseInt(request.getParameter("id"))
            );
            eventScore.setId(Integer.parseInt(request.getParameter("id")));
            eventScore.setScoreTeam1(Integer.parseInt(request.getParameter("scoreTeam1")));
            eventScore.setScoreTeam2(Integer.parseInt(request.getParameter("scoreTeam2")));
        
            if (service.udpateEventScore(eventScore)) {
                message="Score updated";
            } else {
                message="Error while updating";
            }
            
            log(message);
            actionUri=EVENTSCORE_URI_INDEX;
                
        } else if(ACTIONS_CREATE.equalsIgnoreCase(action)){
            eventScore = new EventScore();
            
            //eventScore.setId(Integer.parseInt(request.getParameter("id")));
            eventScore.setScoreTeam1(Integer.parseInt(request.getParameter("scoreTeam1")));
            eventScore.setScoreTeam2(Integer.parseInt(request.getParameter("scoreTeam2")));
        
            if (service.addEventScore(eventScore)) {
                message="Score added";
            } else {
                message="Error while adding";
            }
            
            log(message);
            actionUri=EVENTSCORE_URI_INDEX;
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

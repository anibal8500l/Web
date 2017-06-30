/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.Court;
import com.sportclub.innovativemind.models.Event;
import com.sportclub.innovativemind.models.Team;
import com.sportclub.innovativemind.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "EventServlet", urlPatterns = {"/Event"})
public class EventServlet extends HttpServlet {

    SpService service = new SpService();
    public static String EVENT_URI_EDIT = "editEvent.jsp";
    public static String EVENT_URI_NEW = "/newEvent.jsp";
    public static String EVENT_URI_INDEX = "/listEvent.jsp";
    public static String ACTIONS_NEW = "new";
    public static String ACTIONS_EDIT = "edit";
    public static String ACTIONS_CREATE = "create";
    public static String ACTIONS_UPDATE = "update";
    public static String ACTIONS_DELETE = "delete";
    public static String ACTIONS_INDEX = "index";
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String actionUri = "";
        String message ="";
        
        if (ACTIONS_EDIT.equalsIgnoreCase(action)) {
            Event event = service.getEvent(
                    Integer.parseInt(request.getParameter("id"))
            );
            request.setAttribute("event", event);
            request.setAttribute("action", ACTIONS_EDIT);
            actionUri = EVENT_URI_EDIT;
        } else if (ACTIONS_NEW.equalsIgnoreCase(action)) {
            actionUri = EVENT_URI_NEW;
            request.setAttribute("action", ACTIONS_NEW);
            actionUri = EVENT_URI_NEW;
        } else if (ACTIONS_DELETE.equalsIgnoreCase(action)) {

            if (service.deleteEvent(Integer.parseInt(
                    request.getParameter("id")) )) {
                message = "event updated";
            } else {
                message = "Error while updating";
            }
            log(message);
            actionUri = EVENT_URI_INDEX;
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
        Event event ;
        
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

            //Actualizacion de eventos
        if (ACTIONS_UPDATE.equalsIgnoreCase(action)) {
            try {
                Court court = new Court();
                User userCreator = new User();
                Team team1 = new Team();
                Team team2 = new Team();
                event = service.getEvent(Integer.parseInt(request.getParameter("id")));
                
                userCreator.setId(Integer.parseInt(request.getParameter("userCreatorId")));
                court.setId(Integer.parseInt(request.getParameter("courtId")));
                team1.setId(Integer.parseInt(request.getParameter("team1Id")));
                team2.setId(Integer.parseInt(request.getParameter("team2Id")));
                
                String dateInString = request.getParameter("dateIn");
                Date dateInDate = formateador.parse(dateInString);
                
                
                String dateOutString = request.getParameter("dateOut");
                Date dateOutDate = formateador.parse(dateOutString);
                
                
                event.setDateIn(dateInDate );
                event.setDateOut(dateOutDate );
                event.setDescription(request.getParameter("description"));
                event.setTeam1Id(team1);
                event.setTeam2Id(team2);
                event.setUserCreatorId(userCreator);
                event.setCourtId(court);

                if (service.updateEvent(event)) {
                    message = "User updated";
                } else {
                    message = "Error while updating";
                }

            } catch (ParseException ex) {
                Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            log(message);
            actionUri = EVENT_URI_INDEX;
            
            //creacion de eventos
        } else if (ACTIONS_CREATE.equalsIgnoreCase(action)){
            
            try {
                event = new Event();
                
                Court court = new Court();
                User userCreator = new User();
                Team team1 = new Team();
                Team team2 = new Team();
               
                //userCreator.setId(Integer.parseInt(request.getParameter("userCreatorId")));
                userCreator.setId(1);

                court.setId(Integer.parseInt(request.getParameter("courtId")));
                team1.setId(Integer.parseInt(request.getParameter("team1Id")));
                team2.setId(Integer.parseInt(request.getParameter("team2Id")));
                
                String dateInString = request.getParameter("dateIn");
                Date dateInDate = formateador.parse(dateInString);
                
                String dateOutString = request.getParameter("dateOut");
                Date dateOutDate = formateador.parse(dateOutString);
                event.setId(0);
                event.setDateIn(dateInDate );
                event.setDateOut(dateOutDate );
                event.setDescription(request.getParameter("description"));
                event.setTeam1Id(team1);
                event.setTeam2Id(team2);
                event.setUserCreatorId(userCreator);
                event.setCourtId(court);
                if (service.addEvent(event)) {
                    message = "Event updated";
                } else {
                    message = "Error while creating";
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            log(message);
            actionUri = EVENT_URI_INDEX;
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

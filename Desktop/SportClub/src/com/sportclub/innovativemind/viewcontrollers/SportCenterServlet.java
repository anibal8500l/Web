/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.SportCenter;
import com.sportclub.innovativemind.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SportCenterServlet", urlPatterns = {"/SportCenter"})
public class SportCenterServlet extends HttpServlet {
    
    SpService service = new SpService();
    public static String SPORTCENTER_URI_EDIT = "editSportCenter.jsp";
    public static String SPORTCENTER_URI_NEW = "/newSportCenter.jsp";
    public static String SPORTCENTER_URI_INDEX = "listSportCenter.jsp";
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
            out.println("<title>Servlet SportCenterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SportCenterServlet at " + request.getContextPath() + "</h1>");
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
            SportCenter sportCenter = service.getSportCenter(
                    Integer.parseInt(request.getParameter("id"))
            );
            
            request.setAttribute("sportCenter", sportCenter);
            request.setAttribute("action", ACTIONS_EDIT);
            actionUri = SPORTCENTER_URI_EDIT;
        } else if(ACTIONS_NEW.equalsIgnoreCase( action)){
            actionUri = SPORTCENTER_URI_NEW;
            request.setAttribute("action", ACTIONS_NEW);
        } else if ( ACTIONS_DELETE.equalsIgnoreCase(action)){
            if (service.deleteSportCenter(
                    Integer.parseInt(request.getParameter("id"))
            )){
                message = "Sportcenter deleted";
            }else {
                message ="Error While updating";
            }
            log(message);
            actionUri = SPORTCENTER_URI_INDEX;
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
        SportCenter sportCenter;
        
        
        if( ACTIONS_UPDATE.equalsIgnoreCase(action)){
            sportCenter = new  SportCenter();
            User user = new User();
            
            user.setId(
                    Integer.parseInt(request.getParameter("userId"))
            );
            sportCenter = service.getSportCenter(
                    Integer.parseInt(request.getParameter("id"))
            );
            
            
            sportCenter.setName(request.getParameter("name"));
            sportCenter.setAddress(request.getParameter("address"));
            sportCenter.setPhone(request.getParameter("phone"));
            sportCenter.setImage(request.getParameter("image"));
            sportCenter.setDescription(request.getParameter("description"));
            sportCenter.setUserId(user);
            
            if(service.updateSportCenter(sportCenter)){
                message = "SportCenter Updated";
            } else {
                message = "Error While Updating";
            }
            
            log(message);
            actionUri = SPORTCENTER_URI_INDEX;
        } else if (ACTIONS_CREATE.equalsIgnoreCase(action)){
            sportCenter = new  SportCenter();
            User user = new User();
            user.setId(
                    Integer.parseInt(request.getParameter("userId"))
            );
            
            sportCenter.setName(request.getParameter("name"));
            sportCenter.setAddress(request.getParameter("address"));
            sportCenter.setPhone(request.getParameter("phone"));
            sportCenter.setImage(request.getParameter("image"));
            sportCenter.setDescription(request.getParameter("description"));
            sportCenter.setUserId(user);
            
            if (service.addSportCenter(sportCenter)) {
                message="SportCenter Created";
            } else {
                message="Error While Creating";
            }
            
            log(message);
            actionUri = SPORTCENTER_URI_INDEX;
            
        }
        
         RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);processRequest(request, response);
  
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

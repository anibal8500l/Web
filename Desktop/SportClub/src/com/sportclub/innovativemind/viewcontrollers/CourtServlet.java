/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportclub.innovativemind.viewcontrollers;

import com.sportclub.innovativemind.SpService;
import com.sportclub.innovativemind.models.Court;
import com.sportclub.innovativemind.models.SportCenter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ThinkUser001
 */
@MultipartConfig
@WebServlet(name = "CourtServlet", urlPatterns = {"/Court"})
public class CourtServlet extends HttpServlet {

    SpService service = new SpService();
    public static String COURT_URI_EDIT = "editCourt.jsp";
    public static String COURT_URI_NEW = "newCourt.jsp";
    public static String COURT_URI_INDEX = "listCourt.jsp";
    public static String ACTIONS_NEW = "new";
    public static String ACTIONS_EDIT = "edit";
    public static String ACTIONS_CREATE = "create";
    public static String ACTIONS_UPDATE = "update";
    public static String ACTIONS_DELETE = "delete";
    public static String ACTIONS_INDEX = "index";

    public static String getcontentPartText(Part input) {
        Scanner sc = null;
        String content = null;
        try {
            sc = new Scanner(input.getInputStream(), "UTF-8");
            if (sc.hasNext()) {
                content = sc.nextLine();
            } else {
                content = "";
            }
            sc.close();
            return content;
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            sc.close();
        }
        return content;
    }


    public static boolean guardarImagenEnElSistemaDeFicheros(InputStream input, String fileName)
            throws ServletException {
        FileOutputStream output = null;
        boolean ok = false;
        try {
            output = new FileOutputStream(fileName);
            int leido = 0;
            leido = input.read();
            while (leido != -1) {
                output.write(leido);
                leido = input.read();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                output.flush();
                output.close();
                input.close();
                ok = true;
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        return ok;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri = "";
        String message ="";
       
        if (ACTIONS_EDIT.equalsIgnoreCase(action)) {
            Court court = service.getCourt(
                    Integer.parseInt(request.getParameter("id"))
            );
            request.setAttribute("court", court);
            request.setAttribute("action", ACTIONS_EDIT);
            actionUri = COURT_URI_EDIT;
        } else if (ACTIONS_NEW.equalsIgnoreCase(action)) {
            actionUri = COURT_URI_NEW;
            request.setAttribute("action", ACTIONS_NEW);
        } else if (ACTIONS_DELETE.equalsIgnoreCase(action)) {
            if (service.deleteCourt(
                    Integer.parseInt(request.getParameter("id"))
            )) {
                message="Court deleted";
            } else {
                message="Error while deleting";
            }
            actionUri=COURT_URI_INDEX;
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
            Court court;
        
        if (ACTIONS_UPDATE.equalsIgnoreCase(action)) {
            SportCenter sportCenter = new SportCenter();
            
            sportCenter.setId(
                    Integer.parseInt(request.getParameter("sportCenterId"))
            );
            
            court = service.getCourt(
                    Integer.parseInt(request.getParameter("id"))
            );
            court.setType(request.getParameter("type"));
            court.setImage(request.getParameter("image"));
            court.setPrice(Float.parseFloat(request.getParameter("price")));
            court.setScore(Integer.parseInt(request.getParameter("score")));
            court.setSportCenterId(sportCenter);
            
            if(service.updateCourt(court)){
                message = "court updated";
            } else {
                message = "Error While updating";
            }
            
             log(message);
            actionUri = COURT_URI_INDEX;
        } else if(ACTIONS_CREATE.equalsIgnoreCase(action)){
            court = new Court();
            
            SportCenter sportCenter = new SportCenter();
            sportCenter.setId(
                    Integer.parseInt(getcontentPartText(request.getPart("sportCenterId")))
            );
            
            court.setType(getcontentPartText(request.getPart("type")));

            //imagen
            if (request.getPart("image").getSize()>0){

                // se verifica tamaño y tipo de archivo recibido
                if (request.getPart("image").getContentType().contains("image") == false ||
                        request.getPart("image").getSize()>8388608){
                    return;
                } else {
                    // se obtiene la ruta donde guardar la imagen

                    String filename = this.getServletContext().getRealPath("images/");
                    log("prueba");
                    log("prueba");
                    log("prueba");
                    log("prueba");log("prueba");log("prueba");log("prueba");log("prueba");log("prueba");log("prueba");




                    log(filename);
                    //String filename = "http://localhost:8080/SportClub_war_exploded/images";
                    //guardamos la imagen en disco con la ruta obtenida
                    boolean ok  = guardarImagenEnElSistemaDeFicheros(request.getPart("image").getInputStream(),filename);

                    if(ok == true){
                        court.setImage("1");

                        //
                        court.setPrice(Float.parseFloat(getcontentPartText(request.getPart("price"))));
                        court.setScore(Integer.parseInt(getcontentPartText(request.getPart("score"))));
                        court.setSportCenterId(sportCenter);
                    }
                }
            }

            
            if(service.addCourt(court)){
                message = "court updated";
            } else {
                message = "Error While updating";
            }
            
             log(message);
            actionUri = COURT_URI_INDEX;
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

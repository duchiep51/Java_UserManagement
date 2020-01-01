/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.controllers;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Hiep
 */
public class MainController extends HttpServlet {
    
    private static final String ERROR = "error.jsp";
    private static final String SEARCH = "SearchController";
    private static final String LOGIN = "LoginController";
    private static final String USERSEARCH= "UserSearchController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE = "UpdateController";
    private static final String EDIT = "EditController";
    private static final String CREATE = "CreateController";
    private static final String LOGOUT = "LogoutController";
    private static final String REGISTER = "RegisterController";
    private static final String ADD_TO_PROMOTION_LIST = "AddToPromotionListController";
    private static final String CONFIRM = "ConfirmController";
    private static final String VIEW_HISTORY = "ViewPromotionHistoryController";

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
        String url = ERROR;
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if(!isMultipart) {
                String action = request.getParameter("action");
                System.out.println(action);
                if(action.equals("Login"))
                    url = LOGIN;
                else if(action.equals("Search"))
                    url = SEARCH;
                else if(action.equals("UserSearch"))
                    url = USERSEARCH;
                else if(action.equals("Delete"))
                    url = DELETE;
                else if(action.equals("Edit"))
                    url = EDIT;
                else if(action.equals("Create"))
                    url = CREATE;
                else if(action.equals("Logout"))
                    url = LOGOUT;
                else if(action.equals("Add to promotion list"))
                    url = ADD_TO_PROMOTION_LIST;
                else if(action.equals("Confirm"))
                    url = CONFIRM;
                else if(action.equals("View history"))
                    url = VIEW_HISTORY;
            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try {
                    items = upload.parseRequest(request);
                    request.setAttribute("ITEMS", items);
                } catch(FileUploadException e) {
                    log("ERROR at MainController :" + e.getMessage());
                }
                Hashtable params = new Hashtable();
                Iterator iter = items.iterator();
                while(iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if(item.isFormField()) {
                        params.put(item.getFieldName(), item.getString());
                    }
                }
                String action = (String)params.get("action");
                
                if(action.equals("Register"))
                    url = REGISTER;
                else if(action.equals("Update"))
                    url = UPDATE;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

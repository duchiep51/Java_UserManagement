/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.controllers;

import MyUtils.Utils;
import hieptd.daos.UserDAO;
import hieptd.dtos.UserDTO;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Hiep
 */
public class RegisterController extends HttpServlet {

    private static final String SUCCESS = "admin.jsp";
    private static final String ERROR = "create.jsp";

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
            List items = null;
            items = (List) request.getAttribute("ITEMS");
            Iterator iter = items.iterator();
            Hashtable params = new Hashtable();
            String fileName = null;
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    params.put(item.getFieldName(), item.getString());
                } else {
                    try {
                        String itemName = item.getName();
                        fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                        System.out.println("path " + fileName);
                        String RealPath = getServletContext().getRealPath("/") + "images\\" + fileName;
                        System.out.println("Rpath " + RealPath);
                        File savedFile = new File(RealPath);
                        item.write(savedFile);
                    } catch (Exception e) {
                        log("ERROR at RegisterController: " + e.getMessage());
                    }
                }
            }
            String username = (String) params.get("txtUsername");
            String password = (String) params.get("txtPassword");
            String encryptedPassword = Utils.getEncrypted(password);
            String fullname = (String) params.get("txtFullname");
            String email = (String) params.get("txtEmail");
            String phone = (String) params.get("txtPhone");
            String roleid = (String) params.get("cboRoleid");
            UserDTO dto = new UserDTO(username, encryptedPassword, fullname, email, fileName, phone, roleid, false);

            UserDAO dao = new UserDAO();
            if (dao.create(dto)) {
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Create failed!");
            }
        } catch (Exception e) {
            log("ERROR at RegisterController: " + e.getMessage());
            if(e.getMessage().contains("duplicate")) {
                String duplicate = "Duplicate username";
                request.setAttribute("DUPLICATE", duplicate);
            }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.controllers;

import hieptd.daos.PromotionDAO;
import hieptd.dtos.PromotionDTO;
import hieptd.dtos.PromotionList;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hiep
 */
public class ConfirmController extends HttpServlet {
    
    private static final String SUCCESS = "viewlist.jsp";
    private static final String ERROR = "error.jsp";
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
            HttpSession session = request.getSession();
            PromotionList list = (PromotionList) session.getAttribute("list");
            if(list != null) {
                if(!list.getList().isEmpty()) {
                    System.out.println("!empty");
                    Set<String> keys = list.getList().keySet();
                    PromotionDAO dao = new PromotionDAO();
                    for (String key : keys) {
                        System.out.println(key);
                        PromotionDTO dto = new PromotionDTO(key, list.getList().get(key));
                        if(dao.insert(dto)) {
                            url = SUCCESS;
                            System.out.println("success");
                        }
                        else 
                            request.setAttribute("ERROR", "Insert failed");
                    }
                    session.removeAttribute("list");
                }
            }
        } catch(Exception e) {
            log("ERROR at ConfirmController: " + e.getMessage());
        } finally {
            response.sendRedirect("viewlist.jsp");
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

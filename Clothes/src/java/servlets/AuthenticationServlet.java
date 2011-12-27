/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.SearchBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author psychok7
 */
public class AuthenticationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("e-mail");
        String password = request.getParameter("password");
        SearchBean userData = new SearchBean();
        userData.test();
//        if (userData.authenticate(email, password)) {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("user", userData.getUser());
//            
//            response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
//        } 
//        else
//            response.sendRedirect("/Phasebook-war/jsp/invaliduser.jsp");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

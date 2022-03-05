/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import EJB.SchoolSessionBeanLocal;
import Entity.TblStd;
import Entity.TblStudent;
import Entity.TblTeacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "SchoolServlet", urlPatterns = {"/SchoolServlet"})
public class SchoolServlet extends HttpServlet {

    @EJB
    SchoolSessionBeanLocal ssb;

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
            out.println("<title>Servlet SchoolServlet</title>");
            out.println("</head>");
            out.println("<body>");
//               ssb.insertStd("Standard-6");
            ssb.insertStudent("Maahi", 5);
//               ssb.insertTeacher("Mayam");
            Collection<Integer> ids = new ArrayList<Integer>();
            ids.add(1);
            ids.add(2);
//                ssb.addTeacherToStd(ids, 5);
            ssb.removeTeacherToStd(ids, 4);

//                ssb.updateStd(5, "Standard 7");
//                ssb.updateStudent(1, "Fatema", 1);
//                ssb.updateTeacher(3, "Maryam");
//               ssb.removeStd(8);
//               ssb.removeStudent(4);
//               ssb.removeTeacher(4);
            Collection<TblStd> stds = ssb.allStd();
            out.println("<h1>Satandard Collection</h1>");
            for (TblStd std : stds) {
                out.println("<h3>Standard Name : " + std.getStdname() + "</h3>");
            }
            Collection<TblStudent> student = ssb.allStudent();
            out.println("<h1>Student Collection</h1>");
            for (TblStudent studs : student) {
                out.println("<h3>Student Name : " + studs.getStudname() + " And " + "Stanard Name : " + studs.getStdid().getStdname() + "</h13>");
            }

            Collection<TblTeacher> teach = ssb.allTeacher();
            out.println("<h1>Teacher Collection</h1>");
            for (TblTeacher Teacher : teach) {
                out.println("<h3>Teacher Name : " + Teacher.getTeacherName() + "</h3>");
            }
            out.println("<h1>Servlet SchoolServlet at " + request.getContextPath() + "</h1>");
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

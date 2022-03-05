/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Client.SchoolClient;
import Entity.TblStd;
import Entity.TblStudent;
import Entity.TblTeacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
public class RestSchoolServlet extends HttpServlet {

    SchoolClient sc = new SchoolClient();
    Response res;
    Collection<TblStd> std;
    GenericType<Collection<TblStd>> gstd = new GenericType<Collection<TblStd>>(){};
    
    Collection<TblTeacher> tech;
    GenericType<Collection<TblTeacher>> gtech = new GenericType<Collection<TblTeacher>>(){};
    
    Collection<TblStudent>stud;
    GenericType<Collection<TblStudent>> gstud = new GenericType<Collection<TblStudent>>(){};

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
            out.println("<title>Servlet RestSchoolServlet</title>");
            out.println("</head>");
            out.println("<body>");

//            sc.insertStd("abc");
//            sc.insertStudent("", stdId);
//            sc.insertTeacher("Namita");
            Integer x = 7 , y =5;
//            sc.removeStd(x.toString());
//            sc.removeStudent(x.toString());
//            sc.removeTeacher(x.toString());

//            sc.updateStd(x.toString(), "Standard 4");
//               sc.updateTeacher(x.toString(), "Aman");
//                sc.updateStudent(x.toString(), "Baby", y.toString());

            res=sc.allStd(Response.class);
            std = res.readEntity(gstd);
            out.println("<h1>Standard Collection</h1>");
            for (TblStd stds : std) {
                out.println("<h3> Standard Name :" + stds.getStdname() + " </h3>");
            }
            
            res= sc.allTeacher(Response.class);
            tech = res.readEntity(gtech);
            out.println("<h1>Teacher Collection</h1>");
            for (TblTeacher techs : tech) {
                out.println("<h3> Standard Name :" + techs.getTeacherName() + " </h3>");
            }
            
            res = sc.allStudent(Response.class);
            stud = res.readEntity(gstud);
            out.println("<h1>Student Collection</h1>");
            for (TblStudent studs : stud) {
                out.println("<h3> Student Name :" + studs.getStudname() + " And " +"Standard Name : " + studs.getStdid().getStdname() + " </h3>");
            }
            out.println("<h1>Servlet RestSchoolServlet at " + request.getContextPath() + "</h1>");
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

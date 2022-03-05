/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import EJB.SchoolSessionBeanLocal;
import Entity.TblStd;
import Entity.TblStudent;
import Entity.TblTeacher;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author HP
 */
//@DeclareRoles({"Admin", "User"})
@Path("generic")
public class SchoolResource {

    @EJB
    SchoolSessionBeanLocal ssb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SchoolResource
     */
    public SchoolResource() {
    }

//    @RolesAllowed("Admin , User")
    @POST
    @Path("insertStd/{stdName}")
    public void insertStd(@PathParam("stdName") String stdName) {
        ssb.insertStd(stdName);
    }

//    @RolesAllowed("Admin , User")
    @PUT
    @Path("updateStd/{stdId}/{stdName}")
    public void updateStd(@PathParam("stdId") Integer stdId, @PathParam("stdName") String stdName) {
        ssb.updateStd(stdId, stdName);
    }

//    @RolesAllowed("Admin")
    @DELETE
    @Path("removeStd/{stdId}")
    public void removeStd(@PathParam("stdId") Integer stdId) {
        ssb.removeStd(stdId);
    }

//    @RolesAllowed("Admin , User")
    @GET
    @Path("allStd")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblStd> allStd() {
        return ssb.allStd();
    }

    @POST
    @Path("insertTeacher/{teacherName}")
    public void insertTeacher(@PathParam("teacherName") String teacherName) {
        ssb.insertTeacher(teacherName);
    }

    @PUT
    @Path("updateTeacher/{teacherId}/{teacherName}")
    public void updateTeacher(@PathParam("teacherId") Integer teacherId, @PathParam("teacherName") String teacherName) {
        ssb.updateTeacher(teacherId, teacherName);
    }

    @DELETE
    @Path("removeTeacher/{teacherId}")
    public void removeTeacher(@PathParam("teacherId") Integer teacherId) {
        ssb.removeTeacher(teacherId);
    }

    @GET
    @Path("allTeacher")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblTeacher> allTeacher() {
        return ssb.allTeacher();
    }

    @POST
    @Path("insertStudent/{studentName}/{stdId}")
    public void insertStudent(@PathParam("studentName") String studentName, @PathParam("stdId") Integer stdId) {
        ssb.insertStudent(studentName, stdId);
    }

    @PUT
    @Path("updateStudent/{studId}/{studentName}/{stdId}")
    public void updateStudent(@PathParam("studId") Integer studId, @PathParam("studentName") String studentName, @PathParam("stdId") Integer stdId) {
        ssb.updateStudent(studId, studentName, stdId);
    }

    @DELETE
    @Path("removeStudent/{studId}")
    public void removeStudent(@PathParam("studId") Integer studId) {
        ssb.removeStudent(studId);
    }

    @GET
    @Path("allStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblStudent> allStudent() {
        return ssb.allStudent();
    }

//    @POST
//    @Path("addTeacherToStd/{teacherId}/{stdId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addTeacherToStd(@PathParam("teacherId") Collection<Integer> teacherId, @PathParam("stdId") Integer stdId) {
//        ssb.addTeacherToStd(teacherId, stdId);
//    }
//
//    @DELETE
//    @Path("removeTeacherToStd/{teacherId}/{stdId}")
//    public void removeTeacherToStd(@PathParam("teacherId") Collection<Integer> teacherId ,@PathParam("stdId") Integer stdId){
//        
//    }
}

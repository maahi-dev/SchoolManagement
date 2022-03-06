/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:SchoolResource [generic]<br>
 * USAGE:
 * <pre>
 *        SchoolClient client = new SchoolClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author HP
 */
public class SchoolClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/SchoolManagement/webresources";

    public SchoolClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void insertStudent(String studentName, String stdId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertStudent/{0}/{1}", new Object[]{studentName, stdId})).request().post(null);
    }

    public void updateStudent(String studId, String studentName, String stdId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateStudent/{0}/{1}/{2}", new Object[]{studId, studentName, stdId})).request().put(null);
    }

    public <T> T allStd(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allStd");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addTeacherToStd(Object requestEntity, String stdId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTeacherToStd/{0}", new Object[]{stdId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateStd(String stdId, String stdName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateStd/{0}/{1}", new Object[]{stdId, stdName})).request().put(null);
    }

    public void removeTeacherToStd(Object requestEntity, String stdId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeTeacherToStd/{0}", new Object[]{stdId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeTeacher(String teacherId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeTeacher/{0}", new Object[]{teacherId})).request().delete();
    }

    public void removeStd(String stdId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeStd/{0}", new Object[]{stdId})).request().delete();
    }

    public <T> T allStudent(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allStudent");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeStudent(String studId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeStudent/{0}", new Object[]{studId})).request().delete();
    }

    public void insertTeacher(String teacherName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertTeacher/{0}", new Object[]{teacherName})).request().post(null);
    }

    public <T> T allTeacher(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allTeacher");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTeacher(String teacherId, String teacherName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTeacher/{0}/{1}", new Object[]{teacherId, teacherName})).request().put(null);
    }

    public void insertStd(String stdName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertStd/{0}", new Object[]{stdName})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJB;

import Entity.TblStd;
import Entity.TblStudent;
import Entity.TblTeacher;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface SchoolSessionBeanLocal {

    public void insertStd(String stdName);

    public void updateStd(Integer stdId, String stdName);

    public void removeStd(Integer stdId);

    public Collection<TblStd> allStd();

    public void insertTeacher(String teacherName);

    public void updateTeacher(Integer teacherId, String teacherName);

    public void removeTeacher(Integer teacherId);

    public Collection<TblTeacher> allTeacher();

    public void insertStudent(String studentName,Integer stdId);

    public void updateStudent(Integer studId, String studentName, Integer stdId);

    public void removeStudent(Integer studId);

    public Collection<TblStudent> allStudent();

    public void addTeacherToStd(Collection<Integer> teacherId , Integer stdId);
    
    public void removeTeacherToStd(Collection<Integer> teacherId , Integer stdId);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import Entity.TblStd;
import Entity.TblStudent;
import Entity.TblTeacher;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class SchoolSessionBean implements SchoolSessionBeanLocal {

    @PersistenceContext(unitName = "SchoolManagementPU")
    EntityManager em;

    @Override
    public void insertStd(String stdName) {
        TblStd std = new TblStd();
        std.setStdname(stdName);
        em.persist(std);
    }

    @Override
    public void updateStd(Integer stdId, String stdName) {
        TblStd std = em.find(TblStd.class, stdId);
        std.setStdname(stdName);
        em.merge(std);
    }

    @Override
    public void removeStd(Integer stdId) {
        TblStd std = em.find(TblStd.class, stdId);
        em.remove(std);
    }

    @Override
    public Collection<TblStd> allStd() {
        return em.createNamedQuery("TblStd.findAll").getResultList();
    }

    @Override
    public void insertTeacher(String teacherName) {
        TblTeacher teacher = new TblTeacher();
        teacher.setTeacherName(teacherName);
        em.persist(teacher);
    }

    @Override
    public void updateTeacher(Integer teacherId, String teacherName) {
        TblTeacher teacher = em.find(TblTeacher.class, teacherId);
        teacher.setTeacherName(teacherName);
        em.merge(teacher);
    }

    @Override
    public void removeTeacher(Integer teacherId) {
        TblTeacher teacher = em.find(TblTeacher.class, teacherId);
        em.remove(teacher);
    }

    @Override
    public Collection<TblTeacher> allTeacher() {
        return em.createNamedQuery("TblTeacher.findAll").getResultList();
    }

    @Override
    public void insertStudent(String studentName, Integer stdId) {
        TblStd std = em.find(TblStd.class, stdId);
        Collection<TblStudent> studs = std.getTblStudentCollection();
        TblStudent stud = new TblStudent();
        stud.setStudname(studentName);
        stud.setStdid(std);

        studs.add(stud);
        std.setTblStudentCollection(studs);
        em.persist(stud);
        em.merge(std);
    }

    @Override
    public void updateStudent(Integer studId, String studentName, Integer stdId) {
        TblStudent student = em.find(TblStudent.class, studId);
        TblStd std = em.find(TblStd.class, stdId);
        student.setStudname(studentName);
        student.setStdid(std);
        em.merge(student);
    }

    @Override
    public void removeStudent(Integer studId) {
        TblStudent stud = em.find(TblStudent.class, studId);
        em.remove(stud);
    }

    @Override
    public Collection<TblStudent> allStudent() {
        return em.createNamedQuery("TblStudent.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addTeacherToStd(Collection<Integer> teacherId, Integer stdId) {
        TblStd std = em.find(TblStd.class, stdId);
        Collection<TblTeacher> teacher = std.getTblTeacherCollection();

        for (Integer tech : teacherId) {
            TblTeacher teachers = em.find(TblTeacher.class, tech);

            if (!teacher.contains(teachers)) {
                Collection<TblStd> stds = teachers.getTblStdCollection();
                stds.add(std);
                teacher.add(teachers);

                std.setTblTeacherCollection(teacher);
                teachers.setTblStdCollection(stds);

                em.merge(std);
            }

        }

    }

    @Override
    public void removeTeacherToStd(Collection<Integer> teacherId, Integer stdId) {
        TblStd std = em.find(TblStd.class, stdId);
        Collection<TblTeacher> teachs = std.getTblTeacherCollection();

        for (Integer teach : teacherId) {
            TblTeacher teacher = em.find(TblTeacher.class, teach);

            if (teachs.contains(teacher)) {
                Collection<TblStd> stds = teacher.getTblStdCollection();

                stds.remove(std);
                teachs.remove(teacher);

                std.setTblTeacherCollection(teachs);
                teacher.setTblStdCollection(stds);

                em.merge(std);
            }
        }
    }
}

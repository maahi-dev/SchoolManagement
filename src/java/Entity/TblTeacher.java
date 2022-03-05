/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTeacher.findAll", query = "SELECT t FROM TblTeacher t"),
    @NamedQuery(name = "TblTeacher.findByTeacherId", query = "SELECT t FROM TblTeacher t WHERE t.teacherId = :teacherId")})
public class TblTeacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacherId")
    private Integer teacherId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "teacherName")
    private String teacherName;
    @ManyToMany(mappedBy = "tblTeacherCollection")
    private Collection<TblStd> tblStdCollection;

    public TblTeacher() {
    }

    public TblTeacher(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public TblTeacher(Integer teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblStd> getTblStdCollection() {
        return tblStdCollection;
    }

    public void setTblStdCollection(Collection<TblStd> tblStdCollection) {
        this.tblStdCollection = tblStdCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTeacher)) {
            return false;
        }
        TblTeacher other = (TblTeacher) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblTeacher[ teacherId=" + teacherId + " ]";
    }
    
}

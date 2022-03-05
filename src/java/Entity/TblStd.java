/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_std")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblStd.findAll", query = "SELECT t FROM TblStd t"),
    @NamedQuery(name = "TblStd.findByStdid", query = "SELECT t FROM TblStd t WHERE t.stdid = :stdid")})
public class TblStd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stdid")
    private Integer stdid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "stdname")
    private String stdname;
    @JoinTable(name = "std_teacher", joinColumns = {
        @JoinColumn(name = "stdId", referencedColumnName = "stdid")}, inverseJoinColumns = {
        @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")})
    @ManyToMany
    private Collection<TblTeacher> tblTeacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdid")
    private Collection<TblStudent> tblStudentCollection;

    public TblStd() {
    }

    public TblStd(Integer stdid) {
        this.stdid = stdid;
    }

    public TblStd(Integer stdid, String stdname) {
        this.stdid = stdid;
        this.stdname = stdname;
    }

    public Integer getStdid() {
        return stdid;
    }

    public void setStdid(Integer stdid) {
        this.stdid = stdid;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblTeacher> getTblTeacherCollection() {
        return tblTeacherCollection;
    }

    public void setTblTeacherCollection(Collection<TblTeacher> tblTeacherCollection) {
        this.tblTeacherCollection = tblTeacherCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblStudent> getTblStudentCollection() {
        return tblStudentCollection;
    }

    public void setTblStudentCollection(Collection<TblStudent> tblStudentCollection) {
        this.tblStudentCollection = tblStudentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdid != null ? stdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblStd)) {
            return false;
        }
        TblStd other = (TblStd) object;
        if ((this.stdid == null && other.stdid != null) || (this.stdid != null && !this.stdid.equals(other.stdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblStd[ stdid=" + stdid + " ]";
    }
    
}

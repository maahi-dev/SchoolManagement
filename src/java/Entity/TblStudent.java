/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblStudent.findAll", query = "SELECT t FROM TblStudent t"),
    @NamedQuery(name = "TblStudent.findByStdid", query = "SELECT t FROM TblStudent t WHERE t.stdid = :stdid"),
    @NamedQuery(name = "TblStudent.findByStudid", query = "SELECT t FROM TblStudent t WHERE t.studid = :studid")})
public class TblStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studid")
    private Integer studid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "studname")
    private String studname;
    @JoinColumn(name = "stdid", referencedColumnName = "stdid")
    @ManyToOne(optional = false)
    private TblStd stdid;

    public TblStudent() {
    }

    public TblStudent(Integer studid) {
        this.studid = studid;
    }

    public TblStudent(Integer studid, String studname) {
        this.studid = studid;
        this.studname = studname;
    }

    public Integer getStudid() {
        return studid;
    }

    public void setStudid(Integer studid) {
        this.studid = studid;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public TblStd getStdid() {
        return stdid;
    }

    public void setStdid(TblStd stdid) {
        this.stdid = stdid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studid != null ? studid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblStudent)) {
            return false;
        }
        TblStudent other = (TblStudent) object;
        if ((this.studid == null && other.studid != null) || (this.studid != null && !this.studid.equals(other.studid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblStudent[ studid=" + studid + " ]";
    }
    
}

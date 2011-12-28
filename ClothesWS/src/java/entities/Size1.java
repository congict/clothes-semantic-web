/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "size")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Size1.findAll", query = "SELECT s FROM Size1 s"),
    @NamedQuery(name = "Size1.findByIdsize", query = "SELECT s FROM Size1 s WHERE s.idsize = :idsize"),
    @NamedQuery(name = "Size1.findBySize", query = "SELECT s FROM Size1 s WHERE s.size = :size")})
public class Size1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsize")
    private Integer idsize;
    @Column(name = "size")
    private Integer size;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sizeIdsize")
    private List<SizeClothes> sizeClothesList;

    public Size1() {
    }

    public Size1(Integer idsize) {
        this.idsize = idsize;
    }

    public Integer getIdsize() {
        return idsize;
    }

    public void setIdsize(Integer idsize) {
        this.idsize = idsize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @XmlTransient
    public List<SizeClothes> getSizeClothesList() {
        return sizeClothesList;
    }

    public void setSizeClothesList(List<SizeClothes> sizeClothesList) {
        this.sizeClothesList = sizeClothesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsize != null ? idsize.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Size1)) {
            return false;
        }
        Size1 other = (Size1) object;
        if ((this.idsize == null && other.idsize != null) || (this.idsize != null && !this.idsize.equals(other.idsize))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Size1[ idsize=" + idsize + " ]";
    }
    
}

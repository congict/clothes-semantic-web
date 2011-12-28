/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author psychok7
 */
@Entity
@Table(name = "sizeClothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SizeClothes.findAll", query = "SELECT s FROM SizeClothes s"),
    @NamedQuery(name = "SizeClothes.findByIdsizeClothes", query = "SELECT s FROM SizeClothes s WHERE s.idsizeClothes = :idsizeClothes")})
public class SizeClothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsizeClothes")
    private Integer idsizeClothes;
    @JoinColumn(name = "size_idsize", referencedColumnName = "idsize")
    @ManyToOne(optional = false)
    private Size1 sizeIdsize;
    @JoinColumn(name = "clothes_idclothes", referencedColumnName = "idclothes")
    @ManyToOne(optional = false)
    private Clothes clothesIdclothes;

    public SizeClothes() {
    }

    public SizeClothes(Integer idsizeClothes) {
        this.idsizeClothes = idsizeClothes;
    }

    public Integer getIdsizeClothes() {
        return idsizeClothes;
    }

    public void setIdsizeClothes(Integer idsizeClothes) {
        this.idsizeClothes = idsizeClothes;
    }

    public Size1 getSizeIdsize() {
        return sizeIdsize;
    }

    public void setSizeIdsize(Size1 sizeIdsize) {
        this.sizeIdsize = sizeIdsize;
    }

    public Clothes getClothesIdclothes() {
        return clothesIdclothes;
    }

    public void setClothesIdclothes(Clothes clothesIdclothes) {
        this.clothesIdclothes = clothesIdclothes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsizeClothes != null ? idsizeClothes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SizeClothes)) {
            return false;
        }
        SizeClothes other = (SizeClothes) object;
        if ((this.idsizeClothes == null && other.idsizeClothes != null) || (this.idsizeClothes != null && !this.idsizeClothes.equals(other.idsizeClothes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SizeClothes[ idsizeClothes=" + idsizeClothes + " ]";
    }
    
}

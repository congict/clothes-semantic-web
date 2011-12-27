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
@Table(name = "materialClothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialClothes.findAll", query = "SELECT m FROM MaterialClothes m"),
    @NamedQuery(name = "MaterialClothes.findByIdmaterialClothes", query = "SELECT m FROM MaterialClothes m WHERE m.idmaterialClothes = :idmaterialClothes")})
public class MaterialClothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmaterialClothes")
    private Integer idmaterialClothes;
    @JoinColumn(name = "material_idmaterial", referencedColumnName = "idmaterial")
    @ManyToOne(optional = false)
    private Material materialIdmaterial;
    @JoinColumn(name = "clothes_idclothes", referencedColumnName = "idclothes")
    @ManyToOne(optional = false)
    private Clothes clothesIdclothes;

    public MaterialClothes() {
    }

    public MaterialClothes(Integer idmaterialClothes) {
        this.idmaterialClothes = idmaterialClothes;
    }

    public Integer getIdmaterialClothes() {
        return idmaterialClothes;
    }

    public void setIdmaterialClothes(Integer idmaterialClothes) {
        this.idmaterialClothes = idmaterialClothes;
    }

    public Material getMaterialIdmaterial() {
        return materialIdmaterial;
    }

    public void setMaterialIdmaterial(Material materialIdmaterial) {
        this.materialIdmaterial = materialIdmaterial;
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
        hash += (idmaterialClothes != null ? idmaterialClothes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialClothes)) {
            return false;
        }
        MaterialClothes other = (MaterialClothes) object;
        if ((this.idmaterialClothes == null && other.idmaterialClothes != null) || (this.idmaterialClothes != null && !this.idmaterialClothes.equals(other.idmaterialClothes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MaterialClothes[ idmaterialClothes=" + idmaterialClothes + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author psychok7
 */
@Entity
@Table(name = "clothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c"),
    @NamedQuery(name = "Clothes.findByIdclothes", query = "SELECT c FROM Clothes c WHERE c.idclothes = :idclothes"),
    @NamedQuery(name = "Clothes.findByName", query = "SELECT c FROM Clothes c WHERE c.name = :name"),
    @NamedQuery(name = "Clothes.findByPrice", query = "SELECT c FROM Clothes c WHERE c.price = :price")})
public class Clothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclothes")
    private Integer idclothes;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clothesIdclothes")
    private List<MaterialClothes> materialClothesList;
    @JoinColumn(name = "subCategory_idsubCategory", referencedColumnName = "idSubCategory")
    @ManyToOne(optional = false)
    private SubCategory subCategoryidsubCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clothesIdclothes")
    private List<ColorClothes> colorClothesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clothesIdclothes")
    private List<SizeClothes> sizeClothesList;

    public Clothes() {
    }

    public Clothes(Integer idclothes) {
        this.idclothes = idclothes;
    }

    public Integer getIdclothes() {
        return idclothes;
    }

    public void setIdclothes(Integer idclothes) {
        this.idclothes = idclothes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @XmlTransient
    public List<MaterialClothes> getMaterialClothesList() {
        return materialClothesList;
    }

    public void setMaterialClothesList(List<MaterialClothes> materialClothesList) {
        this.materialClothesList = materialClothesList;
    }

    public SubCategory getSubCategoryidsubCategory() {
        return subCategoryidsubCategory;
    }

    public void setSubCategoryidsubCategory(SubCategory subCategoryidsubCategory) {
        this.subCategoryidsubCategory = subCategoryidsubCategory;
    }

    @XmlTransient
    public List<ColorClothes> getColorClothesList() {
        return colorClothesList;
    }

    public void setColorClothesList(List<ColorClothes> colorClothesList) {
        this.colorClothesList = colorClothesList;
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
        hash += (idclothes != null ? idclothes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.idclothes == null && other.idclothes != null) || (this.idclothes != null && !this.idclothes.equals(other.idclothes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clothes[ idclothes=" + idclothes + " ]";
    }
    
}

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
@Table(name = "subCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategory.findAll", query = "SELECT s FROM SubCategory s"),
    @NamedQuery(name = "SubCategory.findByIdSubCategory", query = "SELECT s FROM SubCategory s WHERE s.idSubCategory = :idSubCategory"),
    @NamedQuery(name = "SubCategory.findByDescription", query = "SELECT s FROM SubCategory s WHERE s.description = :description")})
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSubCategory")
    private Integer idSubCategory;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoryidsubCategory")
    private List<Clothes> clothesList;
    @JoinColumn(name = "category_idcategory", referencedColumnName = "idCategory")
    @ManyToOne(optional = false)
    private Category categoryIdcategory;

    public SubCategory() {
    }

    public SubCategory(Integer idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public Integer getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(Integer idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }

    public Category getCategoryIdcategory() {
        return categoryIdcategory;
    }

    public void setCategoryIdcategory(Category categoryIdcategory) {
        this.categoryIdcategory = categoryIdcategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubCategory != null ? idSubCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategory)) {
            return false;
        }
        SubCategory other = (SubCategory) object;
        if ((this.idSubCategory == null && other.idSubCategory != null) || (this.idSubCategory != null && !this.idSubCategory.equals(other.idSubCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SubCategory[ idSubCategory=" + idSubCategory + " ]";
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Clothes.findByCategory", query = "SELECT c FROM Clothes c WHERE c.category = :category"),
    @NamedQuery(name = "Clothes.findBySubcategory", query = "SELECT c FROM Clothes c WHERE c.subcategory = :subcategory"),
    @NamedQuery(name = "Clothes.findByModel", query = "SELECT c FROM Clothes c WHERE c.model = :model"),
    @NamedQuery(name = "Clothes.findByGenre", query = "SELECT c FROM Clothes c WHERE c.genre = :genre"),
    @NamedQuery(name = "Clothes.findBySize", query = "SELECT c FROM Clothes c WHERE c.size = :size"),
    @NamedQuery(name = "Clothes.findByColor", query = "SELECT c FROM Clothes c WHERE c.color = :color"),
    @NamedQuery(name = "Clothes.findByPrice", query = "SELECT c FROM Clothes c WHERE c.price = :price"),
    @NamedQuery(name = "Clothes.findByImage", query = "SELECT c FROM Clothes c WHERE c.image = :image")})
public class Clothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclothes")
    private Integer idclothes;
    @Size(max = 45)
    @Column(name = "category")
    private String category;
    @Size(max = 45)
    @Column(name = "subcategory")
    private String subcategory;
    @Size(max = 128)
    @Column(name = "model")
    private String model;
    @Column(name = "genre")
    private Boolean genre;
    @Column(name = "size")
    private Integer size;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Size(max = 128)
    @Column(name = "image")
    private String image;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getGenre() {
        return genre;
    }

    public void setGenre(Boolean genre) {
        this.genre = genre;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

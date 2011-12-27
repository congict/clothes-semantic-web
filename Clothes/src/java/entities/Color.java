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
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c"),
    @NamedQuery(name = "Color.findByIdcolor", query = "SELECT c FROM Color c WHERE c.idcolor = :idcolor"),
    @NamedQuery(name = "Color.findByColor", query = "SELECT c FROM Color c WHERE c.color = :color")})
public class Color implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcolor")
    private Integer idcolor;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorIdcolor")
    private List<ColorClothes> colorClothesList;

    public Color() {
    }

    public Color(Integer idcolor) {
        this.idcolor = idcolor;
    }

    public Integer getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(Integer idcolor) {
        this.idcolor = idcolor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public List<ColorClothes> getColorClothesList() {
        return colorClothesList;
    }

    public void setColorClothesList(List<ColorClothes> colorClothesList) {
        this.colorClothesList = colorClothesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcolor != null ? idcolor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.idcolor == null && other.idcolor != null) || (this.idcolor != null && !this.idcolor.equals(other.idcolor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Color[ idcolor=" + idcolor + " ]";
    }
    
}

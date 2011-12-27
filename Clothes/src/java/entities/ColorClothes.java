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
@Table(name = "colorClothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorClothes.findAll", query = "SELECT c FROM ColorClothes c"),
    @NamedQuery(name = "ColorClothes.findByIdcolorClothes", query = "SELECT c FROM ColorClothes c WHERE c.idcolorClothes = :idcolorClothes")})
public class ColorClothes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcolorClothes")
    private Integer idcolorClothes;
    @JoinColumn(name = "color_idcolor", referencedColumnName = "idcolor")
    @ManyToOne(optional = false)
    private Color colorIdcolor;
    @JoinColumn(name = "clothes_idclothes", referencedColumnName = "idclothes")
    @ManyToOne(optional = false)
    private Clothes clothesIdclothes;

    public ColorClothes() {
    }

    public ColorClothes(Integer idcolorClothes) {
        this.idcolorClothes = idcolorClothes;
    }

    public Integer getIdcolorClothes() {
        return idcolorClothes;
    }

    public void setIdcolorClothes(Integer idcolorClothes) {
        this.idcolorClothes = idcolorClothes;
    }

    public Color getColorIdcolor() {
        return colorIdcolor;
    }

    public void setColorIdcolor(Color colorIdcolor) {
        this.colorIdcolor = colorIdcolor;
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
        hash += (idcolorClothes != null ? idcolorClothes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorClothes)) {
            return false;
        }
        ColorClothes other = (ColorClothes) object;
        if ((this.idcolorClothes == null && other.idcolorClothes != null) || (this.idcolorClothes != null && !this.idcolorClothes.equals(other.idcolorClothes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ColorClothes[ idcolorClothes=" + idcolorClothes + " ]";
    }
    
}

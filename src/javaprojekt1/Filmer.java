/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author albinarvidsson
 */
@Entity
@Table(name = "filmer", catalog = "film", schema = "")
@NamedQueries({
    @NamedQuery(name = "Filmer.findAll", query = "SELECT f FROM Filmer f"),
    @NamedQuery(name = "Filmer.findById", query = "SELECT f FROM Filmer f WHERE f.id = :id"),
    @NamedQuery(name = "Filmer.findByNamn", query = "SELECT f FROM Filmer f WHERE f.namn = :namn"),
    @NamedQuery(name = "Filmer.findByRegisor", query = "SELECT f FROM Filmer f WHERE f.regisor = :regisor"),
    @NamedQuery(name = "Filmer.findByGenre", query = "SELECT f FROM Filmer f WHERE f.genre = :genre"),
    @NamedQuery(name = "Filmer.findByBetyg", query = "SELECT f FROM Filmer f WHERE f.betyg = :betyg")})
public class Filmer implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "namn")
    private String namn;
    @Basic(optional = false)
    @Column(name = "regisor")
    private String regisor;
    @Basic(optional = false)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @Column(name = "betyg")
    private String betyg;

    public Filmer() {
    }

    public Filmer(Integer id) {
        this.id = id;
    }

    public Filmer(Integer id, String namn, String regisor, String genre, String betyg) {
        this.id = id;
        this.namn = namn;
        this.regisor = regisor;
        this.genre = genre;
        this.betyg = betyg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        String oldNamn = this.namn;
        this.namn = namn;
        changeSupport.firePropertyChange("namn", oldNamn, namn);
    }

    public String getRegisor() {
        return regisor;
    }

    public void setRegisor(String regisor) {
        String oldRegisor = this.regisor;
        this.regisor = regisor;
        changeSupport.firePropertyChange("regisor", oldRegisor, regisor);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String oldGenre = this.genre;
        this.genre = genre;
        changeSupport.firePropertyChange("genre", oldGenre, genre);
    }

    public String getBetyg() {
        return betyg;
    }

    public void setBetyg(String betyg) {
        String oldBetyg = this.betyg;
        this.betyg = betyg;
        changeSupport.firePropertyChange("betyg", oldBetyg, betyg);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmer)) {
            return false;
        }
        Filmer other = (Filmer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaprojekt1.Filmer[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

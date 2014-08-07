/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Plane;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aFun
 */
@Entity
@Table(name = "Plane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plane.findAll", query = "SELECT p FROM Plane p"),
    @NamedQuery(name = "Plane.findById", query = "SELECT p FROM Plane p WHERE p.id = :id"),
    @NamedQuery(name = "Plane.findByType", query = "SELECT p FROM Plane p WHERE p.type = :type"),
    @NamedQuery(name = "Plane.findByLenght", query = "SELECT p FROM Plane p WHERE p.lenght = :lenght"),
    @NamedQuery(name = "Plane.findByWeight", query = "SELECT p FROM Plane p WHERE p.weight = :weight"),
    @NamedQuery(name = "Plane.findByColor", query = "SELECT p FROM Plane p WHERE p.color = :color"),
    @NamedQuery(name = "Plane.findBySeats", query = "SELECT p FROM Plane p WHERE p.seats = :seats"),
    @NamedQuery(name = "Plane.findByDescription", query = "SELECT p FROM Plane p WHERE p.description = :description"),
    @NamedQuery(name = "Plane.findByStatus", query = "SELECT p FROM Plane p WHERE p.status = :status")})
public class Plane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lenght")
    private double lenght;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private double weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seats")
    private int seats;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;

    public Plane() {
    }

    public Plane(Integer id) {
        this.id = id;
    }

    public Plane(Integer id, String type, double lenght, double weight, String color, int seats, short status) {
        this.id = id;
        this.type = type;
        this.lenght = lenght;
        this.weight = weight;
        this.color = color;
        this.seats = seats;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
        if (!(object instanceof Plane)) {
            return false;
        }
        Plane other = (Plane) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plane.Plane[ id=" + id + " ]";
    }
    
}

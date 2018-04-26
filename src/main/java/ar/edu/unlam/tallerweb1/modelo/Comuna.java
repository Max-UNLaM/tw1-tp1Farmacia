package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany
    private Barrio[] barrios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Barrio[] getBarrios() {
        return barrios;
    }

    public void setBarrios(Barrio[] barrios) {
        this.barrios = barrios;
    }
}

package com.RiosAviacion.Aerolineas.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_equipaje")
public class ModelEquipaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipaje")
    private int idEquipaje;

    @Column(name = "num_vuelo")
    private int numVuelo;

    @Column(name = "cantidad_bolsas")
    private int cantidadBolsas;

    @Column(name = "peso")
    private int peso;

    // Getters y Setters

    public int getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(int idEquipaje) {
        this.idEquipaje = idEquipaje;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    public int getCantidadBolsas() {
        return cantidadBolsas;
    }

    public void setCantidadBolsas(int cantidadBolsas) {
        this.cantidadBolsas = cantidadBolsas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}

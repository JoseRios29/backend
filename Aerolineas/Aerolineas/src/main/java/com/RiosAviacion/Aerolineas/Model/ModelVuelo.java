package com.RiosAviacion.Aerolineas.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_vuelo")
public class ModelVuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_reservacion")
    private int numReservacion;

    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "num_vuelo")
    private int numVuelo;

    @Column(name = "clase_vuelo")
    private String claseVuelo;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "tiempo_abordaje")
    private String tiempoAbordaje;

    @Column(name = "puerta")
    private String puerta;

    // Getters y Setters

    public int getNumReservacion() {
        return numReservacion;
    }

    public void setNumReservacion(int numReservacion) {
        this.numReservacion = numReservacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTiempoAbordaje() {
        return tiempoAbordaje;
    }

    public void setTiempoAbordaje(String tiempoAbordaje) {
        this.tiempoAbordaje = tiempoAbordaje;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }
}

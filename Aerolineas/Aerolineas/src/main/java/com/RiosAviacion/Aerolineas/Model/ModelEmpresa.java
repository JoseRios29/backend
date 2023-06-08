package com.RiosAviacion.Aerolineas.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_empresa")
public class ModelEmpresa {
    @Id
    @Column(name = "cod_empresa")
    private String codEmpresa;

    @Column(name = "num_vuelo")
    private int numVuelo;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "hora_compra")
    private String horaCompra;

    // Getters y Setters

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
    }
}

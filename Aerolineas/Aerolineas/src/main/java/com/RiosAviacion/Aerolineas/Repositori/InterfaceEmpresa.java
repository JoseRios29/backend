package com.RiosAviacion.Aerolineas.Repositori;

import com.RiosAviacion.Aerolineas.Model.ModelEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfaceEmpresa extends JpaRepository<ModelEmpresa, String> {
    // No es necesario agregar métodos personalizados en este caso
}

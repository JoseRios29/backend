package com.RiosAviacion.Aerolineas.Repositori;


import com.RiosAviacion.Aerolineas.Model.ModelPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfacePersona extends JpaRepository<ModelPersona, Integer> {
    // No es necesario agregar métodos personalizados en este caso
}

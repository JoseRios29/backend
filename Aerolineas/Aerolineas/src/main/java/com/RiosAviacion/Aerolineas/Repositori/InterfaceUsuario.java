package com.RiosAviacion.Aerolineas.Repositori;


import com.RiosAviacion.Aerolineas.Model.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface InterfaceUsuario extends JpaRepository<ModelUsuario, Integer> {
    // No es necesario agregar métodos personalizados en este caso
    Optional<ModelUsuario> findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}

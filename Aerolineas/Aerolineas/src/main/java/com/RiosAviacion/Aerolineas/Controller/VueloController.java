package com.RiosAviacion.Aerolineas.Controller;


import com.RiosAviacion.Aerolineas.Model.ModelVuelo;
import com.RiosAviacion.Aerolineas.Repositori.InterfaceVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
    @Autowired
    private InterfaceVuelo vueloRepository;

    @GetMapping
    public List<ModelVuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    @GetMapping("/{numReservacion}")
    public ResponseEntity<ModelVuelo> getVueloByNumReservacion(@PathVariable int numReservacion) {
        Optional<ModelVuelo> vuelo = vueloRepository.findById(numReservacion);
        if (vuelo.isPresent()) {
            return ResponseEntity.ok(vuelo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelVuelo> insertVuelo(@RequestBody ModelVuelo vuelo) {
        ModelVuelo newVuelo = vueloRepository.save(vuelo);
        return ResponseEntity.ok(newVuelo);
    }

    @PutMapping("/{numReservacion}")
    public ResponseEntity<ModelVuelo> updateVuelo(@PathVariable int numReservacion, @RequestBody ModelVuelo vuelo) {
        Optional<ModelVuelo> vueloOptional = vueloRepository.findById(numReservacion);

        if (vueloOptional.isPresent()) {
            ModelVuelo existingVuelo = vueloOptional.get();
            existingVuelo.setIdPersona(vuelo.getIdPersona());
            existingVuelo.setNumVuelo(vuelo.getNumVuelo());
            existingVuelo.setClaseVuelo(vuelo.getClaseVuelo());
            existingVuelo.setDestino(vuelo.getDestino());
            existingVuelo.setFecha(vuelo.getFecha());
            existingVuelo.setHora(vuelo.getHora());
            existingVuelo.setTiempoAbordaje(vuelo.getTiempoAbordaje());
            existingVuelo.setPuerta(vuelo.getPuerta());

            ModelVuelo updatedVuelo = vueloRepository.save(existingVuelo);
            return ResponseEntity.ok(updatedVuelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{numReservacion}")
    public ResponseEntity<String> deleteVueloByNumReservacion(@PathVariable int numReservacion) {
        Optional<ModelVuelo> vuelo = vueloRepository.findById(numReservacion);
        if (vuelo.isPresent()) {
            vueloRepository.delete(vuelo.get());
            return ResponseEntity.ok("Vuelo deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

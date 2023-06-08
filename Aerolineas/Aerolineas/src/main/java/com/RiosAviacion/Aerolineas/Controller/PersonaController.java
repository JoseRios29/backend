package com.RiosAviacion.Aerolineas.Controller;

import com.RiosAviacion.Aerolineas.Model.ModelPersona;
import com.RiosAviacion.Aerolineas.Repositori.InterfacePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    private InterfacePersona personaRepository;

    @GetMapping
    public List<ModelPersona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{idPersona}")
    public ResponseEntity<ModelPersona> getPersonaById(@PathVariable int idPersona) {
        Optional<ModelPersona> persona = personaRepository.findById(idPersona);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelPersona> insertPersona(@RequestBody ModelPersona persona) {
        ModelPersona newPersona = personaRepository.save(persona);
        return ResponseEntity.ok(newPersona);
    }

    @PutMapping("/{idPersona}")
    public ResponseEntity<ModelPersona> updatePersona(@PathVariable int idPersona, @RequestBody ModelPersona persona) {
        Optional<ModelPersona> personaOptional = personaRepository.findById(idPersona);

        if (personaOptional.isPresent()) {
            ModelPersona existingPersona = personaOptional.get();
            existingPersona.setTitulo(persona.getTitulo());
            existingPersona.setNombre(persona.getNombre());
            existingPersona.setFechaNacimiento(persona.getFechaNacimiento());

            ModelPersona updatedPersona = personaRepository.save(existingPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idPersona}")
    public ResponseEntity<String> deletePersonaById(@PathVariable int idPersona) {
        Optional<ModelPersona> persona = personaRepository.findById(idPersona);
        if (persona.isPresent()) {
            personaRepository.delete(persona.get());
            return ResponseEntity.ok("Persona deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

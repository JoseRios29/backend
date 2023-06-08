package com.RiosAviacion.Aerolineas.Controller;

import com.RiosAviacion.Aerolineas.Model.ModelEmpresa;
import com.RiosAviacion.Aerolineas.Repositori.InterfaceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private InterfaceEmpresa empresaRepository;

    @GetMapping
    public List<ModelEmpresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/{codEmpresa}")
    public ResponseEntity<ModelEmpresa> getEmpresaByCodEmpresa(@PathVariable String codEmpresa) {
        Optional<ModelEmpresa> empresa = empresaRepository.findById(codEmpresa);
        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelEmpresa> insertEmpresa(@RequestBody ModelEmpresa empresa) {
        ModelEmpresa newEmpresa = empresaRepository.save(empresa);
        return ResponseEntity.ok(newEmpresa);
    }

    @PutMapping("/{codEmpresa}")
    public ResponseEntity<ModelEmpresa> updateEmpresa(@PathVariable String codEmpresa, @RequestBody ModelEmpresa empresa) {
        Optional<ModelEmpresa> empresaOptional = empresaRepository.findById(codEmpresa);

        if (empresaOptional.isPresent()) {
            ModelEmpresa existingEmpresa = empresaOptional.get();
            existingEmpresa.setNumVuelo(empresa.getNumVuelo());
            existingEmpresa.setCodigoBarras(empresa.getCodigoBarras());
            existingEmpresa.setDepartamento(empresa.getDepartamento());
            existingEmpresa.setFechaCompra(empresa.getFechaCompra());
            existingEmpresa.setHoraCompra(empresa.getHoraCompra());

            ModelEmpresa updatedEmpresa = empresaRepository.save(existingEmpresa);
            return ResponseEntity.ok(updatedEmpresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codEmpresa}")
    public ResponseEntity<String> deleteEmpresaByCodEmpresa(@PathVariable String codEmpresa) {
        Optional<ModelEmpresa> empresa = empresaRepository.findById(codEmpresa);
        if (empresa.isPresent()) {
            empresaRepository.delete(empresa.get());
            return ResponseEntity.ok("Empresa deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

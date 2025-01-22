package ucsal.cauzy.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucsal.cauzy.domain.service.CargoService;
import ucsal.cauzy.rest.dto.CargoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    // GET /api/cargos - Lista todos os cargos
    @GetMapping
    public ResponseEntity<List<CargoDTO>> getAllCargos() {
        List<CargoDTO> cargos = cargoService.findAll();
        return ResponseEntity.ok(cargos);
    }

    // GET /api/cargos/{id} - Retorna um cargo por ID
    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> getCargoById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(cargoService.findById(id));
    }

    // POST /api/cargos - Cria um novo cargo
    @PostMapping
    public ResponseEntity<CargoDTO> createCargo(@RequestBody CargoDTO cargoDTO) {
        CargoDTO createdCargo = cargoService.save(cargoDTO);
        return ResponseEntity.ok(createdCargo);
    }

    // PUT /api/cargos/{id} - Atualiza um cargo existente
    @PutMapping("/{id}")
    public ResponseEntity<CargoDTO> updateCargo(@PathVariable Integer id, @RequestBody CargoDTO cargoDTO) {
        try {
            CargoDTO updatedCargo = cargoService.update(id, cargoDTO);
            return ResponseEntity.ok(updatedCargo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/cargos/{id} - Exclui um cargo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Integer id) {
        try {
            cargoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


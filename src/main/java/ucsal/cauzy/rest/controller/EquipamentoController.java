package ucsal.cauzy.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucsal.cauzy.rest.dto.EquipamentoDTO;
import ucsal.cauzy.domain.service.EquipamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    // GET /api/equipamentos - Lista todos os equipamentos
    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> getAllEquipamentos() {
        List<EquipamentoDTO> equipamentos = equipamentoService.findAll();
        return ResponseEntity.ok(equipamentos);
    }

    // GET /api/equipamentos/{id} - Retorna um equipamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> getEquipamentoById(@PathVariable Integer id) {
        return equipamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/equipamentos - Cria um novo equipamento
    @PostMapping
    public ResponseEntity<EquipamentoDTO> createEquipamento(@RequestBody EquipamentoDTO equipamentoDTO) {
        EquipamentoDTO createdEquipamento = equipamentoService.save(equipamentoDTO);
        return ResponseEntity.ok(createdEquipamento);
    }

    // PUT /api/equipamentos/{id} - Atualiza um equipamento existente
    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> updateEquipamento(@PathVariable Integer id, @RequestBody EquipamentoDTO equipamentoDTO) {
        try {
            EquipamentoDTO updatedEquipamento = equipamentoService.update(id, equipamentoDTO);
            return ResponseEntity.ok(updatedEquipamento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/equipamentos/{id} - Exclui um equipamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipamento(@PathVariable Integer id) {
        try {
            equipamentoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


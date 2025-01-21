package ucsal.cauzy.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucsal.cauzy.domain.service.LogAcoesService;
import ucsal.cauzy.rest.dto.LogAcoesDTO;

import java.util.List;

@RestController
@RequestMapping("/api/logAcoes")
public class LogAcoesController {

    @Autowired
    private LogAcoesService logAcoesService;

    // GET /api/logAcoes - Lista todos os logAcoes
    @GetMapping
    public ResponseEntity<List<LogAcoesDTO>> getAllLogAcoess() {
        List<LogAcoesDTO> logAcoes = logAcoesService.findAll();
        return ResponseEntity.ok(logAcoes);
    }

    // GET /api/logAcoes/{id} - Retorna um logAcoes por ID
    @GetMapping("/{id}")
    public ResponseEntity<LogAcoesDTO> getLogAcoesById(@PathVariable Integer id) {
        return logAcoesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/logAcoes - Cria um novo logAcoes
    @PostMapping
    public ResponseEntity<LogAcoesDTO> createLogAcoes(@RequestBody LogAcoesDTO logAcoesDTO) {
        LogAcoesDTO createdLogAcoes = logAcoesService.save(logAcoesDTO);
        return ResponseEntity.ok(createdLogAcoes);
    }

    // PUT /api/logAcoes/{id} - Atualiza um logAcoes existente
    @PutMapping("/{id}")
    public ResponseEntity<LogAcoesDTO> updateLogAcoes(@PathVariable Integer id, @RequestBody LogAcoesDTO logAcoesDTO) {
        try {
            LogAcoesDTO updatedLogAcoes = logAcoesService.update(id, logAcoesDTO);
            return ResponseEntity.ok(updatedLogAcoes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/logAcoes/{id} - Exclui um logAcoes
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogAcoes(@PathVariable Integer id) {
        try {
            logAcoesService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


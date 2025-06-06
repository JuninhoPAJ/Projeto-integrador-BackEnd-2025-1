package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.Campanha;
import integrador.api.repository.CampanhaRepository;

import java.util.Optional;

@RestController
@RequestMapping("api/campanha")
public class CampanhaController {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Campanha campanha) {
        try {
            Campanha novaCampanha = campanhaRepository.save(campanha);
            return ResponseEntity.ok(novaCampanha);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao cadastrar campanha.");
        }
    }

    @GetMapping("/listar")
    public Iterable<Campanha> listar() {
        return campanhaRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Optional<Campanha> campanha = campanhaRepository.findById(id);
        return campanha.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Campanha campanha) {
        if (!campanhaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        campanha.setId(id);
        Campanha atualizada = campanhaRepository.save(campanha);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        if (!campanhaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        campanhaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.Match;
import integrador.api.repository.MatchRepository;

import java.util.Optional;

@RestController
@RequestMapping("api/match")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Match match) {
        try {
            Match novoMatch = matchRepository.save(match);
            return ResponseEntity.ok(novoMatch);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao cadastrar match.");
        }
    }

    @GetMapping("/listar")
    public Iterable<Match> listar() {
        return matchRepository.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Optional<Match> match = matchRepository.findById(id);
        return match.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody Match match) {
        if (!matchRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        match.setId(id);
        Match atualizado = matchRepository.save(match);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        if (!matchRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        matchRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package integrador.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import integrador.api.model.Doacao;
import integrador.api.model.Doador;
import integrador.api.repository.DoacaoRepository;
import integrador.api.repository.DoadorRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doacao")
public class DoacaoController {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private DoadorRepository doadorRepository;

    @PostMapping("/cadastrar/{doadorId}")
    public ResponseEntity<?> cadastrar(@PathVariable Integer doadorId, @RequestBody Doacao doacao) {
        Doador doador = doadorRepository.findById(doadorId).orElse(null);
        if (doador == null) {
            return ResponseEntity.badRequest().body("Doador não encontrado.");
        }

        doacao.setDoador(doador);
        doacao.setData(LocalDate.now()); // define a data atual
        return ResponseEntity.ok(doacaoRepository.save(doacao));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Doacao>> listar() {
        return ResponseEntity.ok(doacaoRepository.findAll());
    }
}

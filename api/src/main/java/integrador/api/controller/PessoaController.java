package integrador.api.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import integrador.api.model.Pessoa;
import integrador.api.repository.PessoaRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository acao;

    @PostMapping("api/cadastrar")
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return acao.save(pessoa);
    }

    @GetMapping("api/listar")
    public List<Pessoa> listar() {
        return acao.findAll();
    }

    @GetMapping("api/pessoa/{codigo}")
    public Pessoa buscarPorCodigo(@PathVariable Integer codigo) {
        return acao.findByCodigo(codigo);
    }

    @PutMapping("api/editar")
    public Pessoa editar(@RequestBody Pessoa pessoa) {
        return acao.save(pessoa);
    }

    @DeleteMapping("api/excluir/{codigo}")
    public void excluir(@PathVariable Integer codigo) {
        Pessoa pessoa = buscarPorCodigo(codigo);
        acao.delete(pessoa);
    }

    @GetMapping("")
    public String mensagem() {
        return "Hello  World!";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}

package integrador.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;

@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idCampanha;
    private String valorItens;
    private LocalDate data;
    private String comprovante;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_doador")
    private Doador doador;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCampanha() {
        return idCampanha;
    }

    public void setIdCampanha(Integer idCampanha) {
        this.idCampanha = idCampanha;
    }

    public String getValorItens() {
        return valorItens;
    }

    public void setValorItens(String valorItens) {
        this.valorItens = valorItens;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }
}

package integrador.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class Doador {

    @Id
    private Integer idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private User user;

    private String tipoDoacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL)
    private List<Doacao> doacoes;

    // Getters e Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTipoDoacao() {
        return tipoDoacao;
    }

    public void setTipoDoacao(String tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }
}

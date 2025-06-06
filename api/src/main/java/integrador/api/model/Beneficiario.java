package integrador.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Beneficiario {

    @Id
    private Integer idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference(value = "beneficiario-user")
    private User user;

    private String necessidades;
    private String situacao;

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

    public String getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(String necessidades) {
        this.necessidades = necessidades;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}

package integrador.api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "voluntario")
public class Voluntario {

    @Id
    private Integer idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference(value = "voluntario-user")
    private User user;

    private String habilidades;
    private String disponibilidadeHorario;

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

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getDisponibilidadeHorario() {
        return disponibilidadeHorario;
    }

    public void setDisponibilidadeHorario(String disponibilidadeHorario) {
        this.disponibilidadeHorario = disponibilidadeHorario;
    }
}

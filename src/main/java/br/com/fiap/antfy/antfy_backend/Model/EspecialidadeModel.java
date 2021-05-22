package br.com.fiap.antfy.antfy_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@Table(name = "Especialidade")
public class EspecialidadeModel {

    @Id
    @Column(name = "id_especialidade")
    private Integer inEspecialidade;

    @Column(name = "nome_especialidade")
    private String especialidade;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidade")
    private List<MedicoModel> medico;

}


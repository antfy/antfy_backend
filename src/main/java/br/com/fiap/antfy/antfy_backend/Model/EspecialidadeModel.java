package br.com.fiap.antfy.antfy_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_08_especialidade")
public class EspecialidadeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_especialidade")
    private Integer idEspecialidade;

    @Column(name = "nome_especialidade")
    private String especialidade;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidade")
    private List<MedicoModel> medico;

}


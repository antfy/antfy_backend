package br.com.fiap.antfy.antfy_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "Medico")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inMedico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "crm")
    private String crm;

    @ManyToOne
    @JoinColumn(name = "especialidade")
    private EspecialidadeModel especialidade;

    @OneToOne(mappedBy = "medico", cascade = CascadeType.ALL)
    private EnderecoModel endereco;
}


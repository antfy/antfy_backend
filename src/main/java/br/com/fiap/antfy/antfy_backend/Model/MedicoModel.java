package br.com.fiap.antfy.antfy_backend.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_07_medico")
public class MedicoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco")
    private EnderecoModel endereco;

    public MedicoModel(String nome, String email, String senha, String crm, EspecialidadeModel especialidade, EnderecoModel endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }
}


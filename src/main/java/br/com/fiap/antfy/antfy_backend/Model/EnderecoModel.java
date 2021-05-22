package br.com.fiap.antfy.antfy_backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "Enderecos")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(name = "lagradouro")
    private String lagradouro;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private Integer cep;

    @Column(name = "numero")
    private Integer numero;

    @JsonIgnore
    @OneToOne
    private PacienteModel paciente;

    @JsonIgnore
    @OneToOne
    private MedicoModel medico;
}

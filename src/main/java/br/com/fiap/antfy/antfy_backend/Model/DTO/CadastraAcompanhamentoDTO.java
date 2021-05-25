package br.com.fiap.antfy.antfy_backend.Model.DTO;

import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CadastraAcompanhamentoDTO {

    private Double peso;
    private Double altura;
    private Double temperatura;
    private String precao;
    private Integer batimento;
    private Integer paciente;
}

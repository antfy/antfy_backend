package br.com.fiap.antfy.antfy_backend.Repository;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
}

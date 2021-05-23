package br.com.fiap.antfy.antfy_backend.Repository;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<AcompanhamentoModel, Integer> {

    @Transactional(readOnly = true)
    List<AcompanhamentoModel> findByPaciente(PacienteModel paciente);
}

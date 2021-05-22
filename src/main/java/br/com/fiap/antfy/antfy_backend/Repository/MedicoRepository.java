package br.com.fiap.antfy.antfy_backend.Repository;

import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  MedicoRepository extends JpaRepository<MedicoModel, Integer> {
}

package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.EnderecoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;


    public List<PacienteModel> buscarTodos() {
        List<PacienteModel> paciente = repository.findAll();
        return paciente;
    }

    public PacienteModel buscarUm(Integer id){
        PacienteModel paciente = repository.getOne(id);
        return paciente;
    }


    public PacienteModel cadastrarMedico(CadastraUsuarioDTO obj) {

        PacienteModel paciente = new PacienteModel(obj.getNome(),
                obj.getEmail(), obj.getSenha(), obj.getCpf(),
                new EnderecoModel(obj.getLagradouro(), obj.getBairro(), obj.getCidade(), obj.getEstado(),
                obj.getPais(), obj.getComplemento(), obj.getCep(), obj.getNumero()));

        return repository.save(paciente);
    }
}

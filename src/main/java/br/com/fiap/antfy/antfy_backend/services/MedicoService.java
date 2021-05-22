package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraMedicoDTO;
import br.com.fiap.antfy.antfy_backend.Model.EnderecoModel;
import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    @Autowired
    ServiceEspecialidade serviceEspecialidade;

    public List<MedicoModel> buscarTodos() {
        List<MedicoModel> medico = repository.findAll();
        return medico;
    }

    public MedicoModel cadastrarMedico(CadastraMedicoDTO obj) {

        MedicoModel medico = new MedicoModel(obj.getNome(),
                obj.getEmail(), obj.getSenha(), obj.getCrm(),
                serviceEspecialidade.buscarUm(obj.getEspecialidade()),
                new EnderecoModel(obj.getLagradouro(), obj.getBairro(), obj.getCidade(), obj.getEstado(),
                obj.getPais(), obj.getComplemento(), obj.getCep(), obj.getNumero()));

        return repository.save(medico);
    }
}

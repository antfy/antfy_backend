package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraMedicoDTO;
import br.com.fiap.antfy.antfy_backend.Model.EnderecoModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicoService {

    @Autowired
    MedicoRepository repository;

    @Autowired
    ServiceEspecialidade serviceEspecialidade;

    public List<MedicoModel> buscarTodos(){
        List<MedicoModel> medico = repository.findAll();
        return  medico;
    }

    public MedicoModel cadastrarMedico(CadastraMedicoDTO obj){
        EnderecoModel endereco = EnderecoModel.builder()
                .bairro(obj.getBairro())
                .cep(obj.getCep())
                .cidade(obj.getCidade())
                .complemento(obj.getComplemento())
                .estado(obj.getEstado())
                .lagradouro(obj.getLagradouro())
                .numero(obj.getNumero())
                .pais(obj.getPais())
                .build();

        MedicoModel medico = MedicoModel.builder()
                .crm(obj.getCrm())
                .email(obj.getEmail())
                .endereco(endereco)
                .especialidade(serviceEspecialidade.buscarUm(obj.getEspecialidade()))
                .nome(obj.getNome())
                .senha(obj.getSenha())
                .build();

        return repository.save(medico);
    }
}

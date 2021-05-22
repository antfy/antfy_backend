package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceEspecialidade {

    @Autowired
    EspecialidadeRepository repository;

    public EspecialidadeModel buscarUm(Integer id){
        return repository.getOne(id);
    }
}

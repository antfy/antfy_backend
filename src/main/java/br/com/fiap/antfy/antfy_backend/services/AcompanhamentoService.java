package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.EspecialidadeModel;
import br.com.fiap.antfy.antfy_backend.Repository.AcompanhamentoRepository;
import br.com.fiap.antfy.antfy_backend.Repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AcompanhamentoService implements Serializable {
    private static final long serialVersionUID = 1L;


    @Autowired
    AcompanhamentoRepository repository;

    @Autowired
    PacienteService pacienteService;

    public List<AcompanhamentoModel> buscarPorPaciente(Integer id){
        List<AcompanhamentoModel> model = repository.findByPaciente(pacienteService.buscarUm(id));
        return model ;
    }

    public List<AcompanhamentoModel> buscarTodos(){
        return repository.findAll();
    }

    public AcompanhamentoModel cadrastrarEpecialidade(AcompanhamentoModel acompanhamento){
        return repository.save(acompanhamento);
    }
}

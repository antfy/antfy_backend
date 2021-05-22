package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraMedicoDTO;
import br.com.fiap.antfy.antfy_backend.Model.EnderecoModel;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Repository.MedicoRepository;
import br.com.fiap.antfy.antfy_backend.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

        @Autowired
        MedicoService medicoService;


    @GetMapping
    public ResponseEntity<List<MedicoModel>> buscarTodos(){
        List<MedicoModel> medico = medicoService.buscarTodos();
        return  ResponseEntity.ok().body(medico);
    }

    public ResponseEntity<MedicoModel> cadastraMedico(@RequestBody CadastraMedicoDTO obj){
        MedicoModel medico = medicoService.cadastrarMedico(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getInMedico()).toUri();
        return ResponseEntity.created(uri).body(medico);
    }
}

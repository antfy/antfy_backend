package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CriaConsultaDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.RetornoCriaConsultaDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.SintomasApiDTO;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaController {

    @Autowired
    ConsultaService service;


    @GetMapping
    public ResponseEntity<List<SintomasApiDTO>> buscarSintomas() {
        List<SintomasApiDTO> listaSintomas =  service.buscarSintomas();
        return ResponseEntity.ok().body(listaSintomas);
    }

    @PostMapping
    public ResponseEntity<RetornoCriaConsultaDTO> cadastraPaciente(@RequestBody CriaConsultaDTO criaConsultaDTO) {

        var consulta = service.criarConsulta(criaConsultaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consulta.getConsulta().getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }
}

package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.SintomasDTO;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.services.ConsultaService;
import br.com.fiap.antfy.antfy_backend.services.PacienteService;
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
    public ResponseEntity<List<SintomasDTO>> buscarSintomas() {
        List<SintomasDTO> listaSintomas =  service.buscarSintomas();
        return ResponseEntity.ok().body(listaSintomas);
    }

    @PostMapping
    public ResponseEntity<PacienteModel> cadastraPaciente(@RequestBody CadastraUsuarioDTO obj) {
        PacienteModel paciente = service.cadastrarPaciente(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }
}

package br.com.fiap.antfy.antfy_backend.Controller;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraAcompanhamentoDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.services.AcompanhamentoService;
import br.com.fiap.antfy.antfy_backend.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/acompanhamentos")
public class AcompanhamentoController {

    @Autowired
    AcompanhamentoService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<List<AcompanhamentoModel>> buscarProPaciente(@PathVariable Integer id) {
        List<AcompanhamentoModel> acompanhamento = service.buscarPorPaciente(id);
        return ResponseEntity.ok().body(acompanhamento);
    }

    @PostMapping
    public ResponseEntity<AcompanhamentoModel> cadrastrarAcompanhamento(@RequestBody CadastraAcompanhamentoDTO obj) {
        AcompanhamentoModel acompanhamento = service.cadrastrarAcompanhamento(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acompanhamento.getIdAcompanhamento()).toUri();
        return ResponseEntity.created(uri).body(acompanhamento);
    }
}

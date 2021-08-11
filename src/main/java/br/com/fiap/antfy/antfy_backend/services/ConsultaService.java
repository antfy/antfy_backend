package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.ConsultaModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraUsuarioDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CriaConsultaDTO;
import br.com.fiap.antfy.antfy_backend.Model.DTO.SintomasDTO;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private WebClient webClient;

    public List<SintomasDTO> buscarSintomas() {
        Mono<SintomasDTO[]> monoSintomas = webClient.method(HttpMethod.GET).uri("/")
                .retrieve().bodyToMono(SintomasDTO[].class);
        SintomasDTO[] listaSintomas = monoSintomas.block();
        return List.of(listaSintomas);
    }

    public List<ConsultaModel> BuscarConsulta(Integer id) {
        return null;
    }

    public void criarConsulta(CriaConsultaDTO criaConsultaDTO){

    }



    public PacienteModel cadastrarPaciente(CadastraUsuarioDTO obj) {
        return null;
    }
}

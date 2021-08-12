package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Enum.StatusConsulta;
import br.com.fiap.antfy.antfy_backend.Model.ConsultaModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.*;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultaRepository repository;

    public List<SintomasApiDTO> buscarSintomas() {
        Mono<SintomasApiDTO[]> monoSintomas = webClient.method(HttpMethod.GET).uri("/")
                .retrieve().bodyToMono(SintomasApiDTO[].class);
        SintomasApiDTO[] listaSintomas = monoSintomas.block();
        return List.of(listaSintomas);
    }

    public List<ConsultaModel> BuscarConsulta(Integer id) {
        return null;
    }

    public RetornoCriaConsultaDTO criarConsulta(CriaConsultaDTO criaConsultaDTO) {
        Mono<SintomaFiltoDTO> monoSintomaFintro = webClient.method(HttpMethod.GET).uri("/filtro/{listaID}", criaConsultaDTO.getListaSintomaId())
                .retrieve().bodyToMono(SintomaFiltoDTO.class);

        var paciente = pacienteService.buscarUm(criaConsultaDTO.getPacenteID());
        var consulta = new ConsultaModel(new Date(), StatusConsulta.CONSULTA_CRIADA.getCode(), paciente);

        repository.save(consulta);

        SintomaFiltoDTO SintomaFilto = monoSintomaFintro.block();

        var listaMedico = medicoService.buscarPorEspecialidade(SintomaFilto.getEspecialidade());

        return new RetornoCriaConsultaDTO(consulta, listaMedico);

    }


    public PacienteModel cadastrarPaciente(CadastraUsuarioDTO obj) {
        return null;
    }
}

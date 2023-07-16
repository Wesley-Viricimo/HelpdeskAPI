package org.example.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.example.domain.Chamado;
import org.example.domain.Cliente;
import org.example.domain.Tecnico;
import org.example.domain.dtos.ChamadoDTO;
import org.example.domain.enums.Prioridade;
import org.example.domain.enums.Status;
import org.example.repositories.ChamadoRepository;
import org.example.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id); //Optional define que o objeto pode ou não ser encontrado
        return obj.orElseThrow(() -> new ObjectNotFoundException("O chamado '" + id +  "' não foi encontrado!")); //Se o objeto não for encontrado será disparada a exceção customizada
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(@Valid ChamadoDTO objDTO) {
        return repository.save(newChamado(objDTO));
    }

    public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
        objDTO.setId(id);
        Chamado oldObj = findById(id);
        oldObj = newChamado(objDTO);
        return repository.save(oldObj);
    }

    private Chamado newChamado(ChamadoDTO obj) { //Método que irá disparar uma exceção, caso o chamado possuir algum técnico ou algum cliente que não exista
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if(obj.getId() != null) { //Se o id do chamado for diferente de nulo significa que se trata de uma atualização do chamado
            chamado.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)) { //Se o chamado for um chamado encerrado irá ser setada a data atual
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());

        return chamado;
    }
}


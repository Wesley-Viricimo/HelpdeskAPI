package org.example.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.Chamado;

@Getter
@Setter
public class ChamadoDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento = LocalDate.now();
    @NotNull(message = "O campo PRIORIDADE é requerido")
    private Integer prioridade; //Quando for realizar a busca por prioridade retornar apenas o id da prioridade
    @NotNull(message = "O campo STATUS é requerido")
    private Integer status; //Quando for realizar a busca por status retornar apenas o id do status
    @NotNull(message = "O campo TÍTULO é requerido")
    private String titulo;
    @NotNull(message = "O campo OBSERVAÇÕES é requerido")
    private String observacoes;
    @NotNull(message = "O campo TÉCNICO é requerido")
    private Integer tecnico; //Quando for realizar a busca por tecnico retornar apenas o id do tecnico
    @NotNull(message = "O campo CLIENTE é requerido")
    private Integer cliente; //Quando for realizar a busca por cliente retornar apenas o id do cliente
    private String nomeTecnico;
    private String nomeCliente;

    public ChamadoDTO() {
        super();
    }

    public ChamadoDTO(Chamado obj) {
        super();
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade().getCodigo();
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();
        this.tecnico = obj.getTecnico().getId();
        this.cliente = obj.getCliente().getId();
        this.nomeTecnico = obj.getTecnico().getNome();
        this.nomeCliente = obj.getCliente().getNome();
    }

}


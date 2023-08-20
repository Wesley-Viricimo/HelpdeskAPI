package org.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.Prioridade;
import org.example.domain.enums.Status;

@Getter
@Setter
@Entity(name = "T_CHAMADO")
public class Chamado implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento = null;

    private Prioridade prioridade;
    private Status status;

    @Column(length = 80)
    private String titulo;

    private String observacoes;

    //Todo chamado precisa ter um cliente e um técnico atribuido a ele
    @ManyToOne //Informando que um tecnico pode ter muitos chamados (muitos para um)
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne //Informando que um cliente pode ter vários chamados (muitos para um)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Chamado() {
        super();
    }

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico,
                   Cliente cliente) {
        super();
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Chamado other = (Chamado) obj;
        return Objects.equals(id, other.id);
    }

}


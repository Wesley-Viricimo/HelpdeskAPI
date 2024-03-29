package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.dtos.ClienteDTO;
import org.example.domain.enums.Perfil;

@Getter
@Setter
@Entity(name="T_CLIENTE")
public class Cliente extends Pessoa {

    private static final long serialVersionUID = 1L;

    //Clientes e tecnicos poderão possuir uma lista de chamados
    @JsonIgnore
    @OneToMany(mappedBy = "cliente") //Definindo que um cliente poderá ter vários chamados(1 para muitos) e está mapeado no atributo cliente
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);//Sempre que um cliente for adicionado será adicionado o perfil cliente ao mesmo
    }

    public Cliente(ClienteDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, String fotoPerfil) {
        super(id, nome, cpf, email, senha, fotoPerfil);
        addPerfil(Perfil.CLIENTE);
    }

}


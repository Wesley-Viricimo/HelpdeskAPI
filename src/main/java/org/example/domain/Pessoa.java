package org.example.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.enums.Perfil;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

//Classe abstrata significa que não poderá ser criadas instâncias dessa classe.
@Getter
@Setter
@Entity(name="T_PESSOA")  //Informando ao JPA que a classe pessoa é uma entidade e deverá ser ciada uma tabela para ela no banco de dados
public abstract class Pessoa implements Serializable {

    //Serializable serve para que seja criada uma sequência de bites das instâncias dessa classe para que possam ser trafegadas em rede
    private static final long serialVersionUID = 1L;
    //Atributos protegidos que só poderão ser visualizados dentro do pacote domain

    @Id //Definindo que o atributo ID é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definindo que a geração deste id será do tipo identity(pelo próprio banco)
    protected Integer id;

    @Column(length = 80)
    protected String nome;

    @CPF
    @Column(unique = true, length = 15) //Definindo que não pode existir dois registros iguais no campo CPF
    protected String cpf;

    @Column(unique = true, length = 80) //Definindo que não pode existir dois registros iguais no campo Email
    @Email
    protected String email;

    @Column(length = 100)
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)//Informando que essa é uma coleção de elementos do tipo integer e que deve ser retornado quando um usuario for chamado
    @CollectionTable(name = "T_PERFIL")
    protected Set<Integer> perfis = new HashSet<>();//Atributo perfil será uma lista, pois um técnico também poderá ser um cliente

    @JsonFormat(pattern = "dd/MM/yyyy")//Definindo o padrão de data que será salvo no banco de dados
    protected LocalDate dataCriacao = LocalDate.now();//Método pega a data atual onde a intância do objeto foi criada

    protected String fotoPerfil;

    //Construtor da super classe, sem os parâmetros para criar um objeto da classe sem atribuir valor a ele
    public Pessoa() {
        super();
    }

    //Construtor que receberá os parâmetros;
    public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Pessoa(Integer id, String nome, String cpf, String email, String senha, String fotoPerfil) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
    }

    public Set<Perfil> getPerfis() {
        //Chamada do método que irá verificar se o perfil informado existe e se existir irá retornar, coletar e converter para uma lista do tipo set
        return perfis.stream().map(cod -> Perfil.toEnum(cod)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
    }

}


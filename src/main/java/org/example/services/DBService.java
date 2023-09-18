package org.example.services;

import org.example.domain.Chamado;
import org.example.domain.Cliente;
import org.example.domain.Tecnico;
import org.example.domain.enums.Prioridade;
import org.example.domain.enums.Status;
import org.example.repositories.ChamadoRepository;
import org.example.repositories.ClienteRepository;
import org.example.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {

    //Injetando dependências das interfaces criadas
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Tecnico teste 01", "28598547034", "tec1@mail.com", encoder.encode("1234"));
        Tecnico tec2 = new Tecnico(null, "Tecnico teste 02", "85119890059", "tec2@mail.com", encoder.encode("1234"));
        Tecnico tec3 = new Tecnico(null, "Tecnico teste 03", "28900297007", "tec3@mail.com", encoder.encode("1234"));
        Tecnico tec4 = new Tecnico(null, "Tecnico teste 04", "74737545058", "tec4@mail.com", encoder.encode("1234"));
        Tecnico tec5 = new Tecnico(null, "Tecnico teste 05", "67229960002", "tec5@mail.com", encoder.encode("1234"));
        Tecnico tec6 = new Tecnico(null, "Tecnico teste 06", "45026134017", "tec6@mail.com", encoder.encode("1234"));
        Tecnico tec7 = new Tecnico(null, "Tecnico teste 07", "23678151000", "tec7@mail.com", encoder.encode("1234"));
        Tecnico tec8 = new Tecnico(null, "Tecnico teste 08", "23130649050", "tec8@mail.com", encoder.encode("1234"));
        Tecnico tec9 = new Tecnico(null, "Tecnico teste 09", "62373584042", "tec9@mail.com", encoder.encode("1234"));
        Tecnico tec10 = new Tecnico(null,"Tecnico teste 10", "37486330091", "tec10@mail.com", encoder.encode("1234"));
        Tecnico tec11 = new Tecnico(null,"Tecnico teste 11", "96428734001", "tec11@mail.com", encoder.encode("1234"));
        Tecnico tec12 = new Tecnico(null,"Tecnico teste 12", "78854125040", "tec12@mail.com", encoder.encode("1234"));

        Cliente cli1 = new Cliente(null, "Cliente teste 01", "08729083052", "cli1@mail.com", encoder.encode("1234"));
        Cliente cli2 = new Cliente(null, "Cliente teste 02", "98946201088", "cli2@mail.com", encoder.encode("1234"));
        Cliente cli3 = new Cliente(null, "Cliente teste 03", "65180638070", "cli3@mail.com", encoder.encode("1234"));
        Cliente cli4 = new Cliente(null, "Cliente teste 04", "30064498000", "cli4@mail.com", encoder.encode("1234"));
        Cliente cli5 = new Cliente(null, "Cliente teste 05", "69402303006", "cli5@mail.com", encoder.encode("1234"));
        Cliente cli6 = new Cliente(null, "Cliente teste 06", "57025436020", "cli6@mail.com", encoder.encode("1234"));
        Cliente cli7 = new Cliente(null, "Cliente teste 07", "31817221035", "cli7@mail.com", encoder.encode("1234"));
        Cliente cli8 = new Cliente(null, "Cliente teste 08", "25563371093", "cli8@mail.com", encoder.encode("1234"));

        Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Título chamado teste 01", "Observações de teste do primeiro chamado", tec1, cli2);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Título chamado teste 02", "Observações de teste do segundo chamado", tec2, cli3);
        Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Título chamado teste 03", "Observações de teste do terceiro chamado", tec3, cli4);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Título chamado teste 04", "Observações de teste do quarto chamado", tec4, cli5);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Título chamado teste 05", "Observações de teste do quinto chamado", tec5, cli6);
        Chamado c6 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Título chamado teste 06", "Observações de teste do sexto chamado", tec6, cli7);
        Chamado c7 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Título chamado teste 07", "Observações de teste do setimo chamado", tec7, cli8);
        Chamado c8 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Título chamado teste 08", "Observações de teste do oitavo chamado", tec8, cli8);
        Chamado c9 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Título chamado teste 09", "Observações de teste do nono chamado", tec9, cli1);
        Chamado c10 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Título chamado teste 10", "Observações de teste do decimo chamado", tec10, cli2, LocalDate.now());
        Chamado c11 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Título chamado teste 11", "Observações de teste do decimo primeiro chamado", tec11, cli3, LocalDate.now());
        Chamado c12 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Título chamado teste 12", "Observações de teste do decimo segundo chamado", tec12, cli4, LocalDate.now());


        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6, tec7, tec8, tec9, tec10, tec11, tec12));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
    }
}


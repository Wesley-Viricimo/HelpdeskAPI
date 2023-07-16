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
        Tecnico tec1 = new Tecnico(null, "Wesley Viricimo", "459.410.608-07", "wesley@teste1.com", encoder.encode("123"));
        Tecnico tec2 = new Tecnico(null, "Jessica Viricimo", "573.533.610-00", "jessica@teste1.com", encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null, "Ana Jullia Viricimo", "689.964.080-50", "julia@teste1.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Sidineia Viricimo", "087.290.830-52", "sidineia@teste1.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Sheila Viricimo", "783.429.940-90", "Sheila@teste1.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Alessandra Amazonas", "896.208.390-64", "alessandra@teste1.com", encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 03", "Terceiro Chamado", tec3, cli3);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}


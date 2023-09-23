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
    private String fotoPessoa = "https://wl-incrivel.cf.tsp.li/resize/728x/jpg/805/57a/7337b758ba825025d94ceaf9dc.jpg";
    private String fotoPessoa1 = "https://i0.wp.com/engenharia360.com/wp-content/uploads/2019/05/esta-pessoa-nao-existe-engenharia360-4.png?resize=791%2C785&ssl=1";
    private String fotoPessoa2 = "https://dentistaubatuba.com.br/wp-content/uploads/2021/06/o-que-as-pessoas-bonitas-tem-em-comum-2.jpg";
    private String fotoPessoa3 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/08/site-vacinacao-26-anos.png";
    private String fotoPessoa4 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/08/ed5d55c8-3966-4114-8ce4-9b9d0d25effd.png";
    private String fotoPessoa5 = "https://img.ibxk.com.br/2019/02/17/17124052466014.jpg?ims=328x";
    private String fotoPessoa6 = "https://vocerh.abril.com.br/wp-content/uploads/2022/06/Eduardo_Alves.jpg?quality=70&strip=info&w=1280&h=720&crop=1";
    private String fotoPessoa7 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/07/site-vacinacao-38-anos-2.png";
    private String fotoPessoa8 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/07/site-vacinacao-38-anos-1.png";
    private String fotoPessoa9 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/07/site-vacinacao-36-anos.png";
    private String fotoPessoa10 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/07/site_vacinacao_34_anos.png";
    private String fotoPessoa11 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/08/site-vacinacao-28-anos.png";
    private String fotoPessoa12 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/07/75833718-f68b-4cf8-9f3d-70c70d18f2b6.png";
    private String fotoPessoa13 = "https://cdn.diariodolitoral.com.br/upload/dn_noticia/2017/11/papo-de-domingo-divulgacao.jpg";
    private String fotoPessoa14 = "https://cajamar.sp.gov.br/noticias/wp-content/uploads/sites/2/2021/07/site-vacinacao-33-anos.png";
    private String fotoPessoa15 = "https://www.agendartecultura.com.br/wp-content/uploads/2022/12/meneson.jpg";
    private String fotoPessoa16 = "https://blog.unyleya.edu.br/wp-content/uploads/2017/12/saiba-como-a-educacao-ajuda-voce-a-ser-uma-pessoa-melhor.jpeg";
    private String fotoPessoa17 = "https://osegredo.com.br/wp-content/uploads/2017/09/O-que-as-pessoas-felizes-t%C3%AAm-em-comum-site.jpg";
    private String fotoPessoa18 = "https://i0.wp.com/engenharia360.com/wp-content/uploads/2019/05/esta-pessoa-nao-existe-engenharia-360-2.png?resize=791%2C783&ssl=1";
    private String fotoPessoa19 = "https://wl-incrivel.cf.tsp.li/resize/728x/jpg/a98/367/8abd5c598bad7f16b2e3eb9f40.jpg";
    private String fotoPessoa20 = "https://wl-incrivel.cf.tsp.li/resize/728x/jpg/998/af8/8012d855ecac748fdf628d682d.jpg";

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
        Tecnico tec1 = new Tecnico(null, "Tecnico teste 01", "28598547034", "tec1@mail.com", encoder.encode("1234"), fotoPessoa);
        Tecnico tec2 = new Tecnico(null, "Tecnico teste 02", "85119890059", "tec2@mail.com", encoder.encode("1234"), fotoPessoa1);
        Tecnico tec3 = new Tecnico(null, "Tecnico teste 03", "28900297007", "tec3@mail.com", encoder.encode("1234"), fotoPessoa2);
        Tecnico tec4 = new Tecnico(null, "Tecnico teste 04", "74737545058", "tec4@mail.com", encoder.encode("1234"), fotoPessoa3);
        Tecnico tec5 = new Tecnico(null, "Tecnico teste 05", "67229960002", "tec5@mail.com", encoder.encode("1234"), fotoPessoa4);
        Tecnico tec6 = new Tecnico(null, "Tecnico teste 06", "45026134017", "tec6@mail.com", encoder.encode("1234"), fotoPessoa5);
        Tecnico tec7 = new Tecnico(null, "Tecnico teste 07", "23678151000", "tec7@mail.com", encoder.encode("1234"), fotoPessoa6);
        Tecnico tec8 = new Tecnico(null, "Tecnico teste 08", "23130649050", "tec8@mail.com", encoder.encode("1234"), fotoPessoa7);
        Tecnico tec9 = new Tecnico(null, "Tecnico teste 09", "62373584042", "tec9@mail.com", encoder.encode("1234"), fotoPessoa8);
        Tecnico tec10 = new Tecnico(null,"Tecnico teste 10", "37486330091", "tec10@mail.com", encoder.encode("1234"), fotoPessoa9);
        Tecnico tec11 = new Tecnico(null,"Tecnico teste 11", "96428734001", "tec11@mail.com", encoder.encode("1234"), fotoPessoa10);
        Tecnico tec12 = new Tecnico(null,"Tecnico teste 12", "78854125040", "tec12@mail.com", encoder.encode("1234"), fotoPessoa11);

        Cliente cli1 = new Cliente(null, "Cliente teste 01", "08729083052", "cli1@mail.com", encoder.encode("1234"), fotoPessoa12);
        Cliente cli2 = new Cliente(null, "Cliente teste 02", "98946201088", "cli2@mail.com", encoder.encode("1234"), fotoPessoa13);
        Cliente cli3 = new Cliente(null, "Cliente teste 03", "65180638070", "cli3@mail.com", encoder.encode("1234"), fotoPessoa14);
        Cliente cli4 = new Cliente(null, "Cliente teste 04", "30064498000", "cli4@mail.com", encoder.encode("1234"), fotoPessoa15);
        Cliente cli5 = new Cliente(null, "Cliente teste 05", "69402303006", "cli5@mail.com", encoder.encode("1234"), fotoPessoa16);
        Cliente cli6 = new Cliente(null, "Cliente teste 06", "57025436020", "cli6@mail.com", encoder.encode("1234"), fotoPessoa17);
        Cliente cli7 = new Cliente(null, "Cliente teste 07", "31817221035", "cli7@mail.com", encoder.encode("1234"), fotoPessoa18);
        Cliente cli8 = new Cliente(null, "Cliente teste 08", "25563371093", "cli8@mail.com", encoder.encode("1234"), fotoPessoa19);
        Cliente cli9 = new Cliente(null, "Cliente teste 09", "93537556039", "cli9@mail.com", encoder.encode("1234"), fotoPessoa20);

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
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8, cli9));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
    }
}


package br.edu.aula.bd.bdAula.service;

import br.edu.aula.bd.bdAula.dao.AlunoDao;
import br.edu.aula.bd.bdAula.model.Aluno;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"test"})
public class AlunoServiceTest {

    @Autowired
    AlunoService aServ;
    @Autowired
    AlunoDao aDao;

    @BeforeAll
    public static void init(){
        System.out.println("TESTES EM EXECUÇÃO");
    }

    int totalAlunos = 6;
    int qtdeAlunosAprov = 4;

    @BeforeEach
    public void initV1(){
        System.out.println("inserindo dados");
        Aluno a1 = new Aluno(1,"Zezin", 8);
        Aluno a2 = new Aluno(2,"Pedrin", 0);
        Aluno a3 = new Aluno(3,"Gustin", 9);
        Aluno a4 = new Aluno(4,"Jefin", 7);
        Aluno a5 = new Aluno(5,"Markin", 6.9);
        Aluno a6 = new Aluno(6,"Grilin", 10);
        aDao.save(a1);
        aDao.save(a2);
        aDao.save(a3);
        aDao.save(a4);
        aDao.save(a5);
        aDao.save(a6);
    }
    @AfterEach
    public void finish(){
        System.out.println("removendo dados");
        aDao.deleteAll();
    }

    @Test
    @DisplayName("teste gravação aluno sem nome")
    public void teste001(){
        Aluno a1 = new Aluno(1, "",10);
        String esperado = "nome incorreto";

        try {
            aServ.salvarAluno(a1);
            Assertions.fail("erro!!!!!!");
        } catch (Exception e) {
            Assertions.assertEquals(esperado, e.getMessage());
        }
    }

    @Test
    @DisplayName("testa gravação aluno com sucesso")
    public void teste002(){
        Aluno a1 = new Aluno(0, "Cadin",9.5);
        long esperado = totalAlunos+1;
        try {
            aServ.salvarAluno(a1);

            Assertions.assertEquals(esperado, aDao.count() );
        } catch (Exception e) {
            Assertions.fail("erro!!!!!!");

        }
    }

    @Test
    @DisplayName("testa consulta alunos aprovados")
    public void teste003(){
        long esperado = qtdeAlunosAprov;
        try {
             int resultado = aServ.alunosAprovados().size();

            Assertions.assertEquals(esperado, resultado );
        } catch (Exception e) {
            Assertions.fail("erro!!!!!!");

        }
    }

}

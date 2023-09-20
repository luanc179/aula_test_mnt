package br.edu.aula.bd.bdAula;

import br.edu.aula.bd.bdAula.dao.AlunoDao;
import br.edu.aula.bd.bdAula.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BdAulaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BdAulaApplication.class, args);
	}

	@Autowired
	AlunoDao aDao;
	@Value("${spring.profiles.active:prod}")
	String profile;
	@Override
//	@ActiveProfiles("test")
	public void run(String... args) throws Exception {
		System.out.println(profile);
		if (profile.equals("test")) {
			Aluno a1 = new Aluno(1,"Zezin", 8);
			Aluno a2 = new Aluno(2,"Pedrin", 1);
			Aluno a3 = new Aluno(3,"Gustin", 9);
			Aluno a4 = new Aluno(4,"Jefin", 7);
			Aluno a5 = new Aluno(5,"Markin", 6.9);
			aDao.save(a1);
			aDao.save(a2);
			aDao.save(a3);
			aDao.save(a4);
			aDao.save(a5);
		}
	}
}

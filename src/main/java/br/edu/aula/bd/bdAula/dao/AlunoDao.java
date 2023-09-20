package br.edu.aula.bd.bdAula.dao;

import br.edu.aula.bd.bdAula.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoDao  extends JpaRepository<Aluno, Integer> {

    public List<Aluno> findByNotaGreaterThan(double nota);
}

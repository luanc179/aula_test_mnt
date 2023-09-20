package br.edu.aula.bd.bdAula.service;

import br.edu.aula.bd.bdAula.dao.AlunoDao;
import br.edu.aula.bd.bdAula.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    AlunoDao aDao;

    public Aluno salvarAluno(Aluno a) throws Exception {
        if (a.getNome() == null || a.getNome().isEmpty()){
            throw new Exception("nome incorreto");
        }
        if (a.getNota() < 0 || a.getNota() > 10){
            throw new Exception("nota incorreta");
        }
        return aDao.save(a);
    }

    public List<Aluno> alunosAprovados(){
        List<Aluno> lista = aDao.findByNotaGreaterThan(6.9999999999);
        return lista;
    }
}

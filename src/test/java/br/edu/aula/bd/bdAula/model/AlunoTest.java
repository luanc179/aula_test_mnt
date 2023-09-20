package br.edu.aula.bd.bdAula.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    @Test
    public void Teste001(){
        Aluno a = new Aluno(1,"",6.9);
        boolean aprovado = false;

        boolean resultado = a.isAprovado();

        Assertions.assertEquals(aprovado,resultado);
    }

}

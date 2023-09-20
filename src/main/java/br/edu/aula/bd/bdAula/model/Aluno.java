package br.edu.aula.bd.bdAula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private double nota;
    public boolean isAprovado(){
        return nota >= 7;
    }
    public boolean isReprovado(){
        return nota < 4;
    }
    public boolean isFinal(){
        return !isAprovado() && !isReprovado();
    }

}

package com.example.demo.disciplina;
import lombok.Data;



@Data
public class Disciplina implements Comparable<Disciplina>{

    private Long id;
    String nome;
    double nota;

    @Override
    public int compareTo(Disciplina outraDisciplina) {
        if (this.nota > outraDisciplina.getNota()) {
            return -1;
        } if (this.nota < outraDisciplina.getNota()) {
            return 1;
        }
        return 0;
    }
}

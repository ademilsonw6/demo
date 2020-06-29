package com.example.demo.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplinaService {
    private List<Disciplina> listDisciplinas;

    public DisciplinaService(){
        listDisciplinas = new ArrayList<>();
    }


    public Disciplina findById(Long id) {
        for(Disciplina d: this.listDisciplinas){
            if(d.getId()==id){
                return d;
            }
        }
        return null;
    }

    public Disciplina save(Disciplina disciplina){
        this.listDisciplinas.add(disciplina);
        return disciplina;
    }

    public List<Disciplina> findAll(){
        return this.listDisciplinas;
    }

    public List<Disciplina> ranking (){
        Collections.sort(this.listDisciplinas);
        return this.listDisciplinas;
    }


    public void delete(Disciplina disciplina) {
        this.listDisciplinas.remove(disciplina);
    }

    public Disciplina alterarNome(Long id, String nome){
        Disciplina d = this.findById(id);
        d.setNome(nome);
        return d;
    }

    public Disciplina alterarNota(Long id, Double nota){
        Disciplina d = this.findById(id);
        d.setNota(nota);
        return d;
    }

}

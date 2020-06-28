package com.example.demo.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    private List<Disciplina> listDisciplinas;

    public DisciplinaService(){
        listDisciplinas = new ArrayList<>();
    }


    public Disciplina findById(Long id) {
        for(Disciplina d: listDisciplinas){
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


    public void delete(Disciplina disciplina) {
        this.listDisciplinas.remove(disciplina);
    }

}

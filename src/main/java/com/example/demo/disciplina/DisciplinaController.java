package com.example.demo.disciplina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value="v1/api/disciplinas")
public class DisciplinaController {
    private static final Logger log = LoggerFactory.getLogger(Disciplina.class);
    @Autowired
    private DisciplinaService disciplinaService;

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id){
        log.info("Buscando disciplina pela ID: {}", id);
        Disciplina disciplina = this.disciplinaService.findById(id);
        this.disciplinaService.delete(disciplina);
    }


    @PostMapping
    public Disciplina create (@RequestBody Disciplina disciplina){
        log.info("Cadastrando Disciplina {}", disciplina);
        return this.disciplinaService.save(disciplina);
    }

    @GetMapping
    public List<Disciplina> findAll(){
        return this.disciplinaService.findAll();
    }

    @GetMapping(value="/{id}")
    public Disciplina findById(@PathVariable("id") Long id){
        log.info("Buscando disciplina pela ID: {}", id);
        Disciplina disciplina = this.disciplinaService.findById(id);
        return disciplina;
    }

    @GetMapping(value="/ranking")
    public List<Disciplina> ranking(){
        return this.disciplinaService.ranking();
    }

    @PutMapping(value="/{id}/nome", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina alterarNome(@PathVariable("id") Long id, @RequestBody String nome){
        log.info("Buscando disciplina pela ID: {}", id);
        Disciplina disciplina = this.disciplinaService.findById(id);
        return this.disciplinaService.alterarNome(id, nome);
    }

    @PutMapping(value="/{id}/nota", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina alterarNota(@PathVariable("id") Long id, @RequestBody Double nota){
        log.info("Buscando disciplina pela ID: {}", id);
        Disciplina disciplina = this.disciplinaService.findById(id);
        return this.disciplinaService.alterarNota(id, nota);
    }



}

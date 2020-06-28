package com.example.demo.disciplina;

import com.example.demo.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;

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




}

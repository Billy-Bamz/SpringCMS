package com.codebamz.startcms.StartCMS.controller.rest;

import com.codebamz.startcms.StartCMS.model.Categoria;
import com.codebamz.startcms.StartCMS.model.common.RepBase;
import com.codebamz.startcms.StartCMS.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//con RestController le decimos que va a ser una API
@RestController
//RequestMapping lo qeu va hacer es que:  este controlador lo va a mapear en espringboot
// El API se manejara por versiones, versionado de API, para que siempre se tenga soporte.
@RequestMapping("/api/v1/categoria")
public class CategoriaRestController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //ResponseEntity: es para devolver la respuesta
    @PutMapping//(consumes = {MediaType.APPLICATION_STREAM_JSON_VALUE}) esto significa vamos a necesitar consu ir un JSON, pero esto por defecto spring lo esta tomanto por que se anoto con Restcontroller
    public ResponseEntity<RepBase> save(@RequestBody @Valid Categoria categoria){
        return ResponseEntity.ok(new RepBase(categoriaRepository.save(categoria)));
    }

    @PostMapping
    public ResponseEntity<RepBase> update(@RequestBody @Valid  Categoria categoria){
        return ResponseEntity.ok(new RepBase(categoriaRepository.update(categoria)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RepBase> delete(@PathVariable int id){
        return ResponseEntity.ok( new RepBase(categoriaRepository.deleteById(id)));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(SpringDataWebProperties.Pageable pageable){
        return ResponseEntity.ok(categoriaRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable int id){
        return ResponseEntity.ok(categoriaRepository.findById(id));
    }

}

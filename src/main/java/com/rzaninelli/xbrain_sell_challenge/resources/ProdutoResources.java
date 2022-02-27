package com.rzaninelli.xbrain_sell_challenge.resources;

import com.rzaninelli.xbrain_sell_challenge.entities.Produto;
import com.rzaninelli.xbrain_sell_challenge.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> lista =service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

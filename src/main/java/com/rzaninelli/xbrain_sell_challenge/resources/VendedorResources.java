package com.rzaninelli.xbrain_sell_challenge.resources;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;

import com.rzaninelli.xbrain_sell_challenge.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorResources {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<Vendedor>> findAll(){
        List<Vendedor> lista =service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vendedor> findById(@PathVariable Long id){
        Vendedor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

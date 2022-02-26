package com.rzaninelli.xbrain_sell_challenge.resources;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorResources {

    @GetMapping
    public ResponseEntity<Vendedor> findAll(){
        Vendedor v1 = new Vendedor(1L, "Maria");
        return ResponseEntity.ok().body(v1);
    }
}

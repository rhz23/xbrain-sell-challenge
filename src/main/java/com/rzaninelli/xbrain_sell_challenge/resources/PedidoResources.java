package com.rzaninelli.xbrain_sell_challenge.resources;

import com.rzaninelli.xbrain_sell_challenge.entities.Pedido;
import com.rzaninelli.xbrain_sell_challenge.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> lista =service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

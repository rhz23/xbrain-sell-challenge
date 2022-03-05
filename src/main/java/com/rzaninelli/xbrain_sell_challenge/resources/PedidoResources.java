package com.rzaninelli.xbrain_sell_challenge.resources;

import com.rzaninelli.xbrain_sell_challenge.entities.ItemPedido;
import com.rzaninelli.xbrain_sell_challenge.entities.Pedido;
import com.rzaninelli.xbrain_sell_challenge.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Pedido pedido, ItemPedido itemPedido){
        pedido = service.insert(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

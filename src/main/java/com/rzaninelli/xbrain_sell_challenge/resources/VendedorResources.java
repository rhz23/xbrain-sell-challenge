package com.rzaninelli.xbrain_sell_challenge.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;

import com.rzaninelli.xbrain_sell_challenge.response.VendedorResponseHandler;
import com.rzaninelli.xbrain_sell_challenge.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.ZoneId;
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

    @GetMapping(value = "/{id}/dataInicial={dataInicial}/dataFinal={dataFinal}")
    public ResponseEntity<Object> findById(@PathVariable Long id, @PathVariable("dataInicial") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddT", timezone = "GMT") String dataInicial, @PathVariable("dataFinal") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT") String dataFinal){
        return VendedorResponseHandler.generateResponse(service.findById(id), LocalDate.parse(dataInicial).atStartOfDay(ZoneId.systemDefault()).toInstant(), LocalDate.parse(dataFinal).atStartOfDay(ZoneId.systemDefault()).toInstant(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vendedor> insert(@RequestBody Vendedor Vendedor){
        Vendedor = service.insert(Vendedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(Vendedor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vendedor> update(@PathVariable Long id, @RequestBody Vendedor Vendedor){
        Vendedor = service.update(id, Vendedor);
        return ResponseEntity.ok().body(Vendedor);
    }
}

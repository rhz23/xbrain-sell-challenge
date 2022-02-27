package com.rzaninelli.xbrain_sell_challenge.services;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import com.rzaninelli.xbrain_sell_challenge.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> findAll() {
        return repository.findAll();
    }

    public Vendedor findById(Long id){
        Optional<Vendedor> obj = repository.findById(id);
        return obj.get();
    }
}

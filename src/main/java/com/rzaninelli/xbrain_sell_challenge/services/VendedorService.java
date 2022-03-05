package com.rzaninelli.xbrain_sell_challenge.services;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import com.rzaninelli.xbrain_sell_challenge.repositories.VendedorRepository;
import com.rzaninelli.xbrain_sell_challenge.services.exceptions.DatabaseException;
import com.rzaninelli.xbrain_sell_challenge.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Vendedor insert(Vendedor vendedor){
        return repository.save(vendedor);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Vendedor update(Long id, Vendedor vendedor){
        try{
            Vendedor entity = repository.getById(id);
            updateData(entity, vendedor);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Vendedor entity, Vendedor vendedor) {
        entity.setNome(vendedor.getNome());
    }
}

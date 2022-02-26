package com.rzaninelli.xbrain_sell_challenge.config;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import com.rzaninelli.xbrain_sell_challenge.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private VendedorRepository vendedorRepository;


    @Override
    public void run(String... args) throws Exception {

        Vendedor v1 = new Vendedor(null, "Cecília Meireles");
        Vendedor v2 = new Vendedor(null, "José de Alencar");
        Vendedor v3 = new Vendedor(null, "Carlos Drummond");
        
        vendedorRepository.saveAll(Arrays.asList(v1, v2, v3));
    }
}

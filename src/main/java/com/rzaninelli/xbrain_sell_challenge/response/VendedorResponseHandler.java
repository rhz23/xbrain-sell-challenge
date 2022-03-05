package com.rzaninelli.xbrain_sell_challenge.response;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class VendedorResponseHandler {

    public static ResponseEntity<Object> generateResponse(Vendedor vendedor, Instant dataInicial, Instant dataFinal, HttpStatus status){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", vendedor.getId());
        map.put("nome", vendedor.getNome());
        map.put("Total de vendas", vendedor.getTotalPedidos(dataInicial, dataFinal));
        map.put("Média de vendas diarias ", vendedor.getMediaDiariaPedidos(dataInicial, dataFinal));

        return new ResponseEntity<Object>(map, status);
    }
}

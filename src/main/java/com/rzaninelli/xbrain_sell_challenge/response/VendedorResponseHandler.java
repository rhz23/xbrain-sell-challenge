package com.rzaninelli.xbrain_sell_challenge.response;

import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class VendedorResponseHandler {

    public static ResponseEntity<Object> generateResponse(Vendedor vendedor, Instant startDate, Instant endDate, HttpStatus status){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", vendedor.getId());
        map.put("name", vendedor.getNome());
        map.put("Sales amount", vendedor.getTotalPedidos(startDate, endDate));
        map.put("Average Daily Sells", vendedor.getMediaDiariaPedidos(startDate, endDate));

        return new ResponseEntity<Object>(map, status);
    }
}

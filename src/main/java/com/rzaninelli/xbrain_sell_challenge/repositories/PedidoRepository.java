package com.rzaninelli.xbrain_sell_challenge.repositories;

import com.rzaninelli.xbrain_sell_challenge.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

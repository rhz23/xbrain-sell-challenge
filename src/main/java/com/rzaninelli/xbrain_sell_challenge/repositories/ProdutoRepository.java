package com.rzaninelli.xbrain_sell_challenge.repositories;

import com.rzaninelli.xbrain_sell_challenge.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

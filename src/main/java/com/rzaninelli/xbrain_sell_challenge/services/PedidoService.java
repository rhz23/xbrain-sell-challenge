package com.rzaninelli.xbrain_sell_challenge.services;

import com.rzaninelli.xbrain_sell_challenge.entities.ItemPedido;
import com.rzaninelli.xbrain_sell_challenge.entities.Pedido;
import com.rzaninelli.xbrain_sell_challenge.repositories.ItemPedidoRepository;
import com.rzaninelli.xbrain_sell_challenge.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }

    @Transactional
    public Pedido insert(Pedido pedido){
        pedido.setId(null);
        pedido.setTimestamp(new Date().toInstant());
        pedido = repository.save(pedido);
        for (ItemPedido itemPedido : pedido.getItens()){
            itemPedido.setPreco(produtoService.findById(itemPedido.getProduto().getId()).getPreco());
            itemPedido.setPedido(pedido);
        }
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;
    }
}

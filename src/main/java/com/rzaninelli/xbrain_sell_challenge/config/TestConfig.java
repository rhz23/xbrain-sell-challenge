package com.rzaninelli.xbrain_sell_challenge.config;

import com.rzaninelli.xbrain_sell_challenge.entities.ItemPedido;
import com.rzaninelli.xbrain_sell_challenge.entities.Pedido;
import com.rzaninelli.xbrain_sell_challenge.entities.Produto;
import com.rzaninelli.xbrain_sell_challenge.entities.Vendedor;
import com.rzaninelli.xbrain_sell_challenge.repositories.ItemPedidoRepository;
import com.rzaninelli.xbrain_sell_challenge.repositories.PedidoRepository;
import com.rzaninelli.xbrain_sell_challenge.repositories.ProdutoRepository;
import com.rzaninelli.xbrain_sell_challenge.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    @Override
    public void run(String... args) throws Exception {

        Produto p1 = new Produto(null, "Box As Crônicas de Gelo e Fogo", 223.19);
        Produto p2 = new Produto(null, "O Nome do Vento", 53.90);
        Produto p3 = new Produto(null, "Box As Crônicas do Rei Artur", 104.95);
        Produto p4 = new Produto(null, "MacBook Air M1", 7639.99);
        Produto p5 = new Produto(null, "Monitor 4K 28\"", 223.19);
        Produto p6 = new Produto(null, "Geforce RTX 3090", 21999.90);
        Produto p7 = new Produto(null, "Headset Barracuda X", 1100.00);
        Produto p8 = new Produto(null, "Domain-Driven-Designe", 67.99);
        Produto p9 = new Produto(null, "Código Limpo", 62.63);
        Produto p10 = new Produto(null, "Grooking Simplicity: Taming Complex Software with Funcional Thinking", 188.89);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

        Vendedor v1 = new Vendedor(null, "Cecília Meireles");
        Vendedor v2 = new Vendedor(null, "José de Alencar");
        Vendedor v3 = new Vendedor(null, "Carlos Drummond");

        Pedido pd1 =  new Pedido(null, Instant.parse("2022-02-22T20:00:02Z"), v1);
        Pedido pd2 =  new Pedido(null, Instant.parse("2022-02-22T21:15:00Z"), v1);
        Pedido pd3 =  new Pedido(null, Instant.parse("2022-02-22T13:30:23Z"), v2);
        Pedido pd4 =  new Pedido(null, Instant.parse("2022-02-21T20:00:02Z"), v3);
        Pedido pd5 =  new Pedido(null, Instant.parse("2022-02-20T20:00:02Z"), v1);
        Pedido pd6 =  new Pedido(null, Instant.parse("2022-02-23T20:00:02Z"), v1);

        vendedorRepository.saveAll(Arrays.asList(v1, v2, v3));

        pedidoRepository.saveAll(Arrays.asList(pd1, pd2, pd3, pd4, pd5, pd6));

        ItemPedido iP1 = new ItemPedido(pd1, p1, 1, p1.getPreco());
        /*
        ItemPedido iP2 = new ItemPedido(pd1, p2, 2, p2.getPreco());
        ItemPedido iP3 = new ItemPedido(pd1, p3, 1, p3.getPreco());
        ItemPedido iP4 = new ItemPedido(pd2, p6, 1, p6.getPreco());
        ItemPedido iP5 = new ItemPedido(pd3, p8, 1, p8.getPreco());
        ItemPedido iP6 = new ItemPedido(pd3, p9, 1, p9.getPreco());
        ItemPedido iP7 = new ItemPedido(pd4, p5, 1, p5.getPreco());
        ItemPedido iP8 = new ItemPedido(pd5, p4, 10, p4.getPreco());
        ItemPedido iP9 = new ItemPedido(pd6, p7, 1, p7.getPreco());
        ItemPedido iP10 = new ItemPedido(pd6, p3, 1, p3.getPreco());
        ItemPedido iP11 = new ItemPedido(pd6, p10, 1, p10.getPreco());

         */

        //itemPedidoRepository.saveAll(Arrays.asList(iP1, iP2, iP3, iP4, iP5, iP6, iP6, iP7, iP8, iP9, iP10));
        itemPedidoRepository.saveAll(Arrays.asList(iP1));
    }
}

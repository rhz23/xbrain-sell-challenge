package com.rzaninelli.xbrain_sell_challenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private List<Pedido> pedidos = new ArrayList<>();

    public Vendedor(){
    }
    
    public Vendedor(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Long getTotalPedidos(Instant dataInicial, Instant dataFinal){
        return vendasPorTempo(dataInicial, dataFinal);
    }

    public Double getMediaDiariaPedidos (Instant dataInicial, Instant dataFinal){
        Long dias =  dataInicial.until(dataFinal, ChronoUnit.DAYS);
        Long vendas = vendasPorTempo(dataInicial, dataFinal);
        Double mediaDiaria =  Double.valueOf(vendas)/dias;
        return Math.round(mediaDiaria*100.00)/100.00;
    }

    private Long vendasPorTempo(Instant dataInicial, Instant dataFinal) {
        Long vendas = 0L;
        for (Pedido x : pedidos){
            if (x.getVendedor() == this && (x.getTimestamp().compareTo(dataInicial)>=0 || x.getTimestamp().compareTo(dataFinal)<=0)){
                vendas++;
            }
        }
        return vendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(id, vendedor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

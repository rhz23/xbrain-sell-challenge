package com.rzaninelli.xbrain_sell_challenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_vendedor")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Exclude
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    @Setter(value = AccessLevel.NONE)
    private List<Pedido> pedidos = new ArrayList<>();

    public Vendedor(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}

package com.rzaninelli.xbrain_sell_challenge.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Table(name = "tb_produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Exclude
    private String nome;
    @EqualsAndHashCode.Exclude
    private Double preco;



}

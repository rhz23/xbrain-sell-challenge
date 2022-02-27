package com.rzaninelli.xbrain_sell_challenge.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Exclude
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant timestamp;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    @EqualsAndHashCode.Exclude
    private Vendedor vendedor;


}

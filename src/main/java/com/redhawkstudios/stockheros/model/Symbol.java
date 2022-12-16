package com.redhawkstudios.stockheros.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Data
@Entity
@Table(name = "symbols")
public class Symbol {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
        this.symbol = "";
    }
}

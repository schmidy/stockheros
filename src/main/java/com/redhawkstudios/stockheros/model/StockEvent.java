package com.redhawkstudios.stockheros.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name = "StockEvents")
public class StockEvent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
//
//    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/dd/yy");
    @Column(name = "date", columnDefinition = "TEXT")
    private String date;

    @Column(name = "symbol", columnDefinition = "TEXT")
    private String symbol;

    @Column(name = "event", columnDefinition = "TEXT")
    private String event;

    @Column(name = "value", columnDefinition = "TEXT")
    private String value;

    public StockEvent(String Date, String symbol, String Event, String Value) {
        this.date = Date;
        this.symbol = symbol;
        this.event = Event;
        this.value = Value;
    }

    public StockEvent() {
        this.date = "";
        this.symbol = "";
        this.event = "";
        this.value = "";
    }
}

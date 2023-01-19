package com.redhawkstudios.stockheros.repository;

import com.redhawkstudios.stockheros.StockHeroController;
import com.redhawkstudios.stockheros.model.StockEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class StockEventRepositoryTest {

    @Autowired
    private StockEventRepository stockEventRepository;

    @Test
    void findAllStockEvents() {

        Iterable<StockEvent> stockEvents = stockEventRepository.findAll();
        for (StockEvent stockEvent : stockEvents) {
            System.out.println(stockEvent.getSymbol());
        }

    }

    @Test
    void findStockEventBySymbol() {
    }

    @Test
    void findAllByDate() {
    }

    @Test
    void findAllBySymbolAndDate() {
    }
}
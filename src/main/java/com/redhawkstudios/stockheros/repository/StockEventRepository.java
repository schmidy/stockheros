package com.redhawkstudios.stockheros.repository;

import com.redhawkstudios.stockheros.model.StockEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockEventRepository extends CrudRepository<StockEvent, Integer> {

    List<StockEvent> findStockEventBySymbol(String symbol);

    @Query(value = "SELECT s.* FROM stockevents s WHERE s.date = :date ", nativeQuery = true)
    List<StockEvent>  findAllByDate(@Param("date") String date);

    @Query(value = "SELECT * FROM stockevents WHERE symbol = :symbol and date = :date ", nativeQuery = true)
    List<StockEvent>  findAllBySymbolAndDate(@Param("symbol")String symbol, @Param("date") String date);
}


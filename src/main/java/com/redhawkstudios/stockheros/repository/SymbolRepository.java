package com.redhawkstudios.stockheros.repository;

import com.redhawkstudios.stockheros.model.Symbol;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SymbolRepository extends CrudRepository<Symbol, Integer> {

    List<Symbol> findSymbolBySymbol(String symbol);

}

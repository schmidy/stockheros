package com.redhawkstudios.stockheros.repository;

import com.redhawkstudios.stockheros.model.Symbol;
import org.springframework.data.repository.CrudRepository;

public interface SymbolRepository extends CrudRepository<Symbol, Integer> {

}

package com.redhawkstudios.stockheros;

import com.redhawkstudios.stockheros.model.StockEvent;
import com.redhawkstudios.stockheros.model.Symbol;
import com.redhawkstudios.stockheros.repository.StockEventRepository;
import com.redhawkstudios.stockheros.repository.SymbolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController	// This means that this class is a Controller
public class StockHeroController {
    @Autowired
    private SymbolRepository symbolRepository;
    @Autowired
    private StockEventRepository stockEventRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewSymbol (@RequestParam String symbol
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Symbol s = new Symbol();
        s.setSymbol(symbol);
        symbolRepository.save(s);
        return "Saved";
    }

    @GetMapping(path="/symbols")
    public @ResponseBody Iterable<Symbol> getAlSymbols() {
        // This returns a JSON or XML with the users
        return symbolRepository.findAll();
    }

    @GetMapping(path={"/stockevents","/stockevents/{symbol}"})
    public @ResponseBody Iterable<StockEvent> getStockEventsBySymbol(@PathVariable(name = "symbol", required = false) String symbol,
                                                                     @RequestParam(name="date", required = false) String date) {

        String returnValue = "";

        if (date != null) {
            if (symbol != null) {
                return stockEventRepository.findAllBySymbolAndDate(symbol, date);
            }
            return stockEventRepository.findAllByDate(date);
        }

        if (symbol == null) {
            return stockEventRepository.findAll();
        }

        return stockEventRepository.findStockEventBySymbol(symbol.toUpperCase());
    }

}


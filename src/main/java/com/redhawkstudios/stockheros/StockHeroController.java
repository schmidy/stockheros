package com.redhawkstudios.stockheros;

import com.redhawkstudios.stockheros.model.StockEvent;
import com.redhawkstudios.stockheros.model.Symbol;
import com.redhawkstudios.stockheros.repository.StockEventRepository;
import com.redhawkstudios.stockheros.repository.SymbolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController	// This means that this class is a Controller
@CrossOrigin(origins = "*")
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
    public @ResponseBody Iterable<StockEvent> getStockEventsBySymbol(
            @PathVariable(name = "symbol", required = false) String symbol,
            @RequestParam Map<String, String> allRequestParams) {


        return handleStockEventRequest(symbol, allRequestParams);
    }

    private List<StockEvent> handleStockEventRequest (String symbol, Map<String, String> allRequestParams) {

        // No params sent on URL
        if (allRequestParams.size() == 0) {
            // Get all stock events
            if (symbol == null) {
                return (List<StockEvent>) stockEventRepository.findAll();
            }
            return stockEventRepository.findStockEventBySymbol(symbol.toLowerCase());
        }


        // Handle stock events for single date
        if (allRequestParams.get("date") != null) {
            if (symbol != null) {
                // get all for one symbol
                return stockEventRepository.findAllBySymbolAndDate(symbol.toLowerCase(), allRequestParams.get("date"));
            }
            // get all symbols events for date
            return stockEventRepository.findAllByDate(allRequestParams.get("date"));
        }

//        if (allRequestParams.get("startdate") != null) {
//
//        }

        return (List<StockEvent>) stockEventRepository.findAll();

    }

}


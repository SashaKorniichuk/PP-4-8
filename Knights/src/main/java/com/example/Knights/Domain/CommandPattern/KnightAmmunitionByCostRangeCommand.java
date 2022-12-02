package com.example.Knights.Domain.CommandPattern;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Domain.Response.RestException;
import com.example.Knights.Domain.Services.KnightService;
import javafx.collections.ObservableList;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class KnightAmmunitionByCostRangeCommand implements Command<ResponseEntity<ObservableList<Ammunition>>>{

    private final KnightService knightService;
    private final long knightId;
    private final int lLim;
    private final int rLim;

    public KnightAmmunitionByCostRangeCommand(KnightService knightService, long knightId, int lLim, int rLim) {
        this.knightService = knightService;
        this.knightId = knightId;
        this.lLim = lLim;
        this.rLim = rLim;
    }

    @Override
    public ResponseEntity<ObservableList<Ammunition>> execute()throws RestException {
       return knightService.findAmmunitionByCostRange(knightId,lLim,rLim);
    }
}

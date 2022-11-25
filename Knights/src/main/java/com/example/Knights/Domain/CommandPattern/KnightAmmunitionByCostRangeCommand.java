package com.example.Knights.Domain.CommandPattern;

import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.RestException;
import com.example.Knights.Domain.Services.KnightService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class KnightAmmunitionByCostRangeCommand implements Command<ResponseEntity<List<AmmunitionViewModel>>>{

    private final KnightService knightService;
    private final long knightId;
    private final double lLim;
    private final double rLim;

    public KnightAmmunitionByCostRangeCommand(KnightService knightService, long knightId, double lLim, double rLim) {
        this.knightService = knightService;
        this.knightId = knightId;
        this.lLim = lLim;
        this.rLim = rLim;
    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> execute()throws RestException {
       return knightService.findAmmunitionByCostRange(knightId,lLim,rLim);
    }
}

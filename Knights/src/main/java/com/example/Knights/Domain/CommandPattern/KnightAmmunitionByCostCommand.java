package com.example.Knights.Domain.CommandPattern;

import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.RestException;
import com.example.Knights.Domain.Services.KnightService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class KnightAmmunitionByCostCommand implements Command<ResponseEntity<List<AmmunitionViewModel>>>{

    private final KnightService knightService;
    private final long knightId;

    public KnightAmmunitionByCostCommand(KnightService knightService, long knightId) {
        this.knightService = knightService;
        this.knightId = knightId;
    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> execute()throws RestException {
        return knightService.knightAmmunitionByCost(knightId);
    }
}

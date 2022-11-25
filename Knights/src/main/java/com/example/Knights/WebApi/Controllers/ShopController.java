package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Services.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/buyAmmunition")
    public ResponseEntity<BaseResponse> buyAmmunition( Long ammunitionId, Long knightId) {
        return shopService.buyAmmunition(ammunitionId,knightId);
    }
    @GetMapping("/allAmmunition")
    public ResponseEntity<List<AmmunitionViewModel>> allAmmunition()
    {
        return shopService.allAmmunition();
    }
}

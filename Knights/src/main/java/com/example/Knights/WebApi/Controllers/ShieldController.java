package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Data.Entities.Ammunition.Shield;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Services.ShieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ShieldController {

    private final ShieldService shieldService;

    public ShieldController(ShieldService shieldService) {
        this.shieldService = shieldService;
    }

    @PostMapping("/addShield")
    public ResponseEntity<BaseResponse> createShield(@RequestBody Shield shield) {
        return shieldService.addAmmunition(shield);
    }

    @PutMapping ("/updateShield")
    public ResponseEntity<BaseResponse> updateShield(@RequestBody Shield shield,Long id) {
        return shieldService.updateAmmunition(shield,id);
    }

    @DeleteMapping ("/deleteShield")
    public ResponseEntity<BaseResponse> deleteShield(Long id) {
        return shieldService.deleteAmmunition(id);
    }
}

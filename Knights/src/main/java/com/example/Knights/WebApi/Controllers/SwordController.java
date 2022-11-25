package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.ApiModels.SwordViewModel;
import com.example.Knights.Domain.Services.SwordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SwordController {
    private final SwordService swordService;

    public SwordController(SwordService swordService) {
        this.swordService = swordService;
    }

    @PostMapping("/addSword")
    public ResponseEntity<BaseResponse> createShield(@RequestBody SwordViewModel sword) {
        return swordService.addAmmunition(sword);
    }

    @PutMapping ("/updateSword")
    public ResponseEntity<BaseResponse> updateShield(@RequestBody SwordViewModel sword,Long id) {
        return swordService.updateAmmunition(sword,id);
    }

    @DeleteMapping ("/deleteSword")
    public ResponseEntity<BaseResponse> deleteShield(Long id) {
        return swordService.deleteAmmunition(id);
    }
}

package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Data.Entities.Ammunition.Lance;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Services.LanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LanceController {

    private final LanceService lanceService;

    public LanceController(LanceService lanceService) {
        this.lanceService = lanceService;
    }

    @PostMapping("/addLance")
    public ResponseEntity<BaseResponse> createLance(@RequestBody Lance lance) {
        return lanceService.addAmmunition(lance);
    }

    @PutMapping ("/updateLance")
    public ResponseEntity<BaseResponse> updateLance(@RequestBody Lance lance,Long id) {
        return lanceService.updateAmmunition(lance,id);
    }

    @DeleteMapping ("/deleteLance")
    public ResponseEntity<BaseResponse> deleteLance(Long id) {
        return lanceService.deleteAmmunition(id);
    }
}

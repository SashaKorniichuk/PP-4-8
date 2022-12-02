package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Data.Entities.Ammunition.Helm;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Services.HelmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class HelmController {
    private final HelmService helmService;

    public HelmController(HelmService helmService) {
        this.helmService = helmService;
    }

    @PostMapping("/addHelm")
    public ResponseEntity<BaseResponse> createHelm(@RequestBody Helm helm) {
        return helmService.addAmmunition(helm);
    }

    @PutMapping ("/updateHelm")
    public ResponseEntity<BaseResponse> updateHelm(@RequestBody Helm helm,Long id) {
        return helmService.updateAmmunition(helm,id);
    }

    @DeleteMapping ("/deleteHelm")
    public ResponseEntity<BaseResponse> deleteHelm(Long id) {
        return helmService.deleteAmmunition(id);
    }
}

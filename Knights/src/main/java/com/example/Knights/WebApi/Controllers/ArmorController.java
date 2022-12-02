package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Data.Entities.Ammunition.Armor;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Services.ArmorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ArmorController {

    private final ArmorService armorService;

    public ArmorController(ArmorService armorService) {
        this.armorService = armorService;
    }

    @PostMapping("/addArmor")
    public ResponseEntity<BaseResponse> createArmor(@RequestBody Armor armor) {
        return armorService.addAmmunition(armor);
    }

    @PutMapping ("/updateArmor")
    public ResponseEntity<BaseResponse> updateArmor(@RequestBody Armor armor,Long id) {
        return armorService.updateAmmunition(armor,id);
    }

    @DeleteMapping ("/deleteArmor")
    public ResponseEntity<BaseResponse> deleteArmor(Long id) {
        return armorService.deleteAmmunition(id);
    }
}

package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.CommandPattern.*;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.ApiModels.KnightViewModel;
import com.example.Knights.Domain.Response.RestException;
import com.example.Knights.Domain.Services.KnightService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("knights.fxml")
public class KnightController {

    @FXML
    private Button backButton;

    @FXML
    private ListView<KnightViewModel> knightList;

    private KnightService knightService;

    @Autowired
    public KnightController(KnightService knightService) {
        this.knightService = knightService;

    }

    @FXML
    void back(ActionEvent event) {
        this.knightList.setItems(knightService.getAllKnights().getBody());
    }

    @PostMapping("/addKnight")
    public ResponseEntity<BaseResponse> createKnight(@RequestBody KnightViewModel knightViewModel) {
        return knightService.addKnight(knightViewModel);
    }

    @PutMapping ("/updateKnight")
    public ResponseEntity<BaseResponse> updateKnight(@RequestBody KnightViewModel knightViewModel,Long id) {
        return knightService.updateKnight(knightViewModel,id);
    }

    @DeleteMapping ("/deleteKnight")
    public ResponseEntity<BaseResponse> deleteKnight(Long id) {
        return knightService.deleteKnight(id);
    }

    @GetMapping("/knightAmmunition")
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunition(Long id) throws RestException {
        Command<ResponseEntity<List<AmmunitionViewModel>>> ammunition=new KnightAmmunitionCommand(knightService,id);
        return ammunition.execute();
    }
    @GetMapping("/knightAmmunitionByWeight")
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByWeight(Long id) throws RestException {
        Command<ResponseEntity<List<AmmunitionViewModel>>> sortByWeight=new KnightAmmunitionByWeightCommand(knightService,id);
        return  sortByWeight.execute();
    }
    @GetMapping("/knightAmmunitionByCost")
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByCost(Long id) throws RestException {
        Command<ResponseEntity<List<AmmunitionViewModel>>> sortByCost=new KnightAmmunitionByCostCommand(knightService,id);
        return  sortByCost.execute();
    }
    @GetMapping("/knightAmmunitionByCostRange")
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByCostRange(Long id,double lLim,double rLim) throws RestException {
        Command<ResponseEntity<List<AmmunitionViewModel>>> ammunitionByCostRange=new KnightAmmunitionByCostRangeCommand(knightService,id,lLim,rLim);
        return  ammunitionByCostRange.execute();
    }
}

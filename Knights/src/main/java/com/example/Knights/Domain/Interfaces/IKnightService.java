package com.example.Knights.Domain.Interfaces;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Data.Entities.Knight.Knight;
import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.ApiModels.KnightViewModel;
import com.example.Knights.Domain.Response.RestException;
import javafx.collections.ObservableList;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKnightService {
     ResponseEntity<BaseResponse> addKnight(KnightViewModel knightViewModel);

     ResponseEntity<BaseResponse> updateKnight(KnightViewModel knightViewModel, Long id);

     ResponseEntity<BaseResponse> deleteKnight(Long id);

     ResponseEntity<List<AmmunitionViewModel>> knightAmmunition(Long id) throws RestException;

     ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByWeight(Long id) throws RestException;

     ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByCost(Long id) throws RestException;

     ResponseEntity<List<AmmunitionViewModel>> findAmmunitionByCostRange(Long id,double lLim,double rLim) throws RestException;

     ResponseEntity<ObservableList<KnightViewModel>> getAllKnights();
}

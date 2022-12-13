package com.example.Knights.Domain.Interfaces;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Data.Entities.Knight.Knight;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Response.RestException;
import javafx.collections.ObservableList;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKnightService {
     BaseResponse addKnight(Knight knightViewModel);

     ObservableList<Ammunition> knightAmmunition(Long id) throws RestException;

     ObservableList<Ammunition> knightAmmunitionByWeight(Long id) throws RestException;

    ObservableList<Ammunition> knightAmmunitionByCost(Long id) throws RestException;

     ObservableList<Ammunition> findAmmunitionByCostRange(Long id,int lLim,int rLim) throws RestException;

     ObservableList<Knight> getAllKnights();
}

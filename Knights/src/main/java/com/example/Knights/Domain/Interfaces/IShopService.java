package com.example.Knights.Domain.Interfaces;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IShopService {
    ResponseEntity<BaseResponse> buyAmmunition(Long ammunitionId, Long knightId);
    ResponseEntity<List<AmmunitionViewModel>> allAmmunition();
}

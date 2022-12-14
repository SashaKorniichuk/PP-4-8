package com.example.Knights.Domain.Interfaces;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Domain.Response.BaseResponse;
import javafx.collections.ObservableList;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IShopService {
    BaseResponse buyAmmunition(Long ammunitionId, Long knightId);
   ObservableList<Ammunition> allAmmunition();
}

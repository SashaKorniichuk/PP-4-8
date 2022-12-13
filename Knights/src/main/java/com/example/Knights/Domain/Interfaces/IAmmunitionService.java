package com.example.Knights.Domain.Interfaces;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Domain.Response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface IAmmunitionService<T extends Ammunition> {
   <E> BaseResponse addAmmunition(E ammunition);
}

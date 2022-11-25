package com.example.Knights.Domain.CommandPattern;

import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.RestException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Command<T> {
   T execute()throws RestException;
}

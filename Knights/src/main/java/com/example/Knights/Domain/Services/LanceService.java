package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Lance;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LanceService extends AmmunitionService<Lance> {
    private final IGenericRepository<Lance> lanceRepository;

    public LanceService(IGenericRepository<Lance> repository) {
        super(repository);
        this.lanceRepository=repository;
    }

    @Override
    public BaseResponse addAmmunition(Object ammunition) {
        try {
            Lance lance=(Lance) ammunition;
            lanceRepository.save(new Lance(lance.getName(),lance.getLength(), lance.getDamage(),lance.getPrice(), lance.getWeight()));
            return new BaseResponse("Ammunition Lance was added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new BaseResponse("Ammunition Lance was not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

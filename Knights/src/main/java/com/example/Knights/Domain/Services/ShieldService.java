package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Shield;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShieldService extends AmmunitionService<Shield> {

    private final IGenericRepository<Shield> shieldRepository;

    public ShieldService(IGenericRepository<Shield> repository) {
        super(repository);
        this.shieldRepository=repository;
    }

    @Override
    public BaseResponse addAmmunition(Object ammunition) {
        try {
            Shield shield=(Shield) ammunition;
            shieldRepository.save(new Shield(shield.getName(),shield.getCanTakeDamage(), shield.getSize(),shield.getPrice(), shield.getWeight()));
            return new BaseResponse("Ammunition Shield was added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new BaseResponse("Ammunition Shield was not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

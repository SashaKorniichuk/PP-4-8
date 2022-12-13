package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Sword;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SwordService extends AmmunitionService<Sword> {

    private final IGenericRepository<Sword> swordRepository;

    public SwordService(IGenericRepository<Sword> repository) {
        super(repository);
        this.swordRepository=repository;
    }

    @Override
    public BaseResponse addAmmunition(Object ammunition) {
        try {
            Sword sword=(Sword) ammunition;
            swordRepository.save(new Sword(sword.getName(), sword.isTwoHanded(),sword.getDamage(),sword.getPrice(), sword.getWeight()));
            return new BaseResponse("Ammunition Sword was added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new BaseResponse("Ammunition Sword was not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

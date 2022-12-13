package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Armor;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArmorService extends AmmunitionService<Armor> {


    private final IGenericRepository<Armor> armorRepository;

    public ArmorService(IGenericRepository<Armor> armorRepository) {
        super(armorRepository);
        this.armorRepository = armorRepository;
    }
    @Override
    public BaseResponse addAmmunition(Object ammunition) {
        try {
            Armor armor=(Armor) ammunition;
            armorRepository.save(new Armor(armor.getName(), armor.getCanTakeDamage(), armor.getSize(), armor.isCeremonial(), armor.getPrice(), armor.getWeight()));
            return new BaseResponse("Ammunition Armor was added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new BaseResponse("Ammunition Armor was not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


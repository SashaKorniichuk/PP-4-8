package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Shield;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.ApiModels.ShieldViewModel;
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
    public ResponseEntity<BaseResponse> addAmmunition(Object ammunition) {
        try {
            ShieldViewModel shield=(ShieldViewModel) ammunition;
            shieldRepository.save(new Shield(shield.getName(),shield.getCanTakeDamage(), shield.getSize(),shield.getPrice(), shield.getWeight()));
            return new ResponseEntity<>(new BaseResponse("Ammunition Shield was added"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse("Ammunition Shield was not added"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BaseResponse> updateAmmunition(Object ammunition,Long id) {
        try {
            ShieldViewModel shieldViewModel=(ShieldViewModel)ammunition;
            var shield=shieldRepository.findById(id);

            if(shield.isEmpty())
            {
                return new ResponseEntity<>(new BaseResponse("Ammunition Shield was not found"), HttpStatus.NOT_FOUND);
            }
            Shield updateShield=shield.get();

            updateShield.setName(shieldViewModel.getName());
            updateShield.setCanTakeDamage(shieldViewModel.getCanTakeDamage());
            updateShield.setSize(shieldViewModel.getSize());
            updateShield.setPrice(shieldViewModel.getPrice());
            updateShield.setWeight(shieldViewModel.getWeight());

            shieldRepository.save(updateShield);

            return new ResponseEntity<>(new BaseResponse("Ammunition Shield was updated"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse("Ammunition Shield was not updated"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Data.Entities.Knight.Knight;
import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Interfaces.IShopService;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import com.example.Knights.Domain.Repositories.IKnightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements IShopService {
    private final IGenericRepository<Ammunition> ammunitionRepository;
    private final IKnightRepository knightRepository;


    public ShopService(IGenericRepository<Ammunition> ammunitionRepository, IKnightRepository knightRepository) {
        this.ammunitionRepository = ammunitionRepository;
        this.knightRepository = knightRepository;
    }

    @Override
    public ResponseEntity<BaseResponse> buyAmmunition(Long ammunitionId, Long knightId) {
        Optional<Knight> optionalKnight = knightRepository.findById(knightId);
        if (optionalKnight.isEmpty()) {
            return new ResponseEntity<>(new BaseResponse("Knight was not found"), HttpStatus.NOT_FOUND);
        }
        Knight knight = optionalKnight.get();

        Optional<Ammunition> optionalAmmunition = ammunitionRepository.findById(ammunitionId);
        if (optionalAmmunition.isEmpty()) {
            return new ResponseEntity<>(new BaseResponse("Ammunition was not found"), HttpStatus.NOT_FOUND);
        }
        Ammunition ammunition = optionalAmmunition.get();
        try {
            knight.getAmmunitions().add(ammunition);
            knightRepository.save(knight);
            return new ResponseEntity<>(new BaseResponse("Ammunition was bought"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse("Ammunition was not bought"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> allAmmunition() {
        ArrayList ammunition = (ArrayList) ammunitionRepository.findAll();
        return new ResponseEntity<>(ammunition, HttpStatus.OK);
    }

}

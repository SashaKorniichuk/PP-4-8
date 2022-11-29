package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Data.Entities.Knight.Knight;
import com.example.Knights.Domain.ApiModels.AmmunitionViewModel;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.ApiModels.KnightViewModel;
import com.example.Knights.Domain.Interfaces.IKnightService;
import com.example.Knights.Domain.Repositories.IKnightRepository;
import com.example.Knights.Domain.Response.RestException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class KnightService implements IKnightService {
    Logger logger = LoggerFactory.getLogger(KnightService.class);
    private final IKnightRepository knightRepository;

    public KnightService(IKnightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }

    @Override
    public ResponseEntity<BaseResponse> addKnight(KnightViewModel knightViewModel) {
        try {
            knightRepository.save(new Knight(knightViewModel.getTitle(), knightViewModel.getName(), knightViewModel.getAge(), knightViewModel.getHitPoints()));
            logger.info("Knight was added");
            return new ResponseEntity<>(new BaseResponse("Knight was added"), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Knight was not added");
            return new ResponseEntity<>(new BaseResponse("Knight was not added"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BaseResponse> updateKnight(KnightViewModel knightViewModel, Long id) {
        try {
            var knight = knightRepository.findById(id);

            if (knight.isEmpty()) {
                logger.error("Knight was not found");
                return new ResponseEntity<>(new BaseResponse("Knight was not found"), HttpStatus.NOT_FOUND);
            }
            Knight updateKnight = knight.get();

            updateKnight.setName(knightViewModel.getName());
            updateKnight.setAge(knightViewModel.getAge());
            updateKnight.setHitPoints(knightViewModel.getHitPoints());
            updateKnight.setTitle(knightViewModel.getTitle());
            knightRepository.save(updateKnight);
            logger.info("Knight was updated");
            return new ResponseEntity<>(new BaseResponse("Knight was updated"), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Knight was not updated");
            return new ResponseEntity<>(new BaseResponse("Knight  was not updated"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<BaseResponse> deleteKnight(Long id) {
        try {

            if (!knightRepository.existsById(id)) {
                logger.error("Knight was not found");
                return new ResponseEntity<>(new BaseResponse("Knight was not found"), HttpStatus.NOT_FOUND);
            }

            knightRepository.deleteById(id);
            logger.info("Knight was deleted");
            return new ResponseEntity<>(new BaseResponse("Knight was deleted"), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Knight was not deleted");
            return new ResponseEntity<>(new BaseResponse("Knight was not deleted"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunition(Long id) throws RestException {

        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight was not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        List ammunitions = knight.getAmmunitions();
        logger.info("Knight ammunition was found");
        return new ResponseEntity<>(ammunitions, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByWeight(Long id) throws RestException {

        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        List ammunitions = knight.getAmmunitions();

        ammunitions.sort(Comparator.comparingDouble(Ammunition::getWeight));
        logger.info("Knight ammunition was sort by weight");
        return new ResponseEntity<>(ammunitions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> knightAmmunitionByCost(Long id) throws RestException {
        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        List ammunitions = knight.getAmmunitions();

        ammunitions.sort(Comparator.comparingDouble(Ammunition::getPrice));
        logger.info("Knight ammunition was sort by price");
        return new ResponseEntity<>(ammunitions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AmmunitionViewModel>> findAmmunitionByCostRange(Long id, double lLim, double rLim) throws RestException {
        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        List<Ammunition> ammunitions = knight.getAmmunitions();

        ammunitions.sort(Comparator.comparingDouble(Ammunition::getPrice));
        List<Ammunition> needed = ammunitions.stream().filter(x -> x.getPrice() <= rLim && x.getPrice() >= lLim).collect(Collectors.toList());
        logger.info("Knight ammunition was found by price range from "+lLim+" to "+rLim);
        return new ResponseEntity(needed, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObservableList<KnightViewModel>> getAllKnights() {
        ObservableList<Knight> knightsViewModel= FXCollections.observableArrayList();
        knightRepository.findAll().forEach(knightsViewModel::add);
        return new ResponseEntity(knightsViewModel,HttpStatus.OK);
    }
}

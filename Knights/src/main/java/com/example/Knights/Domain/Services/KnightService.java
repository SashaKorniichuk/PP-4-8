package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Data.Entities.Knight.Knight;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Interfaces.IKnightService;
import com.example.Knights.Domain.Repositories.IKnightRepository;
import com.example.Knights.Domain.Response.RestException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public BaseResponse addKnight(Knight knightViewModel) {
        try {
            knightRepository.save(new Knight(knightViewModel.getTitle(), knightViewModel.getName(), knightViewModel.getAge(), knightViewModel.getHitPoints()));
            logger.info("Knight was added");
            return new BaseResponse("Knight was added", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Knight was not added");
            return new BaseResponse("Knight was not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ObservableList<Ammunition> knightAmmunition(Long id) throws RestException {

        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight was not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        ObservableList<Ammunition> ammunitions=FXCollections.observableArrayList();
        ammunitions.setAll(knight.getAmmunitions());

        logger.info("Knight ammunition was found");

        return ammunitions;

    }

    @Override
    public ObservableList<Ammunition> knightAmmunitionByWeight(Long id) throws RestException {

        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        ObservableList<Ammunition> ammunitions=FXCollections.observableArrayList();
        ammunitions.setAll(knight.getAmmunitions());

        ammunitions.sort(Comparator.comparingDouble(Ammunition::getWeight));

        logger.info("Knight ammunition was sort by weight");
        return ammunitions;
    }

    @Override
    public ObservableList<Ammunition> knightAmmunitionByCost(Long id) throws RestException {
        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        ObservableList<Ammunition> ammunitions=FXCollections.observableArrayList();
        ammunitions.setAll(knight.getAmmunitions());

        ammunitions.sort(Comparator.comparingDouble(Ammunition::getPrice));

        logger.info("Knight ammunition was sort by price");
        return ammunitions;
    }

    @Override
    public ObservableList<Ammunition> findAmmunitionByCostRange(Long id, int lLim, int rLim) throws RestException {
        var optionalKnight = knightRepository.findById(id);

        if (optionalKnight.isEmpty()) {
            logger.error("Knight not found");
            throw new RestException(HttpStatus.NOT_FOUND, "Knight was not found");
        }
        Knight knight = optionalKnight.get();

        List<Ammunition> ammunitions = knight.getAmmunitions();

        ammunitions.sort(Comparator.comparingDouble(Ammunition::getPrice));

        ObservableList<Ammunition> needed=FXCollections.observableArrayList();
        needed.setAll( ammunitions.stream().filter(x -> x.getPrice() <= rLim && x.getPrice() >= lLim).collect(Collectors.toList()));

        logger.info("Knight ammunition was found by price range from "+lLim+" to "+rLim);
        return needed;
    }

    @Override
    public ObservableList<Knight> getAllKnights() {
        ObservableList<Knight> knights= FXCollections.observableArrayList();
        knightRepository.findAll().forEach(knights::add);
        return knights;
    }
}

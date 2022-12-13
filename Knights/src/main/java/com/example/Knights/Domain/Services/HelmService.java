package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Helm;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HelmService extends AmmunitionService<Helm> {
    private final IGenericRepository<Helm> helmRepository;

    public HelmService(IGenericRepository<Helm> helmRepository) {
        super(helmRepository);
        this.helmRepository = helmRepository;
    }
    @Override
    public BaseResponse addAmmunition(Object ammunition) {
        try {
            Helm helm=(Helm) ammunition;
            helmRepository.save(new Helm(helm.getName(), helm.getCanTakeDamage(), helm.getSize(), helm.isCloseHelm(), helm.getPrice(), helm.getWeight()));
            return new BaseResponse("Ammunition Helm was added", HttpStatus.CREATED);
        } catch (Exception e) {
            return new BaseResponse("Ammunition Helm was not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

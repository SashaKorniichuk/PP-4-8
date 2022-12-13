package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.Ammunition.Ammunition;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Interfaces.IAmmunitionService;
import com.example.Knights.Domain.Repositories.IGenericRepository;
import org.springframework.core.GenericTypeResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public  class AmmunitionService<T extends Ammunition> implements IAmmunitionService<T> {
    private final IGenericRepository<T> repository;
    private final Class<T> genericType;
    public AmmunitionService(IGenericRepository<T> repository) {
        this.repository = repository;
        this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AmmunitionService.class);
    }

    @Override
    public BaseResponse addAmmunition(Object ammunition) {
        return null;
    }
}

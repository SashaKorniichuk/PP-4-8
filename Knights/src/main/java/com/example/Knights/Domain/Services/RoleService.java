package com.example.Knights.Domain.Services;

import com.example.Knights.Data.Entities.User.Role;
import com.example.Knights.Domain.ApiModels.AddRoleApiModel;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Interfaces.IRoleService;
import com.example.Knights.Domain.Repositories.IRoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<BaseResponse> AddRole(AddRoleApiModel role) {
        try {
            Role _role = roleRepository.save(new Role(role.getName()));
            return new ResponseEntity<>(new BaseResponse("Role was added"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse("Role was not added"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

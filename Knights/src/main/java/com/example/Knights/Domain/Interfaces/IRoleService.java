package com.example.Knights.Domain.Interfaces;

import com.example.Knights.Domain.ApiModels.AddRoleApiModel;
import com.example.Knights.Domain.Response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface IRoleService {
    ResponseEntity<BaseResponse> AddRole(AddRoleApiModel role);
}

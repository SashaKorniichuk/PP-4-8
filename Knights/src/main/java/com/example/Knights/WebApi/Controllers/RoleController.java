package com.example.Knights.WebApi.Controllers;

import com.example.Knights.Domain.ApiModels.AddRoleApiModel;
import com.example.Knights.Domain.Response.BaseResponse;
import com.example.Knights.Domain.Interfaces.IRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RoleController {
    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    public ResponseEntity<BaseResponse> createRole(@RequestBody AddRoleApiModel role) {
        return roleService.AddRole(role);
    }
}

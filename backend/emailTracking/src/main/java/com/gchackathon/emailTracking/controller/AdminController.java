package com.gchackathon.emailTracking.controller;

import com.gchackathon.emailTracking.dto.IsUserExistsDto;
import com.gchackathon.emailTracking.models.AdminAddSme;
import com.gchackathon.emailTracking.models.AdminAddUser;
import com.gchackathon.emailTracking.service.AdminRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/v1")
public class AdminController {

    @Autowired
    private AdminRepositoryService adminRepositoryService;

    @PostMapping("/addSme")
    public AdminAddSme saveSme(@RequestBody AdminAddSme adminAddSme) {
        return adminRepositoryService.addSME(adminAddSme);
    }

    @PostMapping("/addUser")
    public AdminAddUser saveUser(@RequestBody AdminAddUser adminAddSme) {
        return adminRepositoryService.addUSER(adminAddSme);
    }

    @GetMapping("/getAllSME")
    public List<AdminAddSme> getAllSME() {
        return adminRepositoryService.listAllSme();
    }

    @GetMapping("/getsso")
    public IsUserExistsDto checkUserExists(@RequestParam("email") String email) {
        return  adminRepositoryService.checkIfUserExists(email);
    }
}


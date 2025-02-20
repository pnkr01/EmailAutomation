package com.gchackathon.emailTracking.controller;

import com.gchackathon.emailTracking.models.AdminAddSme;
import com.gchackathon.emailTracking.models.AdminAddUser;
import com.gchackathon.emailTracking.service.AdminRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

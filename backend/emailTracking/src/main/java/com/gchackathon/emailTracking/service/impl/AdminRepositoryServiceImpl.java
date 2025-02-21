package com.gchackathon.emailTracking.service.impl;

import com.gchackathon.emailTracking.dto.IsUserExistsDto;
import com.gchackathon.emailTracking.models.AdminAddSme;
import com.gchackathon.emailTracking.models.AdminAddUser;
import com.gchackathon.emailTracking.repository.AdminRepository;
import com.gchackathon.emailTracking.repository.AdminUserRepository;
import com.gchackathon.emailTracking.service.AdminRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRepositoryServiceImpl implements AdminRepositoryService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public AdminAddSme addSME(AdminAddSme adminAddSme) {
        return adminRepository.save(adminAddSme);
    }

    @Override
    public List<AdminAddSme> listAllSme() {
        return adminRepository.findAll();
    }

    @Override
    public IsUserExistsDto checkIfUserExists(String email) {
        boolean isUserPresent = adminRepository.findByEmail(email) != null || adminUserRepository.findByEmail(email) != null;
        return new IsUserExistsDto(isUserPresent);
    }


    @Override
    public AdminAddSme updateSME(AdminAddSme adminAddSme) {
        return null;
    }

    @Override
    public boolean delSME() {
        return false;
    }

    @Override
    public AdminAddUser addUSER(AdminAddUser adminAddUser) {
        return adminUserRepository.save(adminAddUser);
    }

    @Override
    public AdminAddUser updateUSER(AdminAddUser adminAddUser) {
        return null;
    }

    @Override
    public boolean delUSER(AdminAddUser adminAddUser) {
        return false;
    }
}

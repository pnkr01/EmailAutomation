package com.gchackathon.emailTracking.service.impl;

import com.gchackathon.emailTracking.models.AdminAddSme;
import com.gchackathon.emailTracking.models.AdminAddUser;
import com.gchackathon.emailTracking.repository.AdminRepository;
import com.gchackathon.emailTracking.repository.AdminUserRepository;
import com.gchackathon.emailTracking.service.AdminRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

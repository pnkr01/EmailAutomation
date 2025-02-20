package com.gchackathon.emailTracking.service;

import com.gchackathon.emailTracking.models.AdminAddSme;
import com.gchackathon.emailTracking.models.AdminAddUser;
import org.springframework.stereotype.Service;

@Service
public interface AdminRepositoryService {
   AdminAddSme addSME(AdminAddSme adminAddSme);
    AdminAddSme updateSME(AdminAddSme adminAddSme);
    boolean delSME();
   AdminAddUser addUSER(AdminAddUser adminAddUser);
    AdminAddUser updateUSER(AdminAddUser adminAddUser);
   boolean delUSER(AdminAddUser adminAddUser);
}

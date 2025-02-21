package com.gchackathon.emailTracking.service;

import com.gchackathon.emailTracking.dto.IsUserExistsDto;
import com.gchackathon.emailTracking.models.AdminAddSme;
import com.gchackathon.emailTracking.models.AdminAddUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminRepositoryService {
   AdminAddSme addSME(AdminAddSme adminAddSme);
   List<AdminAddSme> listAllSme();
   IsUserExistsDto checkIfUserExists(String email);
    AdminAddSme updateSME(AdminAddSme adminAddSme);
    boolean delSME();
   AdminAddUser addUSER(AdminAddUser adminAddUser);
    AdminAddUser updateUSER(AdminAddUser adminAddUser);
   boolean delUSER(AdminAddUser adminAddUser);
}

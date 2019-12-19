package hnu.houseweb.service.admin;

import hnu.houseweb.entity.Admin;

public interface LoginService {
    Admin loginByAdminNo(int adminNo, String password);
    Admin loginByName(String name, String password);
}

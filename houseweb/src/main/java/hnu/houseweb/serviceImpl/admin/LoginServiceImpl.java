package hnu.houseweb.serviceImpl.admin;

import hnu.houseweb.dao.AdminMapper;
import hnu.houseweb.entity.Admin;
import hnu.houseweb.service.admin.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin loginByAdminNo(int adminNo, String password) {
        return adminMapper.findAdminByNo(adminNo,password);
    }

    @Override
    public Admin loginByName(String name, String password) {
        return adminMapper.findAdminByName(name,password);
    }
}

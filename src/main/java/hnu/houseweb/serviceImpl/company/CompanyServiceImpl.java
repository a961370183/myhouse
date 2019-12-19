package hnu.houseweb.serviceImpl.company;

import hnu.houseweb.dao.CompanyMapper;
import hnu.houseweb.entity.CompanyPart;
import hnu.houseweb.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<CompanyPart> getSomeComps() {
        return companyMapper.getTenCompany();
    }


}

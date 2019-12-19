package hnu.houseweb.serviceImpl.company;

import hnu.houseweb.dao.CompanyMapper;
import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.Company;
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

    @Override
    public List<CompanyPart> getCompanyParts(String condition, Boolean sortStarLevel) {
        if (sortStarLevel) {
            if (condition==null) {
                return companyMapper.getStarLevelSortedAllCompanyPart();
            } else if (condition.matches("^[0-9]*")) {  //如果是纯数字，说明是找机构编号
                //进行模糊查询前先拼接两个百分号
                return companyMapper.getStarLevelSortedCompanyPartByCompNoLike("%"+condition+"%");
            } else {
                return companyMapper.getStarLevelSortedCompanyPartByCompNameLike("%"+condition+"%");
            }
        } else {
            if (condition==null) {
                return companyMapper.getAllCompanyPart();
            } else if (condition.matches("^[0-9]*")) {  //如果是纯数字，说明是找机构编号
                //进行模糊查询前先拼接两个百分号
                return companyMapper.getCompanyPartByCompNoLike("%"+condition+"%");
            } else {
                return companyMapper.getCompanyPartByCompNameLike("%"+condition+"%");
            }
        }
    }

    @Override
    public Company getCompanyDetail(int compNo) {
        return companyMapper.selectByCompNo(compNo);
    }

    @Override
    public List<AgentDetail> getAgentDetails(int compNo) {
        return companyMapper.getAgentDetails(compNo);
    }


    @Override
    public List<Company> getAllCompanies(String compName) {
        return companyMapper.getAllCompanies("%"+compName+"%");
    }

    @Override
    public Boolean setOneCompany(Company company) {
        return companyMapper.setOneCompany(company) > 0;
    }

    @Override
    public Boolean delOneCompany(int compNo) {
        return companyMapper.delOneCompany(compNo)>0;
    }

    @Override
    public Boolean updateOneCompany(Company company) {
        return companyMapper.updateOneCompany(company) > 0;
    }
}

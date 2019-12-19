package hnu.houseweb.service.company;

import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.Company;
import hnu.houseweb.entity.CompanyPart;

import java.util.List;

public interface CompanyService{
    /* 获取一些机构，用于房源检索界面的按机构检索 */
    public List<CompanyPart> getSomeComps();

    /* 按照检索条件获取机构的部分信息，用于机构检索 */
    public List<CompanyPart> getCompanyParts(String condition, Boolean sortStarLevel);

    /* 按照机构编号找到机构，用于机构详细信息页面 */
    public Company getCompanyDetail(int compNo);

    /* 按照机构编号找到机构名下中介，用于机构详细信息页面 */
    public List<AgentDetail> getAgentDetails(int compNo);

    /* 获取所有机构，用于后台机构管理 */
    public List<Company> getAllCompanies(String compName);

    public  Boolean setOneCompany(Company company);

    public Boolean delOneCompany(int compNo);

    public Boolean updateOneCompany(Company company);
}

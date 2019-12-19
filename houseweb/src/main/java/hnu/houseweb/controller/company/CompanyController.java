package hnu.houseweb.controller.company;

import hnu.houseweb.entity.Company;
import hnu.houseweb.entity.CompanyPart;
import hnu.houseweb.service.agent.AgentService;
import hnu.houseweb.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("getCompany")
    @ResponseBody
    public List<CompanyPart> getCompany(){
        return companyService.getSomeComps();
    }

    @RequestMapping("/getCompanyParts")
    @ResponseBody
    public List<CompanyPart> getCompanyParts(String condition, Boolean sortStarLevel) {
        return companyService.getCompanyParts(condition, sortStarLevel);
    }

    /////////
    @RequestMapping("/getCompanies")
    @ResponseBody
    public List<Company> getCompanies(String compName) {
        return companyService.getAllCompanies(compName);
    }

    @RequestMapping("/setCompanies")
    @ResponseBody
    public Boolean setCompanies(@RequestBody Company company) {
        if (company.getCompNo() == null) {
            return companyService.setOneCompany(company);
        } else {
            return companyService.updateOneCompany(company);
        }

    }
    @RequestMapping("/delCompany")
    @ResponseBody
    public Boolean delCompany(int compNo){
        return companyService.delOneCompany(compNo);
    }
    /////////
}

package hnu.houseweb.controller.company;

import hnu.houseweb.entity.CompanyPart;
import hnu.houseweb.service.agent.AgentService;
import hnu.houseweb.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("getCompany")
    @ResponseBody
    public List<CompanyPart> getCompany(){
        return companyService.getSomeComps();
    }
}

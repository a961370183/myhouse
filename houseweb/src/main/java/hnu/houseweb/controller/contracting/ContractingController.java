package hnu.houseweb.controller.contracting;

import hnu.houseweb.entity.Contract;
import hnu.houseweb.entity.Contracting;
import hnu.houseweb.service.contracting.ContractingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("contracting")
public class ContractingController {
    @Autowired
    private ContractingService contractingService;

    @RequestMapping("getAll")
    @ResponseBody
    public List<Contracting> getAllContracting(int userId){
        return contractingService.getAllContracting(userId);
}

    @RequestMapping("/getAgentsContracts")
    public List<Contract> getAgentsContractsBy(String name) {
        return contractingService.getAllContractsBy(name);
    }

    @RequestMapping("get")
    @ResponseBody
    public Contracting getContracting(int contractNo){
        return contractingService.getContracting(contractNo);
    }

    @RequestMapping("comment")
    @ResponseBody
    public void comment(@RequestParam("contractNo") int contractNo, @RequestParam("comment") String comment, @RequestParam("star") int star){
        System.out.println(contractNo);
        System.out.println(comment);
        contractingService.comment(contractNo,comment,star);
    }
}

package hnu.houseweb.controller.information;

import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.service.agent.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private AgentService agentService;

    @RequestMapping("/agentSearch")
    public String agentSearch() {
        return "information/agent-search";
    }

    @RequestMapping("/agentDetailInformation/{workNo}")
    public String agentDetailInformation(Model mv, @PathVariable int workNo) {
//        AgentDetail agentDetail =
        mv.addAttribute("agentDetail", agentService.getAgentDetail(workNo));
        return "information/agent-detail-information";
    }
}

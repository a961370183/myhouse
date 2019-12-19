package hnu.houseweb.controller.agent;

import hnu.houseweb.dao.ContractingMapper;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.agent.AgentService;
import hnu.houseweb.serviceImpl.tools.ImgToolsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("/agent")
public class AgentController {

    /*依赖注入AgentService*/
    @Autowired
    private AgentService agentService;
    @Autowired
    private ContractingMapper contractingMapper;
    @Autowired
    private ImgToolsImpl imgTools;

    /* 寻找中介是否存在 */
    @RequestMapping("find")
    @ResponseBody
    public boolean isCorrect(int id,String name){
        System.out.println("访问到");
        return agentService.isCorrect(id,name);
    }
    /* 寻找中介是否存在 */
    @RequestMapping("sign")
    @ResponseBody
    public String sign(HttpServletRequest request, @RequestParam(value = "userId", defaultValue = "")int id, @RequestParam(value = "id", defaultValue = "")int workNo, @RequestParam(value = "name", defaultValue = "") String name){
        return agentService.sign(id,workNo,name);
    }
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("name") String name, @RequestParam("compNo") int compNo, @RequestParam("userId") String userId,@RequestParam("tel") String tel,@RequestParam("cardId") String cardId, @RequestParam("file") MultipartFile[] files) throws FileNotFoundException {
        String finalUrl = "";
        System.out.println(compNo);
        System.out.println(name);
        System.out.println(cardId);
        System.out.println(files.length);
        Date date = new Date();
        System.out.println(agentService.getStatues(Integer.parseInt(userId)));
        String str=agentService.getStatues(Integer.parseInt(userId));
        if (agentService.existsCard(cardId) || str.equals("1")) {
            return "exists";

        } else if (str.equals("2")) {

            for (MultipartFile file : files) {
                finalUrl += imgTools.saveFile(file, "images/agent/" + userId) + ";";
            }
            if (finalUrl.length() > 0)
                finalUrl = finalUrl.substring(0, finalUrl.length() - 1);
            System.out.println("update");
            agentService.update(userId, name, cardId, compNo, finalUrl,0,date,tel);
            return "update";
        } else {
            for (MultipartFile file : files) {
                finalUrl += imgTools.saveFile(file, "images/agent/" + userId) + ";";
            }
            if (finalUrl.length() > 0)
                finalUrl = finalUrl.substring(0, finalUrl.length() - 1);
            System.out.println("insert");
            agentService.insert(userId, name, cardId, compNo, finalUrl,date,tel);
            return "succsee";
        }
    }

    private String getRequestImgUrl(String path){
        int cutIndex = path.lastIndexOf("static") + 6;
//        System.out.println(path.substring(cutIndex));
        return path.substring(cutIndex);
    }

    /* 通过用户编号获得中介详细信息 */
    @RequestMapping("/getMyAgentInformation")
    @ResponseBody
    public Agent getAgent(int workNo) {
        return agentService.getAgent(workNo);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Agent> getAll(int status) {
        return agentService.getAll(status);
    }

    /* 改变中介手机号码 */
    @RequestMapping("/changeAgentTel")
    @ResponseBody
    public boolean changeAgentTel(int workNo, String tel) {
        return agentService.changeAgentTel(workNo, tel);
    }


    /* 获得与该中介有签约意向(contractState=0)或已签约(contractState=1)的用户 */
    @RequestMapping("/getContract")
    @ResponseBody
    public List<User> getContract(int workNo, String contractState) {
        return agentService.getContractingUsers(workNo, contractState);
    }

    /* 中介同意(contractState=1)或拒绝(contractState=2)用户的签约意向 */
    @RequestMapping("/updateContractingState")
    @ResponseBody
    public boolean updateContractingUser(int workNo, int userId, String contractState) {
        return agentService.updateContractingUser(workNo, userId, contractState);
    }

    /* 中介检索的时候的中介一部分信息 */
    @RequestMapping("/getAgentPart")
    @ResponseBody
    public List<AgentPart> getAgentPart(String condition) {
        return agentService.getAgentPart(condition);
    }

    /* 用户签约中介 */
    @RequestMapping("/contractAgent")
    @ResponseBody
    public boolean contractAgent(int userId, int workNo, String contractSrc) {
        if (userId==workNo) {
            return false;
        } else {
            return agentService.contractAgent(userId, workNo, contractSrc);
        }
    }

    @RequestMapping("/getAgentDetails")
    @ResponseBody
    public List<AgentDetail> getAgentDetails(String condition, Boolean sortStarLevel) {
        return agentService.getAgentDetails(condition, sortStarLevel);
    }

    @RequestMapping("/decline")
    @ResponseBody
    public void decline(@RequestParam("userId") String userId,@RequestParam("reply") String reply) {
        System.out.println("接收到");
        System.out.println(userId);
        System.out.println(reply);
        agentService.decline(userId,reply);
    }

    @RequestMapping("/pass")
    @ResponseBody
    public void pass(@RequestParam("userId") String userId,@RequestParam("reply") String reply) {
        System.out.println("接收到");
        System.out.println(userId);
        System.out.println(reply);
        agentService.pass(userId,reply);
    }

    @RequestMapping("/getAllAgents")
    @ResponseBody
    public  List<Agent> getAllAgents(String name){
        return agentService.getAllAgents(name);
    }

    @RequestMapping("/updateOneAgent")
    @ResponseBody
    public Boolean updateOneAgent(@RequestBody Agent agent){
        //    System.out.println(agent.getEmail());
        return agentService.updateOneAgent(agent);
    }

    @RequestMapping("/delOneAgent")
    @ResponseBody
    public Boolean delOneAgent(int workNo){
        return agentService.delOneAgent(workNo);
    }

    @RequestMapping("/getOneAgentDetail")
    @ResponseBody
    public AgentDetail getOneAgentDetail(int workNo) {
        return agentService.getOneAgentDetail(workNo);
    }

    @RequestMapping("/getContractsByWorkNo")
    @ResponseBody
    public List<Contract> getContractBy(int workNo) {
        return agentService.getContractBy(workNo);
    }
}

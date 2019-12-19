package hnu.houseweb.controller.information;

import hnu.houseweb.controller.tools.ImageTools;
import hnu.houseweb.dao.LawMapper;
import hnu.houseweb.dao.PunishmentMapper;
import hnu.houseweb.dao.RedListMapper;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.agent.AgentService;
import hnu.houseweb.service.company.CompanyService;
import hnu.houseweb.service.contracting.ContractingService;
import hnu.houseweb.service.information.LawService;
import hnu.houseweb.service.information.PunishmentService;
import hnu.houseweb.service.information.RedBlackListService;
import hnu.houseweb.service.information.SearchService;
import hnu.houseweb.service.tools.ImgTools;
import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private AgentService agentService;
    @Autowired
    private PunishmentService punishmentService;
    @Autowired
    private RedBlackListService redBlackListService;
    @Autowired
    private LawService lawService;
    @Autowired
    private ImgTools imgTools;
    @Autowired
    private SearchService searchService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ContractingService contractingService;
    @Autowired
    private PunishmentMapper punishmentMapper;
    @Autowired
    private LawMapper lawMapper;
    @Autowired
    private RedListMapper redListMapper;

    @RequestMapping("")
    public String index(){
        return "information/index";
    }

    @RequestMapping("/agentSearch")
    public String agentSearch() {
        return "information/agent-search";
    }

    @RequestMapping("/agentDetailPage/{workNo}")
    public String agentDetailInformation(Model mv, @PathVariable int workNo) {
        mv.addAttribute("agentDetail", agentService.getOneAgentDetail(workNo));
        mv.addAttribute("contracts", agentService.getContractBy(workNo));
        return "information/agent-detail-information";
    }

    @RequestMapping("/companyDetailPage/{compNo}")
    public String companyDetailInformation(Model mv, @PathVariable int compNo) {
        mv.addAttribute("companyDetail", companyService.getCompanyDetail(compNo));
        mv.addAttribute("agentDetails", companyService.getAgentDetails(compNo));
        return "information/company-detail-information";
    }

    @RequestMapping("/agentContractSearch")
    public String agentsContractsInformation() {
        return "information/agent-contract-search";
    }

    @RequestMapping("/agentCommentPage")
    public String agentCommentsInformation(Model model) {
        model.addAttribute("agentDetails", contractingService.getContractNumSortedAgentDetail());
        return "information/agent-comment";
    }

    /*
    * 中介、机构检查公示
    * Shihuan
    * */
    /*路由： 中介、机构检查公示 */
    @RequestMapping("/agentPunishment")
    public String agentPunishment(){
        return "information/agentPunishment";
    }
    /*路由： 中介、机构检查公示 */
    @RequestMapping("/compPunishment")
    public String compPunishment(){
        return "information/compPunishment";
    }


    /* 获取中介检查公示,前端分页 */
    @RequestMapping("/getAgentPunishmentList")
    @ResponseBody
    public List getAgentPunishmentList(String kw){
        if(kw==null || kw.trim().length()==0)
            return punishmentService.getAgentPunishment();
        else
            return punishmentMapper.findAgentPunishment(kw);
    }

    @RequestMapping("/getCompPunishmentList")
    @ResponseBody
    public List getCompPunishmentList(String kw){
        if(kw==null || kw.trim().length()==0)
            return punishmentService.getCompPunishment();
        else
            return punishmentMapper.findCompPunishment(kw);
    }

    /* 检查公示的详情页*/
    @RequestMapping("/compPunishmentDetail")
    public String getCompPunishmentDetail(String id,Model m){
        CompPunishment c = punishmentService.getCompPunishmentDetail(id);
        m.addAttribute("detail",c);
        return "information/compPunishmentDetail";
    }

    @RequestMapping("/agentPunishmentDetail")
    public String getAgentPunishmentDetail(String id,Model m){
         AgentPunishment a = punishmentService.getAgentPunishmentDetail(id);
         m.addAttribute("detail",a);
        return "information/agentPunishmentDetail";
    }

    /* 新增加检查公示 */
    @RequestMapping("/addCompPunishment")
    @ResponseBody
    public String addCompPunishment(HttpServletRequest request){
        Punishment punishment = new Punishment();
        int adminNo = 0;
        String id = request.getParameter("id");
        String compNo = request.getParameter("compNo");
        String reason = request.getParameter("reason");
        String result = request.getParameter("result");
        punishment.setAdminNo(adminNo);
        punishment.setReason(reason);
        punishment.setCompNo(Integer.parseInt(compNo));
        punishment.setResult(result);
        punishment.setCreated(new Timestamp(System.currentTimeMillis()));
        if(id!=null){
            punishment.setId(id);
            return punishmentService.updateCompPunishment(punishment);
        }else{
            punishment.setId(String.valueOf(System.currentTimeMillis()).substring(4));
            return punishmentService.addCompPunishment(punishment);
        }
    }

    @RequestMapping("/addAgentPunishment")
    @ResponseBody
    public String addAgentPunishment(HttpServletRequest request){
        int adminNo = 0;
        String id = request.getParameter("id");
        String workNo = request.getParameter("workNo");
        String reason = request.getParameter("reason");
        String result = request.getParameter("result");
        Punishment punishment = new Punishment();
        punishment.setCreated(new Date(System.currentTimeMillis()));
        punishment.setAdminNo(adminNo);
        punishment.setReason(reason);
        punishment.setWorkNo(Integer.parseInt(workNo));
        punishment.setResult(result);
        if(id!=null){
            punishment.setId(id);
            return punishmentService.updateAgentPunishment(punishment);
        }else{
            punishment.setId(String.valueOf(System.currentTimeMillis()).substring(4));
            return punishmentService.addAgentPunishment(punishment);
        }
    }

    /*删除检查公示，支持批量删除*/
    @RequestMapping("/deleteCompPunishment")
    @ResponseBody
    public String deleteCompPunishment(@RequestParam(value = "id[]") String[] id){
        String result = "";
        for(String s : id){
            try {
                punishmentService.deleteCompPunishment(s);
                result = "1";
            }catch (Exception e){
                result = "2";
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping("/deleteAgentPunishment")
    @ResponseBody
    public String deleteAgentPunishment(@RequestParam(value = "id[]") String[] id){
        String result = "";
        for(String s : id){
            try {
                punishmentService.deleteAgentPunishment(s);
                result = "1";
            }catch (Exception e){
                result = "2";
                e.printStackTrace();
            }
        }
        return result;
    }
    /*
     * 红黑名单公示
     * Shihuan
     * */
    /*路由： 红黑名单 */
    @RequestMapping("/redList")
    public String redList(){
        return "information/redList";
    }

    @RequestMapping("/blackList")
    public String blackList(){
        return "information/blackList";
    }

    /* 获取红黑名单 */
    @RequestMapping("/getRedList")
    @ResponseBody
    public List getRedList(String kw){
        if(kw==null || kw.trim().length()==0)
            return redBlackListService.getRedList();
        else
            return redListMapper.findRedList(kw);
    }

    @RequestMapping("/getBlackList")
    @ResponseBody
    public List getBlackList(String kw){
        if(kw==null || kw.trim().length()==0)
            return redBlackListService.getBlackList();
        else
            return redListMapper.findBlackList(kw);
    }

    /* 红黑名单详情页 */
    @RequestMapping("/blackDetail")
    public String blackDetail(String id,Model m){
        m.addAttribute("black",redBlackListService.getBlackDetail(id));
        return "information/blackDetail";
    }

    @RequestMapping("/redDetail")
    public String redDetail(String id,Model m){
        m.addAttribute("red",redBlackListService.getRedDetail(id));
        return "information/redDetail";
    }
    /*新增红黑名单*/
    @RequestMapping("/addRedList")
    @ResponseBody
    public String addRedList(HttpServletRequest request){
        RedList redList = new RedList();
        String id = request.getParameter("id");
        String workNo = request.getParameter("workNo");
        String reason = request.getParameter("reason");
        redList.setAdminNo(0);
        redList.setReason(reason);
        redList.setWorkNo(Integer.parseInt(workNo));
        redList.setCreated(new Date(System.currentTimeMillis()));
        if(id!=null){
            redList.setId(id);
            return redBlackListService.updateRedList(redList);
        }else{
            redList.setId(String.valueOf(System.currentTimeMillis()).substring(4));
            return redBlackListService.addRedList(redList);
        }
    }

    @RequestMapping("/addBlackList")
    @ResponseBody
    public String addBlackList(HttpServletRequest request){
        BlackList blackList = new BlackList();
        String id = request.getParameter("id");
        String workNo = request.getParameter("workNo");
        String reason = request.getParameter("reason");
        blackList.setAdminNo(0);
        blackList.setReason(reason);
        blackList.setWorkNo(Integer.parseInt(workNo));
        blackList.setCreated(new Date(System.currentTimeMillis()));
        if(id!=null){
            blackList.setId(id);
            return redBlackListService.updateBlackList(blackList);
        }else{
            blackList.setId(String.valueOf(System.currentTimeMillis()).substring(4));
            return redBlackListService.addBlackList(blackList);
        }
    }

    /*删除红黑名单*/
    @RequestMapping("/deleteBlackList")
    @ResponseBody
    public String deleteBlackList(@RequestParam(value = "id[]")String[] id){
        String result = "0";
        for(String s : id){
            try {
                redBlackListService.deleteBlackList(s);
                result = "1";
            }catch (Exception e){
                result = "2";
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping("/deleteRedList")
    @ResponseBody
    public String deleteRedList(@RequestParam(value = "id[]")String[] id){
        String result = "0";
        for(String s : id){
            try {
                redBlackListService.deleteRedList(s);
                result = "1";
            }catch (Exception e){
                result = "2";
                e.printStackTrace();
            }
        }
        return result;
    }

    /*
    * 新闻发布
    * */
    @RequestMapping("/lawNews")
    public String lawNews(){
        return "information/lawNews";
    }

    @RequestMapping("/getLawNews")
    @ResponseBody
    public List getLawNews(String kw){
        if(kw==null || kw.trim().length()==0)
            return lawService.getLawNews();
        else
            return lawMapper.findLaw(kw);
    }

    @RequestMapping("/lawDetail")
    public String getLawDetail(int id,Model m){
        m.addAttribute("law",lawService.getLawDetail(id)) ;
        return "information/lawDetail";
    }

    @RequestMapping("/addLawNews")
    @ResponseBody
    public String addLawNews(HttpServletRequest request){
        Law law = new Law();
        int lawNo = 0;
        if(request.getParameter("lawNo")!=null && request.getParameter("lawNo").trim().length()>0){
            try {
                lawNo = Integer.parseInt(request.getParameter("lawNo"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        law.setAdminNo(0);
        law.setTitle(title);
        law.setContent(content);
        law.setCreated(new Date(System.currentTimeMillis()));
        if(lawNo!=0){
            law.setLawNo(lawNo);
            return lawService.updateLaw(law);
        }else{
            return lawService.addLaw(law);
        }
    }

    /*删除政策新闻*/
    @RequestMapping("/deleteLawNews")
    @ResponseBody
    public String deleteLaw(@RequestParam(value = "lawNo[]") int[] lawNo){
        String result = "0";
        for(int s : lawNo){
            try{
                lawService.deleteLaw(s);
                result="1";
            }catch (Exception e){
                result="2";
            }
        }
        return result;
    }
    /*获取全部中介、机构*/
    @RequestMapping("/getAllAgent")
    @ResponseBody
    public List<Agent> getAllAgent(){
        return searchService.getAllAgent();
    }
    @RequestMapping("/getAllComp")
    @ResponseBody
    public List<Company> getAllComp(){
        return searchService.getAllComp();
    }

    /*用于联动搜索*/
    @RequestMapping("/searchAgent")
    @ResponseBody
    public List<Agent> searchAgent(String kw){
        return searchService.search(kw,"agent");
    }

    @RequestMapping("/searchComp")
    @ResponseBody
    public List<Company> searchComp(String kw){
        return searchService.search(kw,"comp");
    }

    /* 存储图片的工具 */
    @RequestMapping("/saveImg")
    @ResponseBody
    public String saveImg(@RequestParam("image") MultipartFile image){
        String savePath = "0";
        try {
            savePath = imgTools.saveFile(image, "images/lawNews");
        }catch (Exception e){
            e.printStackTrace();
        }
        return savePath;
    }
}

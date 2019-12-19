package hnu.houseweb.serviceImpl.agent;

import hnu.houseweb.dao.AgentMapper;
import hnu.houseweb.dao.ContractingMapper;
import hnu.houseweb.dao.UserMapper;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.agent.AgentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentMapper agentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ContractingMapper contractingMapper;
    @Override
    public boolean isCorrect(@Param("id") int id, @Param("name") String name) {
        if(agentMapper.exists(id,name)!=null){
            return true;
        }
        return false;
    }

    //我新加的
    @Override
    public Agent getAgent(int workNo) {
        Agent agent = agentMapper.selectByWorkNo(workNo);
        System.out.println(agent);
        return agent;
    }

    @Override
    public boolean changeAgentTel(int workNo, String tel) {
        return agentMapper.updateTel(workNo, tel);
    }

    @Override
    public List<User> getContractingUsers(int workNo, String contractState) {
        return contractingMapper.getContractingUsers(workNo, contractState);
    }

    @Override
    public boolean updateContractingUser(int workNo, int userId, String contractState) {
        int count = contractingMapper.updateContractingUser(workNo, userId, contractState);
        return count > 0;
    }

    @Override
    public List<AgentPart> getAgentPart(String condition) {
        if (condition==null) {
            return agentMapper.getAllAgentPart();
        } else if (condition.matches("^[0-9]*")) {  //如果是纯数字，说明是找中介编号
            //进行模糊查询前先拼接两个百分号
            return agentMapper.getAgentPartByWorkNoLike("%"+condition+"%");
        } else {
            return agentMapper.getAgentPartByNameLike("%"+condition+"%");
        }
    }

    @Override
    public List<Agent> getAll(int status) {
        return agentMapper.getAll(status);

    }

    @Override
    public AgentDetail getAgentDetail(int workNo) {
        return agentMapper.getAgentDetail(workNo);
    }

    @Override
    public boolean contractAgent(int userId, int workNo, String contractSrc) {
        return agentMapper.contractAgent(userId, workNo, contractSrc) > 0;
    }

    public boolean exists(@Param("userId") int userId){
        if(agentMapper.existsId(userId)==null){
            return false;
        }
        return true;
    }

    @Override
    public String getStatues(int userId) {
        if(!this.exists(userId)){
            return "-1";
        }
        else return  agentMapper.getStatus(userId);
    }


    @Override
    public boolean existsCard(String cardId) {
        if(agentMapper.existsCard(cardId)==null){
            return false;
        }
        return true;
    }

    @Override
    public void insert(String userId, String name, String credentialid, int compNo,String imgurl,Date date,String tel) {
        agentMapper.insert_second(userId,name,credentialid,compNo,imgurl,date,tel);
    }

    @Override
    public void update(String userId, String name, String credentialid, int compNo, String imgurl,int status,Date date,String tel) {
        agentMapper.myUpdate(userId,name,credentialid,compNo,imgurl,status,date,tel);
    }

    @Override
    public void decline(String userId,String reply) {
        agentMapper.changeStatus(2,userId,reply);
    }

    @Override
    public void pass(String userId,String reply) {
        agentMapper.changeStatus(1,userId,reply);
        userMapper.changeStatus(userId,2);
    }

    @Override
    public String sign(int id, int workNo,String name,String url) {
        if (!this.isCorrect(workNo, name)) {
            return "notfound";
        } else {
            try {
                Contracting con = contractingMapper.selectContracting(id, workNo);
                if (con == null) {
                    Date date=new Date();
                    SimpleDateFormat bj = new SimpleDateFormat("yyyy-MM-dd HH:mm");     // 北京
                    bj.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateFormat=bj.format(date);
                    System.out.println(url);
                    contractingMapper.setContracting(id, workNo,dateFormat,url);
                    return "success";
                } else {
                    return "nullError";
                }
            } catch (Exception e) {
            }
        }
        return "error";
    }
}

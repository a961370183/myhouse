package hnu.houseweb.service.agent;

import hnu.houseweb.entity.*;

import java.util.Date;
import java.util.List;

public interface AgentService {
    public boolean isCorrect(int id,String name);

    public Agent getAgent(int workNo);

    public boolean changeAgentTel(int workNo, String tel);

    public List<User> getContractingUsers(int workNo, String contractState);

    public boolean updateContractingUser(int workNo, int userId, String contractState);

    public List<AgentPart> getAgentPart(String condition);

    public AgentDetail getAgentDetail(int workNo);

    public boolean contractAgent(int userId, int workNo, String contractSrc);

    public String sign(int userid,int workNo,String name);
    public boolean exists(int userId);
    public String getStatues(int userId);
    public boolean existsCard(String cardId);
    public void insert(String userId, String name, String credentialid, int compNo, String imgurl, Date date, String tel);
    public void update(String userId, String name, String credentialid, int compNo, String imgurl, int status, Date date,String tel);

    public List<AgentDetail> getAgentDetails(String condition, Boolean sortStarLevel);

    public AgentDetail getOneAgentDetail(int workNo);
    public List<Agent> getAll(int status);
    public List<Contract> getContractBy(int workNo);
    public void decline(String userId,String reply);
    public void pass(String userId,String reply);

    public List<Agent> getAllAgents(String name);
    ////

    public  Boolean updateOneAgent(Agent agent);

    public Boolean delOneAgent(int workNo);
}

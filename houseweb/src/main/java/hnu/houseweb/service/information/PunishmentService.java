package hnu.houseweb.service.information;

import hnu.houseweb.entity.AgentPunishment;
import hnu.houseweb.entity.CompPunishment;
import hnu.houseweb.entity.Punishment;

import java.util.List;

public interface PunishmentService {
    public List<AgentPunishment> getAgentPunishment();
    public List<CompPunishment> getCompPunishment();
    public AgentPunishment getAgentPunishmentDetail(String id);
    public CompPunishment getCompPunishmentDetail(String id);
    public String addAgentPunishment(Punishment punishment);
    public String addCompPunishment(Punishment punishment);
    public String updateAgentPunishment(Punishment punishment);
    public String updateCompPunishment(Punishment punishment);
    public String deleteAgentPunishment(String id);
    public String deleteCompPunishment(String id);
}

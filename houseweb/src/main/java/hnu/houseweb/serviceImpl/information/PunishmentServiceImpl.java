package hnu.houseweb.serviceImpl.information;

import hnu.houseweb.dao.PunishmentMapper;
import hnu.houseweb.entity.AgentPunishment;
import hnu.houseweb.entity.CompPunishment;
import hnu.houseweb.entity.Punishment;
import hnu.houseweb.service.information.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunishmentServiceImpl implements PunishmentService {

    @Autowired
    PunishmentMapper punishmentMapper;

    @Override
    public List<AgentPunishment> getAgentPunishment(){
        return punishmentMapper.getAgentPunishment();
    }
    @Override
    public List<CompPunishment> getCompPunishment(){
        return punishmentMapper.getCompPunishment();
    }
    @Override
    public AgentPunishment getAgentPunishmentDetail(String id){
        return punishmentMapper.getAgentPunishmentDetail(id);
    }

    @Override
    public CompPunishment getCompPunishmentDetail(String id){
        return punishmentMapper.getCompPunishmentDetail(id);
    }

    @Override
    public String addAgentPunishment(Punishment punishment) {
        String result = "0";
        try {
            punishmentMapper.addAgentPunishment(punishment);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String addCompPunishment(Punishment punishment) {
        String result = "0";
        try {
            punishmentMapper.addCompPunishment(punishment);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateAgentPunishment(Punishment punishment) {
        String result = "0";
        try {
            punishmentMapper.updateAgentPunishment(punishment);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateCompPunishment(Punishment punishment) {
        String result = "0";
        try {
            punishmentMapper.updateCompPunishment(punishment);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteAgentPunishment(String id) {
        String result = "0";
        try {
            punishmentMapper.deleteAgentPunishment(id);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteCompPunishment(String id) {
        String result = "0";
        try {
            punishmentMapper.deleteCompPunishment(id);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

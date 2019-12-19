package hnu.houseweb.service.contracting;

import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.Contract;
import hnu.houseweb.entity.Contracting;

import java.util.List;

public interface ContractingService {
    public List<Contracting> getAllContracting(int userId);

    public List<Contract> getAllContractsBy(String name);

    public List<AgentDetail> getContractNumSortedAgentDetail();

    void comment(int contractNo, String comment,int star);

    Contracting getContracting(int contractNo);
}

package hnu.houseweb.service.contracting;

import hnu.houseweb.entity.Contracting;

import java.util.List;

public interface ContractingService {
    public List<Contracting> getAllContracting(int userId);
    

    void comment(int contractNo, String comment,int star);

    Contracting getContracting(int contractNo);
}

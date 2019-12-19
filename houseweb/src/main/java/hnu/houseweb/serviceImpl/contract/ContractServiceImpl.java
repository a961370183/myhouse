package hnu.houseweb.serviceImpl.contract;

import hnu.houseweb.dao.ContractMapper;
import hnu.houseweb.dao.ContractingMapper;
import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.Contract;
import hnu.houseweb.entity.Contracting;
import hnu.houseweb.service.contracting.ContractingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
@Service
@Transactional
public class ContractServiceImpl implements ContractingService {
    @Autowired
    ContractingMapper contractingMapper;
    @Autowired
    ContractMapper contractMapper;


    @Override
    public List<Contracting> getAllContracting(@Param("userId") int userId) {
        return contractingMapper.getAllContracting(userId);
    }

    @Override
    public List<Contract> getAllContractsBy(String name) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if (name == null) {
            List<Contract> contractList = contractMapper.getAllContracts();
            for (Contract contract: contractList) {
                contract.setFormatDateString(sdf.format(contract.getCreated()));
            }
            return contractList;
        } else {

            List<Contract> contractList = contractMapper.getContractsByNameLike("%"+name+"%");
            for (Contract contract: contractList) {
                contract.setFormatDateString(sdf.format(contract.getCreated()));
            }
            return contractList;
        }
    }

    @Override
    public List<AgentDetail> getContractNumSortedAgentDetail() {
        return contractMapper.getContractNumSortedAgentDetail();
    }

    @Override
    public void comment(int contractNo, String comment,int star) {
        System.out.println(contractNo);
        System.out.println(comment);
        contractingMapper.comment(contractNo,comment,star);
    }

    @Override
    public Contracting getContracting(int contractNo) {
        return contractingMapper.getContracting(contractNo);
    }
}

package hnu.houseweb.serviceImpl.contract;

import hnu.houseweb.dao.ContractingMapper;
import hnu.houseweb.entity.Contract;
import hnu.houseweb.entity.Contracting;
import hnu.houseweb.service.contracting.ContractingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ContractServiceImpl implements ContractingService {
    @Autowired
    ContractingMapper contractingMapper;

    @Override
    public List<Contracting> getAllContracting(@Param("userId") int userId) {
        return contractingMapper.getAllContracting(userId);
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

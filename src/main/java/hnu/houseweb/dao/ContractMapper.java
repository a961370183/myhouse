package hnu.houseweb.dao;

import hnu.houseweb.entity.Contract;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(String contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}
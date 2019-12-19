package hnu.houseweb.dao;

import hnu.houseweb.entity.Collect;
import hnu.houseweb.entity.CollectKey;
import org.springframework.stereotype.Service;

@Service
public interface CollectMapper {
    int deleteByPrimaryKey(CollectKey key);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(CollectKey key);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    int collectNumOfHouse(int houseNo);
}
package hnu.houseweb.serviceImpl.house;

import hnu.houseweb.dao.CollectMapper;
import hnu.houseweb.entity.Collect;
import hnu.houseweb.entity.CollectKey;
import hnu.houseweb.service.house.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;


    @Override
    public void insertCollect(Collect collect) {
        collectMapper.insertSelective(collect);
    }

    @Override
    public void deleteCollect(Collect collect) {
        CollectKey collectKey = new CollectKey();
        collectKey.setHouseNo(collect.getHouseNo());
        collectKey.setUserId(collect.getUserId());
        collectMapper.deleteByPrimaryKey(collectKey);
    }

    public Collect getCollect(CollectKey ck){
        return collectMapper.selectByPrimaryKey(ck);
    }

    @Override
    public int getCollectNumOfHouse(int houseNo){
        return collectMapper.collectNumOfHouse(houseNo);
    }
}

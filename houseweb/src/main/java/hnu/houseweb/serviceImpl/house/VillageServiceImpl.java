package hnu.houseweb.serviceImpl.house;

import hnu.houseweb.dao.VillageMapper;
import hnu.houseweb.entity.Village;
import hnu.houseweb.service.house.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageServiceImpl implements VillageService {

    @Autowired
    VillageMapper villageMapper;

    @Override
    public List<Village> search(String kw) {
        return villageMapper.search(kw);
    }

}

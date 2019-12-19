package hnu.houseweb.service.house;

import hnu.houseweb.entity.Village;

import java.util.List;

public interface VillageService {
    public List<Village> search(String kw);
}

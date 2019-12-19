package hnu.houseweb.service.house;

import hnu.houseweb.entity.HousePart;

import java.util.List;
import java.util.Map;

public interface HouseSearchService {
    public List getRegionCount();
    public List<HousePart> listFind(String url);
    public Map mapFind(String url);
}

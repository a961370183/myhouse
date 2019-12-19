package hnu.houseweb;

import hnu.houseweb.dao.CollectMapper;
import hnu.houseweb.dao.HouseDetailMapper;
import hnu.houseweb.dao.VillageMapper;
import hnu.houseweb.entity.Area;
import hnu.houseweb.entity.HousePart;
import hnu.houseweb.entity.Village;
import hnu.houseweb.service.house.HouseSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HousewebApplicationTests {


    @Autowired
    HouseDetailMapper housedetailMapper;

    @Autowired
    HouseSearchService houseSearchImpl;

    @Autowired
    CollectMapper collectMapper;

    @Autowired
    VillageMapper villageMapper;

    @Test
    void contextLoads() {
//        List<Village> villages = villageMapper.getAll();
//        for(Village v : villages){
//            GPS gps = GGG.bd09_To_Gcj02(Double.parseDouble(v.getLatitude()),Double.parseDouble(v.getLongitude()));
//            villageMapper.updateV(String.valueOf(gps.getLat()),String.valueOf(gps.getLon()),v.getId());
//        }
        List<Area> areas = villageMapper.areaAll();
        GPS gps = null;
        String la = "";
        String lg = "";
        String[] ll;
        StringBuilder stringBuilder = new StringBuilder();
        for(Area area : areas){
            gps = GGG.bd09_To_Gcj02(Double.parseDouble(area.getLatitude()),Double.parseDouble(area.getLongitude()));
            area.setLatitude(String.valueOf(gps.getLat()));
            area.setLongitude(String.valueOf(gps.getLon()));
            for(String s : area.getBorder().split(";")){
                ll = s.split(",");
                gps = GGG.bd09_To_Gcj02(Double.parseDouble(ll[1]),Double.parseDouble(ll[0]));
                stringBuilder.append(gps.getLon());
                stringBuilder.append(',');
                stringBuilder.append(gps.getLat());
                stringBuilder.append(';');
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            area.setBorder(stringBuilder.toString());
            System.out.println(area);
            stringBuilder.setLength(0);
        }
    }
}

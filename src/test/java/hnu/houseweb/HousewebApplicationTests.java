package hnu.houseweb;

import hnu.houseweb.dao.CollectMapper;
import hnu.houseweb.dao.HouseDetailMapper;
import hnu.houseweb.entity.HousePart;
import hnu.houseweb.service.house.HouseSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HousewebApplicationTests {


    @Autowired
    HouseDetailMapper housedetailMapper;

    @Autowired
    HouseSearchService houseSearchImpl;

    @Autowired
    CollectMapper collectMapper;

    @Test
    void contextLoads() {
    }

}

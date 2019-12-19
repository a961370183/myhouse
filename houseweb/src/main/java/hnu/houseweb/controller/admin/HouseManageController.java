package hnu.houseweb.controller.admin;

import hnu.houseweb.entity.HouseDetail;
import hnu.houseweb.entity.HousePart;
import hnu.houseweb.service.house.HouseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController //声明Rest风格的控制器
@RequestMapping("/housemanage")
public class HouseManageController {
    @Autowired
    HouseDetailService houseDetailService;

    /* 查询房子 */
    @RequestMapping("/find")
    public HouseDetail findByHouseNo(int houseNo){
        HouseDetail houseDetail=null;
        if (houseDetailService.getUserHouse(houseNo)!=null) {
            houseDetail=houseDetailService.getUserHouse(houseNo);
            houseDetail.setRole(1);
        }
        else if (houseDetailService.getAgentHouse(houseNo)!=null) {
            houseDetail=houseDetailService.getAgentHouse(houseNo);
            houseDetail.setRole(0);
        }
        return houseDetail;
    }

    @RequestMapping("/userhouse")
    public List<HousePart> findByUserID(int userId){
        return houseDetailService.getHouseByUserId(userId);
    }

    @RequestMapping("/agenthouse")
    public List<HousePart> findByAgentID(int workNo){
        return houseDetailService.getHouseByWorkNo(workNo);
    }

    @RequestMapping("/delhouse")
    public  int deletehouse(int houseNo,Integer role){
        int keeperNo=houseDetailService.getKeeperId(houseNo);
        if (role == 1) {
            houseDetailService.deleteUserHouseByHouseNo(houseNo,keeperNo);
        } else {
            houseDetailService.deleteAgentHouseByHouseNo(houseNo,keeperNo);
        }
        return 1;
    }

    @RequestMapping("/getUnchecked")
    public  List<Map> getUnchecked(){return houseDetailService.getUnCheckedHouse();}

    @RequestMapping("/checkHouse")
    public  int checkHouse(int houseNo,String comment,int status){
        return houseDetailService.updateHouseCheck(houseNo,comment,status);
    }
}

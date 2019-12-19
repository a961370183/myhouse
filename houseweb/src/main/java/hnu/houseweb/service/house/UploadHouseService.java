package hnu.houseweb.service.house;

import hnu.houseweb.entity.House;
import hnu.houseweb.entity.HouseDetail;
import hnu.houseweb.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UploadHouseService {
    /* 检查房产证号是否已存在 */
    public boolean checkHouseNo(int userId, String propertyNo);

//    /* 录入一个房源详情记录 */
//    public boolean uploadHouseDetail(HouseDetail houseDetail);

    public boolean uploadHouse(User user, House house);

    public String uploadHouseDetail(MultipartFile[] insideUrl,
                               MultipartFile[] outsideUrl,
                               MultipartFile[] envUrl,
                               MultipartFile coverUrl,
                               MultipartFile video,
                               int houseNo,User user,
                               HttpServletRequest request);

}

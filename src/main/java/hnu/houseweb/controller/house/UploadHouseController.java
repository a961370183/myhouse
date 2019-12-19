package hnu.houseweb.controller.house;

import com.alibaba.fastjson.JSONObject;
import hnu.houseweb.dao.HangoutMapper;
import hnu.houseweb.dao.HouseDetailMapper;
import hnu.houseweb.dao.HouseMapper;
import hnu.houseweb.entity.Hangout;
import hnu.houseweb.entity.House;
import hnu.houseweb.entity.HouseDetail;
import hnu.houseweb.entity.User;
import hnu.houseweb.service.house.UploadHouseService;
import hnu.houseweb.service.house.UploadHouseService;
import hnu.houseweb.service.tools.ImgTools;
import hnu.houseweb.service.user.IUserService;
import hnu.houseweb.serviceImpl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/uploadHouse")
public class UploadHouseController {

    @Autowired
    private UploadHouseService uploadHouseService;

    @Autowired
    ImgTools imgTools;

    @Autowired
    HouseDetailMapper houseDetailMapper;

    @Autowired
    HangoutMapper hangoutMapper;

    @Autowired
    UploadHouseService uploadHouseServiceImpl;

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    UserServiceImpl userService;
    /* 检查房产证号是否存在, 不允许同一房源挂牌多次 */
    @RequestMapping("/checkHousePropertyNo")
    @ResponseBody
    public String checkHouseNo(int userId, String propertyNo) {
        if (uploadHouseService.checkHouseNo(userId, propertyNo)) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/checkHouseProperty")
    public String checkHouseProperty(Model mv, String propertyNo,HttpServletResponse response) {
        User user =  userService.userInfo();
        int userId = 0;
        if(user!=null){
            userId = user.getUserId();      //二次确认用户登录状态
        }else {
            mv.addAttribute("error", "请先登录");
            return "house/propertyPage";
        }

        mv.addAttribute("userInfo",user);

        /*若房源在此平台还未存在, 则允许挂牌*/
        try {
            if (!uploadHouseService.checkHouseNo(userId, propertyNo)) {
                /* 模拟出唯一的房源编号,根据时间戳 */
                int houseNo = Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000));
                House house = new House();
                house.setHouseNo(houseNo);
                house.setPropertyNo(propertyNo);
                uploadHouseServiceImpl.uploadHouse(user,house);
                try {
                    response.sendRedirect("/houseUpload/" + houseNo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                mv.addAttribute("error", "产权证号存在");
                return "house/propertyPage";
            }
        }catch (Exception e){
            mv.addAttribute("error", "产权证号存在或者未知错误");
            return "house/propertyPage";
        }
        return "house/propertyPage";
    }

    /*操作:  上传房源详情操作 */
    @RequestMapping(value = "/uploadHouseDetail",method = RequestMethod.POST)
    @ResponseBody
    public String uploadHouseDetail(@RequestParam("insideUrl") MultipartFile[] insideUrl,
                                    @RequestParam("outsideUrl") MultipartFile[] outsideUrl,
                                    @RequestParam("envUrl") MultipartFile[] envUrl,
                                    @RequestParam(value = "coverUrl",required = false) MultipartFile coverUrl,
                                    @RequestParam(value = "video",required = false) MultipartFile video,
                                    @RequestParam(value = "houseNo",required = false) int houseNo,
                                    HttpServletRequest request,HttpServletResponse response) {
        String result = "0";
        try {
            User user =  userService.userInfo();
            if(user!=null){             //二次确认用户登录状态, 未登录则强行跳转回浏览页面
                result = uploadHouseServiceImpl.uploadHouseDetail(insideUrl,outsideUrl,envUrl,coverUrl,video,houseNo,user,request);
            }else {
                response.sendRedirect("/house/");
            }
        }catch (Exception e){
            e.printStackTrace();
        }return result;
    }
}

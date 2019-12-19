package hnu.houseweb.controller.tools;

import com.alibaba.fastjson.JSONObject;
import hnu.houseweb.entity.User;
import hnu.houseweb.service.tools.ImgTools;
import hnu.houseweb.serviceImpl.user.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImageTools {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    ImgTools imgTools;

    @RequestMapping("/imgTools/delete/*")
    @ResponseBody
    public String deleteFile(String key){
        String result = "0";
        if(key!=null) {
            try {
                if(imgTools.deleteFile(key).equals("1")) {
                    result = "1";
                    System.out.println("删除文件");
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        return result;
    }
}

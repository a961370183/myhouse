package hnu.houseweb.serviceImpl.information;

import hnu.houseweb.dao.BlackListMapper;
import hnu.houseweb.dao.RedListMapper;
import hnu.houseweb.entity.BlackList;
import hnu.houseweb.entity.RedList;
import hnu.houseweb.service.information.RedBlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedBlackListServiceImpl implements RedBlackListService {
    @Autowired
    RedListMapper redListMapper;
    @Autowired
    BlackListMapper blackListMapper;

    public List<RedList> getRedList(){
        return redListMapper.getRedList();
    }

    public List<BlackList> getBlackList(){
        return redListMapper.getBlackList();
    }
    public RedList getRedDetail(String id){
        return redListMapper.getRedDetail(id);
    }

    public BlackList getBlackDetail(String id){
        return redListMapper.getBlackDetail(id);
    }

    @Override
    public String addBlackList(BlackList blackList) {
        String result = "0";
        try {
            blackListMapper.insertSelective(blackList);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String addRedList(RedList redList) {
        String result = "0";
        try {
            redListMapper.insertSelective(redList);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteBlackList(String id) {
        String result = "0";
        try {
            blackListMapper.deleteByPrimaryKey(id);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteRedList(String id) {
        String result = "0";
        try {
            redListMapper.deleteByPrimaryKey(id);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateBlackList(BlackList blackList) {
        String result = "0";
        try {
            blackListMapper.updateByPrimaryKeySelective(blackList);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateRedList(RedList redList) {
        String result = "0";
        try {
            redListMapper.updateByPrimaryKeySelective(redList);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

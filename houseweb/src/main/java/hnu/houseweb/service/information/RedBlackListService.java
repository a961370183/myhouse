package hnu.houseweb.service.information;

import hnu.houseweb.entity.BlackList;
import hnu.houseweb.entity.RedList;

import java.util.List;

public interface RedBlackListService {
    public List<RedList> getRedList();
    public List<BlackList> getBlackList();
    public RedList getRedDetail(String id);
    public BlackList getBlackDetail(String id);
    public String addBlackList(BlackList blackList);
    public String addRedList(RedList redList);
    public String deleteBlackList(String id);
    public String deleteRedList(String id);
    public String updateBlackList(BlackList blackList);
    public String updateRedList(RedList redList);
}

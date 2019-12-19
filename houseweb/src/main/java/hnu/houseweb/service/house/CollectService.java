package hnu.houseweb.service.house;

import hnu.houseweb.entity.Collect;
import hnu.houseweb.entity.CollectKey;

public interface CollectService {
    /* 插入一条收藏记录 */
    public void insertCollect(Collect collect);
    /* 删除一条收藏记录 */
    public void deleteCollect(Collect collect);
    /* 查找收藏记录是否存在 */
    public Collect getCollect(CollectKey ck);

    public int getCollectNumOfHouse(int houseNo);
}

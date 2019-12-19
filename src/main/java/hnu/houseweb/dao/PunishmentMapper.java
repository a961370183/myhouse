package hnu.houseweb.dao;

import hnu.houseweb.entity.Punishment;
import hnu.houseweb.entity.PunishmentKey;

public interface PunishmentMapper {
    int deleteByPrimaryKey(PunishmentKey key);

    int insert(Punishment record);

    int insertSelective(Punishment record);

    Punishment selectByPrimaryKey(PunishmentKey key);

    int updateByPrimaryKeySelective(Punishment record);

    int updateByPrimaryKey(Punishment record);
}
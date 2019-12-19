package hnu.houseweb.dao;

import hnu.houseweb.entity.Community;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityMapper {

    @Select("select * from village where id = #{id,jdbcType=VARCHAR}")
    Community getCommunityById(String id);

}

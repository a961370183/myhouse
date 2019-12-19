package hnu.houseweb.dao;

import hnu.houseweb.entity.Company;
import hnu.houseweb.entity.CompanyPart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    int deleteByPrimaryKey(String compno);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String compno);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<CompanyPart> getTenCompany();
}
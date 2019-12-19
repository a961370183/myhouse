package hnu.houseweb.service.company;

import hnu.houseweb.entity.Company;
import hnu.houseweb.entity.CompanyPart;

import java.util.List;

public interface CompanyService{
    /* 获取一些机构，用于房源检索界面的按机构检索 */
    public List<CompanyPart> getSomeComps();
}

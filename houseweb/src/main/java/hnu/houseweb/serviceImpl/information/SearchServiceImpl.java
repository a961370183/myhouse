package hnu.houseweb.serviceImpl.information;

import hnu.houseweb.dao.InformationMapper;
import hnu.houseweb.service.information.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private InformationMapper informationMapper;

    public List search(String kw, String type){
        List list = null;
        int no;
        if("agent".equalsIgnoreCase(type)){
            try{
                no = Integer.parseInt(kw);
                list = informationMapper.searchAgentByWorkNo(no);
            }catch (Exception e){
                e.printStackTrace();
                list = informationMapper.searchAgentByName(kw);
            }
        }else if("comp".equalsIgnoreCase(type)){
            try{
                no = Integer.parseInt(kw);
                list = informationMapper.searchCompByCompNo(no);
            }catch (Exception e){
                list = informationMapper.searchCompByCompName(kw);
            }
        }
        return list;
    }

    public List getAllAgent(){
        return informationMapper.getAllAgent();
    }
    public List getAllComp(){
        return informationMapper.getAllComp();
    }
}

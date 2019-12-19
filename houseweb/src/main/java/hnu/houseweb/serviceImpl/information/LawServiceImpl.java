package hnu.houseweb.serviceImpl.information;

import hnu.houseweb.dao.LawMapper;
import hnu.houseweb.entity.Law;
import hnu.houseweb.service.information.LawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawServiceImpl implements LawService {

    @Autowired
    private LawMapper lawMapper;

    @Override
    public List<Law> getLawNews() {
        return lawMapper.getLawNews();
    }

    @Override
    public Law getLawDetail(int id) {
        return lawMapper.getLawDetail(id);
    }

    @Override
    public String addLaw(Law law) {
        String result = "0";
        try {
            lawMapper.insertSelective(law);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateLaw(Law law) {
        String result = "0";
        try {
            lawMapper.updateByPrimaryKeyWithBLOBs(law);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteLaw(int lawNo) {
        String result = "0";
        try {
            lawMapper.deleteByPrimaryKey(lawNo);
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

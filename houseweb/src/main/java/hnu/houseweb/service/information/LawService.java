package hnu.houseweb.service.information;

import hnu.houseweb.entity.Law;

import java.util.List;

public interface LawService {
    public List<Law> getLawNews();
    public Law getLawDetail(int id);
    public String addLaw(Law law);
    public String updateLaw(Law law);
    public String deleteLaw(int lawNo);
}

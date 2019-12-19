package hnu.houseweb.service.information;

import java.util.List;

public interface SearchService {
    public List search(String kw,String type);
    public List getAllAgent();
    public List getAllComp();
}

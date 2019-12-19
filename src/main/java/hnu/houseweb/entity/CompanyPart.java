package hnu.houseweb.entity;

public class CompanyPart {
    private Integer compNo;

    private String compName;

    public Integer getCompNo() {
        return compNo;
    }

    public void setCompNo(Integer compNo) {
        this.compNo = compNo;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    @Override
    public String toString() {
        return "CompanyPart{" +
                "compNo=" + compNo +
                ", compName='" + compName + '\'' +
                '}';
    }
}

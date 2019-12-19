package hnu.houseweb.entity;

import java.math.BigDecimal;

public class CompanyPart {
    private Integer compNo;

    private String compName;

    private BigDecimal starLevel;

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

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    @Override
    public String toString() {
        return "CompanyPart{" +
                "compNo=" + compNo +
                ", compName='" + compName + '\'' +
                '}';
    }
}

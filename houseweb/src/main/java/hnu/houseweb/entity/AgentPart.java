package hnu.houseweb.entity;

import java.math.BigDecimal;

public class AgentPart {
    private Integer workNo;

    private String name;

    private String compName;

    private BigDecimal starLevel;

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "AgentPart{" +
                "workNo=" + workNo +
                ", name='" + name + '\'' +
                ", compName='" + compName + '\'' +
                ", starLevel=" + starLevel +
                '}';
    }
}

package hnu.houseweb.entity;

import java.math.BigDecimal;

public class AgentHouseDetail extends HouseDetail {
    String compNo;
    String compName;
    BigDecimal starLevel;
    String imgSrc;
    String businessScope;

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }


    @Override
    public String toString() {
        return "AgentHouseDetail{" +
                "compNo='" + compNo + '\'' +
                ", compName='" + compName + '\'' +
                ", starLevel=" + starLevel +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}

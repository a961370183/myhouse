package hnu.houseweb.entity;

import java.math.BigDecimal;

public class AgentDetail {
    private Integer workNo;

    private String compName;

    private String name;

    private BigDecimal starLevel;

    private String tel;

    private Integer workYear;

    private String imgSrc;

    private Integer contractNum;

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Integer getContractNum() {
        return contractNum;
    }

    public void setContractNum(Integer contractNum) {
        this.contractNum = contractNum;
    }

    @Override
    public String toString() {
        return "AgentDetail{" +
                "workNo=" + workNo +
                ", compName=" + compName +
                ", name='" + name + '\'' +
                ", starLevel=" + starLevel +
                ", tel='" + tel + '\'' +
                ", workYear=" + workYear +
                ", imgSrc='" + imgSrc + '\'' +
                ", contractNum=" + contractNum +
                '}';
    }
}

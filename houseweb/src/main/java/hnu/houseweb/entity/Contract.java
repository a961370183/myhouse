package hnu.houseweb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Contract {
    private Integer contractNo;

    private Integer userId;

    private Integer workNo;

    private String name;

    private Date created;

    private String formatDateString;

    private String contractSrc;

    private String description;

    private BigDecimal starLevel;

    public Integer getContractNo() {
        return contractNo;
    }

    public void setContractNo(Integer contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getContractSrc() {
        return contractSrc;
    }

    public void setContractSrc(String contractSrc) {
        this.contractSrc = contractSrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    public String getFormatDateString() {
        return formatDateString;
    }

    public void setFormatDateString(String formateDateString) {
        this.formatDateString = formateDateString;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNo=" + contractNo +
                ", userId=" + userId +
                ", workNo=" + workNo +
                ", created=" + created +
                ", contractSrc='" + contractSrc + '\'' +
                '}';
    }
}
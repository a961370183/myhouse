package hnu.houseweb.entity;

import java.util.Date;

public class Contract {
    private Integer contractNo;

    private Integer userId;

    private Integer workNo;

    private Date created;

    private String contractSrc;

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
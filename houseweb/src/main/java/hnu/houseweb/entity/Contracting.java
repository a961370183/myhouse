package hnu.houseweb.entity;

import java.util.Date;

public class Contracting {
    private Integer contractNo;

    private Integer userId;

    private Integer workNo;

    private Date created;

    private String contractState;

    private String contractSrc;

    private String description;

    private String name;

    private int startLevel;

    public int getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getContractState() {
        return contractState;
    }

    public void setContractState(String contractState) {
        this.contractState = contractState;
    }

    public String getContractSrc() {
        return contractSrc;
    }

    public void setContractSrc(String contractSrc) {
        this.contractSrc = contractSrc;
    }

    @Override
    public String toString() {
        return "Contracting{" +
                "contractNo=" + contractNo +
                ", userId=" + userId +
                ", workNo=" + workNo +
                ", contractState='" + contractState + '\'' +
                ", contractSrc='" + contractSrc + '\'' +
                '}';
    }
}

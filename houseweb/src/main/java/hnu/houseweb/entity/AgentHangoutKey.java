package hnu.houseweb.entity;

public class AgentHangoutKey {
    private Integer workNo;

    private Integer houseNo;

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return "AgentHangoutKey{" +
                "workNo=" + workNo +
                ", houseNo=" + houseNo +
                '}';
    }
}
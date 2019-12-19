package hnu.houseweb.entity;

public class House {
    private Integer houseNo;

    private String propertyNo;

    private String status;

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseNo=" + houseNo +
                ", propertyNo='" + propertyNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
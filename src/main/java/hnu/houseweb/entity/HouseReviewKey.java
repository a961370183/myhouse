package hnu.houseweb.entity;

public class HouseReviewKey {
    private Integer adminNo;

    private Integer houseNo;

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return "HouseReviewKey{" +
                "adminNo=" + adminNo +
                ", houseNo=" + houseNo +
                '}';
    }
}
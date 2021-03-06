package hnu.houseweb.entity;

public class CollectKey {
    private Integer userId;

    private Integer houseNo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return "CollectKey{" +
                "userId=" + userId +
                ", houseNo=" + houseNo +
                '}';
    }
}
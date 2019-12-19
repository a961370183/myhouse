package hnu.houseweb.entity;

public class BlackListKey {
    private Integer adminNo;

    private Integer workNo;

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    @Override
    public String toString() {
        return "BlackListKey{" +
                "adminNo=" + adminNo +
                ", workNo=" + workNo +
                '}';
    }
}
package hnu.houseweb.entity;

public class AgentReviewKey {
    private Integer adminNo;

    private Integer workNo;

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    @Override
    public String toString() {
        return "AgentReviewKey{" +
                "adminNo=" + adminNo +
                ", workNo=" + workNo +
                '}';
    }
}
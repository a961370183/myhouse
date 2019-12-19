package hnu.houseweb.entity;

public class ServiceEvaluationKey {
    private Integer workNo;

    private Integer userId;

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ServiceEvaluationKey{" +
                "workNo=" + workNo +
                ", userId=" + userId +
                '}';
    }
}
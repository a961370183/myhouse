package hnu.houseweb.entity;

public class PunishmentKey {
    private Integer adminNo;

    private Integer workNo;

    private Integer compNo;

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
        return "PunishmentKey{" +
                "adminNo=" + adminNo +
                ", workNo=" + workNo +
                '}';
    }
}
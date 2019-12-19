package hnu.houseweb.entity;

public class ContractReviewKey {
    private Integer adminNo;

    private Integer contractNo;

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public Integer getContractNo() {
        return contractNo;
    }

    public void setContractNo(Integer contractNo) {
        this.contractNo = contractNo;
    }

    @Override
    public String toString() {
        return "ContractReviewKey{" +
                "adminNo=" + adminNo +
                ", contractNo=" + contractNo +
                '}';
    }
}
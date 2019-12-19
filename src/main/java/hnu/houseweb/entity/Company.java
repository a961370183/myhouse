package hnu.houseweb.entity;

import java.math.BigDecimal;

public class Company {
    private Integer compNo;

    private String compName;

    private String qualifyNo;

    private String address;

    private String licenseNo;

    private Integer storesNum;

    private Integer registFund;

    private BigDecimal starLevel;

    private String legalRepresentor;

    private Integer employeeNum;

    private String tel;

    private String businessScope;

    public Integer getCompNo() {
        return compNo;
    }

    public void setCompNo(Integer compNo) {
        this.compNo = compNo;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getQualifyNo() {
        return qualifyNo;
    }

    public void setQualifyNo(String qualifyNo) {
        this.qualifyNo = qualifyNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Integer getStoresNum() {
        return storesNum;
    }

    public void setStoresNum(Integer storesNum) {
        this.storesNum = storesNum;
    }

    public Integer getRegistFund() {
        return registFund;
    }

    public void setRegistFund(Integer registFund) {
        this.registFund = registFund;
    }

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    public String getLegalRepresentor() {
        return legalRepresentor;
    }

    public void setLegalRepresentor(String legalRepresentor) {
        this.legalRepresentor = legalRepresentor;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    @Override
    public String toString() {
        return "Company{" +
                "compNo=" + compNo +
                ", compName='" + compName + '\'' +
                ", qualifyNo='" + qualifyNo + '\'' +
                ", address='" + address + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", storesNum=" + storesNum +
                ", registFund=" + registFund +
                ", starLevel=" + starLevel +
                ", legalRepresentor='" + legalRepresentor + '\'' +
                ", employeeNum=" + employeeNum +
                ", tel='" + tel + '\'' +
                ", businessScope='" + businessScope + '\'' +
                '}';
    }
}
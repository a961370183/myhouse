package hnu.houseweb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Agent {
    private Integer workNo;

    private Integer compNo;

    private String name;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    private String imgurl;

    public String getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(String credentialid) {
        this.credentialid = credentialid;
    }

    private String credentialid;


    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    private String compname;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    private Date created;

    private BigDecimal starLevel;

    private String password;

    private String tel;

    private Integer workYear;

    private String status;

    private String imgSrc;

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    public Integer getCompNo() {
        return compNo;
    }

    public void setCompNo(Integer compNo) {
        this.compNo = compNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "workNo=" + workNo +
                ", compNo=" + compNo +
                ", name='" + name + '\'' +
                ", starLevel=" + starLevel +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", workYear=" + workYear +
                ", status='" + status + '\'' +
                '}';
    }
}
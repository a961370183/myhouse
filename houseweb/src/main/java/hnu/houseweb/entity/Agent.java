package hnu.houseweb.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Agent {
    private Integer workNo;

    private Integer compNo;

    private String name;

    private BigDecimal starLevel;

    private String password;

    private String tel;

    private Integer workYear;

    private String status;

    private String imgSrc;
    private String imgUrl;

    private String compName;

    private String credentialid;

    private Date created;

    private  String reply;

    private String email;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(String credentialid) {
        this.credentialid = credentialid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

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
                ", imgSrc='" + imgSrc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", compName='" + compName + '\'' +
                ", credentialid='" + credentialid + '\'' +
                ", created=" + created +
                ", reply='" + reply + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
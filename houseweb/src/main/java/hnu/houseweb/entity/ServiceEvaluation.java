package hnu.houseweb.entity;

import java.util.Date;

public class ServiceEvaluation extends ServiceEvaluationKey {
    private Integer starLevel;

    private String signNo;

    private String description;

    private Date created;

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ServiceEvaluation{" +
                "starLevel=" + starLevel +
                ", signNo='" + signNo + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                '}';
    }
}
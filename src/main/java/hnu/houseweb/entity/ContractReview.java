package hnu.houseweb.entity;

import java.util.Date;

public class ContractReview extends ContractReviewKey {
    private Date created;

    private String result;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        return "ContractReview{" +
                "created=" + created +
                ", result='" + result + '\'' +
                '}';
    }
}
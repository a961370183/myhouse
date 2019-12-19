package hnu.houseweb.entity;

import java.util.Date;

public class HouseReview extends HouseReviewKey {
    private Date created;

    private String result;

    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    @Override
    public String toString() {
        return "HouseReview{" +
                "created=" + created +
                ", result='" + result + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
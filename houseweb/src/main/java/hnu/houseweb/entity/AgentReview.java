package hnu.houseweb.entity;

import java.util.Date;

public class AgentReview extends AgentReviewKey {
    private Date created;

    private String result;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "AgentReview{" +
                "created=" + created +
                ", result='" + result + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
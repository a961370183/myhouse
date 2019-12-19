package hnu.houseweb.entity;

import java.util.Date;

public class RedList extends RedListKey {
    private String reason;

    private Date created;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "RedList{" +
                "reason='" + reason + '\'' +
                ", created=" + created +
                '}';
    }
}
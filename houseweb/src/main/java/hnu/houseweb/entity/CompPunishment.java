package hnu.houseweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CompPunishment extends Company{
    private String reason;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;

    private String id;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "CompPunishment{" +
                "reason='" + reason + '\'' +
                ", created=" + created +
                '}';
    }
}

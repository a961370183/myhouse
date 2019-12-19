package hnu.houseweb.entity;

import java.util.Date;

public class Punishment extends PunishmentKey {
    private String reason;

    private Date created;

    private String id;

    private int compNo;

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCompNo() {
        return compNo;
    }

    public void setCompNo(int compNo) {
        this.compNo = compNo;
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
        return "Punishment{" +
                "reason='" + reason + '\'' +
                ", created=" + created +
                '}';
    }
}
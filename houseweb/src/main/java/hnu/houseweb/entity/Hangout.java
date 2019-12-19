package hnu.houseweb.entity;

import java.util.Date;

public class Hangout extends HangoutKey {
    private Date created;

    private Integer period;

    private Integer clientId;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Hangout{" +
                "created=" + created +
                ", period=" + period +
                ", clientId=" + clientId +
                '}';
    }
}
package hnu.houseweb.entity;

import java.util.Date;

public class AgentHangout extends AgentHangoutKey {
    private Integer clientId;

    private Date created;

    private Integer period;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

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

    @Override
    public String toString() {
        return "AgentHangout{" +
                "clientId=" + clientId +
                ", created=" + created +
                ", period=" + period +
                '}';
    }
}
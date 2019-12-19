package hnu.houseweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AgentPunishment extends Agent {
    private String reason;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;

    private String compName;
    private String legalRepresentor;
    private String address;
    private String id;
    private String result;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getLegalRepresentor() {
        return legalRepresentor;
    }

    public void setLegalRepresentor(String legalRepresentor) {
        this.legalRepresentor = legalRepresentor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "AgentPunishment{" +
                "reason='" + reason + '\'' +
                ", created=" + created +
                '}';
    }
}

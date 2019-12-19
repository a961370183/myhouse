package hnu.houseweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RedList extends RedListKey {
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;
    private String name;
    private String imgSrc;
    private String id;
    String compName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
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
        return "RedList{" +
                "reason='" + reason + '\'' +
                ", created=" + created +
                ", name='" + name + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", id='" + id + '\'' +
                ", compName='" + compName + '\'' +
                '}';
    }
}
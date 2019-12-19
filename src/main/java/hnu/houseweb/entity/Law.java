package hnu.houseweb.entity;

import java.util.Date;

public class Law {
    private Integer lawNo;

    private Integer adminNo;

    private Date created;

    private String title;

    private String content;

    public Integer getLawNo() {
        return lawNo;
    }

    public void setLawNo(Integer lawNo) {
        this.lawNo = lawNo;
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Law{" +
                "lawNo=" + lawNo +
                ", adminNo=" + adminNo +
                ", created=" + created +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
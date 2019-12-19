package hnu.houseweb.entity;

import java.util.Date;

public class Collect extends CollectKey {
    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "created=" + created +
                '}';
    }
}
package hnu.houseweb.entity;

public class Admin {
    private Integer adminNo;

    private String name;

    private String password;


    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminNo=" + adminNo +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
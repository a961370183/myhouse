package hnu.houseweb.entity;

public class Community {
    String id;
    String name;
    String address;
    String latitude;
    String longitude;
    String zone;
    String year;
    String build_type;
    String property_costs;
    String property_company;
    String developers;
    String region;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBuild_type() {
        return build_type;
    }

    public void setBuild_type(String build_type) {
        this.build_type = build_type;
    }

    public String getProperty_costs() {
        return property_costs;
    }

    public void setProperty_costs(String property_costs) {
        this.property_costs = property_costs;
    }

    public String getProperty_company() {
        return property_company;
    }

    public void setProperty_company(String property_company) {
        this.property_company = property_company;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Override
    public String toString() {
        return "Community{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", zone='" + zone + '\'' +
                ", year='" + year + '\'' +
                ", build_type='" + build_type + '\'' +
                ", property_costs='" + property_costs + '\'' +
                ", property_company='" + property_company + '\'' +
                ", developers='" + developers + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}

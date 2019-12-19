package hnu.houseweb.entity;

public class RegionHouseCount {
    String region;
    int count;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RegionHouseCount{" +
                "region='" + region + '\'' +
                ", count=" + count +
                '}';
    }
}

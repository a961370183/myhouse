package hnu.houseweb.entity;

public class HouseCount {
    private  String region;
    private  int count;
    private  String communityNo;

    public String getCommunityNo() {
        return communityNo;
    }

    public void setCommunityNo(String communityNo) {
        this.communityNo = communityNo;
    }

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
        return "HouseCount{" +
                "region='" + region + '\'' +
                ", count=" + count +
                '}';
    }
}

package hnu.houseweb.entity;

import java.math.BigDecimal;
import java.sql.Date;

/* 拼接Agent、AgentHangout、House、HouseDetail*/
public class AgentHouse extends HouseDetail{
    /*Agent*/
    private Integer workNo;
    private Integer compNo;
    private String name;
    private BigDecimal starLevel;
    private String tel;
    private Integer workYear;
    private int role;
    private int evaluateCount;
    /*House*/
    private Integer houseNo;
    private String status;

    /*HouseDetail*/
    private String title;
    private BigDecimal size;
    private String tag;
    private String lookTime;
    private String description;
    private BigDecimal price;
    private Integer roomNum;
    private Integer hallNum;
    private String faceAt;
    private String decoration;
    private String elevator;
    private String frozenInfo;
    private String coverUrl;
    private String envUrl;
    private String outsideUrl;
    private String insideUrl;
    private String videoUrl;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String sellReason;
    private String region;
    private String floor;
    private Integer maxFloor;
    private String yongTu;
    private String ownStatus;
    private String diyaInfo;
    private String houseInfo;
    private String keyPoint;
    private String structure;
    private String community;
    private String communityNo;
    private String address;
    private String buildYear;
    private Integer toiletNum;
    private Integer kitchenNum;

    /*Hangout*/
    private Date created;
    private Integer period;
    private Integer clientId;

    /*Company*/
    private String compName;
    private String qualifyNo;
    private String licenseNo;
    private String businessScope;

    public AgentHouse(){
        role = 2;         //默认2为中介
    }


    public int getEvaluateCount() {
        return evaluateCount;
    }

    public void setEvaluateCount(int evaluateCount) {
        this.evaluateCount = evaluateCount;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Integer getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Integer workNo) {
        this.workNo = workNo;
    }

    public Integer getCompNo() {
        return compNo;
    }

    public void setCompNo(Integer compNo) {
        this.compNo = compNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLookTime() {
        return lookTime;
    }

    public void setLookTime(String lookTime) {
        this.lookTime = lookTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getHallNum() {
        return hallNum;
    }

    public void setHallNum(Integer hallNum) {
        this.hallNum = hallNum;
    }

    public String getFaceAt() {
        return faceAt;
    }

    public void setFaceAt(String faceAt) {
        this.faceAt = faceAt;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getFrozenInfo() {
        return frozenInfo;
    }

    public void setFrozenInfo(String frozenInfo) {
        this.frozenInfo = frozenInfo;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getEnvUrl() {
        return envUrl;
    }

    public void setEnvUrl(String envUrl) {
        this.envUrl = envUrl;
    }

    public String getOutsideUrl() {
        return outsideUrl;
    }

    public void setOutsideUrl(String outsideUrl) {
        this.outsideUrl = outsideUrl;
    }

    public String getInsideUrl() {
        return insideUrl;
    }

    public void setInsideUrl(String insideUrl) {
        this.insideUrl = insideUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getSellReason() {
        return sellReason;
    }

    public void setSellReason(String sellReason) {
        this.sellReason = sellReason;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(Integer maxFloor) {
        this.maxFloor = maxFloor;
    }

    public String getYongTu() {
        return yongTu;
    }

    public void setYongTu(String yongTu) {
        this.yongTu = yongTu;
    }

    public String getOwnStatus() {
        return ownStatus;
    }

    public void setOwnStatus(String ownStatus) {
        this.ownStatus = ownStatus;
    }

    public String getDiyaInfo() {
        return diyaInfo;
    }

    public void setDiyaInfo(String diyaInfo) {
        this.diyaInfo = diyaInfo;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public String getKeyPoint() {
        return keyPoint;
    }

    public void setKeyPoint(String keyPoint) {
        this.keyPoint = keyPoint;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCommunityNo() {
        return communityNo;
    }

    public void setCommunityNo(String communityNo) {
        this.communityNo = communityNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public Integer getToiletNum() {
        return toiletNum;
    }

    public void setToiletNum(Integer toiletNum) {
        this.toiletNum = toiletNum;
    }

    public Integer getKitchenNum() {
        return kitchenNum;
    }

    public void setKitchenNum(Integer kitchenNum) {
        this.kitchenNum = kitchenNum;
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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getQualifyNo() {
        return qualifyNo;
    }

    public void setQualifyNo(String qualifyNo) {
        this.qualifyNo = qualifyNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    @Override
    public String toString() {
        return "AgentHouse{" +
                "workNo=" + workNo +
                ", compNo=" + compNo +
                ", name='" + name + '\'' +
                ", starLevel=" + starLevel +
                ", tel='" + tel + '\'' +
                ", workYear=" + workYear +
                ", houseNo=" + houseNo +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", tag='" + tag + '\'' +
                ", lookTime='" + lookTime + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", roomNum=" + roomNum +
                ", hallNum=" + hallNum +
                ", faceAt='" + faceAt + '\'' +
                ", decoration='" + decoration + '\'' +
                ", elevator='" + elevator + '\'' +
                ", frozenInfo='" + frozenInfo + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", envUrl='" + envUrl + '\'' +
                ", outsideUrl='" + outsideUrl + '\'' +
                ", insideUrl='" + insideUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", sellReason='" + sellReason + '\'' +
                ", region='" + region + '\'' +
                ", floor='" + floor + '\'' +
                ", maxFloor=" + maxFloor +
                ", yongTu='" + yongTu + '\'' +
                ", ownStatus='" + ownStatus + '\'' +
                ", diyaInfo='" + diyaInfo + '\'' +
                ", houseInfo='" + houseInfo + '\'' +
                ", keyPoint='" + keyPoint + '\'' +
                ", structure='" + structure + '\'' +
                ", community='" + community + '\'' +
                ", communityNo='" + communityNo + '\'' +
                ", address='" + address + '\'' +
                ", buildYear='" + buildYear + '\'' +
                ", toiletNum=" + toiletNum +
                ", kitchenNum=" + kitchenNum +
                ", created=" + created +
                ", period=" + period +
                ", clientId=" + clientId +
                ", compName='" + compName + '\'' +
                ", qualifyNo='" + qualifyNo + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", businessScope='" + businessScope + '\'' +
                '}';
    }
}

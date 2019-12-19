package hnu.houseweb.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class HousePart {
    private String houseNo;
    private String type;
    private String title;
    private String city;
    private String district;
    private BigDecimal size;
    private String tag;
    private BigDecimal price;
    private Integer roomNum;
    private Integer hallNum;
    private String elevator;
    private String coverUrl;
    private String community;
    private String address;
    private int maxFloor;
    private int floor;
    private int role;
    Date created;
    private String status;
    private BigDecimal longitude;
    private BigDecimal latitude;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "HousePart{" +
                "houseNo='" + houseNo + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", size=" + size +
                ", tag='" + tag + '\'' +
                ", price=" + price +
                ", roomNum=" + roomNum +
                ", hallNum=" + hallNum +
                ", elevator='" + elevator + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", community='" + community + '\'' +
                ", address='" + address + '\'' +
                ", maxFloor=" + maxFloor +
                ", floor=" + floor +
                ", role=" + role +
                ", created=" + created +
                ", status='" + status + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

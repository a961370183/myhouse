package hnu.houseweb.entity;

import java.sql.Date;

/* 用于封装检索参数 ， 然后调用Mybatis动态生成SQL*/
public class HouseParam {

    int roomNum;
    int priceMin;
    int priceMax;
    int sizeMin;
    int sizeMax;
    int orderType;
    String district;
    String tag;
    String decoration;  //z1~z3
    String faceAt;      //f1~f8
    String floor;       //l1~l3
    String company;     //c20202
    String type;        //个人房源为b1；中介房源为b2
    int pageNum;

    public HouseParam() {
        roomNum = -1;
        priceMax = -1;
        priceMin = -1;
        sizeMax = -1;
        sizeMin = -1;
        orderType = -1;
        pageNum = 1;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getFaceAt() {
        return faceAt;
    }

    public void setFaceAt(String faceAt) {
        this.faceAt = faceAt;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public int getSizeMin() {
        return sizeMin;
    }

    public void setSizeMin(int sizeMin) {
        this.sizeMin = sizeMin;
    }

    public int getSizeMax() {
        return sizeMax;
    }

    public void setSizeMax(int sizeMax) {
        this.sizeMax = sizeMax;
    }

    @Override
    public String toString() {
        return "HouseParam{" +
                "roomNum=" + roomNum +
                ", priceMin=" + priceMin +
                ", priceMax=" + priceMax +
                ", sizeMin=" + sizeMin +
                ", sizeMax=" + sizeMax +
                ", orderType=" + orderType +
                ", district='" + district + '\'' +
                ", tag='" + tag + '\'' +
                ", decoration='" + decoration + '\'' +
                ", faceAt='" + faceAt + '\'' +
                ", floor='" + floor + '\'' +
                ", company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", pageNum=" + pageNum +
                '}';
    }
}

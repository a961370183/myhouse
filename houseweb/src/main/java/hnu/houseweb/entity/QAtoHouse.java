package hnu.houseweb.entity;

import java.util.List;
import java.util.Objects;

public class QAtoHouse {
    HouseDetail houseDetail;
    int houseNo;
    List<QAUnion> qaUnionList;

    public QAtoHouse(HouseDetail houseDetail, int houseNo, List<QAUnion> qaUnionList) {
        this.houseDetail = houseDetail;
        this.houseNo = houseNo;
        this.qaUnionList = qaUnionList;
    }

    public HouseDetail getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(HouseDetail houseDetail) {
        this.houseDetail = houseDetail;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public List<QAUnion> getQaUnionList() {
        return qaUnionList;
    }

    public void setQaUnionList(List<QAUnion> qaUnionList) {
        this.qaUnionList = qaUnionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QAtoHouse qAtoHouse = (QAtoHouse) o;
        return houseNo == qAtoHouse.houseNo &&
                Objects.equals(houseDetail, qAtoHouse.houseDetail) &&
                Objects.equals(qaUnionList, qAtoHouse.qaUnionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseDetail, houseNo, qaUnionList);
    }

    @Override
    public String toString() {
        return "QAtoHouse{" +
                "houseDetail=" + houseDetail +
                ", houseNo=" + houseNo +
                ", qaUnionList=" + qaUnionList +
                '}';
    }
}

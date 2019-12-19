package hnu.houseweb.entity;

import java.util.Date;

public class Question {
    private Integer questionNo;

    private Integer houseNo;

    private Integer userId;

    private Date created;

    private String questionContent;

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionNo=" + questionNo +
                ", houseNo=" + houseNo +
                ", userId=" + userId +
                ", created=" + created +
                ", questionContent='" + questionContent + '\'' +
                '}';
    }
}
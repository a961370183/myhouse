package hnu.houseweb.entity;

import java.util.Date;

public class Answer extends AnswerKey {
    private String answerContent;

    private Date answerTime;

    private int answerNo;

    private String name;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerContent='" + answerContent + '\'' +
                ", answerTime=" + answerTime +
                ", name='" + name + '\'' +
                '}';
    }
}
package hnu.houseweb.entity;

public class AnswerKey {
    private Integer userId;

    private Integer questionNo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    @Override
    public String toString() {
        return "AnswerKey{" +
                "userId=" + userId +
                ", questionNo=" + questionNo +
                '}';
    }
}
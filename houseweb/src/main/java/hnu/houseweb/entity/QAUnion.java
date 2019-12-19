package hnu.houseweb.entity;

import java.util.List;
import java.util.Objects;

public class QAUnion {
    Question question;
    Answer answer;
    List<Answer> answerList;
    HouseDetail houseDetail;

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
    public QAUnion(){

    }
    public QAUnion(Question question, Answer answer, HouseDetail houseDetail) {
        this.question = question;
        this.answer = answer;
        this.houseDetail = houseDetail;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public HouseDetail getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(HouseDetail houseDetail) {
        this.houseDetail = houseDetail;
    }

    @Override
    public String toString() {
        return "QAUnion{" +
                "question=" + question +
                ", answer=" + answer +
                ", answerList=" + answerList +
                ", houseDetail=" + houseDetail +
                '}';
    }
}
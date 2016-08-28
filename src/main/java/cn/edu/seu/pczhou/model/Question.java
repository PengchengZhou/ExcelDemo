package cn.edu.seu.pczhou.model;

/**
 * Created by 鹏程 on 2016/8/28.
 */
public class Question {
    int id;

    public Question(int id, String question, String answer_A, String answer_B,
                    String answer_C, String answer_D, String answer_right) {
        this.id = id;
        this.question = question;
        this.answer_A = answer_A;
        this.answer_B = answer_B;
        this.answer_C = answer_C;
        this.answer_D = answer_D;
        this.answer_right = answer_right;
    }

    public Question(String question, String answer_A, String answer_B,
                    String answer_C, String answer_D, String answer_right) {
        this.id = 0;
        this.question = question;
        this.answer_A = answer_A;
        this.answer_B = answer_B;
        this.answer_C = answer_C;
        this.answer_D = answer_D;
        this.answer_right = answer_right;
    }

    String question;
    String answer_A;
    String answer_B;
    String answer_C;
    String answer_D;
    String answer_right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_A() {
        return answer_A;
    }

    public void setAnswer_A(String answer_A) {
        this.answer_A = answer_A;
    }

    public String getAnswer_B() {
        return answer_B;
    }

    public void setAnswer_B(String answer_B) {
        this.answer_B = answer_B;
    }

    public String getAnswer_C() {
        return answer_C;
    }

    public void setAnswer_C(String answer_C) {
        this.answer_C = answer_C;
    }

    public String getAnswer_D() {
        return answer_D;
    }

    public void setAnswer_D(String answer_D) {
        this.answer_D = answer_D;
    }

    public String getAnswer_right() {
        return answer_right;
    }

    public void setAnswer_right(String answer_right) {
        this.answer_right = answer_right;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer_A='" + answer_A + '\'' +
                ", answer_B='" + answer_B + '\'' +
                ", answer_C='" + answer_C + '\'' +
                ", answer_D='" + answer_D + '\'' +
                ", answer_right='" + answer_right + '\'' +
                '}';
    }
}

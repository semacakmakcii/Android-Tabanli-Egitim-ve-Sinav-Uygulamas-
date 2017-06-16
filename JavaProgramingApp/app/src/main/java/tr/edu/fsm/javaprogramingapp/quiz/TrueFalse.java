package tr.edu.fsm.javaprogramingapp.quiz;

/**
 * Created by kelleemassey on 4/23/15.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private String q;
    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }
    public TrueFalse(String question, boolean TrueQuestion){
        q = question;
        mTrueQuestion = TrueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }
    public String getStringQuestion(){
        return q;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setQuestion(String mQuestion){
        this.q = mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}

package tr.edu.fsm.javaprogramingapp.quiz;

/**
 * Created by erol on 12.04.2017.
 */

public class Quiz {
    String quiz;
    String soru;
    String cevap;
    String title;
    public Quiz(String title, String soru, String cevap) {
        this.soru = soru;
        this.cevap = cevap;
        this.title = title;
    }
    public Quiz(String quiz){
        this.quiz = quiz;
    }
    public String getQuiz(){
        return this.quiz;
    }
}

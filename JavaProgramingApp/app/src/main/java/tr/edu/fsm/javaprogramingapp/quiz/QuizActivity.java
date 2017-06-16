package tr.edu.fsm.javaprogramingapp.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import android.content.Intent;

import java.util.List;

import tr.edu.fsm.javaprogramingapp.R;
import tr.edu.fsm.javaprogramingapp.konu.Konu;

public class QuizActivity extends AppCompatActivity  implements FindCallback<ParseObject> {

    ListView list;
    QuizBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        adapter = new QuizBaseAdapter(this);
        list = (ListView) findViewById(R.id.listQuiz);
        list.setAdapter(adapter);
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("quizs");
        //query.whereEqualTo("title", "quiz1");
        query.findInBackground(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent i = new Intent(QuizActivity.this, QuizSorularActivity.class);
                i.putExtra("quiztype",adapter.getItem(position).getQuiz());
                startActivity(i);
            }

        });
    }

    @Override
    public void done(List<ParseObject> list, ParseException e) {
        for(ParseObject p : list){
            String quiz = p.getString("quiz");
            adapter.add(new Quiz(quiz));
           /* p.deleteInBackground(new DeleteCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null){

                    }else{
                        Log.v("data","sildim abi");
                    }
                }
            });*/
        }
    }

    /*


    curl -X POST \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  -d '{"soru":"static metodlar için her çağrılışlarında bellekte ayrı bir yer ayrılır.","cevap":"false"}' \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/Quiz6

curl -X GET \
  -H "X-Parse-Application-Id: myAppId" \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/Quiz5 : Döngüler

 add:
    curl -X POST \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  -d '{"quiz":"Quiz6"}' \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/quizs

update:
curl -X PUT \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  -d '{"quiz":"quiz2"}' \
   http://fsm-javaprograming-app.herokuapp.com/parse/classes/quizs/jMj4sU9HTs

   removee:
   curl -X DELETE \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/quizs/jMj4sU9HTs
     */

    private void quizEkle(String soru, String cevap){
        ParseObject topic = new ParseObject("quiz");
        topic.put("soru", soru);
        topic.put("cevap", cevap);
        topic.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e !=null){
                    Log.v("data", e.getMessage());
                }else{
                    Log.v("data","done");
                }
            }
        });
    }
}

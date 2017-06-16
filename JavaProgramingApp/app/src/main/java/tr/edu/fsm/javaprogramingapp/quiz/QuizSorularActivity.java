package tr.edu.fsm.javaprogramingapp.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import tr.edu.fsm.javaprogramingapp.R;


public class QuizSorularActivity extends AppCompatActivity implements FindCallback<ParseObject> {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    ListView list1;
    QuizBaseAdapter adapter;

    private boolean isComplete = false;

    private List<TrueFalse> list = new ArrayList<>();

    private List<TrueFalse> mQuestionBank = new ArrayList<>();
    @Override
    public void done(List<ParseObject> list, ParseException e) {
        for(ParseObject p : list){
            String soru = p.getString("soru");
            Boolean cvp = Boolean.valueOf(p.getString("cevap"));
            Log.v("data", soru + cvp);
            mQuestionBank.add(new TrueFalse(soru, cvp));
        }
        isComplete = true;
        updateQuestion();
    }

    private int mCurrentIndex = 0;

    private void updateQuestion(){
        String question = mQuestionBank.get(mCurrentIndex).getStringQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank.get(mCurrentIndex).isTrueQuestion();
        String messageResId = "";
        if (userPressedTrue == answerIsTrue){
            messageResId = "DOĞRU!";
        } else{
            messageResId = "YANLIŞ!";
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sorular);
        Bundle bndl = getIntent().getExtras();
        String q = bndl.getString("quiztype");

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(q);
        query.findInBackground(this);
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        setmTrueButton((Button) findViewById(R.id.trueButton));
        getmTrueButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }
        });
        setmFalseButton((Button) findViewById(R.id.falseButton));
        getmFalseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                 mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size();
                 updateQuestion();
            }

        });



        if(isComplete) updateQuestion();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Button getmTrueButton() {
        return mTrueButton;
    }

    public void setmTrueButton(Button mTrueButton) {
        this.mTrueButton = mTrueButton;
    }

    public Button getmFalseButton() {
        return mFalseButton;
    }

    public void setmFalseButton(Button mFalseButton) {
        this.mFalseButton = mFalseButton;
    }
    // new TrueFalse(R.string.question_interface, false),

}

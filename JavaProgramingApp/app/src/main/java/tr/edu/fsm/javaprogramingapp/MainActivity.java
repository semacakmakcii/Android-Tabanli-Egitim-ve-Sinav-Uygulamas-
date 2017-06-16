package tr.edu.fsm.javaprogramingapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b5;
    public final static String EXTRA_MESSAGE = "tr.edu.fsm.javaprogramingapp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animScale1 = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animScale2 = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animScale3 = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);


        b1= (Button) findViewById(R.id.topic_id);
        b2= (Button) findViewById(R.id.video_id);
        b3= (Button) findViewById(R.id.quiz_id);
        b5= (Button) findViewById(R.id.info_id);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale1);
                v.setSelected(true);

                final Intent i=new Intent(MainActivity.this,tr.edu.fsm.javaprogramingapp.konu.KonuActivity.class);
                String s = "konu";
                i.putExtra(EXTRA_MESSAGE, s);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale2);
                v.setSelected(true);

                final Intent i=new Intent(MainActivity.this,tr.edu.fsm.javaprogramingapp.video.VideoActivity.class);
                String s = "video";
                i.putExtra(EXTRA_MESSAGE, s);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale3);
                final Intent i=new Intent(MainActivity.this,tr.edu.fsm.javaprogramingapp.quiz.QuizActivity.class);
                String s = "quiz";
                i.putExtra(EXTRA_MESSAGE, s);
                startActivity(i);
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
                showMessage("Geliştirici : Dilara Arı & Sema Çakmakçı" +
                        "\nKategori : Eğitim" +
                        "\nGüncellendi : 18 Kasım 2015" +
                        "\nSürüm : 2.1" +
                        "\nBoyut : 9.8 MB" +
                        "\nUyumluluk : Android 5.0 veya üst sürümünü gerektirir.Android cihazlar ile uyumludur.");
            }
        });
    }
    public void showMessage( String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }
}


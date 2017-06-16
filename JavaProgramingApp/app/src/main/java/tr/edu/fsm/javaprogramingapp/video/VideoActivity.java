package tr.edu.fsm.javaprogramingapp.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.DeleteCallback;

import java.util.List;
import android.widget.Button;
import com.parse.SaveCallback;
import tr.edu.fsm.javaprogramingapp.R;
import tr.edu.fsm.javaprogramingapp.konu.Aciklamalar;
import tr.edu.fsm.javaprogramingapp.konu.Konu;
import tr.edu.fsm.javaprogramingapp.konu.KonuActivity;
import tr.edu.fsm.javaprogramingapp.konu.KonuBaseAdapter;

/**
 * Created by sema on 16.4.2017.
 */

public class VideoActivity extends AppCompatActivity implements FindCallback<ParseObject> {
    Button save;
    ListView listview;
    VideoBaseAdapter videoBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        listview = (ListView) findViewById(R.id.listview);
        videoBaseAdapter = new VideoBaseAdapter(getApplicationContext());
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("video");
        query.findInBackground(this);

        listview.setAdapter(videoBaseAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String url = videoBaseAdapter.getItem(position).url;
                Log.v("data",  "url:"+ url);

                Intent i = new Intent(VideoActivity.this, VideoAciklamalar.class);
                i.putExtra("url1",url);
                startActivity(i);

            }

        });

      /*  save = (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("data","onclikc1");
                ParseObject topic = new ParseObject("video");
                topic.put("title", "VIDEO 2: MATRİS VE DİZİ TANIMLAMA");
                topic.put("url", "https://www.youtube.com/watch?v=-fLjOQhAGj4");
              //  topic.put("title", "VIDEO 1: SINIF VE METOD TANIMLAMA");
              //  topic.put("url", "https://www.youtube.com/watch?v=6ve89PcG-kM");
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
        }); */

         /*

curl -X POST \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  -d '{"title":"VIDEO 25: Text Dosyasına Yazma","url":"iIdBWK_C9oA"}' \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/video


curl -X GET \
  -H "X-Parse-Application-Id: myAppId" \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/video

     */
      /*  get = (Button) findViewById(R.id.getButton);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("konu");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, ParseException e) {
                        for(ParseObject p : list){
                            Log.v("data","mydata: "+p.getObjectId());
                            String title = p.getString("title");
                            String url = p.getString("url");
                            Log.v("data","mydata: "+title + "url:"+ url);
                        }
                    }
                });
            }
        }); */
    }

    @Override
    public void done(List<ParseObject> list, ParseException e) {
        for(ParseObject p : list){
            Log.v("data","mydata: "+p.getObjectId());
            String title = p.getString("title");
            String url = p.getString("url");
            Log.v("data","mydata: "+title + "url:"+ url);
            videoBaseAdapter.add(new Video(title,url));

        }
    }
}

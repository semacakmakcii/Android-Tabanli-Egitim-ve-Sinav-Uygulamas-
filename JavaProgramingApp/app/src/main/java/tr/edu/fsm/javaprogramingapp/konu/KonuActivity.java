package tr.edu.fsm.javaprogramingapp.konu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.parse.DeleteCallback;

import java.util.List;

import tr.edu.fsm.javaprogramingapp.R;

public class KonuActivity extends AppCompatActivity implements FindCallback<ParseObject>{
  //  Button save; Button get;
    int x = 0;
    int p1=0;
    ListView listview;
    KonuBaseAdapter konuBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konu);
        listview = (ListView) findViewById(R.id.listview);
        konuBaseAdapter = new KonuBaseAdapter(getApplicationContext());
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("konu");
        query.findInBackground(this);

        listview.setAdapter(konuBaseAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String url = konuBaseAdapter.getItem(position).url;
                Log.v("data",  "url:"+ url);

                Intent i = new Intent(KonuActivity.this, Aciklamalar.class);
                i.putExtra("url1",url);
                startActivity(i);

            }

        });

    /*    save = (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("data","onclikc1");
                ParseObject topic = new ParseObject("konu");
                topic.put("title", "KONU 19: AWT – SWİNG");
                topic.put("url", "https://javaprogramlamadili.wordpress.com/2017/04/11/konu-19-awt-swing/");
                topic.put("date", "2017/04/11");
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
  -d '{"title":"KONU 20: Event – Component","url":"https://javaprogramlamadili.wordpress.com/2017/04/11/konu-20-event-component/","date":"2017/04/10"}' \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/konu

update:
curl -X PUT \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  -d '{"title":"KONU 7: Kontrol Yapıları"}' \
   http://fsm-javaprograming-app.herokuapp.com/parse/classes/konu/uRng2XlThO

 removee:
   curl -X DELETE \
  -H "X-Parse-Application-Id: myAppId" \
  -H "Content-Type: application/json" \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/konu/TbwGc70GT8


curl -X GET \
  -H "X-Parse-Application-Id: myAppId" \
  http://fsm-javaprograming-app.herokuapp.com/parse/classes/konu

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
            konuBaseAdapter.add(new Konu(title,url,"hello"));
           /* p.deleteInBackground(new DeleteCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null){

                    }else{
                        Log.v("data","sildim abi");
                    }
                }
            }); */
        }
    }
}

package tr.edu.fsm.javaprogramingapp.konu;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import tr.edu.fsm.javaprogramingapp.R;

/**
 * Created by dilara on 02/12/16.
 */

public class Aciklamalar extends Activity {

    private WebView webView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aciklamalar_main);
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);

        Bundle bndl = getIntent().getExtras();
        String strUrl = bndl.getString("url1");

        webView.loadUrl(strUrl);

    }
}

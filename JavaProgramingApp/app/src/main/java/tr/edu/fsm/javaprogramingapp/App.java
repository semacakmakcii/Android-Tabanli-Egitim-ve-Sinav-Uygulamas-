package tr.edu.fsm.javaprogramingapp;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by erol on 12.04.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this);
    }
}

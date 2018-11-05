package e.huini.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.util.Log;
//import android.util.log;

public  class MainActivity extends AppCompatActivity {

    //    private static final String TAG = "bucysmessage";
//    Button btn, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.i(TAG, "onCreate");
//        btn = (Button) findViewById(R.id.signup);
//        btn3 = (Button) findViewById(R.id.login);
//        btn4 = (Button) findViewById(R.id.signin);
//
//
//        btn.setOnClickListener(this);
//        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);

    }

    public void btn3(View v) {
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    public void btn(View v) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }
//
//    public void btn4(View v) {
//        Intent i = new Intent(this, SignIn.class);
//        startActivity(i);
//    }
}
//    }
//    public void onClick(View v){
//        if(v == btn){
//            Intent i = new Intent(this, LoginActivity.class);
//            startActivity(i);
//        }
//        else if(v == btn3){
//            Intent i = new Intent(this, SignUp.class);
//            startActivity(i);
//        } else if (v == btn4){
//            Intent i = new Intent(this, SignIn.class);
//            startActivity(i);
//        }
//    }


//    public void log5(View v){
//        Intent i = new Intent(this,SignIn.class);
//        startActivity(i);
//    }
//public void log4(View v){
//        Intent i = new Intent(this,Profile.class);
//        startActivity(i);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i(TAG, "onCreate");
//    }
//#
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i(TAG, "onCreate");
//    }


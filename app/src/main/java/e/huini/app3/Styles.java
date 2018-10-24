package e.huini.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Styles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);

    }


        public void saveStyles(View v){
            Intent i = new Intent(this,HairdresserProfile.class);
            startActivity(i);
        }

}

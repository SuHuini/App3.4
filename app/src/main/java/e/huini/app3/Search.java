package e.huini.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
    }
    public void btn(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Search.this, MainActivity.class));
    }

}

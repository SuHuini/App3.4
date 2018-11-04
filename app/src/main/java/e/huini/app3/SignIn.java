package e.huini.app3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
//import android.widget.EditText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

   private   EditText email;
   private   EditText password;
    private FirebaseAuth firebaseAuth;
    private Button login;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        firebaseAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.login) ;

         authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            if(firebaseAuth.getCurrentUser() != null){

                finish();
                startActivity(new Intent(SignIn.this, Search.class));
            }
            }
        };

//
//        public void onStart(){
//        super.onStart();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//
//        if(user != null)
//        {
//            finish();
//            startActivity(new Intent(SignIn.this, Search.class));
//
//        }
//        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });
    }
    private void validate(String email, String password){
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(SignIn.this,"Please fill in all fields", Toast.LENGTH_LONG).show();
        } else {
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          startActivity(new Intent(SignIn.this, Search.class));
                      }else{
                          Toast.makeText(SignIn.this, "Login failed", Toast.LENGTH_SHORT).show();

                      }
                    }
                });
    }
    }
}

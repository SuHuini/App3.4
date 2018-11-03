package e.huini.app3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private EditText username;
    private EditText email;
    private EditText password;
    private Button hairdresser;
    private TextView hairdresser1;

//    private ProgressBar bar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        register = (Button) findViewById(R.id.register);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        hairdresser = (Button) findViewById(R.id.hairdresser);
        hairdresser1 = (TextView) findViewById(R.id.hairdresser1);

        register.setOnClickListener(this);
        hairdresser1.setOnClickListener(this);
        hairdresser.setOnClickListener(this);


    }

    private void registerUser() {
        String u = username.getText().toString().trim();
        String e = email.getText().toString().trim();
        String p = password.getText().toString().trim();
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(p) || TextUtils.isEmpty(u)
// || TextUtils.isEmpty(s)
                ) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(e, p)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Successful registration", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this, "Unable to register. Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == register) {
            registerUser();
        } else if (v == hairdresser) {
            startActivity(new Intent(this, HairdresserProfile.class));
        } else if (v == hairdresser1) {
            startActivity(new Intent(this, HairdresserProfile.class));
        }
    }
}











//package e.huini.app3;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.*;
////import android.widget.EditText;
////import android.widget.TextView;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.*;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.UserInfo;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import org.w3c.dom.Text;
//
//import java.nio.Buffer;
//
//public class SignUp extends AppCompatActivity {
//    private FirebaseAuth firebaseAuth;
////    TextView userEmail;
//    Button saveUser;
//
//    ProgressBar bar;
//
//    DatabaseReference databaseHairdresser;
//
//    EditText FName, SName, email, password;
//    EditText location, phone;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//         firebaseAuth = FirebaseAuth.getInstance();
//
//             bar = new ProgressBar(this);
////        if (firebaseAuth.getCurrentUser() == null) {
////            finish();
////            startActivity(new Intent(this, LoginActivity.class));
////        }
//
//        databaseHairdresser = FirebaseDatabase.getInstance().getReference("stylist");
//
//        FName = (EditText) findViewById(R.id.FName);
//        SName = (EditText) findViewById(R.id.SName);
//        email = (EditText) findViewById(R.id.email);
//        password = (EditText) findViewById(R.id.password);
//        location = (EditText) findViewById(R.id.location);
//        phone = (EditText) findViewById(R.id.phone);
//
//        saveUser = (Button) findViewById(R.id.signup);
//
////        FirebaseUser user = firebaseAuth.getCurrentUser();
//////        userEmail = (TextView) findViewById(R.id.userID);
////        userEmail.setText("User Email" + user.getEmail());
//
//        saveUser.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                saveDetails();
//            }
//        });
//
//    }
//
//    public void saveDetails() {
//        String name1 = FName.getText().toString().trim();
//        String name2 = SName.getText().toString().trim();
//        String loc = location.getText().toString().trim();
//        String mail = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        String number = phone.getText().toString().trim();
//
//
//
//        if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(name1) || TextUtils.isEmpty(loc)
//                || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(number)) {
//            Toast.makeText(this, "Fill in all fields!", Toast.LENGTH_LONG).show();
//
//        } else {
//            String id = databaseHairdresser.push().getKey();
//            String name = name1 + name2;
//            Hairdresser stylist = new Hairdresser(id, name, loc, mail, pass, number);
//            databaseHairdresser.child(id).setValue(stylist);
//            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
//
//        }
//        firebaseAuth.createUserWithEmailAndPassword(mail,pass)
//            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(SignUp.this, "Successful registration", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(SignUp.this, "Unable to register. Please try again", Toast.LENGTH_SHORT).show();
//                        }
//                }
//            });
//    }
//    }


package e.huini.app3;

import android.content.Intent;
<<<<<<< HEAD

import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

=======
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
//import android.widget.EditText;
//import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c

import org.w3c.dom.Text;

import java.nio.Buffer;

public class HairdresserProfile extends AppCompatActivity {
<<<<<<< HEAD
=======

>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c
    private FirebaseAuth firebaseAuth;

//    private TextView userEmail;

<<<<<<< HEAD
    Button saveUser;
    Button styles;


    DatabaseReference databaseHairdresser;

    EditText FName, SName, email, password;
    EditText location, phone;
    FirebaseDatabase db;
    Hairdresser stylist;
=======
    private Button saveUser;
    private Button styles;

    DatabaseReference databaseHairdresser;

    private EditText FName, SName, email, password;
    private EditText location, phone;

>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c
    //  private  Firebase mr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();

//        mr = new Firebase("https://app3-52a9c.firebaseio.com/");

//        if (firebaseAuth.getCurrentUser() == null) {
//            finish();
//            startActivity(new Intent(this, LoginActivity.class));
//        }
<<<<<<< HEAD
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        databaseHairdresser = db.getReference("Hairdresser");
        stylist =  new Hairdresser();
=======

        databaseHairdresser = FirebaseDatabase.getInstance().getReference("stylist");
>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c

        FName = (EditText) findViewById(R.id.FName);
        SName = (EditText) findViewById(R.id.SName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        location = (EditText) findViewById(R.id.location);
        phone = (EditText) findViewById(R.id.phone);

        saveUser = (Button) findViewById(R.id.save);
        styles = (Button) findViewById(R.id.styles);

<<<<<<< HEAD

=======
>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        userEmail = (TextView) findViewById(R.id.email);
//        userEmail.setText( user.getEmail());

<<<<<<< HEAD
//        saveUser.setOnClickListener(this);
//            @Override
//            public void onClick(View v) {
//                saveUser();
//
=======
        saveUser.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetails();
            }
        });
>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c
        styles.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HairdresserProfile.this, Styles.class));
            }
        });
<<<<<<< HEAD
    }

    private void getValues() {
        stylist.setFName(FName.getText().toString());
        stylist.setSName(SName.getText().toString());
        stylist.setLocation(location.getText().toString());
        stylist.setPhone(phone.getText().toString());
        stylist.setEmail(email.getText().toString());
        stylist.setPassword(password.getText().toString());


    }

    public void saveUser(View v) {
        databaseHairdresser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                getValues();

                databaseHairdresser.child("User04").setValue(stylist);
                Toast.makeText(HairdresserProfile.this, "Successful registration", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HairdresserProfile.this, Styles.class));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HairdresserProfile.this, "Unsuccessful. Try again", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HairdresserProfile.this, HairdresserProfile.class));
            }
        });
    }


    public void styles(View view) {
        Intent i = new Intent(this, Styles.class);
        startActivity(i);
    }
}

//    public void saveDetails() {
//        String name1 = FName.getText().toString().trim();
//        String name2 = SName.getText().toString().trim();
//        String loc = location.getText().toString().trim();
//        String mail = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        String number = phone.getText().toString().trim();
//
//
//             if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(name1) || TextUtils.isEmpty(loc)
//                || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(number)) {
//            Toast.makeText(this, "Fill in all fields!", Toast.LENGTH_LONG).show();
//                    }
//
//        String id = databaseHairdresser.push().getKey();
//        String name = name1 + name2;
//        Hairdresser stylist = new Hairdresser(id, name, loc, mail, pass, number);
//        databaseHairdresser.child(id).setValue(stylist);
//
//
//        Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
//        startActivity(new Intent(HairdresserProfile.this, Styles.class));
//
//    }
=======




    }
    public void styles(View view){
        Intent i = new Intent(this,Styles.class);
        startActivity(i);
    }

    public void saveDetails() {
        String name1 = FName.getText().toString().trim();
        String name2 = SName.getText().toString().trim();
        String loc = location.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String number = phone.getText().toString().trim();


        if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(name1) || TextUtils.isEmpty(loc)
                || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(number)) {
            Toast.makeText(this, "Fill in all fields!", Toast.LENGTH_LONG).show();

        }

        String id = databaseHairdresser.push().getKey();
        String name = name1 + name2;
        Hairdresser stylist = new Hairdresser(id, name, loc, mail, pass, number);
        databaseHairdresser.child(id).setValue(stylist);


        Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
        startActivity(new Intent(HairdresserProfile.this, Styles.class));

    }
}
//    package e.huini.app3;
//
//import android.app.ProgressDialog;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//    public class signup extends AppCompatActivity implements View.OnClickListener{
//
//        private Button signup;
//        private EditText FName;
//        private EditText SName;
//        private EditText email;
//        private EditText  password;
//
////    private ProgressBar bar;
//
//        private FirebaseAuth firebaseAuth;
//
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_signup);
//
//            firebaseAuth = FirebaseAuth.getInstance();
////           bar = new ProgressBar(this);
//            signup = (Button) findViewById(R.id.signup);
//            FName = (EditText) findViewById(R.id.FName);
//            SName = (EditText) findViewById(R.id.SName);
//            email = (EditText) findViewById(R.id.email);
//            password = (EditText) findViewById(R.id.password);
//
//            signup.setOnClickListener(this);
//
//
//        }
//        private void registerUser(){
//            String e = email.getText().toString().trim();
//            String p  = password.getText().toString().trim();
//            String f  = FName.getText().toString().trim();
//            String s  = SName.getText().toString().trim();
//            if(TextUtils.isEmpty(e)|| TextUtils.isEmpty(p)
////                ||
////                TextUtils.isEmpty(f)|| TextUtils.isEmpty(s)
//                    ){
//                Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show();
//                //
//                return;
//            }
//
//            firebaseAuth.createUserWithEmailAndPassword(e,p)
//                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(signup.this, "Successful registration", Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                                Toast.makeText(signup.this, "Unable to register. Please try again", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        }
//
//
//
//        @Override
//        public void onClick (View v){
//            if (v == signup) {
//                registerUser();
//            }
//
//        }







>>>>>>> 6248a17b502cdc53ce0df6218dcbcaf2877e515c


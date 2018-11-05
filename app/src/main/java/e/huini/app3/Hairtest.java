package e.huini.app3;



import android.content.Intent;

import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.w3c.dom.Text;

import java.nio.Buffer;

    public class Hairtest extends AppCompatActivity {
        private FirebaseAuth firebaseAuth;

//    private TextView userEmail;

        Button saveUser;
        Button styles;
        TextView userEmail;


        DatabaseReference databaseHairdresser;

        EditText FName, SName, email, password;
        EditText location, phone;
        FirebaseDatabase db;
        Hairdresser stylist;
        //  private  Firebase mr;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hairtest);

//        mr = new Firebase("https://app3-52a9c.firebaseio.com/");

//        if (firebaseAuth.getCurrentUser() == null) {
//            finish();
//            startActivity(new Intent(this, LoginActivity.class));
//        }
            FirebaseDatabase db = FirebaseDatabase.getInstance();

            databaseHairdresser = db.getReference("Hairdresser");
            stylist =  new Hairdresser();

            FName = (EditText) findViewById(R.id.FName);
            SName = (EditText) findViewById(R.id.SName);
            email = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            location = (EditText) findViewById(R.id.location);
            phone = (EditText) findViewById(R.id.phone);

            saveUser = (Button) findViewById(R.id.save);
            styles = (Button) findViewById(R.id.styles);


            saveUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveUser();
                }
            });


        FirebaseUser user = firebaseAuth.getCurrentUser();
        userEmail = (TextView) findViewById(R.id.userEmail);
        userEmail.setText( user.getEmail());

//        saveUser.setOnClickListener(this);
//            @Override
//            public void onClick(View v) {
//                saveUser();
//
            styles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(e.huini.app3.Hairtest.this, Styles.class));
                }
            });
        }

        private void getValues() {
            stylist.setFName(FName.getText().toString());
            stylist.setSName(SName.getText().toString());
            stylist.setLocation(location.getText().toString());
            stylist.setPhone(phone.getText().toString());
            stylist.setEmail(email.getText().toString());
            stylist.setPassword(password.getText().toString());


        }

        public void saveUser() {
            databaseHairdresser.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    getValues();

                    databaseHairdresser.child("User04").setValue(stylist);
                    Toast.makeText(e.huini.app3.Hairtest.this, "Successful registration", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(e.huini.app3.Hairtest.this, Styles.class));


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(e.huini.app3.Hairtest.this, "Unsuccessful. Try again", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(e.huini.app3.Hairtest.this, e.huini.app3.Hairtest.class));
                }
            });
        }


        public void styles(View view) {
            Intent i = new Intent(this, Styles.class);
            startActivity(i);
        }
    }


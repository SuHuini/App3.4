package e.huini.app3;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SearchResults extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase db;
    DatabaseReference ref;
    ArrayList<Hairdresser> list1;
    ArrayAdapter<Hairdresser> adapter;
    Hairdresser stylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        stylist = new Hairdresser();
        listView = (ListView) findViewById(R.id.listview);
        db = FirebaseDatabase.getInstance();
        ref = db.getReference( "Hairdresser");
        list1 = new ArrayList<>();
        adapter = new ArrayAdapter<Hairdresser>(this, R.layout.hairdresserinfo, R.id.info, list1);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                stylist = dataSnapshot1.getValue(Hairdresser.class);
               list1.add(stylist);
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

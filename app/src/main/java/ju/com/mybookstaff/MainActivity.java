package ju.com.mybookstaff;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button login;
    DatabaseReference dbReference;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    String user, pass;
    EditText Eusername, Epassword;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("user", MODE_PRIVATE);
        editor = preferences.edit();

        login = findViewById(R.id.login);
        Eusername = findViewById(R.id.username);
        Epassword = findViewById(R.id.pass);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = Eusername.getText().toString();
                pass = Epassword.getText().toString();



                if (user.startsWith("dl")) {
                    checkIfDelivery(user, pass);
                    Toast.makeText(getApplicationContext(), "done !", Toast.LENGTH_LONG).show();
                }
                else if (user.startsWith("bk"))
                    checkIfBookshop(user, pass);
               // else
                 //   Toast.makeText(getApplicationContext(), "please try again !", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void checkIfDelivery(final String username, final String pass) {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        dbReference = FirebaseDatabase.getInstance().getReference().child("deliveries");
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(username)) {

                    StaffModel staffModel = dataSnapshot.child(username).getValue(StaffModel.class);

                    Toast.makeText(getApplicationContext(), staffModel.getUsername() + " / " + staffModel.getPassword(), Toast.LENGTH_LONG).show();
                    if (user.equals(staffModel.getUsername()) && pass.equals(staffModel.getPassword())) {
                        Toast.makeText(getApplicationContext(), "Log in successfully", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        editor.putString("id",user);
                        editor.putString("number",staffModel.getPhone());
                        editor.putString("fullname",staffModel.getFullname());
                        Toast.makeText(getApplicationContext(),preferences.getString("id","")
                        +"\n"+preferences.getString("number","")
                                +"\n"+preferences.getString("fullname",""),Toast.LENGTH_SHORT).show();
                        //Intent here
                    } else {
                        Toast.makeText(getApplicationContext(), "Input is not correct try again ", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }else{
                    progressDialog.dismiss();
                   Toast.makeText(getApplicationContext(), "User is not registered !", Toast.LENGTH_SHORT).show();


                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void checkIfBookshop(final String username, final String pass) {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        dbReference = FirebaseDatabase.getInstance().getReference().child("bookshops");
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(username)) {
                    StaffModel staffModel = dataSnapshot.child(username).getValue(StaffModel.class);
                    if (user.equals(staffModel.getUsername()) && pass.equals(staffModel.getPassword())) {
                        Toast.makeText(getApplicationContext(), "Log in successfully", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        //Intent here
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Input is not correct try again", Toast.LENGTH_LONG).show();
                    }
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "not found user ", Toast.LENGTH_LONG).show();

                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}


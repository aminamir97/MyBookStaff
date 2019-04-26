package ju.com.mybookstaff.FirstPage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ju.com.mybookstaff.About;
import ju.com.mybookstaff.R;
import ju.com.mybookstaff.profile.Profile;

public class FirstPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<OfferModel> offers;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private OffersAdapter offersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        offers = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);

        final ProgressDialog progressDialog = new ProgressDialog(FirstPage.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        DatabaseReference dbReference;

        offers.clear();

        dbReference = FirebaseDatabase.getInstance().getReference().child("orders");
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    OfferModel offer = snapshot.getValue(OfferModel.class);
                    Toast.makeText(getApplicationContext(), offer.getBookPhoto(),Toast.LENGTH_SHORT).show();
                    offers.add(offer);

                }

                offersAdapter = new OffersAdapter(offers, FirstPage.this);
                offersAdapter.notifyDataSetChanged();
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(offersAdapter);
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"get all done from databse" ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"canceled from databse",Toast.LENGTH_SHORT).show();

            }
        });
    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myOrders) {
            // Handle the camera action
        } else if (id == R.id.account) {
            Intent intent= new Intent(FirstPage.this, Profile.class);
            startActivity(intent);

        } else if (id == R.id.about) {
            Intent intent= new Intent(FirstPage.this, About.class);
            startActivity(intent);

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

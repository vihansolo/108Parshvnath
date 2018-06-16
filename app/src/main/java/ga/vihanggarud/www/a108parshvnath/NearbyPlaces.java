package ga.vihanggarud.www.a108parshvnath;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ga.vihanggarud.www.a108parshvnath.Entity.Temple;

public class NearbyPlaces extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("temples");
    ListView nearbyPlacesListView;

    List<Temple> nearbyTemples = new ArrayList<>();
    ItemAdapter itemAdapter;

    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    double userLatitude;
    double userLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_places);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        nearbyPlacesListView = findViewById(R.id.nearby_places_list);

        nearbyPlacesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Temple currentTemple = nearbyTemples.get(position);

                Intent intent = new Intent(NearbyPlaces.this, TempleDetails.class);

                intent.putExtra("templeName",currentTemple.getTempleName());
                intent.putExtra("templeAddress",currentTemple.getTempleAddress());
                intent.putExtra("templeImageURI",currentTemple.getTempleImageURI());
                intent.putExtra("latitude",currentTemple.getLatitude());
                intent.putExtra("longitude",currentTemple.getLongitude());

                startActivity(intent);
            }
        });

        itemAdapter = new ItemAdapter(this, R.layout.list_item, nearbyTemples);
        nearbyPlacesListView.setAdapter(itemAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Temple temple = dataSnapshot.getValue(Temple.class);

                assert temple != null;
                double templeLatitude = temple.getLatitude();
                double templeLongitude = temple.getLongitude();

                double distance = getDistance(userLatitude,userLongitude,templeLatitude,templeLongitude);

                if (distance < 10000)
                    itemAdapter.add(temple);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }

        else {

            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null) {

                userLatitude = location.getLatitude();
                userLongitude = location.getLongitude();
            }

            else
                Toast.makeText(this, "Please Accept Permissions", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case REQUEST_LOCATION :
                getLocation();
                break;
        }
    }

    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {

        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (earthRadius * c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.nearby_places, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.go_back) {

            startActivity(new Intent(NearbyPlaces.this, MainActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

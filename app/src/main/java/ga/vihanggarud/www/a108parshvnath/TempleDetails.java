package ga.vihanggarud.www.a108parshvnath;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;

public class TempleDetails extends AppCompatActivity {

    LatLng latLng;
    ImageView templeImage;
    TextView templeName;
    TextView templeAddress;

    String name;
    String address;
    String imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_details);

        templeName = findViewById(R.id.templeName);
        templeImage = findViewById(R.id.templeImage);
        templeAddress = findViewById(R.id.templeAddress);

        Intent intent = getIntent();

        latLng = new LatLng(intent.getDoubleExtra("latitude",19.0639001),
                intent.getDoubleExtra("longitude",72.8349828));
        name = intent.getStringExtra("templeName");
        address = intent.getStringExtra("templeAddress");
        imageURI = intent.getStringExtra("templeImageURI");

        imageURI = imageURI.substring(1,imageURI.length());

        Glide.with(templeImage.getContext())
                .load(imageURI)
                .into(templeImage);

        templeName.setText(name);
        templeAddress.setText(address);
    }

    public void onViewOnMapClicked (View view) {

        Uri goToMapUri = Uri.parse("google.navigation:q="+latLng.latitude+","+latLng.longitude);

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, goToMapUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }
}

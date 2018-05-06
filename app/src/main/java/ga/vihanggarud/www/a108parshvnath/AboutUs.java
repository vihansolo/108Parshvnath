package ga.vihanggarud.www.a108parshvnath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Toast.makeText(this, "This is About Us activity", Toast.LENGTH_SHORT).show();
    }
}

package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lukas Schneider on 04.02.2017.
 */

public class NewRecordOverviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newrecord_overview);
    }

    public void personalInfo (View view){
        Intent intent = new Intent(this, PersonalInformationActivity.class);
        startActivity(intent);
    }

    public void registration (View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void cancellation (View view){
        Intent intent = new Intent(this, CancellationActivity.class);
        startActivity(intent);
    }

    public void create (View view){
        Intent intent = new Intent(this, OverviewActivity.class);
        startActivity(intent);
    }
}

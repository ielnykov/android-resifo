package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lukas Schneider on 05.02.2017.
 */

public class CancellationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancellation);
    }

    public void backC (View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void forwardC (View view){
        Intent intent = new Intent(this, NewRecordOverviewActivity.class);
        startActivity(intent);
    }
}

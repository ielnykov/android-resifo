package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lukas Schneider on 04.02.2017.
 */

public class RestorePassword2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_recovery_2);
    }

    public void confirmNewPassword (View view){
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }
}

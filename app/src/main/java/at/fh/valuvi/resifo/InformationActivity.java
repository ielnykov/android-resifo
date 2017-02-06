package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_adaptive);
    }

    public void infoBack (View view) {
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }

}

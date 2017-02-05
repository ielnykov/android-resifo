package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lukas Schneider on 04.02.2017.
 */

public class ChooseRecordActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_record);
    }

    public void newRecord (View view){
        Intent intent = new Intent(this, NewRecordOverviewActivity.class);
        startActivity(intent);
    }

    public void findRecord (View view){
        Intent intent = new Intent(this, FindRecordActivity.class);
        startActivity(intent);
    }

    public void information (View view){
        Intent intent = new Intent(this, InformationActivity.class);
        startActivity(intent);
    }
}

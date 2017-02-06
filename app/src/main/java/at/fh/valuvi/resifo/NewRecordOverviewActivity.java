package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import at.fh.valuvi.resifo.models.Entry;

public class NewRecordOverviewActivity extends AppCompatActivity {

    private Intent intent;
    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newrecord_overview);

        intent = getIntent();
        entry = (Entry) intent.getSerializableExtra("entry");
    }

    public void personalInfo (View view) {
        Intent intent = new Intent(this, PersonalInformationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void registration (View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void cancellation (View view) {
        Intent intent = new Intent(this, CancellationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void create (View view) {
        Intent intent = new Intent(this, OverviewCompleteRecordActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void cancelNR (View view) {
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }

}

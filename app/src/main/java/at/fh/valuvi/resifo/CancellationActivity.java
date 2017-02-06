package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.util.ArrayList;

import at.fh.valuvi.resifo.models.Entry;

public class CancellationActivity extends AppCompatActivity {

    private Intent intent;
    private Entry entry;
    private ArrayList<String> countries;

    EditText getCStreet() { return (EditText) findViewById(R.id.editCStreet); }
    EditText getCHouseNumber() {return (EditText) findViewById(R.id.editCHousenumber); }
    EditText getCApartment() { return (EditText) findViewById(R.id.editCApartment); }
    EditText getCDoor() { return (EditText) findViewById(R.id.editCDoor); }
    EditText getCPostalCode() { return (EditText) findViewById(R.id.editCPostalCode); }
    EditText getCCity() { return (EditText) findViewById(R.id.editCCity); }
    ToggleButton getCMovingAbroad(){ return (ToggleButton) findViewById(R.id.tbCMoveAbroad); }
    Spinner getCAbroadCountry(){ return (Spinner) findViewById(R.id.spAbroadCountry); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancellation);

        intent = getIntent();
        entry = (Entry) intent.getSerializableExtra("entry");

        countries = new ArrayList<>();
        for (String country: getResources().getStringArray(R.array.countries)) {
            countries.add(country);
        }

        loadFromEntry();
    }

    public void backC(View view){
        saveToEntry();

        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void forwardC(View view){
        saveToEntry();

        Intent intent = new Intent(this, NewRecordOverviewActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    private void loadFromEntry() {
        getCStreet().setText(entry.c_street);
        getCHouseNumber().setText(entry.c_houseNumber);
        getCApartment().setText(entry.c_apartment);
        getCDoor().setText(entry.c_door);
        getCPostalCode().setText(entry.c_postalCode);
        getCCity().setText(entry.c_city);
        getCMovingAbroad().setChecked((entry.c_abroad != null ? entry.c_abroad : false));
        getCAbroadCountry().setSelection((entry.c_abroadCountry != null ? countries.indexOf(entry.c_abroadCountry) : 0));
    }

    private void saveToEntry() {
        entry.c_street = getCStreet().getText().toString();
        entry.c_houseNumber = getCHouseNumber().getText().toString();
        entry.c_apartment = getCApartment().getText().toString();
        entry.c_door = getCDoor().getText().toString();
        entry.c_postalCode = getCPostalCode().getText().toString();
        entry.c_city = getCCity().getText().toString();
        entry.c_abroad = getCMovingAbroad().isChecked();
        entry.c_abroadCountry = String.valueOf(getCAbroadCountry().getSelectedItem());
    }
}

package at.fh.valuvi.resifo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import at.fh.valuvi.resifo.components.MyLocationListener;
import at.fh.valuvi.resifo.models.Entry;

public class RegistrationActivity extends AppCompatActivity {

    private Intent intent;
    private Entry entry;
    private ArrayList<String> countries;
    private LocationManager mlocManager;

    EditText getRStreet() { return (EditText) findViewById(R.id.editRStreet); }
    EditText getRHouseNumber() { return (EditText) findViewById(R.id.editRHousenumber); }
    EditText getRApartment() { return (EditText) findViewById(R.id.editRApartment); }
    EditText getRDoor() { return (EditText) findViewById(R.id.editRDoor); }
    EditText getRPostalCode() { return (EditText) findViewById(R.id.editRPostalCode); }
    EditText getRCity() { return (EditText) findViewById(R.id.editRCity); }
    ToggleButton getMainResidence() { return (ToggleButton) findViewById(R.id.tbRMainResidence); }
    EditText getMRStreet() { return (EditText) findViewById(R.id.editMRStreet); }
    EditText getMRHouseNumber() { return (EditText) findViewById(R.id.editMRHousenumber); }
    EditText getMRApartment() { return (EditText) findViewById(R.id.editMRApartment); }
    EditText getMRDoor() { return (EditText) findViewById(R.id.editMRDoor); }
    EditText getMRPostalCode() { return (EditText) findViewById(R.id.editMRPostalCode); }
    EditText getMRCity() { return (EditText) findViewById(R.id.editMRCity); }
    ToggleButton getAustriaAbroad() { return (ToggleButton) findViewById(R.id.tbRAbroad); }
    Spinner getAustriaAbroadCountry() { return (Spinner) findViewById(R.id.spRAbroadCountry); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        intent = getIntent();
        entry = (Entry) intent.getSerializableExtra("entry");

        countries = new ArrayList<>();
        for (String country: getResources().getStringArray(R.array.countries)) {
            countries.add(country);
        }

        loadFromEntry();

        mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();

        if (ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED) {
            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 2, mlocListener);
        }
    }

    public void findLocation (View view) {
        if (ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED) {
            Location loc = mlocManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            List<Address> addresses = null;
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
            } catch (IOException e) {
                System.out.println("Oh no!");
                e.printStackTrace();
            }

            String address = addresses.get(0).getAddressLine(0);
            String city = addresses.get(0).getLocality();
            String postalCode = addresses.get(0).getPostalCode();

            getRStreet().setText(address);
            getRCity().setText(city);
            getRPostalCode().setText(postalCode);
        }
    }

    public void backR (View view) {
        saveToEntry();

        Intent intent = new Intent(this, PersonalInformationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void forwardR (View view) {
        saveToEntry();

        Intent intent = new Intent(this, CancellationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    private void loadFromEntry() {
        getRStreet().setText(entry.r_street);
        getRHouseNumber().setText(entry.r_houseNumber);
        getRApartment().setText(entry.r_apartment);
        getRDoor().setText(entry.r_door);
        getRPostalCode().setText(entry.r_postalCode);
        getRCity().setText(entry.r_city);
        getMainResidence().setChecked((entry.r_mainResidence != null ? entry.r_mainResidence : false));
        getMRStreet().setText(entry.r_mainResidenceStreet);
        getMRHouseNumber().setText(entry.r_mainResidenceHouseNumber);
        getMRApartment().setText(entry.r_mainResidenceApartment);
        getMRDoor().setText(entry.r_mainResidenceDoor);
        getMRPostalCode().setText(entry.r_mainResidencePostalCode);
        getMRCity().setText(entry.r_mainResidenceCity);
        getAustriaAbroad().setChecked((entry.r_abroad != null ? entry.r_abroad : false));
        getAustriaAbroadCountry().setSelection((entry.r_abroadCountry != null ? countries.indexOf(entry.r_abroadCountry) : 0));
    }

    private void saveToEntry() {
        entry.r_street = getRStreet().getText().toString();
        entry.r_houseNumber = getRHouseNumber().getText().toString();
        entry.r_apartment = getRApartment().getText().toString();
        entry.r_door = getRDoor().getText().toString();
        entry.r_postalCode = getRPostalCode().getText().toString();
        entry.r_city = getRCity().getText().toString();
        entry.r_mainResidence = getMainResidence().isChecked();
        entry.r_mainResidenceStreet = getMRStreet().getText().toString();
        entry.r_mainResidenceHouseNumber = getMRHouseNumber().getText().toString();
        entry.r_mainResidenceApartment = getMRApartment().getText().toString();
        entry.r_mainResidenceDoor = getMRDoor().getText().toString();
        entry.r_mainResidencePostalCode = getMRPostalCode().getText().toString();
        entry.r_mainResidenceCity = getMRCity().getText().toString();
        entry.r_abroad = getAustriaAbroad().isChecked();
        entry.r_abroadCountry = String.valueOf(getAustriaAbroadCountry().getSelectedItem());
    }
}

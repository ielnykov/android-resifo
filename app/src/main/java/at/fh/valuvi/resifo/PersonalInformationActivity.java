package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import at.fh.valuvi.resifo.helpers.DateHelper;
import at.fh.valuvi.resifo.models.Entry;

public class PersonalInformationActivity extends AppCompatActivity {

    private Intent intent;
    private Entry entry;
    private ArrayList<String> countries;

    EditText getLastName() { return (EditText) findViewById(R.id.editLastName); }
    EditText getAcademicTitle() {return (EditText) findViewById(R.id.editAcademicTitle); }
    EditText getFirstName() { return (EditText) findViewById(R.id.editFirstName); }
    EditText getMaidenName() { return (EditText) findViewById(R.id.editMaidenName); }
    DatePicker getDateOfBirth() { return (DatePicker) findViewById(R.id.dpDateOfBirth); }
    Spinner getGender() { return (Spinner) findViewById(R.id.spGender); }
    EditText getReligion() { return (EditText) findViewById(R.id.editReligion); }
    EditText getPlaceOfBirth() { return (EditText) findViewById(R.id.editPlaceOfBirth); }
    Spinner getMaritalStatus() { return (Spinner) findViewById(R.id.spMaritalStatus); }
    Spinner getNationality() { return (Spinner) findViewById(R.id.spNationality); }
    EditText getZMR() { return (EditText) findViewById(R.id.editZMR); }
    EditText getTravelDocumentID() { return (EditText) findViewById(R.id.editTravelDocumentID); }
    EditText getTravelDocumentNumber() { return (EditText) findViewById(R.id.editTravelDocumentNumber); }
    EditText getTravelDocumentAuthority() { return (EditText) findViewById(R.id.editTravelDocumentAuthority); }
    Spinner getTravelDocumentCountry() { return (Spinner) findViewById(R.id.spTravelDocumentCountry); }
    DatePicker getTravelDocumentDate() { return (DatePicker) findViewById(R.id.dpTravelDocumentDate); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information);

        intent = getIntent();
        entry = (Entry) intent.getSerializableExtra("entry");

        countries = new ArrayList<>();
        for (String country: getResources().getStringArray(R.array.countries)) {
            countries.add(country);
        }

        addListenerOnSpinnerItemSelection();

        loadFromEntry();
    }

    public void backPI (View view){
        saveToEntry();

        Intent intent = new Intent(this, NewRecordOverviewActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void forwardPI (View view) {
        saveToEntry();

        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void addListenerOnSpinnerItemSelection() {
        getNationality().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country = countries.get(i);
                if (country.equals("Austria")) {
                    System.out.println("POWER!!!");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void loadFromEntry() {
        getAcademicTitle().setText(entry.academicTitle);
        getFirstName().setText(entry.firstName);
        getLastName().setText(entry.lastName);
        getMaidenName().setText(entry.maidenName);
        DateHelper.setDatePickerDate(getDateOfBirth(), entry.dateOfBirth);
        getGender().setSelection((entry.gender.equals("m") ? 0 : 1));
        getReligion().setText(entry.religion);
        getPlaceOfBirth().setText(entry.placeOfBirth);
        getMaritalStatus().setSelection((entry.maritalStatus != null ? entry.maritalStatus : 0));
        getNationality().setSelection((entry.nationality != null ? countries.indexOf(entry.nationality) : 13));
        getZMR().setText(entry.zmr);
        getTravelDocumentID().setText(entry.travelDocumentID);
        getTravelDocumentNumber().setText(entry.travelDocumentNumber);
        getTravelDocumentAuthority().setText(entry.travelDocumentAuthority);
        getTravelDocumentCountry().setSelection((entry.travelDocumentCountry != null ? countries.indexOf(entry.travelDocumentCountry) : 13));
        DateHelper.setDatePickerDate(getTravelDocumentDate(), entry.travelDocumentDate);
    }

    private void saveToEntry() {
        entry.academicTitle = getAcademicTitle().getText().toString();
        entry.firstName = getFirstName().getText().toString();
        entry.lastName = getLastName().getText().toString();
        entry.maidenName = getMaidenName().getText().toString();
        entry.dateOfBirth = DateHelper.getDateFromDatePicker(getDateOfBirth());
        entry.gender = (getGender().getSelectedItemPosition() == 0 ? "m" : "f");
        entry.religion = getReligion().getText().toString();
        entry.placeOfBirth = getPlaceOfBirth().getText().toString();
        entry.maritalStatus = getMaritalStatus().getSelectedItemPosition();
        entry.nationality = String.valueOf(getNationality().getSelectedItem());
        entry.zmr = getZMR().getText().toString();
        entry.travelDocumentID = getTravelDocumentID().getText().toString();
        entry.travelDocumentNumber = getTravelDocumentNumber().getText().toString();
        entry.travelDocumentAuthority = getTravelDocumentAuthority().getText().toString();
        entry.travelDocumentCountry = String.valueOf(getTravelDocumentCountry().getSelectedItem());
        entry.travelDocumentDate = DateHelper.getDateFromDatePicker(getTravelDocumentDate());
    }

}

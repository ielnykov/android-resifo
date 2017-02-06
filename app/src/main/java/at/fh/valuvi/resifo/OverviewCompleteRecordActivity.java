package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import at.fh.valuvi.resifo.helpers.DateHelper;
import at.fh.valuvi.resifo.models.Entry;

public class OverviewCompleteRecordActivity extends AppCompatActivity {

    private Intent intent;
    private Entry entry;
    private ArrayList<String> maritalStatuses = new ArrayList<>();

    TextView getLastName() { return (TextView) findViewById(R.id.tvLastName); }
    TextView getAcademicTitle() {return (TextView) findViewById(R.id.tvAcademicTitle); }
    TextView getFirstName() { return (TextView) findViewById(R.id.tvFirstName); }
    TextView getMaidenName() { return (TextView) findViewById(R.id.tvMaidenName); }
    TextView getDateOfBirth() { return (TextView) findViewById(R.id.tvDateOfBirth); }
    TextView getGender() { return (TextView) findViewById(R.id.tvGender); }
    TextView getReligion() { return (TextView) findViewById(R.id.tvReligion); }
    TextView getPlaceOfBirth() { return (TextView) findViewById(R.id.tvPlaceOfBirth); }
    TextView getMaritalStatus() { return (TextView) findViewById(R.id.tvMaritalStatus); }
    TextView getNationality() { return (TextView) findViewById(R.id.tvNationality); }
    TextView getZMR() { return (TextView) findViewById(R.id.tvZMR); }
    TextView getTravelDocumentID() { return (TextView) findViewById(R.id.tvTravelDocumentID); }
    TextView getTravelDocumentNumber() { return (TextView) findViewById(R.id.tvTravelDocumentNumber); }
    TextView getTravelDocumentAuthority() { return (TextView) findViewById(R.id.tvTravelDocumentAuthority); }
    TextView getTravelDocumentCountry() { return (TextView) findViewById(R.id.tvTravelDocumentCountry); }
    TextView getTravelDocumentDate() { return (TextView) findViewById(R.id.tvTravelDocumentDate); }
    TextView getRStreet() { return (TextView) findViewById(R.id.tvRStreet); }
    TextView getRHouseNumber() { return (TextView) findViewById(R.id.tvRHouseNumber); }
    TextView getRApartment() { return (TextView) findViewById(R.id.tvRApartment); }
    TextView getRDoor() { return (TextView) findViewById(R.id.tvRDoorNumber); }
    TextView getRPostalCode() { return (TextView) findViewById(R.id.tvRPostalCode); }
    TextView getRCity() { return (TextView) findViewById(R.id.tvRCity); }
    TextView MainResidence() { return (TextView) findViewById(R.id.tvRMainResidence); }
    TextView getMRStreet() { return (TextView) findViewById(R.id.tvMRStreet); }
    TextView getMRHouseNumber() { return (TextView) findViewById(R.id.tvMRHouseNumber); }
    TextView getMRApartment() { return (TextView) findViewById(R.id.tvMRApartmentNumber); }
    TextView getMRDoor() { return (TextView) findViewById(R.id.tvMRDoorNumber); }
    TextView getMRPostalCode() { return (TextView) findViewById(R.id.tvMRPostalCode); }
    TextView getMRCity() { return (TextView) findViewById(R.id.tvMRCity); }
    TextView getAustriaAbroad() { return (TextView) findViewById(R.id.tvRAbroad); }
    TextView getAustriaAbroadCountry() { return (TextView) findViewById(R.id.tvRCountryOfOrigin); }
    TextView getCStreet() { return (TextView) findViewById(R.id.tvCStreet); }
    TextView getCHouseNumber() {return (TextView) findViewById(R.id.tvCHouseNumber); }
    TextView getCApartment() { return (TextView) findViewById(R.id.tvCApartmentNumber); }
    TextView getCDoor() { return (TextView) findViewById(R.id.tvCDoorNumber); }
    TextView getCPostalCode() { return (TextView) findViewById(R.id.tvCPostalCode); }
    TextView getCCity() { return (TextView) findViewById(R.id.tvCCity); }
    TextView getCMovingAbroad() { return (TextView) findViewById(R.id.tvCMovingAbroad); }
    TextView getCAbroadCountry(){ return (TextView) findViewById(R.id.tvCCountry); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_complete_record_revisited);

        intent = getIntent();
        entry = (Entry) intent.getSerializableExtra("entry");

        for (String maritalStatus: getResources().getStringArray(R.array.martialStatus)) {
            maritalStatuses.add(maritalStatus);
        }

        loadFromEntry();
    }

    public void backOV (View view) {
        Intent intent = new Intent(this, NewRecordOverviewActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void doneOV (View view) {
        entry.userID = 1;
        entry.save();

        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }

    private void loadFromEntry() {
        getAcademicTitle().setText(entry.academicTitle);
        getFirstName().setText(entry.firstName);
        getLastName().setText(entry.lastName);
        getMaidenName().setText(entry.maidenName);
        getDateOfBirth().setText(DateHelper.getDisplayDate(entry.dateOfBirth));
        getGender().setText((entry.gender.equals("m") ? "Male" : "Female"));
        getReligion().setText(entry.religion);
        getPlaceOfBirth().setText(entry.placeOfBirth);
        getMaritalStatus().setText(entry.maritalStatus != null ? maritalStatuses.get(entry.maritalStatus) : null);
        getNationality().setText(entry.nationality);
        getZMR().setText(entry.zmr);
        getTravelDocumentID().setText(entry.travelDocumentID);
        getTravelDocumentNumber().setText(entry.travelDocumentNumber);
        getTravelDocumentAuthority().setText(entry.travelDocumentAuthority);
        getTravelDocumentCountry().setText(entry.travelDocumentCountry);
        getTravelDocumentDate().setText(DateHelper.getDisplayDate(entry.travelDocumentDate));
        getRStreet().setText(entry.r_street);
        getRHouseNumber().setText(entry.r_houseNumber);
        getRApartment().setText(entry.r_apartment);
        getRDoor().setText(entry.r_door);
        getRPostalCode().setText(entry.r_postalCode);
        getRCity().setText(entry.r_city);
        MainResidence().setText(entry.r_mainResidence != null ? (entry.r_mainResidence ? "yes" : " no") : null);
        getMRStreet().setText(entry.r_mainResidenceStreet);
        getMRHouseNumber().setText(entry.r_mainResidenceHouseNumber);
        getMRApartment().setText(entry.r_mainResidenceApartment);
        getMRDoor().setText(entry.r_mainResidenceDoor);
        getMRPostalCode().setText(entry.r_mainResidencePostalCode);
        getMRCity().setText(entry.r_mainResidenceCity);
        getAustriaAbroad().setText(entry.r_abroad != null ? (entry.r_abroad ? "yes" : "no") : null);
        getAustriaAbroadCountry().setText(entry.r_abroadCountry);
        getCStreet().setText(entry.c_street);
        getCHouseNumber().setText(entry.c_houseNumber);
        getCApartment().setText(entry.c_apartment);
        getCDoor().setText(entry.c_door);
        getCPostalCode().setText(entry.c_postalCode);
        getCCity().setText(entry.c_city);
        getCMovingAbroad().setText(entry.c_abroad != null ? (entry.r_abroad ? "yes" : "no") : null);
        getCAbroadCountry().setText(entry.c_abroadCountry);
    }

}

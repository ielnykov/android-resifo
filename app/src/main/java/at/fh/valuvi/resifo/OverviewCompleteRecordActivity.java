package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import at.fh.valuvi.resifo.models.Entry;

public class OverviewCompleteRecordActivity extends AppCompatActivity {

    private Intent intent;
    private Entry entry;

    EditText getLastName() { return (EditText) findViewById(R.id.editLastName); }
    EditText getAcademicTitle() {return (EditText) findViewById(R.id.editAcademicTitle); }
    EditText getFirstName() { return (EditText) findViewById(R.id.editFirstName); }
    EditText getMaidenName() { return (EditText) findViewById(R.id.editMaidenName); }
    TextView getDateOfBirth() { return (TextView) findViewById(R.id.textDateOfBirth); }

    TextView getGender() { return (TextView) findViewById(R.id.textGender); }
    EditText getReligion() { return (EditText) findViewById(R.id.editReligion); }
    EditText getPlaceOfBirth() { return (EditText) findViewById(R.id.editPlaceOfBirth); }
    TextView getMartialStatus() { return (TextView) findViewById(R.id.textMartialStatus); }
    TextView getNationality() { return (TextView) findViewById(R.id.textNationality); }

    EditText getZMR() { return (EditText) findViewById(R.id.editZMR); }
    EditText getTravelDocumentID() { return (EditText) findViewById(R.id.editTravelDocumentID); }
    EditText getTravelDocumentNumber() { return (EditText) findViewById(R.id.editTravelDocumentNumber); }
    EditText getTravelDocumentAuthority() { return (EditText) findViewById(R.id.editTravelDocumentAuthority); }
    EditText getTravelDocumentCountry() { return (EditText) findViewById(R.id.editTravelDocumentCountry); }

    TextView getTravelDocumentDate() { return (TextView) findViewById(R.id.textTravelDocumentDate); }

    //---

    EditText getRStreet() { return (EditText) findViewById(R.id.editRStreet); }
    EditText getRHouseNumber() { return (EditText) findViewById(R.id.editRHousenumber); }
    EditText getRApartment() { return (EditText) findViewById(R.id.editRApartment); }
    EditText getRDoor() { return (EditText) findViewById(R.id.editRDoor); }
    EditText getRPostalCode() { return (EditText) findViewById(R.id.editRPostalCode); }

    EditText getRCity() { return (EditText) findViewById(R.id.editRCity); }
    TextView MainResidence() { return (TextView) findViewById(R.id.textMainResidence); }
    EditText getMRStreet() { return (EditText) findViewById(R.id.editMRStreet); }
    EditText getMRHouseNumber() { return (EditText) findViewById(R.id.editMRHousenumber); }
    EditText getMRApartment() { return (EditText) findViewById(R.id.editMRApartment); }

    EditText getMRDoor() { return (EditText) findViewById(R.id.editMRDoor); }
    EditText getMRPostalCode() { return (EditText) findViewById(R.id.editMRPostalCode); }
    EditText getMRCity() { return (EditText) findViewById(R.id.editMRCity); }
    TextView getAustriaAbroad() { return (TextView) findViewById(R.id.textAustriaAbroad); }
    TextView getAustriaAbroadCountry() { return (TextView) findViewById(R.id.editRAbroadCountry); }

    //---

    EditText getCStreet() { return (EditText) findViewById(R.id.editCStreet); }
    EditText getCHouseNumber() {return (EditText) findViewById(R.id.editCHousenumber); }
    EditText getCApartment() { return (EditText) findViewById(R.id.editCApartment); }
    EditText getCDoor() { return (EditText) findViewById(R.id.editCDoor); }
    EditText getCPostalCode() { return (EditText) findViewById(R.id.editCPostalCode); }

    EditText getCCity() { return (EditText) findViewById(R.id.editCCity); }
    TextView getCMovingAbroad() { return (TextView) findViewById(R.id.textVMAbroad); }
    EditText getCAbroadCountry(){ return (EditText) findViewById(R.id.editAbroadCountry); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_complete_record);

        intent = getIntent();
        entry = (Entry) intent.getSerializableExtra("entry");

        loadFromEntry();
    }

    public void backOV (View view){
        Intent intent = new Intent(this, NewRecordOverviewActivity.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }

    public void doneOV (View view){
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }

    private void loadFromEntry() {
        getLastName().setText(entry.lastName);
        getAcademicTitle().setText(entry.academicTitle);
        getFirstName().setText(entry.firstName);
        getMaidenName().setText(entry.maidenName);
        getDateOfBirth().setText(entry.dateOfBirth.toString());

        getGender().setText(entry.gender);
        getReligion().setText(entry.religion);
        getPlaceOfBirth().setText(entry.placeOfBirth);
        getMartialStatus().setText(entry.maritalStatus);
        getNationality().setText(entry.nationality.toString());

        getZMR().setText(entry.zmr);
        getTravelDocumentID().setText(entry.travelDocumentID);
        getTravelDocumentNumber().setText(entry.travelDocumentNumber);
        getTravelDocumentAuthority().setText(entry.travelDocumentAuthority);
        getTravelDocumentCountry().setText(entry.travelDocumentCountry.toString());

        getTravelDocumentDate().setText(entry.travelDocumentDate.toString());

        //---

        getRStreet().setText(entry.r_street);
        getRHouseNumber().setText(entry.r_houseNumber);
        getRApartment().setText(entry.r_apartment);
        getRDoor().setText(entry.r_door);
        getRPostalCode().setText(entry.r_postalCode);

        getRCity().setText(entry.r_city);
        MainResidence().setText(entry.r_mainResidence ? "yes" : "no");
        getMRStreet().setText(entry.r_mainResidenceStreet);
        getMRHouseNumber().setText(entry.r_mainResidenceHouseNumber);
        getMRApartment().setText(entry.r_mainResidenceApartment);

        getMRDoor().setText(entry.r_mainResidenceDoor);
        getMRPostalCode().setText(entry.r_mainResidencePostalCode);
        getMRCity().setText(entry.r_mainResidenceCity);
        getAustriaAbroad().setText(entry.r_abroad ? "yes" : "no");
        getAustriaAbroadCountry().setText(entry.r_abroadCountry.toString());

        //---

        getCStreet().setText(entry.c_street);
        getCHouseNumber().setText(entry.c_houseNumber);
        getCApartment().setText(entry.c_apartment);
        getCDoor().setText(entry.c_door);
        getCPostalCode().setText(entry.c_postalCode);

        getCCity().setText(entry.c_city);
        getCMovingAbroad().setText(entry.c_abroad ? "yes" : "no");
        getCAbroadCountry().setText(entry.c_abroadCountry.toString());
    }
}

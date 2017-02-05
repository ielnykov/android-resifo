package at.fh.valuvi.resifo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import at.fh.valuvi.resifo.components.BaseModel;

public class Entry extends BaseModel {

    public Integer entryId;
    public Integer userID;
    public String firstName;
    public String lastName;
    public String maidenName;
    public Date dateOfBirth;
    public String gender;
    public String religion;
    public String placeOfBirth;
    public Integer martialStatus;
    public Country nationality;
    public String zmr;
    public String travelDocumentID;
    public String travelDocumentNumber;
    public String travelDocumentAuthority;
    public Country travelDocumentCountry;
    public Date travelDocumentDate;
    public String r_street;
    public String r_housenumber;
    public String r_apartment;
    public String r_door;
    public String r_postalCode;
    public String r_city;
    public String r_mainResidence;
    public Boolean r_abroad;
    public Country r_abroadCountry;
    public String c_street;
    public String c_housenumber;
    public String c_apartment;
    public String c_door;
    public String c_postalCode;
    public String c_city;
    public Boolean c_abroad;
    public Country c_abroadCountry;
    public String landroadName;
    public Date landroadDate;
    public String landroadSignaturePath;
    public Date userDate;
    public String userSignaturePath;

    @DataType(type = DataType.DATETIME)
    public Date dateCreated;

    public User user;

    @Override
    public String getTableName() {
        return "Entry";
    }

    public Entry find(int id) {
        return (Entry) super.find(id);
    }

    public Entry find(HashMap<String, Object> attributes) {
        return (Entry) super.find(attributes);
    }

    public Entry[] findAll(HashMap<String, Object> attributes) {
        Object[] models = super.findAll(attributes);
        ArrayList<Entry> newModels = new ArrayList<>();
        for (Object model: models) { newModels.add((Entry) model); }

        return newModels.toArray(new Entry[] {});
    }

}

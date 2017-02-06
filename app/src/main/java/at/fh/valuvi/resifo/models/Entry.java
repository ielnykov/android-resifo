package at.fh.valuvi.resifo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import at.fh.valuvi.resifo.components.BaseRecord;

public class Entry extends BaseRecord implements Serializable {

    public Integer entryId;

    @Required
    public Integer userID;

    public String academicTitle;

    @Required
    public String firstName;

    @Required
    public String lastName;

    public String maidenName;

    @Required
    public Date dateOfBirth;

    @Required
    public String gender = "m";

    public String religion;

    @Required
    public String placeOfBirth;

    @Required
    public Integer maritalStatus;

    @Required
    public String nationality;

    public String zmr;

    public String travelDocumentID;
    public String travelDocumentNumber;
    public String travelDocumentAuthority;
    public String travelDocumentCountry;
    public Date travelDocumentDate;

    @Required
    public String r_street;

    @Required
    public String r_houseNumber;

    public String r_apartment;
    public String r_door;

    @Required
    public String r_postalCode;

    @Required
    public String r_city;

    @Required
    public Boolean r_mainResidence;

    public String r_mainResidenceStreet;
    public String r_mainResidenceHouseNumber;
    public String r_mainResidenceApartment;
    public String r_mainResidenceDoor;
    public String r_mainResidencePostalCode;
    public String r_mainResidenceCity;

    @Required
    public Boolean r_abroad;

    public String r_abroadCountry;
    public String c_street;
    public String c_houseNumber;
    public String c_apartment;
    public String c_door;
    public String c_postalCode;
    public String c_city;
    public Boolean c_abroad;
    public String c_abroadCountry;

    public Date userDate = new Date();

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

    public Entry[] findAll() {
        HashMap<String, Object> attributes = new HashMap<>();

        return findAll(attributes);
    }

    public Entry[] findAll(HashMap<String, Object> attributes) {
        Object[] models = super.findAll(attributes);
        ArrayList<Entry> newModels = new ArrayList<>();
        for (Object model: models) { newModels.add((Entry) model); }

        return newModels.toArray(new Entry[] {});
    }

    public String getRAddress() {
        return r_street + ", " + r_city;
    }
}

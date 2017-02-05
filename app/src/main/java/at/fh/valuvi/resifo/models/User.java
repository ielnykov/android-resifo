package at.fh.valuvi.resifo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import at.fh.valuvi.resifo.components.BaseModel;

public class User extends BaseModel {

    public String firstName;
    public String lastName;
    public String maidenName;
    public Date dateOfBirth;
    public String gender;
    public String religion;
    public String placeOfBirth;
    public Integer maritalStatus;
    public Country nationality;
    public String zmr;
    public String travelDocumentID;
    public String travelDocumentNumber;
    public String travelDocumentAuthority;
    public Country travelDocumentCountry;
    public Date travelDocumentDate;

    @DataType(type = DataType.DATETIME)
    public Date dateCreated = new Date();

    @Override
    public String getTableName() {
        return "User";
    }

    public User find(int id) {
        return (User) super.find(id);
    }

    public User find(HashMap<String, Object> attributes) {
        return (User) super.find(attributes);
    }

    public User[] findAll(HashMap<String, Object> attributes) {
        Object[] models = super.findAll(attributes);
        ArrayList<User> newModels = new ArrayList<>();
        for (Object model: models) { newModels.add((User) model); }

        return newModels.toArray(new User[] {});
    }

}

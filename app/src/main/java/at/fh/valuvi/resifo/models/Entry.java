package at.fh.valuvi.resifo.models;

import java.util.Date;

public class Entry {

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
    public Date dateCreated;
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

    public User user;

}

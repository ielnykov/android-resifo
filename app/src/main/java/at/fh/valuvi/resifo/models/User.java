package at.fh.valuvi.resifo.models;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import at.fh.valuvi.resifo.components.BaseRecord;
import at.fh.valuvi.resifo.helpers.SecurityHelper;

public class User extends BaseRecord implements Serializable {

    @Required
    public String firstName;

    @Required
    public String lastName;

    @Required
    @Email
    public String email;

    @Required
    public String password;

    @DataType(type = DataType.DATETIME)
    public Date dateCreated = new Date();

    @Override
    public String getTableName() {
        return "User";
    }

    public void setPassword(String password) {
        this.password = User.getPasswordHash(password);
    }

    public static String getPasswordHash(String password) {
        return SecurityHelper.md5(password);
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

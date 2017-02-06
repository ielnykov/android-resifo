package at.fh.valuvi.resifo.models.forms;

import java.util.HashMap;
import at.fh.valuvi.resifo.components.BaseForm;
import at.fh.valuvi.resifo.models.User;

public class RestorePasswordForm extends BaseForm {

    @Required
    public String firstName;

    @Required
    public String lastName;

    @Required
    @Email
    public String email;

    private User user;

    public Boolean restore() {
        if (!super.validate()) { return false; }

        return getUser() != null;
    }

    public User getUser() {
        if (user != null) { return user; }

        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("firstName" , firstName);
        attributes.put("lastName" , lastName);
        attributes.put("email" , email);

        user = new User().find(attributes);

        return user;
    }

}

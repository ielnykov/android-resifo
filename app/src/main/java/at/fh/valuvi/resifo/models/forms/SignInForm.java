package at.fh.valuvi.resifo.models.forms;

import java.util.HashMap;
import at.fh.valuvi.resifo.components.BaseForm;
import at.fh.valuvi.resifo.models.User;

public class SignInForm extends BaseForm {

    @Required
    @Email
    public String email;

    @Required
    public String password;

    public Boolean login() {
        if (!super.validate()) { return false; }

        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("email", email);
        attributes.put("password", User.getPasswordHash(password));

        for(Object v: attributes.values()) {
            System.out.println((String) v);
        }



        return new User().find(attributes) != null;
    }

}

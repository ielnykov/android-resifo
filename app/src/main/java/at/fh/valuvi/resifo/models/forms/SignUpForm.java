package at.fh.valuvi.resifo.models.forms;

import at.fh.valuvi.resifo.components.BaseForm;
import at.fh.valuvi.resifo.models.User;

public class SignUpForm extends BaseForm {

    @Required
    public String firstName;

    @Required
    public String lastName;

    @Required
    @Email
    public String email;

    @Required
    public String password;

    @Required
    @Equal(compareAttributeName = "password")
    public String passwordRepeat;

    public Boolean createUser() {
        if (!validate()) { return false; }

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.setPassword(password);

        return user.save();
    }

}

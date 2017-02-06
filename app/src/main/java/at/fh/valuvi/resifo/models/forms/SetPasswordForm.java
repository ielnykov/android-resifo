package at.fh.valuvi.resifo.models.forms;

import at.fh.valuvi.resifo.components.BaseForm;
import at.fh.valuvi.resifo.models.User;

public class SetPasswordForm extends BaseForm {

    @Required
    public String password;

    @Required
    @Equal(compareAttributeName = "password")
    public String passwordRepeat;

    private User user;

    public SetPasswordForm(User user) {
        this.user = user;
    }

    public Boolean set() {
        if (!super.validate()) { return false; }

        user.setPassword(password);

        return user.save();
    }

}

package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import at.fh.valuvi.resifo.components.Application;
import at.fh.valuvi.resifo.models.User;
import at.fh.valuvi.resifo.models.forms.SetPasswordForm;

public class SetPasswordActivity extends AppCompatActivity {

    private Intent intent;
    private User user;
    private TextView getPassword() { return (TextView) findViewById(R.id.editPassword); }
    private TextView getPasswordRepeat() { return (TextView) findViewById(R.id.editRepeatPassword); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.set_password);

        intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
    }

    public void confirmNewPassword (View view) {

        SetPasswordForm setPasswordForm = new SetPasswordForm(user);
        setPasswordForm.password = getPassword().getText().toString();
        setPasswordForm.passwordRepeat = getPasswordRepeat().getText().toString();

        if (setPasswordForm.set()) {
            Intent intent = new Intent(this, ChooseRecordActivity.class);
            startActivity(intent);
        } else {
            Application.showValidationAlert(setPasswordForm.getErrors(), SetPasswordActivity.this);
        }
    }

}

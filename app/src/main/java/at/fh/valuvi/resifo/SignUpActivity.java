package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import at.fh.valuvi.resifo.components.Application;
import at.fh.valuvi.resifo.models.forms.SignUpForm;

public class SignUpActivity extends AppCompatActivity {

    private TextView getFirstName() { return (TextView) findViewById(R.id.editFirstName); }
    private TextView getLastName() { return (TextView) findViewById(R.id.editLastName); }
    private TextView getEMail() { return (TextView) findViewById(R.id.editEmail); }
    private TextView getPassword() { return (TextView) findViewById(R.id.editPassword); }
    private TextView getPasswordRepeat() { return (TextView) findViewById(R.id.editPasswordRepeat); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    public void confirmation (View view) {
        SignUpForm signUpForm = new SignUpForm();

        signUpForm.firstName = getFirstName().getText().toString();
        signUpForm.lastName = getLastName().getText().toString();
        signUpForm.email = getEMail().getText().toString();
        signUpForm.password = getPassword().getText().toString();
        signUpForm.passwordRepeat = getPasswordRepeat().getText().toString();

        if (signUpForm.createUser()) {
            Intent intent = new Intent(this, ConfirmSignUpActivity.class);
            startActivity(intent);
        } else {
            Application.showValidationAlert(signUpForm.getErrors(), SignUpActivity.this);
        }
    }

}

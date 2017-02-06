package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import at.fh.valuvi.resifo.components.Application;
import at.fh.valuvi.resifo.models.forms.SignInForm;

public class SignInActivity extends AppCompatActivity {

    private TextView getEmail() { return (TextView) findViewById(R.id.editEmail); }
    private TextView getPassword() { return (TextView) findViewById(R.id.editPassword); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
    }

    public void signUp (View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void restorePassword (View view) {
        Intent intent = new Intent(this, RestorePasswordActivity.class);
        startActivity(intent);
    }

    public void chooseRecord (View view) {
        String email = getEmail().getText().toString();
        String password = getPassword().getText().toString();

        SignInForm signInForm = new SignInForm();
        signInForm.email = email;
        signInForm.password = password;

        if (signInForm.login()) {
            Intent intent = new Intent(this, ChooseRecordActivity.class);
            startActivity(intent);
        } else {
            Application.showAlert("E-mail or/and password is invalid", "Authentication", SignInActivity.this);
        }
    }
}

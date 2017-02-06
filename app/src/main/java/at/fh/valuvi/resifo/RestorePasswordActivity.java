package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import at.fh.valuvi.resifo.components.Application;
import at.fh.valuvi.resifo.models.forms.RestorePasswordForm;

public class RestorePasswordActivity extends AppCompatActivity {

    private TextView getFirstName() { return (TextView) findViewById(R.id.editFirstName); }
    private TextView getLastName() { return (TextView) findViewById(R.id.editLastName); }
    private TextView getEMail() { return (TextView) findViewById(R.id.editEmail); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_recovery);
    }

    public void restore (View view) {
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.firstName = getFirstName().getText().toString();
        restorePasswordForm.lastName = getLastName().getText().toString();
        restorePasswordForm.email = getEMail().getText().toString();

        if (restorePasswordForm.restore()){
            Intent intent = new Intent(this, SetPasswordActivity.class);
            intent.putExtra("user", restorePasswordForm.getUser());
            startActivity(intent);
        } else {
            Application.showAlert("No user with these attributes found", "Restore Password", RestorePasswordActivity.this);
        }
    }
}

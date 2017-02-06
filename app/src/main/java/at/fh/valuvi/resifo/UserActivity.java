package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import at.fh.valuvi.resifo.models.User;

public class UserActivity extends AppCompatActivity {

    User user;
    TextView name = (TextView) findViewById(R.id.textName);
    TextView email = (TextView) findViewById(R.id.textEmail);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        //TODO: fill User Placeholder

        user = new User();
        name.setText(user.firstName + " " + user.lastName);
        email.setText(user.email);
    }

    public void changePW (View view){
        Intent intent = new Intent(this, SetPasswordActivity.class);
        startActivity(intent);
    }

}

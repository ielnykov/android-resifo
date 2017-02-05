package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lukas Schneider on 04.02.2017.
 */

public class SignInActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
    }

    public void signUp (View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void restorePassword (View view){
        Intent intent = new Intent(this, RestorePasswordActivity.class);
        startActivity(intent);
    }

    public void chooseRecord (View view){
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }
}

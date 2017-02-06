package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import at.fh.valuvi.resifo.components.Application;
import at.fh.valuvi.resifo.models.User;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_startup);
    }

    public void signUp (View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void signIn (View view){
        Intent intent = new Intent (this, SignInActivity.class);
        startActivity(intent);
    }

    public void impressum (View view){
        Intent intent = new Intent (this, ImpressumActivity.class);
        startActivity(intent);
    }
}

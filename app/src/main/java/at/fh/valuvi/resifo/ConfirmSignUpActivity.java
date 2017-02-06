package at.fh.valuvi.resifo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

public class ConfirmSignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_sign_up);
    }

    public void chooseRecordConf (View view) {
        Intent intent = new Intent(this, ChooseRecordActivity.class);
        startActivity(intent);
    }
}

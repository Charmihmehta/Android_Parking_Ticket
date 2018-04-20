package com.moxdroid.samplesharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayDetailsActivity extends Activity {

    TextView txtEmail, txtPassword;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        txtEmail = (TextView)findViewById(R.id.textViewEmail);
        txtPassword  = (TextView)findViewById(R.id.textViewPassword);

        sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);

        String email = sharedPreferences.getString("userEmail",null);
        String pwd = sharedPreferences.getString("userPassword",null);

        if(email != null)
            txtEmail.setText(email);
        else
            txtEmail.setText("No Shared Preferences for EMAIL");

        if(pwd != null)
            txtPassword.setText(pwd);
        else
            txtPassword.setText("No Shared Preferences for PASSWORD");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Menu Resource, Menu
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuStart:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.mnuStop:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.mnuResume:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

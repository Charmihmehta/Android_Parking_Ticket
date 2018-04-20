package com.moxdroid.samplesharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener{

    EditText editTextEmail, editTextPassword;
    CheckBox chkRemember;
    Button btnLogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText)findViewById(R.id.edtEmail);
        editTextPassword = (EditText)findViewById(R.id.edtPassword);
        chkRemember = (CheckBox)findViewById(R.id.chkRemember);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);
        setSavedDetails();
        super.onResume();

    }

    private void setSavedDetails() {
        String email = sharedPreferences.getString("userEmail",null);
        String pwd = sharedPreferences.getString("userPassword",null);

        if(email != null && pwd != null) {
            editTextEmail.setText(email);
            editTextPassword.setText(pwd);
            chkRemember.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {

        if(chkRemember.isChecked()) {
            SharedPreferences.Editor mEditor = sharedPreferences.edit();
            mEditor.putString("userEmail",editTextEmail.getText().toString());
            mEditor.putString("userPassword",editTextPassword.getText().toString());
            //mEditor.commit();
            mEditor.apply();
        }else{
            SharedPreferences.Editor mEditor = sharedPreferences.edit();
            mEditor.putString("userEmail",null);
            mEditor.putString("userPassword",null);
            mEditor.apply();
        }
        Intent mIntent = new Intent(this,DisplayDetailsActivity.class);
        startActivity(mIntent);
    }
}

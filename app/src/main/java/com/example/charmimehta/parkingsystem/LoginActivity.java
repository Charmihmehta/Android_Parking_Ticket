package com.example.charmimehta.parkingsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charmimehta.parkingsystem.databases.AppDatabase;
import com.example.charmimehta.parkingsystem.databases.TicketDeo;
import com.example.charmimehta.parkingsystem.databases.UserDao;
import com.example.charmimehta.parkingsystem.modal.User;

public class LoginActivity extends AppCompatActivity {

    EditText txtUserName;
    EditText txtPsw;
    Button btnLogin;
    Button btnSignUp;
    CheckBox chxRemember;
    SharedPreferences sharedPreferences;

    @Override
    public void onBackPressed() {
        // write your code
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        chxRemember = (CheckBox) findViewById(R.id.chkMe);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        txtPsw = (EditText) findViewById(R.id.txtPsw);
        txtUserName = (EditText) findViewById(R.id.txtUserName);

        String email = txtUserName.getText().toString();
        String emailPattern = "^[A-za-z0-9.]+@[A-za-z]+\\.[a-zA-z]{2,3}$";


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u1 ;
                if (TextUtils.isEmpty(txtUserName.getText()) || txtUserName.getText().toString().length() == 0) {
                    txtUserName.setError("Please enter user name");
                } else if (TextUtils.isEmpty(txtPsw.getText()) || txtPsw.getText().toString().length() == 0) {
                    txtPsw.setError("Please enter password");
                } else {
                    UserDao messageDao = (UserDao) AppDatabase.getInstance(getApplicationContext()).userDao();
                     u1=messageDao.getSingleRecord(txtUserName.getText().toString(),txtPsw.getText().toString());
                     if (u1!=null) {

                        Toast.makeText(LoginActivity.this, "User Successfully logged in ", Toast.LENGTH_LONG).show();
                        if (chxRemember.isChecked()) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("userEmail", txtUserName.getText().toString());
                            editor.putString("userPsw", txtPsw.getText().toString());
                            editor.apply();
                        } else {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("userEmail", null);
                            editor.putString("userPsw", null);
                            editor.apply();
                        }

                        Intent i1 = new Intent(LoginActivity.this, MainMenuActivity.class);
                        startActivity(i1);
                    } else {

                        Toast.makeText(LoginActivity.this, "UserID passwords invalid", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });

    }

    protected void onResume() {

        sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE);
        setSavedDetails();
        super.onResume();
    }

    private void setSavedDetails() {
        String email = sharedPreferences.getString("userEmail", null);
        String psw = sharedPreferences.getString("userPsw", null);

        if (email != null && psw != null) {
            txtUserName.setText(email);
            txtPsw.setText(psw);
            chxRemember.setChecked(true);
        } else {
            chxRemember.setChecked(false);
        }
    }


}

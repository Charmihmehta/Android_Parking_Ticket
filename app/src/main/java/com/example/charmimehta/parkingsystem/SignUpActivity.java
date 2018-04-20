package com.example.charmimehta.parkingsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charmimehta.parkingsystem.databases.AppDatabase;
import com.example.charmimehta.parkingsystem.databases.UserDao;
import com.example.charmimehta.parkingsystem.modal.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {


    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.contact)
    EditText contact;
    @BindView(R.id.carplate)
    EditText carplate;
    @BindView(R.id.btnRegister)
    Button btnRegister;

    @Override
    public void onBackPressed() {
        // write your code
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals(repassword.getText().toString())) {
                    createUser();
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Password Mis-Match");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
        });



    }
    public void createUser()
    {
        User user = new User();
        user.setUsername(username.getText().toString());
        user.setEmail(email.getText().toString());
        user.setCarPlateNo(carplate.getText().toString());
        user.setPassword(password.getText().toString());
        user.setContact(contact.getText().toString());

        //add new message to database
        UserDao userDao = (UserDao) AppDatabase.getInstance(SignUpActivity.this).userDao();
        userDao.insertUser(user);

        if(user != null) {
            Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
            startActivity(i);
        }
        else
        {


        }
    }

}

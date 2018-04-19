package com.example.charmimehta.parkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProfileActivity extends AppCompatActivity {


        EditText username;

        EditText email;

        EditText password;

        EditText conatct;

        EditText carplate;
        Button btnEdit;
        Button btnSave;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update_profile);

            btnEdit = (Button) findViewById(R.id.btnEdit);
            btnSave = (Button) findViewById(R.id.btnUpdate);
            username  = (EditText) findViewById(R.id.edUsername);
            email  = (EditText) findViewById(R.id.edEmail);
            password  = (EditText) findViewById(R.id.edPassword);
            conatct  = (EditText) findViewById(R.id.edContact);
            carplate  = (EditText) findViewById(R.id.edCarPlate);



            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    username.setEnabled(true);
                    email.setEnabled(true);
                    password.setEnabled(true);
                    conatct.setEnabled(true);
                    carplate.setEnabled(true);
                    Toast.makeText(UpdateProfileActivity.this, " EditText Enable Programmatically ", Toast.LENGTH_LONG).show();

                }
            });

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    username.setEnabled(false);
                    email.setEnabled(false);
                    password.setEnabled(false);
                    conatct.setEnabled(false);
                    carplate.setEnabled(false);
                    Toast.makeText(UpdateProfileActivity.this, " EditText Enable Programmatically ", Toast.LENGTH_LONG).show();

                }
            });



        }


}

package com.example.charmimehta.parkingsystem;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.charmimehta.parkingsystem.databases.AppDatabase;
import com.example.charmimehta.parkingsystem.databases.UserDao;
import com.example.charmimehta.parkingsystem.modal.User;

public class UpdateProfileActivity extends AppCompatActivity {


        EditText username;

        EditText email;

        EditText password;

        EditText conatct;

        EditText carplate;
        Button btnEdit;

        SharedPreferences sharedPreferences;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update_profile);

            btnEdit = (Button) findViewById(R.id.btnEdit);

            username  = (EditText) findViewById(R.id.edUsername);
            email  = (EditText) findViewById(R.id.edEmail);
            password  = (EditText) findViewById(R.id.edPassword);
            conatct  = (EditText) findViewById(R.id.edContact);
            carplate  = (EditText) findViewById(R.id.edCarPlate);
            sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);

            String email1 = sharedPreferences.getString("userEmail",null);
            String psw = sharedPreferences.getString("userPsw",null);

            email.setText(email1);
            email.setEnabled(false);




            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                    User user = new User();
                    user.setUsername(username.getText().toString());
                    user.setEmail(email1);
                    user.setCarPlateNo(carplate.getText().toString());
                    user.setPassword(psw);
                    user.setContact(conatct.getText().toString());

                    //add new message to database
                    UserDao userDao = (UserDao) AppDatabase.getInstance(UpdateProfileActivity.this).userDao();
                    userDao.getSingleRecord(email1,psw);
                    if(userDao!=null)
                    {
                        Toast.makeText(UpdateProfileActivity.this, " not updated "+ user, Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(UpdateProfileActivity.this, " not updated ", Toast.LENGTH_LONG).show();
                    }

                }
            });





        }


}

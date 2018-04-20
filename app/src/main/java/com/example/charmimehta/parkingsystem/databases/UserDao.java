package com.example.charmimehta.parkingsystem.databases;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.charmimehta.parkingsystem.modal.User;

import java.util.List;


@Dao
public interface UserDao {

    @Query("Select * from User")
    public LiveData<List<User>> getUser();

    @Delete()
    public void deleteUser(User user);


    @Insert()
    public void insertUser(User user);

    @Query("SELECT * FROM User WHERE email =:email_id AND password =:pwd")
    User getSingleRecord(String email_id, String pwd);






}


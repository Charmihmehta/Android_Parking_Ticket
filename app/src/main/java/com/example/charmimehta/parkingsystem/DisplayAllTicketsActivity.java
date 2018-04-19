package com.example.charmimehta.parkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.charmimehta.parkingsystem.adapter.TicketAdapter;
import com.example.charmimehta.parkingsystem.databases.AppDatabase;
import com.example.charmimehta.parkingsystem.databases.TicketDeo;
import com.example.charmimehta.parkingsystem.modal.Ticket;

import java.util.List;

public class DisplayAllTicketsActivity extends AppCompatActivity {


    private final String TAG = DisplayAllTicketsActivity.class.getSimpleName();
    private TicketAdapter ticketAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_tickets);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tickets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DisplayAllTicketsActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        TicketDeo messageDao = (TicketDeo) AppDatabase.getInstance(getApplicationContext()).ticketDeo();
        messageDao.getAllTicket().observe(this, (List<Ticket> ticket) -> {
            ticketAdapter = new TicketAdapter(DisplayAllTicketsActivity.this,ticket);
            recyclerView.setAdapter(ticketAdapter);
        });
    }
}

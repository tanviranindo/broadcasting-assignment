package com.assignment.native_broadcast_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
    }

    public void onSubmit(View view) {
        String input = spinner.getSelectedItem().toString();
        String msg;
        Intent i;

        switch (input) {
            case "Custom broadcast receiver":
                msg = "Input any text: ";
                i = new Intent(getApplicationContext(), BroadcastSender.class);
                i.putExtra("message", msg);
                i.putExtra("choice", "1");
                startActivity(i);
                break;
            case "WIFI RTT state change receiver":
                msg = "";
                i = new Intent(getApplicationContext(), BroadcastSender.class);
                i.putExtra("message", msg);
                i.putExtra("choice", "2");
                startActivity(i);
                break;
            case "System battery notification receiver":
                msg = "Input battery percentage: ";
                i = new Intent(getApplicationContext(), BroadcastSender.class);
                i.putExtra("message", msg);
                i.putExtra("choice", "3");
                startActivity(i);
                break;
        }
    }
}
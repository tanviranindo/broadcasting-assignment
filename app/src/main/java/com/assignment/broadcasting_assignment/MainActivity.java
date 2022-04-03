package com.assignment.broadcasting_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                intent = new Intent(this, TextBroadcastSender.class);
                break;
            case 1:
                intent = new Intent(this, WIFIBroadcastSender.class);
                break;
            case 2:
                intent = new Intent(this, SystemBroadcastSender.class);
                break;
        }
        Button button = findViewById(R.id.button);
        button.setOnClickListener(activity -> startActivity(intent));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
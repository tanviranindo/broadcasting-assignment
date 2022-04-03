package com.assignment.broadcasting_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SystemBroadcastSender extends AppCompatActivity {

    public static final String header = "Battery Broadcast Sender";
    public static final String EXTRA_TEXT = "EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_broadcast_sender);
        TextView textViewHeader = findViewById(R.id.viewBatterySender);
        textViewHeader.setText(header);
        Button submit = findViewById(R.id.buttonBatterySender);
        submit.setOnClickListener(view -> textSubmit());

        Button back = findViewById(R.id.backButtonBattery);
        back.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));
    }

    private void textSubmit() {
        EditText editText = findViewById(R.id.editBatterySender);
        Intent intent = new Intent(this, SystemBroadcastReceiver.class);
        String text = editText.getText().toString();
        if (isNumber(text)) {
            float value = Float.parseFloat(text);
            if (value > 100) {
                Toast.makeText(getApplicationContext(), "Battery health can not be more than 100", Toast.LENGTH_SHORT).show();
            }
            else if (value < 0) {
                Toast.makeText(getApplicationContext(), "Battery health can not be less than 0", Toast.LENGTH_SHORT).show();
            }
            else {
                intent.putExtra(EXTRA_TEXT, text);
                startActivity(intent);
            }
        } else if (text.equals("")) {
            Toast.makeText(getApplicationContext(), "Please input any number!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Input format is incorrect. Try Again!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNumber(String string) {
        try {
            Float.parseFloat(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
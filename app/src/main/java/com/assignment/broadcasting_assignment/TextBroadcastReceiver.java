package com.assignment.broadcasting_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TextBroadcastReceiver extends AppCompatActivity {
    public static final String header = "Text Broadcast Receiver";
    public static String text = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_broadcast_receiver);

        TextView textViewHeader = findViewById(R.id.viewTextReceiver);
        textViewHeader.setText(header);

        Intent intent = getIntent();
        text = intent.getStringExtra(TextBroadcastSender.EXTRA_TEXT);
        TextView textView = findViewById(R.id.broadcastOutput);
        textView.setText(text);

        Button back = findViewById(R.id.backTextSender);
        back.setOnClickListener(view -> startActivity(new Intent(view.getContext(), TextBroadcastSender.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Broadcast Received: " + text, Toast.LENGTH_SHORT).show();
    }
}
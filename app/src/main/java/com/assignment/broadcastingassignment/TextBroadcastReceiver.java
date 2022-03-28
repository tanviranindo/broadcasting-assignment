package com.assignment.broadcastingassignment;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TextBroadcastReceiver extends AppCompatActivity {
    public static final String header = "Text Broadcast Receiver";
    public static String text = "";

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ToasterBroadcasting.class);
        sendBroadcast(intent);
    }
}
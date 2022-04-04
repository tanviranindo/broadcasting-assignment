package com.assignment.broadcasting_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextBroadcastSender extends AppCompatActivity {
    public static final String header = "Text Broadcast Sender";
    public static final String EXTRA_TEXT = "EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_broadcast_sender);
        TextView textViewHeader = findViewById(R.id.viewTextSender);
        textViewHeader.setText(header);
        Button button = findViewById(R.id.buttonTextSender);
        button.setOnClickListener(view -> textSubmit());

        Button back = findViewById(R.id.backTextSender);
        back.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));

    }

    private void textSubmit() {
        EditText editText = findViewById(R.id.editTextSender);
        if (editText.toString().equals(" ")) return;
        Intent intent = new Intent(this, TextBroadcastReceiver.class);
        String text = editText.getText().toString();
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
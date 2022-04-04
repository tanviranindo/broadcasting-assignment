package com.assignment.broadcasting_assignment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SystemBroadcastReceiver extends AppCompatActivity {
    public static final String header = "Battery Broadcast Receiver";
    public static String text = "null";
    private TextView batteryOutput;
    private TextView chargingOutput;
    private TextView differenceOutput;
    private TextView batteryHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_broadcast_receiver);

        TextView textViewHeader = findViewById(R.id.viewBatteryReceiver);
        textViewHeader.setText(header);

        text = getIntent().getStringExtra(SystemBroadcastSender.EXTRA_TEXT) + " %";
        TextView userInput = findViewById(R.id.batteryOutput);
        userInput.setText(text);

        TextView textView = findViewById(R.id.systemOutput);
        textView.setText(text);

        batteryOutput = findViewById(R.id.systemOutput);
        registerReceiver(this.batteryLevel, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        chargingOutput = findViewById(R.id.chargingOutput);
        registerReceiver(this.chargingStatus, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        differenceOutput = findViewById(R.id.outputDifference);

        batteryHealth = findViewById(R.id.batteryHealth);

        Button back = findViewById(R.id.backBatteryReceiver);
        back.setOnClickListener(view -> startActivity(new Intent(view.getContext(), SystemBroadcastSender.class)));
    }

    private final BroadcastReceiver batteryLevel = new BroadcastReceiver() {
        @SuppressLint({"SetTextI18n", "SuspiciousIndentation"})
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float percentage = level * 100 / (float) scale;
            batteryOutput.setText(percentage + " %");

            try {
                String output;
                output = getIntent().getStringExtra(SystemBroadcastSender.EXTRA_TEXT);
                float userInputFloat = Float.parseFloat(output);
                differenceOutput.setText(userInputFloat == percentage ? "Wow! You predicted right." : userInputFloat > percentage ? "Your system has less battery level than you expected." : "Your system has more battery level than you expected.");
            } catch (Exception e) {
                differenceOutput.setText("Your input format is incorrect.");
            }
        }
    };

    private final BroadcastReceiver chargingStatus = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
            switch (status) {
                case BatteryManager.BATTERY_STATUS_FULL:
                    chargingOutput.setText("Battery Full");
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    chargingOutput.setText("Charging");
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    chargingOutput.setText("Not Charging");
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    chargingOutput.setText("Discharging");
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    chargingOutput.setText("Unknown");
                    break;
            }

            int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
            switch (deviceHealth) {
                case BatteryManager.BATTERY_HEALTH_COLD:
                    batteryHealth.setText("Cold");
                    break;
                case BatteryManager.BATTERY_HEALTH_DEAD:
                    batteryHealth.setText("Dead");
                    break;
                case BatteryManager.BATTERY_HEALTH_GOOD:
                    batteryHealth.setText("Good");
                    break;
                case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                    batteryHealth.setText("Overheated");
                    break;
                case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                    batteryHealth.setText("Over voltage");
                    break;
                case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                    batteryHealth.setText("Unknown");
                    break;
                case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                    batteryHealth.setText("Failure");
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Broadcast Received: " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
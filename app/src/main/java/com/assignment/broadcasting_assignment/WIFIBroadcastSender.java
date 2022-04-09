package com.assignment.broadcasting_assignment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class WIFIBroadcastSender extends AppCompatActivity {

    public static final String header = "WIFI RTT Broadcast Receiver";
    SwitchMaterial wifiSwitch;
    TextView connectionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifibroadcast_sender);
        TextView textViewHeader = findViewById(R.id.wifiRTTBroadcast);
        textViewHeader.setText(header);

        wifiSwitch = findViewById(R.id.wifi_switch);
        connectionStatus = findViewById(R.id.networkStatus);

        wifiSwitch.setOnCheckedChangeListener((compoundButton, status) -> toggleWiFi(status));
        Button back = findViewById(R.id.backWifiSender);
        back.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));

    }

    private void toggleWiFi(boolean status) {

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
            if (status && !wifiManager.isWifiEnabled()) {
                startActivityForResult(panelIntent, 0);
                Toast.makeText(getApplicationContext(), "Turning on Wi-Fi", Toast.LENGTH_SHORT).show();
            } else if (!status && wifiManager.isWifiEnabled()) {
                startActivityForResult(panelIntent, 1);
                Toast.makeText(getApplicationContext(), "Turning off Wi-Fi", Toast.LENGTH_SHORT).show();
            }
        } else {

            if (status && !wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
                Toast.makeText(getApplicationContext(), "Turning on Wi-Fi", Toast.LENGTH_SHORT).show();
            } else if (!status && wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
                Toast.makeText(getApplicationContext(), "Turning off Wi-Fi", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter wifiFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        IntentFilter connectFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(wifiStateReceiver, wifiFilter);
        registerReceiver(internetStateReceiver, connectFilter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
        unregisterReceiver(internetStateReceiver);
    }

    private final BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (state) {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setChecked(true);
                    wifiSwitch.setText("Wi-Fi is ON");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setChecked(false);
                    wifiSwitch.setText("Wi-Fi is OFF");
                    break;
            }
        }
    };

    private final BroadcastReceiver internetStateReceiver = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                connectionStatus.setText("Internet is connected");
                Toast.makeText(getApplicationContext(), "Internet is connected", Toast.LENGTH_SHORT).show();
            } else {
                connectionStatus.setText("No Internet");
                Toast.makeText(getApplicationContext(), "Network is disconnected", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
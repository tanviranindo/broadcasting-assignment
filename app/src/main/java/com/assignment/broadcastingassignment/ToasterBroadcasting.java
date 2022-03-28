package com.assignment.broadcastingassignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ToasterBroadcasting extends BroadcastReceiver {

    public static String string = "default";

    @Override
    public void onReceive(Context context, Intent intent) {
        string = "Broadcast Received: " + TextBroadcastReceiver.text;
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
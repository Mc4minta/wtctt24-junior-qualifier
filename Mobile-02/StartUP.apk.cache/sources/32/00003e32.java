package com.learnium.RNDeviceInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.appsflyer.internal.referrer.Payload;

/* loaded from: classes2.dex */
public class RNDeviceReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            SharedPreferences.Editor edit = context.getSharedPreferences("react-native-device-info", 0).edit();
            edit.putString("installReferrer", intent.getStringExtra(Payload.REFERRER));
            edit.apply();
        }
    }
}
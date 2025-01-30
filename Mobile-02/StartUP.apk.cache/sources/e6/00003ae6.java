package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class d0 extends BroadcastReceiver {
    private e0 a;

    public d0(e0 e0Var) {
        this.a = e0Var;
    }

    public final void a() {
        if (FirebaseInstanceId.y()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        e0 e0Var = this.a;
        if (e0Var != null && e0Var.b()) {
            if (FirebaseInstanceId.y()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.q(this.a, 0L);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}
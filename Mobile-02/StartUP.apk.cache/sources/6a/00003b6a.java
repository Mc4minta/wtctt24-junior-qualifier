package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
final class x extends BroadcastReceiver {
    private y a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ y f9289b;

    public x(y yVar, y yVar2) {
        this.f9289b = yVar;
        this.a = yVar2;
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        boolean f2;
        boolean h2;
        v vVar;
        y yVar = this.a;
        if (yVar == null) {
            return;
        }
        f2 = yVar.f();
        if (f2) {
            h2 = y.h();
            if (h2) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            vVar = this.a.f9295g;
            vVar.f(this.a, 0L);
            context.unregisterReceiver(this);
            this.a = null;
        }
    }
}
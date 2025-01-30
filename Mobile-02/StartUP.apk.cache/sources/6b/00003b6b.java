package com.google.firebase.messaging;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import org.spongycastle.crypto.tls.CipherSuite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class y implements Runnable {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f9290b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f9291c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f9292d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.iid.q f9293e;

    /* renamed from: f  reason: collision with root package name */
    private final PowerManager.WakeLock f9294f;

    /* renamed from: g  reason: collision with root package name */
    private final v f9295g;

    /* renamed from: h  reason: collision with root package name */
    private final long f9296h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, Context context, com.google.firebase.iid.q qVar, long j2) {
        this.f9295g = vVar;
        this.f9292d = context;
        this.f9296h = j2;
        this.f9293e = qVar;
        this.f9294f = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static boolean b(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (a) {
            Boolean bool = f9290b;
            if (bool == null) {
                booleanValue = c(context, "android.permission.WAKE_LOCK", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f9290b = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    private static boolean c(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA);
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean f() {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f9292d.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            z = activeNetworkInfo.isConnected();
        }
        return z;
    }

    private static boolean g(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (a) {
            Boolean bool = f9291c;
            if (bool == null) {
                booleanValue = c(context, "android.permission.ACCESS_NETWORK_STATE", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            f9291c = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
        android.util.Log.d("FirebaseMessaging", "Connectivity change received registered");
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"Wakelock"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.y.run():void");
    }
}
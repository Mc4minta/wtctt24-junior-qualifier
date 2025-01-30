package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.coinbase.ApiConstants;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class e0 implements Runnable {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f9150b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f9151c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(FirebaseInstanceId firebaseInstanceId, long j2) {
        this.f9151c = firebaseInstanceId;
        this.a = j2;
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f9150b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private final boolean c() throws IOException {
        a0 u = this.f9151c.u();
        boolean z = true;
        if (this.f9151c.t(u)) {
            try {
                String x = this.f9151c.x();
                if (x == null) {
                    Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                    return false;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Token successfully retrieved");
                }
                if ((u == null || !x.equals(u.f9128b)) && "[DEFAULT]".equals(this.f9151c.k().i())) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(this.f9151c.k().i());
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                    }
                    Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                    intent.putExtra(ApiConstants.TOKEN, x);
                    Context a = a();
                    Intent intent2 = new Intent(a, FirebaseInstanceIdReceiver.class);
                    intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                    intent2.putExtra("wrapped_intent", intent);
                    a.sendBroadcast(intent2);
                }
                return true;
            } catch (IOException e2) {
                String message = e2.getMessage();
                if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                    z = false;
                }
                if (z) {
                    String message2 = e2.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
                    sb.append("Token retrieval failed: ");
                    sb.append(message2);
                    sb.append(". Will retry token retrieval");
                    Log.w("FirebaseInstanceId", sb.toString());
                    return false;
                } else if (e2.getMessage() == null) {
                    Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                    return false;
                } else {
                    throw e2;
                }
            } catch (SecurityException unused) {
                Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.f9151c.k().g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        if (y.b().c(a())) {
            this.f9150b.acquire();
        }
        try {
            try {
                this.f9151c.s(true);
                if (!this.f9151c.A()) {
                    this.f9151c.s(false);
                    if (y.b().c(a())) {
                        this.f9150b.release();
                    }
                } else if (y.b().f(a()) && !b()) {
                    new d0(this).a();
                    if (y.b().c(a())) {
                        this.f9150b.release();
                    }
                } else {
                    if (c()) {
                        this.f9151c.s(false);
                    } else {
                        this.f9151c.o(this.a);
                    }
                    if (y.b().c(a())) {
                        this.f9150b.release();
                    }
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.f9151c.s(false);
                if (y.b().c(a())) {
                    this.f9150b.release();
                }
            }
        } catch (Throwable th) {
            if (y.b().c(a())) {
                this.f9150b.release();
            }
            throw th;
        }
    }
}
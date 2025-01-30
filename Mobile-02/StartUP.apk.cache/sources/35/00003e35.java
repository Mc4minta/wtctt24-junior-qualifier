package com.learnium.RNDeviceInfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.appsflyer.internal.referrer.Payload;
import e.c.a.a.d;
import java.io.PrintStream;

/* compiled from: RNInstallReferrerClient.java */
/* loaded from: classes2.dex */
public class c {
    private SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    private e.c.a.a.a f10456b;

    /* renamed from: c  reason: collision with root package name */
    private e.c.a.a.c f10457c = new a();

    /* compiled from: RNInstallReferrerClient.java */
    /* loaded from: classes2.dex */
    class a implements e.c.a.a.c {
        a() {
        }

        @Override // e.c.a.a.c
        public void onInstallReferrerServiceDisconnected() {
            Log.d("RNInstallReferrerClient", "InstallReferrerService disconnected");
        }

        @Override // e.c.a.a.c
        public void onInstallReferrerSetupFinished(int i2) {
            if (i2 != 0) {
                if (i2 == 1) {
                    Log.d("InstallReferrerState", Payload.RESPONSE_SERVICE_UNAVAILABLE);
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    Log.d("InstallReferrerState", Payload.RESPONSE_FEATURE_NOT_SUPPORTED);
                    return;
                }
            }
            try {
                Log.d("InstallReferrerState", Payload.RESPONSE_OK);
                d b2 = c.this.f10456b.b();
                b2.c();
                b2.d();
                b2.b();
                SharedPreferences.Editor edit = c.this.a.edit();
                edit.putString("installReferrer", c.this.d());
                edit.apply();
                c.this.f10456b.a();
            } catch (Exception e2) {
                PrintStream printStream = System.err;
                printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e2.getMessage());
                e2.printStackTrace(System.err);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context.getSharedPreferences("react-native-device-info", 0);
        e.c.a.a.a a2 = e.c.a.a.a.d(context).a();
        this.f10456b = a2;
        try {
            a2.e(this.f10457c);
        } catch (Exception e2) {
            PrintStream printStream = System.err;
            printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e2.getMessage());
            e2.printStackTrace(System.err);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        try {
            return this.f10456b.b().c();
        } catch (Exception e2) {
            PrintStream printStream = System.err;
            printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e2.getMessage());
            e2.printStackTrace(System.err);
            return null;
        }
    }
}
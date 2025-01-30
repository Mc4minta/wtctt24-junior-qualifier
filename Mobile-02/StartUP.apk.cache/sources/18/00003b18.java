package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import org.apache.http.HttpStatus;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class y {
    private static y a;

    /* renamed from: b  reason: collision with root package name */
    private String f9195b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f9196c = null;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f9197d = null;

    /* renamed from: e  reason: collision with root package name */
    private final Queue<Intent> f9198e = new ArrayDeque();

    private y() {
    }

    public static synchronized y b() {
        y yVar;
        synchronized (y.class) {
            if (a == null) {
                a = new y();
            }
            yVar = a;
        }
        return yVar;
    }

    private final int d(Context context, Intent intent) {
        ComponentName startService;
        String g2 = g(context, intent);
        if (g2 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", g2.length() != 0 ? "Restricting intent to a specific service: ".concat(g2) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), g2);
        }
        try {
            if (c(context)) {
                startService = g0.a(context, intent);
            } else {
                startService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startService == null) {
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return HttpStatus.SC_NOT_FOUND;
            }
            return -1;
        } catch (IllegalStateException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf);
            Log.e("FirebaseInstanceId", sb.toString());
            return HttpStatus.SC_PAYMENT_REQUIRED;
        } catch (SecurityException e3) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e3);
            return HttpStatus.SC_UNAUTHORIZED;
        }
    }

    private final synchronized String g(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.f9195b;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(serviceInfo.name);
                    this.f9195b = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                } else {
                    this.f9195b = serviceInfo.name;
                }
                return this.f9195b;
            }
            String str3 = serviceInfo.packageName;
            String str4 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str3);
            sb.append("/");
            sb.append(str4);
            Log.e("FirebaseInstanceId", sb.toString());
            return null;
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    public final int a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        this.f9198e.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return d(context, intent2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(Context context) {
        if (this.f9196c == null) {
            this.f9196c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f9196c.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f9196c.booleanValue();
    }

    public final Intent e() {
        return this.f9198e.poll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(Context context) {
        if (this.f9197d == null) {
            this.f9197d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f9196c.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f9197d.booleanValue();
    }
}
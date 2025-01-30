package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class b0 {
    private final SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9134b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Long> f9135c = new c.e.a();

    public b0(Context context) {
        this.f9134b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(androidx.core.content.a.i(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || f()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            c();
            FirebaseInstanceId.c().z();
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    private final synchronized boolean f() {
        return this.a.getAll().isEmpty();
    }

    private static String g(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private final long i(String str) {
        String string = this.a.getString(b(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public final synchronized a0 a(String str, String str2, String str3) {
        return a0.a(this.a.getString(g(str, str2, str3), null));
    }

    public final synchronized void c() {
        this.f9135c.clear();
        this.a.edit().clear().commit();
    }

    public final synchronized void d(String str, String str2, String str3, String str4, String str5) {
        String c2 = a0.c(str4, str5, System.currentTimeMillis());
        if (c2 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(g(str, str2, str3), c2);
        edit.commit();
    }

    public final synchronized long e(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.a.contains(b(str, "cre"))) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(b(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = i(str);
        }
        this.f9135c.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    public final synchronized void h(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.a.edit();
        for (String str2 : this.a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
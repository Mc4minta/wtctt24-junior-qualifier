package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class c {
    private static final Lock a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private static c f5999b;

    /* renamed from: c  reason: collision with root package name */
    private final Lock f6000c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f6001d;

    private c(Context context) {
        this.f6001d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c b(Context context) {
        com.google.android.gms.common.internal.t.k(context);
        Lock lock = a;
        lock.lock();
        try {
            if (f5999b == null) {
                f5999b = new c(context.getApplicationContext());
            }
            c cVar = f5999b;
            lock.unlock();
            return cVar;
        } catch (Throwable th) {
            a.unlock();
            throw th;
        }
    }

    private final void g(String str, String str2) {
        this.f6000c.lock();
        try {
            this.f6001d.edit().putString(str, str2).apply();
        } finally {
            this.f6000c.unlock();
        }
    }

    private static String h(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    private final GoogleSignInAccount i(String str) {
        String k2;
        if (!TextUtils.isEmpty(str) && (k2 = k(h("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.s1(k2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final GoogleSignInOptions j(String str) {
        String k2;
        if (!TextUtils.isEmpty(str) && (k2 = k(h("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.r1(k2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String k(String str) {
        this.f6000c.lock();
        try {
            return this.f6001d.getString(str, null);
        } finally {
            this.f6000c.unlock();
        }
    }

    public void a() {
        this.f6000c.lock();
        try {
            this.f6001d.edit().clear().apply();
        } finally {
            this.f6000c.unlock();
        }
    }

    public GoogleSignInAccount c() {
        return i(k("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions d() {
        return j(k("defaultGoogleSignInAccount"));
    }

    public String e() {
        return k("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        com.google.android.gms.common.internal.t.k(googleSignInAccount);
        com.google.android.gms.common.internal.t.k(googleSignInOptions);
        g("defaultGoogleSignInAccount", googleSignInAccount.u1());
        com.google.android.gms.common.internal.t.k(googleSignInAccount);
        com.google.android.gms.common.internal.t.k(googleSignInOptions);
        String u1 = googleSignInAccount.u1();
        g(h("googleSignInAccount", u1), googleSignInAccount.v1());
        g(h("googleSignInOptions", u1), googleSignInOptions.x1());
    }
}
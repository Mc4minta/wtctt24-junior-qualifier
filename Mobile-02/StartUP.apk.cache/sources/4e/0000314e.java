package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.t;
import java.io.IOException;

/* loaded from: classes2.dex */
public class c {
    private static final String[] a = {"com.google", "com.google.work", "cn.google"};
    @SuppressLint({"InlinedApi"})

    /* renamed from: b  reason: collision with root package name */
    public static final String f6024b = "callerUid";
    @SuppressLint({"InlinedApi"})

    /* renamed from: c  reason: collision with root package name */
    public static final String f6025c = "androidPackageName";

    /* renamed from: d  reason: collision with root package name */
    private static final ComponentName f6026d = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");

    /* renamed from: e  reason: collision with root package name */
    private static final com.google.android.gms.common.l.a f6027e = new com.google.android.gms.common.l.a("Auth", "GoogleAuthUtil");

    private static void a(Context context, int i2) throws GoogleAuthException {
        try {
            h.a(context.getApplicationContext(), i2);
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        } catch (GooglePlayServicesRepairableException e3) {
            throw new GooglePlayServicesAvailabilityException(e3.b(), e3.getMessage(), e3.a());
        }
    }

    public static String b(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return c(context, account, str, new Bundle());
    }

    public static String c(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        k(account);
        return i(context, account, str, bundle).j1();
    }

    @Deprecated
    public static String d(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return b(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static void e(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    private static <T> T g(Context context, ComponentName componentName, e<T> eVar) throws IOException, GoogleAuthException {
        com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
        i b2 = i.b(context);
        try {
            if (b2.a(componentName, aVar, "GoogleAuthUtil")) {
                try {
                    return eVar.a(aVar.a());
                } catch (RemoteException | InterruptedException e2) {
                    f6027e.d("GoogleAuthUtil", "Error on service connection.", e2);
                    throw new IOException("Error on service connection.", e2);
                }
            }
            throw new IOException("Could not bind to service.");
        } finally {
            b2.c(componentName, aVar, "GoogleAuthUtil");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T h(T t) throws IOException {
        if (t != null) {
            return t;
        }
        f6027e.f("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    public static TokenData i(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        t.j("Calling this from your main thread can lead to deadlock");
        t.h(str, "Scope cannot be empty or null.");
        k(account);
        a(context, 8400000);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        String str3 = f6025c;
        if (TextUtils.isEmpty(bundle2.getString(str3))) {
            bundle2.putString(str3, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) g(context, f6026d, new d(account, str, bundle2));
    }

    private static void k(Account account) {
        if (account != null) {
            if (!TextUtils.isEmpty(account.name)) {
                for (String str : a) {
                    if (str.equals(account.type)) {
                        return;
                    }
                }
                throw new IllegalArgumentException("Account type not supported");
            }
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        throw new IllegalArgumentException("Account cannot be null");
    }
}
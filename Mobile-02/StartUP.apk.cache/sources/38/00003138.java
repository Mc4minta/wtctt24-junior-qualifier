package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class o {
    private static o a;

    /* renamed from: b  reason: collision with root package name */
    private c f6004b;

    /* renamed from: c  reason: collision with root package name */
    private GoogleSignInAccount f6005c;

    /* renamed from: d  reason: collision with root package name */
    private GoogleSignInOptions f6006d;

    private o(Context context) {
        c b2 = c.b(context);
        this.f6004b = b2;
        this.f6005c = b2.c();
        this.f6006d = this.f6004b.d();
    }

    public static synchronized o c(Context context) {
        o d2;
        synchronized (o.class) {
            d2 = d(context.getApplicationContext());
        }
        return d2;
    }

    private static synchronized o d(Context context) {
        synchronized (o.class) {
            o oVar = a;
            if (oVar != null) {
                return oVar;
            }
            o oVar2 = new o(context);
            a = oVar2;
            return oVar2;
        }
    }

    public final synchronized void a() {
        this.f6004b.a();
        this.f6005c = null;
        this.f6006d = null;
    }

    public final synchronized void b(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f6004b.f(googleSignInAccount, googleSignInOptions);
        this.f6005c = googleSignInAccount;
        this.f6006d = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount e() {
        return this.f6005c;
    }
}
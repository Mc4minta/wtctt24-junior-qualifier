package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.internal.measurement.bd;
import com.google.android.gms.measurement.internal.b5;
import com.google.android.gms.measurement.internal.e7;
import com.google.android.gms.measurement.internal.ja;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics a;

    /* renamed from: b  reason: collision with root package name */
    private final b5 f8566b;

    /* renamed from: c  reason: collision with root package name */
    private final bd f8567c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8568d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f8569e;

    private FirebaseAnalytics(b5 b5Var) {
        t.k(b5Var);
        this.f8566b = b5Var;
        this.f8567c = null;
        this.f8568d = false;
        this.f8569e = new Object();
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (a == null) {
                    if (bd.B(context)) {
                        a = new FirebaseAnalytics(bd.c(context));
                    } else {
                        a = new FirebaseAnalytics(b5.a(context, null, null));
                    }
                }
            }
        }
        return a;
    }

    @Keep
    public static e7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        bd d2;
        if (bd.B(context) && (d2 = bd.d(context, null, null, null, bundle)) != null) {
            return new b(d2);
        }
        return null;
    }

    public final void a(String str, Bundle bundle) {
        if (this.f8568d) {
            this.f8567c.o(str, bundle);
        } else {
            this.f8566b.G().T("app", str, bundle, true);
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.c().b();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f8568d) {
            this.f8567c.h(activity, str, str2);
        } else if (!ja.a()) {
            this.f8566b.f().K().a("setCurrentScreen must be called from the main thread");
        } else {
            this.f8566b.P().G(activity, str, str2);
        }
    }

    private FirebaseAnalytics(bd bdVar) {
        t.k(bdVar);
        this.f8566b = null;
        this.f8567c = bdVar;
        this.f8568d = true;
        this.f8569e = new Object();
    }
}
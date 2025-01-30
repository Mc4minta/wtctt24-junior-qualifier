package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.o;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.t;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class a {
    public static c a(Activity activity, GoogleSignInOptions googleSignInOptions) {
        return new c(activity, (GoogleSignInOptions) t.k(googleSignInOptions));
    }

    public static c b(Context context, GoogleSignInOptions googleSignInOptions) {
        return new c(context, (GoogleSignInOptions) t.k(googleSignInOptions));
    }

    public static GoogleSignInAccount c(Context context) {
        return o.c(context).e();
    }

    public static com.google.android.gms.tasks.g<GoogleSignInAccount> d(Intent intent) {
        d a = com.google.android.gms.auth.api.signin.internal.i.a(intent);
        if (a == null) {
            return com.google.android.gms.tasks.j.d(com.google.android.gms.common.internal.b.a(Status.f6034c));
        }
        GoogleSignInAccount a2 = a.a();
        if (a.getStatus().l1() && a2 != null) {
            return com.google.android.gms.tasks.j.e(a2);
        }
        return com.google.android.gms.tasks.j.d(com.google.android.gms.common.internal.b.a(a.getStatus()));
    }
}
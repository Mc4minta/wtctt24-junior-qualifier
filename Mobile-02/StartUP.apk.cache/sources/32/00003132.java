package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class i {
    private static com.google.android.gms.common.l.a a = new com.google.android.gms.common.l.a("GoogleSignInCommon", new String[0]);

    public static com.google.android.gms.auth.api.signin.d a(Intent intent) {
        if (intent == null) {
            return new com.google.android.gms.auth.api.signin.d(null, Status.f6034c);
        }
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount == null) {
            if (status == null) {
                status = Status.f6034c;
            }
            return new com.google.android.gms.auth.api.signin.d(null, status);
        }
        return new com.google.android.gms.auth.api.signin.d(googleSignInAccount, Status.a);
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static com.google.android.gms.common.api.e<Status> c(com.google.android.gms.common.api.d dVar, Context context, boolean z) {
        a.a("Signing out", new Object[0]);
        d(context);
        if (z) {
            return com.google.android.gms.common.api.f.b(Status.a, dVar);
        }
        return dVar.b(new l(dVar));
    }

    private static void d(Context context) {
        o.c(context).a();
        for (com.google.android.gms.common.api.d dVar : com.google.android.gms.common.api.d.c()) {
            dVar.f();
        }
        com.google.android.gms.common.api.internal.f.a();
    }

    public static Intent e(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getFallbackSignInIntent()", new Object[0]);
        Intent b2 = b(context, googleSignInOptions);
        b2.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return b2;
    }

    public static com.google.android.gms.common.api.e<Status> f(com.google.android.gms.common.api.d dVar, Context context, boolean z) {
        a.a("Revoking access", new Object[0]);
        String e2 = c.b(context).e();
        d(context);
        if (z) {
            return e.a(e2);
        }
        return dVar.b(new n(dVar));
    }

    public static Intent g(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getNoImplementationSignInIntent()", new Object[0]);
        Intent b2 = b(context, googleSignInOptions);
        b2.setAction("com.google.android.gms.auth.NO_IMPL");
        return b2;
    }
}
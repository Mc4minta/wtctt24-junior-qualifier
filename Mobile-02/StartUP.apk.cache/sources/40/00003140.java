package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class w extends q {
    private final Context a;

    public w(Context context) {
        this.a = context;
    }

    private final void p() {
        if (com.google.android.gms.common.util.o.a(this.a, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }

    @Override // com.google.android.gms.auth.api.signin.internal.r
    public final void h() {
        p();
        o.c(this.a).a();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.r
    public final void i() {
        p();
        c b2 = c.b(this.a);
        GoogleSignInAccount c2 = b2.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f5967f;
        if (c2 != null) {
            googleSignInOptions = b2.d();
        }
        com.google.android.gms.auth.api.signin.c b3 = com.google.android.gms.auth.api.signin.a.b(this.a, googleSignInOptions);
        if (c2 != null) {
            b3.p();
        } else {
            b3.q();
        }
    }
}
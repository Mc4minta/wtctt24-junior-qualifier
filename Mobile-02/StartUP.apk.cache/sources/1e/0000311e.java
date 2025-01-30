package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public class c extends com.google.android.gms.common.api.c<GoogleSignInOptions> {

    /* renamed from: j  reason: collision with root package name */
    private static final a f5983j = new a(null);

    /* renamed from: k  reason: collision with root package name */
    private static int f5984k = b.a;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* loaded from: classes2.dex */
    private static class a implements s.a<d, GoogleSignInAccount> {
        private a() {
        }

        @Override // com.google.android.gms.common.internal.s.a
        public final /* synthetic */ GoogleSignInAccount a(d dVar) {
            return dVar.a();
        }

        /* synthetic */ a(i iVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* loaded from: classes2.dex */
    public enum b {
        public static final int a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5985b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5986c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5987d = 4;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ int[] f5988e = {1, 2, 3, 4};

        public static int[] a() {
            return (int[]) f5988e.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, com.google.android.gms.auth.b.a.f6012g, googleSignInOptions, new com.google.android.gms.common.api.internal.a());
    }

    private final synchronized int r() {
        if (f5984k == b.a) {
            Context i2 = i();
            com.google.android.gms.common.e o = com.google.android.gms.common.e.o();
            int h2 = o.h(i2, com.google.android.gms.common.h.a);
            if (h2 == 0) {
                f5984k = b.f5987d;
            } else if (o.b(i2, h2, null) == null && DynamiteModule.a(i2, "com.google.android.gms.auth.api.fallback") != 0) {
                f5984k = b.f5986c;
            } else {
                f5984k = b.f5985b;
            }
        }
        return f5984k;
    }

    public Intent o() {
        Context i2 = i();
        int i3 = i.a[r() - 1];
        if (i3 != 1) {
            if (i3 != 2) {
                return com.google.android.gms.auth.api.signin.internal.i.g(i2, h());
            }
            return com.google.android.gms.auth.api.signin.internal.i.b(i2, h());
        }
        return com.google.android.gms.auth.api.signin.internal.i.e(i2, h());
    }

    public com.google.android.gms.tasks.g<Void> p() {
        return s.c(com.google.android.gms.auth.api.signin.internal.i.f(b(), i(), r() == b.f5986c));
    }

    public com.google.android.gms.tasks.g<Void> q() {
        return s.c(com.google.android.gms.auth.api.signin.internal.i.c(b(), i(), r() == b.f5986c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, com.google.android.gms.auth.b.a.f6012g, googleSignInOptions, (n) new com.google.android.gms.common.api.internal.a());
    }
}
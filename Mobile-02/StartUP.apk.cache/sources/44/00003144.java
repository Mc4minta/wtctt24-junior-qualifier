package com.google.android.gms.auth.b;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.j;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.r;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class a {
    public static final a.g<e.g.a.e.d.b.g> a;

    /* renamed from: b  reason: collision with root package name */
    public static final a.g<j> f6007b;

    /* renamed from: c  reason: collision with root package name */
    private static final a.AbstractC0138a<e.g.a.e.d.b.g, C0136a> f6008c;

    /* renamed from: d  reason: collision with root package name */
    private static final a.AbstractC0138a<j, GoogleSignInOptions> f6009d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<c> f6010e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<C0136a> f6011f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<GoogleSignInOptions> f6012g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.android.gms.auth.b.e.a f6013h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.android.gms.auth.b.d.a f6014i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.android.gms.auth.api.signin.b f6015j;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    @Deprecated
    /* renamed from: com.google.android.gms.auth.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0136a implements a.d {
        public static final C0136a a = new C0137a().b();

        /* renamed from: b  reason: collision with root package name */
        private final String f6016b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f6017c;

        /* renamed from: d  reason: collision with root package name */
        private final String f6018d;

        public C0136a(C0137a c0137a) {
            this.f6016b = c0137a.a;
            this.f6017c = c0137a.f6019b.booleanValue();
            this.f6018d = c0137a.f6020c;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.f6016b);
            bundle.putBoolean("force_save_dialog", this.f6017c);
            bundle.putString("log_session_id", this.f6018d);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0136a) {
                C0136a c0136a = (C0136a) obj;
                return r.a(this.f6016b, c0136a.f6016b) && this.f6017c == c0136a.f6017c && r.a(this.f6018d, c0136a.f6018d);
            }
            return false;
        }

        public int hashCode() {
            return r.b(this.f6016b, Boolean.valueOf(this.f6017c), this.f6018d);
        }

        /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
        @Deprecated
        /* renamed from: com.google.android.gms.auth.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0137a {
            protected String a;

            /* renamed from: b  reason: collision with root package name */
            protected Boolean f6019b;

            /* renamed from: c  reason: collision with root package name */
            protected String f6020c;

            public C0137a() {
                this.f6019b = Boolean.FALSE;
            }

            public C0137a a(String str) {
                this.f6020c = str;
                return this;
            }

            public C0136a b() {
                return new C0136a(this);
            }

            public C0137a(C0136a c0136a) {
                this.f6019b = Boolean.FALSE;
                this.a = c0136a.f6016b;
                this.f6019b = Boolean.valueOf(c0136a.f6017c);
                this.f6020c = c0136a.f6018d;
            }
        }
    }

    static {
        a.g<e.g.a.e.d.b.g> gVar = new a.g<>();
        a = gVar;
        a.g<j> gVar2 = new a.g<>();
        f6007b = gVar2;
        g gVar3 = new g();
        f6008c = gVar3;
        h hVar = new h();
        f6009d = hVar;
        f6010e = b.f6022c;
        f6011f = new com.google.android.gms.common.api.a<>("Auth.CREDENTIALS_API", gVar3, gVar);
        f6012g = new com.google.android.gms.common.api.a<>("Auth.GOOGLE_SIGN_IN_API", hVar, gVar2);
        f6013h = b.f6023d;
        f6014i = new e.g.a.e.d.b.f();
        f6015j = new com.google.android.gms.auth.api.signin.internal.g();
    }
}
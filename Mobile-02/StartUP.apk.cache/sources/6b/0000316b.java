package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.a0;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.i0;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.t;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class c<O extends a.d> {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f6045b;

    /* renamed from: c  reason: collision with root package name */
    private final O f6046c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.b<O> f6047d;

    /* renamed from: e  reason: collision with root package name */
    private final Looper f6048e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6049f;

    /* renamed from: g  reason: collision with root package name */
    private final d f6050g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.n f6051h;

    /* renamed from: i  reason: collision with root package name */
    protected final com.google.android.gms.common.api.internal.f f6052i;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static class a {
        public static final a a = new C0140a().a();

        /* renamed from: b  reason: collision with root package name */
        public final com.google.android.gms.common.api.internal.n f6053b;

        /* renamed from: c  reason: collision with root package name */
        public final Looper f6054c;

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* renamed from: com.google.android.gms.common.api.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0140a {
            private com.google.android.gms.common.api.internal.n a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f6055b;

            public a a() {
                if (this.a == null) {
                    this.a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f6055b == null) {
                    this.f6055b = Looper.getMainLooper();
                }
                return new a(this.a, this.f6055b);
            }

            public C0140a b(Looper looper) {
                t.l(looper, "Looper must not be null.");
                this.f6055b = looper;
                return this;
            }

            public C0140a c(com.google.android.gms.common.api.internal.n nVar) {
                t.l(nVar, "StatusExceptionMapper must not be null.");
                this.a = nVar;
                return this;
            }
        }

        private a(com.google.android.gms.common.api.internal.n nVar, Account account, Looper looper) {
            this.f6053b = nVar;
            this.f6054c = looper;
        }
    }

    public c(Activity activity, com.google.android.gms.common.api.a<O> aVar, O o, a aVar2) {
        t.l(activity, "Null activity is not permitted.");
        t.l(aVar, "Api must not be null.");
        t.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.a = applicationContext;
        this.f6045b = aVar;
        this.f6046c = o;
        this.f6048e = aVar2.f6054c;
        com.google.android.gms.common.api.internal.b<O> b2 = com.google.android.gms.common.api.internal.b.b(aVar, o);
        this.f6047d = b2;
        this.f6050g = new a0(this);
        com.google.android.gms.common.api.internal.f h2 = com.google.android.gms.common.api.internal.f.h(applicationContext);
        this.f6052i = h2;
        this.f6049f = h2.k();
        this.f6051h = aVar2.f6053b;
        if (!(activity instanceof GoogleApiActivity)) {
            r.q(activity, h2, b2);
        }
        h2.d(this);
    }

    private final <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends i, A>> T m(int i2, T t) {
        t.m();
        this.f6052i.e(this, i2, t);
        return t;
    }

    public d b() {
        return this.f6050g;
    }

    protected d.a c() {
        Account m;
        Set<Scope> emptySet;
        GoogleSignInAccount k0;
        GoogleSignInAccount k02;
        d.a aVar = new d.a();
        O o = this.f6046c;
        if ((o instanceof a.d.b) && (k02 = ((a.d.b) o).k0()) != null) {
            m = k02.m();
        } else {
            O o2 = this.f6046c;
            m = o2 instanceof a.d.InterfaceC0139a ? ((a.d.InterfaceC0139a) o2).m() : null;
        }
        d.a c2 = aVar.c(m);
        O o3 = this.f6046c;
        if ((o3 instanceof a.d.b) && (k0 = ((a.d.b) o3).k0()) != null) {
            emptySet = k0.p1();
        } else {
            emptySet = Collections.emptySet();
        }
        return c2.a(emptySet).d(this.a.getClass().getName()).e(this.a.getPackageName());
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends i, A>> T d(T t) {
        return (T) m(2, t);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends i, A>> T e(T t) {
        return (T) m(0, t);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends i, A>> T f(T t) {
        return (T) m(1, t);
    }

    public com.google.android.gms.common.api.internal.b<O> g() {
        return this.f6047d;
    }

    public O h() {
        return this.f6046c;
    }

    public Context i() {
        return this.a;
    }

    public final int j() {
        return this.f6049f;
    }

    public Looper k() {
        return this.f6048e;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.a$f] */
    public a.f l(Looper looper, f.a<O> aVar) {
        return this.f6045b.c().a(this.a, looper, c().b(), this.f6046c, aVar, aVar);
    }

    public i0 n(Context context, Handler handler) {
        return new i0(context, handler, c().b());
    }

    public c(Context context, com.google.android.gms.common.api.a<O> aVar, O o, a aVar2) {
        t.l(context, "Null context is not permitted.");
        t.l(aVar, "Api must not be null.");
        t.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f6045b = aVar;
        this.f6046c = o;
        this.f6048e = aVar2.f6054c;
        this.f6047d = com.google.android.gms.common.api.internal.b.b(aVar, o);
        this.f6050g = new a0(this);
        com.google.android.gms.common.api.internal.f h2 = com.google.android.gms.common.api.internal.f.h(applicationContext);
        this.f6052i = h2;
        this.f6049f = h2.k();
        this.f6051h = aVar2.f6053b;
        h2.d(this);
    }

    @Deprecated
    public c(Activity activity, com.google.android.gms.common.api.a<O> aVar, O o, com.google.android.gms.common.api.internal.n nVar) {
        this(activity, (com.google.android.gms.common.api.a) aVar, (a.d) o, new a.C0140a().c(nVar).b(activity.getMainLooper()).a());
    }

    @Deprecated
    public c(Context context, com.google.android.gms.common.api.a<O> aVar, O o, com.google.android.gms.common.api.internal.n nVar) {
        this(context, aVar, o, new a.C0140a().c(nVar).a());
    }
}
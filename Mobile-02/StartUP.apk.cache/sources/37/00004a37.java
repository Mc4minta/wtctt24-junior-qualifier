package e.j.l.n;

import android.content.Context;
import android.os.Build;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;

/* compiled from: BiometricHelper.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class a implements b {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final h f13720b;

    /* compiled from: BiometricHelper.kt */
    /* renamed from: e.j.l.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0326a extends o implements kotlin.e0.c.a<c.h.f.a.a> {
        C0326a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final c.h.f.a.a invoke() {
            return c.h.f.a.a.b(a.this.a);
        }
    }

    public a(Context context) {
        h b2;
        m.g(context, "context");
        this.a = context;
        b2 = k.b(new C0326a());
        this.f13720b = b2;
    }

    private final c.h.f.a.a e() {
        return (c.h.f.a.a) this.f13720b.getValue();
    }

    private final boolean f() {
        if (Build.VERSION.SDK_INT >= 28) {
            return e.j.f.h.h(this.a, "android.permission.USE_BIOMETRIC");
        }
        return e.j.f.h.h(this.a, "android.permission.USE_FINGERPRINT");
    }

    private final boolean g() {
        return e().e() && this.a.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
    }

    @Override // e.j.l.n.b
    public boolean a() {
        return f() && b() && c();
    }

    @Override // e.j.l.n.b
    public boolean b() {
        return g();
    }

    @Override // e.j.l.n.b
    public boolean c() {
        return e().d();
    }
}
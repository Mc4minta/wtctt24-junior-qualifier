package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.measurement.cc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u3 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    private String f7873c;

    /* renamed from: d  reason: collision with root package name */
    private String f7874d;

    /* renamed from: e  reason: collision with root package name */
    private int f7875e;

    /* renamed from: f  reason: collision with root package name */
    private String f7876f;

    /* renamed from: g  reason: collision with root package name */
    private String f7877g;

    /* renamed from: h  reason: collision with root package name */
    private long f7878h;

    /* renamed from: i  reason: collision with root package name */
    private long f7879i;

    /* renamed from: j  reason: collision with root package name */
    private List<String> f7880j;

    /* renamed from: k  reason: collision with root package name */
    private int f7881k;

    /* renamed from: l  reason: collision with root package name */
    private String f7882l;
    private String m;
    private String n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u3(b5 b5Var, long j2) {
        super(b5Var);
        this.f7879i = j2;
    }

    private final String K() {
        if (cc.b() && o().u(r.u0)) {
            f().P().a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = h().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, h());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    f().M().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                f().L().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.f5
    protected final boolean B() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final z9 C(String str) {
        boolean z;
        long min;
        Boolean z2;
        d();
        b();
        String D = D();
        String E = E();
        y();
        String str2 = this.f7874d;
        long H = H();
        y();
        String str3 = this.f7876f;
        long E2 = o().E();
        y();
        d();
        if (this.f7878h == 0) {
            this.f7878h = this.a.H().y(h(), h().getPackageName());
        }
        long j2 = this.f7878h;
        boolean q = this.a.q();
        boolean z3 = !n().x;
        d();
        b();
        String K = !this.a.q() ? null : K();
        b5 b5Var = this.a;
        Long valueOf = Long.valueOf(b5Var.B().f7710k.a());
        if (valueOf.longValue() == 0) {
            min = b5Var.G;
            z = q;
        } else {
            z = q;
            min = Math.min(b5Var.G, valueOf.longValue());
        }
        int I = I();
        boolean booleanValue = o().K().booleanValue();
        ka o = o();
        o.b();
        Boolean z4 = o.z("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(z4 == null || z4.booleanValue()).booleanValue();
        k4 n = n();
        n.d();
        return new z9(D, E, str2, H, str3, E2, j2, str, z, z3, K, 0L, min, I, booleanValue, booleanValue2, n.D().getBoolean("deferred_analytics_collection", false), F(), o().z("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!z2.booleanValue()), this.f7879i, o().u(r.e0) ? this.f7880j : null, (com.google.android.gms.internal.measurement.ka.b() && o().u(r.r0)) ? G() : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D() {
        y();
        return this.f7873c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E() {
        y();
        return this.f7882l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F() {
        y();
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String G() {
        y();
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int H() {
        y();
        return this.f7875e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int I() {
        y();
        return this.f7881k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> J() {
        return this.f7880j;
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ a p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ i6 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u3 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ s7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ n7 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ t3 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u8 v() {
        return super.v();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:1|(1:3)(6:104|105|(1:107)(2:122|(1:124))|108|109|(30:111|(1:113)(1:120)|115|116|5|(1:103)(1:9)|10|(1:102)(1:14)|15|(1:(1:18)(1:19))|(3:21|22|(16:25|26|(1:28)|29|30|(1:90)(1:34)|35|(1:37)(1:89)|38|39|(2:86|(1:88))(4:43|(1:45)(1:85)|46|(1:84))|(3:51|(1:53)(1:56)|54)|57|(3:59|(3:61|(1:63)(3:65|(3:68|(1:70)|66)|71)|64)|(1:73))|74|(1:(2:77|78)(2:80|81))(2:82|83)))|101|26|(0)|29|30|(1:32)|90|35|(0)(0)|38|39|(1:41)|86|(0)|(0)|57|(0)|74|(0)(0)))|4|5|(1:7)|103|10|(1:12)|102|15|(0)|(0)|101|26|(0)|29|30|(0)|90|35|(0)(0)|38|39|(0)|86|(0)|(0)|57|(0)|74|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x024f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0250, code lost:
        f().H().c("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.x3.y(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b0 A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e3 A[Catch: IllegalStateException -> 0x024f, TRY_ENTER, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0221 A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0232 A[Catch: IllegalStateException -> 0x024f, TryCatch #2 {IllegalStateException -> 0x024f, blocks: (B:61:0x01aa, B:63:0x01b0, B:65:0x01bc, B:67:0x01d0, B:71:0x01d9, B:74:0x01e3, B:76:0x01ef, B:80:0x0206, B:82:0x020e, B:89:0x0232, B:91:0x0246, B:93:0x024b, B:92:0x0249, B:84:0x0214, B:85:0x021b, B:87:0x0221, B:66:0x01cc), top: B:126:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0270  */
    @Override // com.google.android.gms.measurement.internal.f5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void w() {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u3.w():void");
    }
}
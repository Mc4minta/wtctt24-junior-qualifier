package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.n0;
import com.google.android.gms.internal.measurement.o0;
import com.google.android.gms.internal.measurement.zzfm;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class w4 extends k9 implements b {

    /* renamed from: d  reason: collision with root package name */
    private static int f7918d = 65535;

    /* renamed from: e  reason: collision with root package name */
    private static int f7919e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<String, String>> f7920f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f7921g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f7922h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, com.google.android.gms.internal.measurement.o0> f7923i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f7924j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, String> f7925k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w4(j9 j9Var) {
        super(j9Var);
        this.f7920f = new c.e.a();
        this.f7921g = new c.e.a();
        this.f7922h = new c.e.a();
        this.f7923i = new c.e.a();
        this.f7925k = new c.e.a();
        this.f7924j = new c.e.a();
    }

    private final void A(String str, o0.a aVar) {
        c.e.a aVar2 = new c.e.a();
        c.e.a aVar3 = new c.e.a();
        c.e.a aVar4 = new c.e.a();
        if (aVar != null) {
            for (int i2 = 0; i2 < aVar.u(); i2++) {
                n0.a x = aVar.v(i2).x();
                if (TextUtils.isEmpty(x.v())) {
                    f().K().a("EventConfig contained null event name");
                } else {
                    String b2 = b6.b(x.v());
                    if (!TextUtils.isEmpty(b2)) {
                        x = x.u(b2);
                        aVar.w(i2, x);
                    }
                    aVar2.put(x.v(), Boolean.valueOf(x.w()));
                    aVar3.put(x.v(), Boolean.valueOf(x.x()));
                    if (x.y()) {
                        if (x.A() >= f7919e && x.A() <= f7918d) {
                            aVar4.put(x.v(), Integer.valueOf(x.A()));
                        } else {
                            f().K().c("Invalid sampling rate. Event name, sample rate", x.v(), Integer.valueOf(x.A()));
                        }
                    }
                }
            }
        }
        this.f7921g.put(str, aVar2);
        this.f7922h.put(str, aVar3);
        this.f7924j.put(str, aVar4);
    }

    private final void M(String str) {
        u();
        d();
        com.google.android.gms.common.internal.t.g(str);
        if (this.f7923i.get(str) == null) {
            byte[] r0 = r().r0(str);
            if (r0 == null) {
                this.f7920f.put(str, null);
                this.f7921g.put(str, null);
                this.f7922h.put(str, null);
                this.f7923i.put(str, null);
                this.f7925k.put(str, null);
                this.f7924j.put(str, null);
                return;
            }
            o0.a x = y(str, r0).x();
            A(str, x);
            this.f7920f.put(str, z((com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) x.j())));
            this.f7923i.put(str, (com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) x.j()));
            this.f7925k.put(str, null);
        }
    }

    private final com.google.android.gms.internal.measurement.o0 y(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.o0.O();
        }
        try {
            com.google.android.gms.internal.measurement.o0 o0Var = (com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) ((o0.a) r9.B(com.google.android.gms.internal.measurement.o0.N(), bArr)).j());
            f().P().c("Parsed config. version, gmp_app_id", o0Var.F() ? Long.valueOf(o0Var.G()) : null, o0Var.H() ? o0Var.I() : null);
            return o0Var;
        } catch (zzfm e2) {
            f().K().c("Unable to merge remote config. appId", x3.y(str), e2);
            return com.google.android.gms.internal.measurement.o0.O();
        } catch (RuntimeException e3) {
            f().K().c("Unable to merge remote config. appId", x3.y(str), e3);
            return com.google.android.gms.internal.measurement.o0.O();
        }
    }

    private static Map<String, String> z(com.google.android.gms.internal.measurement.o0 o0Var) {
        c.e.a aVar = new c.e.a();
        if (o0Var != null) {
            for (com.google.android.gms.internal.measurement.p0 p0Var : o0Var.J()) {
                aVar.put(p0Var.B(), p0Var.C());
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean B(String str, byte[] bArr, String str2) {
        u();
        d();
        com.google.android.gms.common.internal.t.g(str);
        o0.a x = y(str, bArr).x();
        if (x == null) {
            return false;
        }
        A(str, x);
        this.f7923i.put(str, (com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) x.j()));
        this.f7925k.put(str, str2);
        this.f7920f.put(str, z((com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) x.j())));
        r().Q(str, new ArrayList(x.x()));
        try {
            x.y();
            bArr = ((com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) x.j())).l();
        } catch (RuntimeException e2) {
            f().K().c("Unable to serialize reduced-size config. Storing full config instead. appId", x3.y(str), e2);
        }
        e r = r();
        com.google.android.gms.common.internal.t.g(str);
        r.d();
        r.u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (r.y().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                r.f().H().b("Failed to update remote config (got 0). appId", x3.y(str));
            }
        } catch (SQLiteException e3) {
            r.f().H().c("Error storing remote config. appId", x3.y(str), e3);
        }
        this.f7923i.put(str, (com.google.android.gms.internal.measurement.o0) ((com.google.android.gms.internal.measurement.n4) x.j()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String C(String str) {
        d();
        return this.f7925k.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean D(String str, String str2) {
        Boolean bool;
        d();
        M(str);
        if (K(str) && v9.B0(str2)) {
            return true;
        }
        if (L(str) && v9.c0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f7921g.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E(String str) {
        d();
        this.f7925k.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean F(String str, String str2) {
        Boolean bool;
        d();
        M(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.M0) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map<String, Boolean> map = this.f7922h.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int G(String str, String str2) {
        Integer num;
        d();
        M(str);
        Map<String, Integer> map = this.f7924j.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(String str) {
        d();
        this.f7923i.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean I(String str) {
        d();
        com.google.android.gms.internal.measurement.o0 x = x(str);
        if (x == null) {
            return false;
        }
        return x.M();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long J(String str) {
        String k2 = k(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(k2)) {
            return 0L;
        }
        try {
            return Long.parseLong(k2);
        } catch (NumberFormatException e2) {
            f().K().c("Unable to parse timezone offset. appId", x3.y(str), e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean K(String str) {
        return DiskLruCache.VERSION_1.equals(k(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean L(String str) {
        return DiskLruCache.VERSION_1.equals(k(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
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

    @Override // com.google.android.gms.measurement.internal.b
    public final String k(String str, String str2) {
        d();
        M(str);
        Map<String, String> map = this.f7920f.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
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

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ aa p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ r9 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ e r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ w4 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.internal.measurement.o0 x(String str) {
        u();
        d();
        com.google.android.gms.common.internal.t.g(str);
        M(str);
        return this.f7923i.get(str);
    }
}
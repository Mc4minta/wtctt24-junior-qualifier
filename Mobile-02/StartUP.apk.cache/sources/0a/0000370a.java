package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class x3 extends w5 {

    /* renamed from: c  reason: collision with root package name */
    private char f7930c;

    /* renamed from: d  reason: collision with root package name */
    private long f7931d;

    /* renamed from: e  reason: collision with root package name */
    private String f7932e;

    /* renamed from: f  reason: collision with root package name */
    private final z3 f7933f;

    /* renamed from: g  reason: collision with root package name */
    private final z3 f7934g;

    /* renamed from: h  reason: collision with root package name */
    private final z3 f7935h;

    /* renamed from: i  reason: collision with root package name */
    private final z3 f7936i;

    /* renamed from: j  reason: collision with root package name */
    private final z3 f7937j;

    /* renamed from: k  reason: collision with root package name */
    private final z3 f7938k;

    /* renamed from: l  reason: collision with root package name */
    private final z3 f7939l;
    private final z3 m;
    private final z3 n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x3(b5 b5Var) {
        super(b5Var);
        this.f7930c = (char) 0;
        this.f7931d = -1L;
        this.f7933f = new z3(this, 6, false, false);
        this.f7934g = new z3(this, 6, true, false);
        this.f7935h = new z3(this, 6, false, true);
        this.f7936i = new z3(this, 5, false, false);
        this.f7937j = new z3(this, 5, true, false);
        this.f7938k = new z3(this, 5, false, true);
        this.f7939l = new z3(this, 4, false, false);
        this.m = new z3(this, 3, false, false);
        this.n = new z3(this, 2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String A(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String z2 = z(z, obj);
        String z3 = z(z, obj2);
        String z4 = z(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(z2)) {
            sb.append(str2);
            sb.append(z2);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(z3)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(z3);
        }
        if (!TextUtils.isEmpty(z4)) {
            sb.append(str3);
            sb.append(z4);
        }
        return sb.toString();
    }

    private final String E() {
        String str;
        String str2;
        synchronized (this) {
            if (this.f7932e == null) {
                if (this.a.N() != null) {
                    str2 = this.a.N();
                } else {
                    o().g();
                    str2 = "FA";
                }
                this.f7932e = str2;
            }
            str = this.f7932e;
        }
        return str;
    }

    private static String G(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object y(String str) {
        if (str == null) {
            return null;
        }
        return new c4(str);
    }

    private static String z(boolean z, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String G = G(b5.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && G(className).equals(G)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i2++;
                }
                return sb2.toString();
            } else if (!(obj instanceof c4)) {
                return z ? "-" : String.valueOf(obj);
            } else {
                str = ((c4) obj).a;
                return str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(int i2, String str) {
        Log.println(i2, E(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && D(i2)) {
            B(i2, A(false, str, obj, obj2, obj3));
        }
        if (z2 || i2 < 5) {
            return;
        }
        com.google.android.gms.common.internal.t.k(str);
        y4 F = this.a.F();
        if (F == null) {
            B(6, "Scheduler not set. Not logging error/warn");
        } else if (!F.u()) {
            B(6, "Scheduler not initialized. Not logging error/warn");
        } else {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= 9) {
                i2 = 8;
            }
            F.A(new a4(this, i2, str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean D(int i2) {
        return Log.isLoggable(E(), i2);
    }

    public final z3 H() {
        return this.f7933f;
    }

    public final z3 I() {
        return this.f7934g;
    }

    public final z3 J() {
        return this.f7935h;
    }

    public final z3 K() {
        return this.f7936i;
    }

    public final z3 L() {
        return this.f7937j;
    }

    public final z3 M() {
        return this.f7938k;
    }

    public final z3 N() {
        return this.f7939l;
    }

    public final z3 O() {
        return this.m;
    }

    public final z3 P() {
        return this.n;
    }

    public final String Q() {
        Pair<String, Long> a = n().f7704e.a();
        if (a == null || a == k4.f7702c) {
            return null;
        }
        String valueOf = String.valueOf(a.second);
        String str = (String) a.first;
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
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

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean t() {
        return false;
    }
}
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class v3 extends w5 {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<String[]> f7897c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<String[]> f7898d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference<String[]> f7899e = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public v3(b5 b5Var) {
        super(b5Var);
    }

    private final boolean C() {
        g();
        return this.a.K() && this.a.f().D(3);
    }

    private static String y(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        com.google.android.gms.common.internal.t.k(strArr);
        com.google.android.gms.common.internal.t.k(strArr2);
        com.google.android.gms.common.internal.t.k(atomicReference);
        com.google.android.gms.common.internal.t.a(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (v9.z0(str, strArr[i2])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i2] == null) {
                        strArr3[i2] = strArr2[i2] + "(" + strArr[i2] + ")";
                    }
                    str2 = strArr3[i2];
                }
                return str2;
            }
        }
        return str;
    }

    private final String z(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = v((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(valueOf);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String A(String str) {
        if (str == null) {
            return null;
        }
        return !C() ? str : y(str, a6.f7486b, a6.a, f7898d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String B(String str) {
        if (str == null) {
            return null;
        }
        if (C()) {
            if (str.startsWith("_exp_")) {
                return "experiment_id(" + str + ")";
            }
            return y(str, d6.f7536b, d6.a, f7899e);
        }
        return str;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final String v(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!C()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(A(str));
            sb.append("=");
            if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.H0)) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    valueOf = z(new Object[]{obj});
                } else if (obj instanceof Object[]) {
                    valueOf = z((Object[]) obj);
                } else if (obj instanceof ArrayList) {
                    valueOf = z(((ArrayList) obj).toArray());
                } else {
                    valueOf = String.valueOf(obj);
                }
                sb.append(valueOf);
            } else {
                sb.append(bundle.get(str));
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String w(p pVar) {
        String str = null;
        if (pVar == null) {
            return null;
        }
        if (!C()) {
            return pVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(pVar.f7791c);
        sb.append(",name=");
        sb.append(x(pVar.a));
        sb.append(",params=");
        o oVar = pVar.f7790b;
        if (oVar != null) {
            if (!C()) {
                str = oVar.toString();
            } else {
                str = v(oVar.l1());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String x(String str) {
        if (str == null) {
            return null;
        }
        return !C() ? str : y(str, b6.f7514b, b6.a, f7897c);
    }
}
package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.bd;
import com.google.android.gms.measurement.internal.e7;
import com.google.android.gms.measurement.internal.f6;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
final class b implements e7 {
    private final /* synthetic */ bd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(bd bdVar) {
        this.a = bdVar;
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final String a() {
        return this.a.N();
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final String b() {
        return this.a.Q();
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final String c() {
        return this.a.J();
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final String d() {
        return this.a.D();
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final long e() {
        return this.a.M();
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void f(String str) {
        this.a.y(str);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void g(Bundle bundle) {
        this.a.i(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final int h(String str) {
        return this.a.I(str);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void i(String str) {
        this.a.F(str);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void j(boolean z) {
        this.a.A(z);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final List<Bundle> k(String str, String str2) {
        return this.a.x(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final Map<String, Object> l(String str, String str2, boolean z) {
        return this.a.f(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void m(f6 f6Var) {
        this.a.m(f6Var);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void n(String str, String str2, Bundle bundle) {
        this.a.z(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void o(String str, String str2, Bundle bundle) {
        this.a.p(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.e7
    public final void p(String str, String str2, Object obj) {
        this.a.r(str, str2, obj);
    }
}
package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class k5 implements Callable<List<ia>> {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7712b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7713c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ h5 f7714d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k5(h5 h5Var, z9 z9Var, String str, String str2) {
        this.f7714d = h5Var;
        this.a = z9Var;
        this.f7712b = str;
        this.f7713c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<ia> call() throws Exception {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7714d.a;
        j9Var.d0();
        j9Var2 = this.f7714d.a;
        return j9Var2.U().l0(this.a.a, this.f7712b, this.f7713c);
    }
}
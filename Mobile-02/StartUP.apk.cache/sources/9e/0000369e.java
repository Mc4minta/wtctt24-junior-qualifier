package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class n5 implements Callable<List<ia>> {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7764b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7765c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ h5 f7766d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n5(h5 h5Var, String str, String str2, String str3) {
        this.f7766d = h5Var;
        this.a = str;
        this.f7764b = str2;
        this.f7765c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<ia> call() throws Exception {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7766d.a;
        j9Var.d0();
        j9Var2 = this.f7766d.a;
        return j9Var2.U().l0(this.a, this.f7764b, this.f7765c);
    }
}
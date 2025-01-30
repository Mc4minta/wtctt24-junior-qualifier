package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class t5 implements Callable<List<s9>> {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ h5 f7866b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t5(h5 h5Var, z9 z9Var) {
        this.f7866b = h5Var;
        this.a = z9Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<s9> call() throws Exception {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7866b.a;
        j9Var.d0();
        j9Var2 = this.f7866b.a;
        return j9Var2.U().J(this.a.a);
    }
}
package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class i5 implements Callable<List<s9>> {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7636b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7637c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ h5 f7638d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5(h5 h5Var, z9 z9Var, String str, String str2) {
        this.f7638d = h5Var;
        this.a = z9Var;
        this.f7636b = str;
        this.f7637c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<s9> call() throws Exception {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7638d.a;
        j9Var.d0();
        j9Var2 = this.f7638d.a;
        return j9Var2.U().L(this.a.a, this.f7636b, this.f7637c);
    }
}
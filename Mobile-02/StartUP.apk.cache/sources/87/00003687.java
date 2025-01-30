package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class l5 implements Callable<List<s9>> {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7736b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7737c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ h5 f7738d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l5(h5 h5Var, String str, String str2, String str3) {
        this.f7738d = h5Var;
        this.a = str;
        this.f7736b = str2;
        this.f7737c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<s9> call() throws Exception {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7738d.a;
        j9Var.d0();
        j9Var2 = this.f7738d.a;
        return j9Var2.U().L(this.a, this.f7736b, this.f7737c);
    }
}
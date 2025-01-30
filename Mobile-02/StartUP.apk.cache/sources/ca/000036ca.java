package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
final class r5 implements Callable<byte[]> {
    private final /* synthetic */ p a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7845b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ h5 f7846c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r5(h5 h5Var, p pVar, String str) {
        this.f7846c = h5Var;
        this.a = pVar;
        this.f7845b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        j9 j9Var;
        j9 j9Var2;
        j9Var = this.f7846c.a;
        j9Var.d0();
        j9Var2 = this.f7846c.a;
        return j9Var2.X().x(this.a, this.f7845b);
    }
}
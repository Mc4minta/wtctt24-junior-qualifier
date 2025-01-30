package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class n8 implements Runnable {
    private final /* synthetic */ ComponentName a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ l8 f7775b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n8(l8 l8Var, ComponentName componentName) {
        this.f7775b = l8Var;
        this.a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7775b.f7748c.F(this.a);
    }
}
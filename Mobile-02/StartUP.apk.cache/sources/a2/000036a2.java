package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class n9 implements Callable<String> {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j9 f7776b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n9(j9 j9Var, z9 z9Var) {
        this.f7776b = j9Var;
        this.a = z9Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        f4 Q = this.f7776b.Q(this.a);
        if (Q == null) {
            this.f7776b.f().K().a("App info was null when attempting to get app instance id");
            return null;
        }
        return Q.x();
    }
}
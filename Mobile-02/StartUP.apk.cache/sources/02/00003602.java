package com.google.android.gms.measurement.internal;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class a5 implements Thread.UncaughtExceptionHandler {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ y4 f7485b;

    public a5(y4 y4Var, String str) {
        this.f7485b = y4Var;
        com.google.android.gms.common.internal.t.k(str);
        this.a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f7485b.f().H().b(this.a, th);
    }
}
package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c0 implements Runnable {
    private final /* synthetic */ b0 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Callable f7988b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(b0 b0Var, Callable callable) {
        this.a = b0Var;
        this.f7988b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.u(this.f7988b.call());
        } catch (Exception e2) {
            this.a.t(e2);
        }
    }
}
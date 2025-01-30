package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Callable {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    private final f f9419b;

    private a(e eVar, f fVar) {
        this.a = eVar;
        this.f9419b = fVar;
    }

    public static Callable a(e eVar, f fVar) {
        return new a(eVar, fVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Void e2;
        e2 = this.a.f9424d.e(this.f9419b);
        return e2;
    }
}
package com.google.firebase.components;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class o implements Runnable {
    private final Map.Entry a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.e.a f8628b;

    private o(Map.Entry entry, com.google.firebase.e.a aVar) {
        this.a = entry;
        this.f8628b = aVar;
    }

    public static Runnable a(Map.Entry entry, com.google.firebase.e.a aVar) {
        return new o(entry, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((com.google.firebase.e.b) this.a.getKey()).a(this.f8628b);
    }
}
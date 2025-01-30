package com.google.android.gms.internal.p000firebaseperf;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.e  reason: invalid package */
/* loaded from: classes2.dex */
final class e extends d {

    /* renamed from: b  reason: collision with root package name */
    private final c f6710b = new c();

    @Override // com.google.android.gms.internal.p000firebaseperf.d
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.f6710b.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
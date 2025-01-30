package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class t2 extends s2 {

    /* renamed from: b  reason: collision with root package name */
    private final r2 f7346b = new r2();

    @Override // com.google.android.gms.internal.measurement.s2
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.f7346b.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
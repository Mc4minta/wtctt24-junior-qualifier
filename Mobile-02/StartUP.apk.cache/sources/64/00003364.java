package com.google.android.gms.internal.p000firebaseperf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.f  reason: invalid package */
/* loaded from: classes2.dex */
final class f extends WeakReference<Throwable> {
    private final int a;

    public f(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == f.class) {
            if (this == obj) {
                return true;
            }
            f fVar = (f) obj;
            if (this.a == fVar.a && get() == fVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
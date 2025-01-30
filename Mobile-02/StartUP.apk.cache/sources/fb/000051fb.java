package kotlin.i0;

import kotlin.jvm.internal.m;

/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
class e {
    public static final void a(boolean z, Number step) {
        m.g(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }
}
package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.s1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class j extends s {
    private final s1 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(s1 s1Var) {
        this.a = s1Var;
    }

    @Override // com.google.firebase.perf.internal.s
    public final boolean b() {
        if (this.a.B()) {
            if (this.a.F() > 0 || this.a.G() > 0) {
                return true;
            }
            return this.a.D() && this.a.E().y();
        }
        return false;
    }
}
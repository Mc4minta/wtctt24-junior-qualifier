package com.google.firebase.perf.metrics;

import com.google.android.gms.internal.p000firebaseperf.h2;
import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.p2;
import com.google.firebase.perf.internal.r;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class e {
    private final Trace a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Trace trace) {
        this.a = trace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p2 a() {
        p2.a q = p2.X().o(this.a.b()).p(this.a.f().c()).q(this.a.f().e(this.a.g()));
        for (b bVar : this.a.e().values()) {
            q.s(bVar.b(), bVar.a());
        }
        List<Trace> h2 = this.a.h();
        if (!h2.isEmpty()) {
            for (Trace trace : h2) {
                q.x(new e(trace).a());
            }
        }
        q.w(this.a.getAttributes());
        h2[] b2 = r.b(this.a.i());
        if (b2 != null) {
            q.v(Arrays.asList(b2));
        }
        return (p2) ((m4) q.O());
    }
}
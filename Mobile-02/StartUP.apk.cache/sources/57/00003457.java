package com.google.android.gms.internal.p000firebaseperf;

import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.zzhx  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzhx extends RuntimeException {
    private final List<String> a;

    public zzhx(v5 v5Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }
}
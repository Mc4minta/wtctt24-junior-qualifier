package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.zzfs  reason: invalid package */
/* loaded from: classes2.dex */
public class zzfs extends IOException {
    private v5 a;

    public zzfs(String str) {
        super(str);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfr a() {
        return new zzfr("Protocol message tag had invalid wire type.");
    }
}
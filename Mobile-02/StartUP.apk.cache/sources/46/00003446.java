package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.z0  reason: invalid package */
/* loaded from: classes2.dex */
public final class z0 {
    private final URL a;

    public z0(URL url) {
        this.a = url;
    }

    public final URLConnection a() throws IOException {
        return this.a.openConnection();
    }

    public final String toString() {
        return this.a.toString();
    }
}
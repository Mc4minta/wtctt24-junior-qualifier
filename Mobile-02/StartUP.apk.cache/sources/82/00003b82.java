package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.i1;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
final /* synthetic */ class o {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[i1.values().length];
        a = iArr;
        try {
            iArr[i1.BACKGROUND.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[i1.FOREGROUND.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
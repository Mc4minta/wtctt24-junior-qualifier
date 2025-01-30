package com.google.android.gms.internal.p000firebaseperf;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s8  reason: invalid package */
/* loaded from: classes2.dex */
public final class s8 extends b {
    public static int a(long j2) {
        if (j2 > 2147483647L) {
            return RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }
}
package com.google.android.gms.internal.p000firebaseperf;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.u3  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class u3 {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f6921b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6922c;

    private u3() {
        this.a = 100;
        this.f6921b = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f6922c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u3 a(byte[] bArr, int i2, int i3, boolean z) {
        w3 w3Var = new w3(bArr, 0, i3, false);
        try {
            w3Var.c(i3);
            return w3Var;
        } catch (zzfs e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int b();

    public abstract int c(int i2) throws zzfs;
}
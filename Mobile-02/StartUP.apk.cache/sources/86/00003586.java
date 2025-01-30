package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class t3 {
    int a;

    /* renamed from: b  reason: collision with root package name */
    private int f7347b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7348c;

    private t3() {
        this.a = 100;
        this.f7347b = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f7348c = false;
    }

    public static long a(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t3 b(byte[] bArr, int i2, int i3, boolean z) {
        u3 u3Var = new u3(bArr, 0, i3, false);
        try {
            u3Var.c(i3);
            return u3Var;
        } catch (zzfm e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int d(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int c(int i2) throws zzfm;

    public abstract int e();
}
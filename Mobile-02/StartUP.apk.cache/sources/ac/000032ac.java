package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* loaded from: classes2.dex */
public abstract class j0 {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f6468b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6469c;

    private j0() {
        this.a = 100;
        this.f6468b = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f6469c = false;
    }

    public static long a(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j0 b(byte[] bArr, int i2, int i3, boolean z) {
        l0 l0Var = new l0(bArr, 0, i3, false);
        try {
            l0Var.d(i3);
            return l0Var;
        } catch (zzco e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int e(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int c();

    public abstract int d(int i2) throws zzco;
}
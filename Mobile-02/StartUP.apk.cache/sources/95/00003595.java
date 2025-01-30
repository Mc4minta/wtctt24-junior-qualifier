package com.google.android.gms.internal.measurement;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class u3 extends t3 {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f7357d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7358e;

    /* renamed from: f  reason: collision with root package name */
    private int f7359f;

    /* renamed from: g  reason: collision with root package name */
    private int f7360g;

    /* renamed from: h  reason: collision with root package name */
    private int f7361h;

    /* renamed from: i  reason: collision with root package name */
    private int f7362i;

    /* renamed from: j  reason: collision with root package name */
    private int f7363j;

    private u3(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.f7363j = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f7357d = bArr;
        this.f7359f = i3 + i2;
        this.f7361h = i2;
        this.f7362i = i2;
        this.f7358e = z;
    }

    private final void f() {
        int i2 = this.f7359f + this.f7360g;
        this.f7359f = i2;
        int i3 = i2 - this.f7362i;
        int i4 = this.f7363j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f7360g = i5;
            this.f7359f = i2 - i5;
            return;
        }
        this.f7360g = 0;
    }

    @Override // com.google.android.gms.internal.measurement.t3
    public final int c(int i2) throws zzfm {
        if (i2 >= 0) {
            int e2 = i2 + e();
            int i3 = this.f7363j;
            if (e2 <= i3) {
                this.f7363j = e2;
                f();
                return i3;
            }
            throw zzfm.a();
        }
        throw zzfm.b();
    }

    @Override // com.google.android.gms.internal.measurement.t3
    public final int e() {
        return this.f7361h - this.f7362i;
    }
}
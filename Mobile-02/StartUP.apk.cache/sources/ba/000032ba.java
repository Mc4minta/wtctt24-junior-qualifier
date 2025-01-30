package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l0 extends j0 {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6498d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6499e;

    /* renamed from: f  reason: collision with root package name */
    private int f6500f;

    /* renamed from: g  reason: collision with root package name */
    private int f6501g;

    /* renamed from: h  reason: collision with root package name */
    private int f6502h;

    /* renamed from: i  reason: collision with root package name */
    private int f6503i;

    /* renamed from: j  reason: collision with root package name */
    private int f6504j;

    private l0(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.f6504j = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f6498d = bArr;
        this.f6500f = i3 + i2;
        this.f6502h = i2;
        this.f6503i = i2;
        this.f6499e = z;
    }

    @Override // com.google.android.gms.internal.clearcut.j0
    public final int c() {
        return this.f6502h - this.f6503i;
    }

    @Override // com.google.android.gms.internal.clearcut.j0
    public final int d(int i2) throws zzco {
        if (i2 >= 0) {
            int c2 = i2 + c();
            int i3 = this.f6504j;
            if (c2 <= i3) {
                this.f6504j = c2;
                int i4 = this.f6500f + this.f6501g;
                this.f6500f = i4;
                int i5 = i4 - this.f6503i;
                if (i5 > c2) {
                    int i6 = i5 - c2;
                    this.f6501g = i6;
                    this.f6500f = i4 - i6;
                } else {
                    this.f6501g = 0;
                }
                return i3;
            }
            throw zzco.a();
        }
        throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
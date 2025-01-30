package com.google.android.gms.internal.p000firebaseperf;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.w3  reason: invalid package */
/* loaded from: classes2.dex */
public final class w3 extends u3 {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6937d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6938e;

    /* renamed from: f  reason: collision with root package name */
    private int f6939f;

    /* renamed from: g  reason: collision with root package name */
    private int f6940g;

    /* renamed from: h  reason: collision with root package name */
    private int f6941h;

    /* renamed from: i  reason: collision with root package name */
    private int f6942i;

    /* renamed from: j  reason: collision with root package name */
    private int f6943j;

    private w3(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.f6943j = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f6937d = bArr;
        this.f6939f = i3 + i2;
        this.f6941h = i2;
        this.f6942i = i2;
        this.f6938e = z;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.u3
    public final int b() {
        return this.f6941h - this.f6942i;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.u3
    public final int c(int i2) throws zzfs {
        if (i2 >= 0) {
            int b2 = i2 + b();
            int i3 = this.f6943j;
            if (b2 <= i3) {
                this.f6943j = b2;
                int i4 = this.f6939f + this.f6940g;
                this.f6939f = i4;
                int i5 = i4 - this.f6942i;
                if (i5 > b2) {
                    int i6 = i5 - b2;
                    this.f6940g = i6;
                    this.f6939f = i4 - i6;
                } else {
                    this.f6940g = 0;
                }
                return i3;
            }
            throw new zzfs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzfs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
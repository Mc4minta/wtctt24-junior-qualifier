package com.google.android.gms.internal.p000firebaseperf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.q3  reason: invalid package */
/* loaded from: classes2.dex */
public final class q3 {
    private final zzev a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6896b;

    private q3(int i2) {
        byte[] bArr = new byte[i2];
        this.f6896b = bArr;
        this.a = zzev.f(bArr);
    }

    public final i3 a() {
        this.a.r0();
        return new s3(this.f6896b);
    }

    public final zzev b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q3(int i2, l3 l3Var) {
        this(i2);
    }
}
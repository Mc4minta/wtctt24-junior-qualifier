package com.google.android.gms.internal.clearcut;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f0 {
    private final zzbn a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6426b;

    private f0(int i2) {
        byte[] bArr = new byte[i2];
        this.f6426b = bArr;
        this.a = zzbn.S(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f0(int i2, b0 b0Var) {
        this(i2);
    }

    public final a0 a() {
        if (this.a.u() == 0) {
            return new h0(this.f6426b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn b() {
        return this.a;
    }
}
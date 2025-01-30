package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class p3 {
    private final zzel a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f7302b;

    private p3(int i2) {
        byte[] bArr = new byte[i2];
        this.f7302b = bArr;
        this.a = zzel.f(bArr);
    }

    public final h3 a() {
        this.a.N();
        return new r3(this.f7302b);
    }

    public final zzel b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p3(int i2, g3 g3Var) {
        this(i2);
    }
}
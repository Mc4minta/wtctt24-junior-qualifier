package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class k3 extends r3 {

    /* renamed from: f  reason: collision with root package name */
    private final int f7214f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7215g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k3(byte[] bArr, int i2, int i3) {
        super(bArr);
        h3.u(i2, i2 + i3, bArr.length);
        this.f7214f = i2;
        this.f7215g = i3;
    }

    @Override // com.google.android.gms.internal.measurement.r3
    protected final int C() {
        return this.f7214f;
    }

    @Override // com.google.android.gms.internal.measurement.r3, com.google.android.gms.internal.measurement.h3
    public final byte h(int i2) {
        int i3 = i();
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.f7332e[this.f7214f + i2];
    }

    @Override // com.google.android.gms.internal.measurement.r3, com.google.android.gms.internal.measurement.h3
    public final int i() {
        return this.f7215g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.r3, com.google.android.gms.internal.measurement.h3
    public final byte s(int i2) {
        return this.f7332e[this.f7214f + i2];
    }
}
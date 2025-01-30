package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p3  reason: invalid package */
/* loaded from: classes2.dex */
final class p3 extends s3 {

    /* renamed from: f  reason: collision with root package name */
    private final int f6888f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6889g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(byte[] bArr, int i2, int i3) {
        super(bArr);
        i3.p(i2, i2 + i3, bArr.length);
        this.f6888f = i2;
        this.f6889g = i3;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s3, com.google.android.gms.internal.p000firebaseperf.i3
    public final int size() {
        return this.f6889g;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s3, com.google.android.gms.internal.p000firebaseperf.i3
    public final byte u(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) < 0) {
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
            sb2.append(size);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.f6905e[this.f6888f + i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.s3, com.google.android.gms.internal.p000firebaseperf.i3
    public final byte w(int i2) {
        return this.f6905e[this.f6888f + i2];
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s3
    protected final int z() {
        return this.f6888f;
    }
}
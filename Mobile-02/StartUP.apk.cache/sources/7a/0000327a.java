package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class d0 extends h0 {

    /* renamed from: e  reason: collision with root package name */
    private final int f6396e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6397f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(byte[] bArr, int i2, int i3) {
        super(bArr);
        a0.p(i2, i2 + i3, bArr.length);
        this.f6396e = i2;
        this.f6397f = i3;
    }

    @Override // com.google.android.gms.internal.clearcut.h0, com.google.android.gms.internal.clearcut.a0
    public final byte s(int i2) {
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
        return this.f6457d[this.f6396e + i2];
    }

    @Override // com.google.android.gms.internal.clearcut.h0, com.google.android.gms.internal.clearcut.a0
    public final int size() {
        return this.f6397f;
    }

    @Override // com.google.android.gms.internal.clearcut.h0
    protected final int x() {
        return this.f6396e;
    }
}
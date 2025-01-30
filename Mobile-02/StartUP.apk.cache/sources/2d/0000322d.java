package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class u extends r {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6321b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f6321b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.r
    public final byte[] q() {
        return this.f6321b;
    }
}
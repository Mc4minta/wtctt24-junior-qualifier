package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
abstract class t extends r {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakReference<byte[]> f6319b = new WeakReference<>(null);

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<byte[]> f6320c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(byte[] bArr) {
        super(bArr);
        this.f6320c = f6319b;
    }

    protected abstract byte[] Z0();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.r
    public final byte[] q() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f6320c.get();
            if (bArr == null) {
                bArr = Z0();
                this.f6320c = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
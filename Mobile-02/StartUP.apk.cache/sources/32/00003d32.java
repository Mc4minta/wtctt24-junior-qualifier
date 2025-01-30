package com.google.zxing.t;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* compiled from: UPCEANExtensionSupport.java */
/* loaded from: classes2.dex */
final class o {
    private static final int[] a = {1, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    private final m f10011b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final n f10012c = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.k a(int i2, com.google.zxing.q.a aVar, int i3) throws NotFoundException {
        int[] n = p.n(aVar, i3, false, a);
        try {
            return this.f10012c.b(i2, aVar, n);
        } catch (ReaderException unused) {
            return this.f10011b.b(i2, aVar, n);
        }
    }
}
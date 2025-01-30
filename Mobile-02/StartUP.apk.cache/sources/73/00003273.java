package com.google.android.gms.internal.clearcut;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class c0 implements e0 {
    private c0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c0(b0 b0Var) {
        this();
    }

    @Override // com.google.android.gms.internal.clearcut.e0
    public final byte[] a(byte[] bArr, int i2, int i3) {
        return Arrays.copyOfRange(bArr, i2, i3 + i2);
    }
}
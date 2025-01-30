package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class l3 implements n3 {
    private l3() {
    }

    @Override // com.google.android.gms.internal.measurement.n3
    public final byte[] a(byte[] bArr, int i2, int i3) {
        return Arrays.copyOfRange(bArr, i2, i3 + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l3(g3 g3Var) {
        this();
    }
}
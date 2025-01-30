package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
abstract class n7 {
    abstract int a(int i2, byte[] bArr, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b(CharSequence charSequence, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String c(byte[] bArr, int i2, int i3) throws zzfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(byte[] bArr, int i2, int i3) {
        return a(0, bArr, i2, i3) == 0;
    }
}
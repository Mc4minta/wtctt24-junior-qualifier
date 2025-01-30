package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

/* loaded from: classes3.dex */
public class ZeroBytePadding implements BlockCipherPadding {
    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i2) {
        int length = bArr.length - i2;
        while (i2 < bArr.length) {
            bArr[i2] = 0;
            i2++;
        }
        return length;
    }

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ZeroByte";
    }

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
    }

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        while (length > 0 && bArr[length - 1] == 0) {
            length--;
        }
        return bArr.length - length;
    }
}
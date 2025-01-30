package org.spongycastle.crypto;

import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;
    protected byte[] salt;

    public static byte[] PKCS12PasswordToBytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(cArr.length + 1) * 2];
        for (int i2 = 0; i2 != cArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i3] = (byte) (cArr[i2] >>> '\b');
            bArr[i3 + 1] = (byte) cArr[i2];
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToBytes(char[] cArr) {
        if (cArr != null) {
            int length = cArr.length;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 != length; i2++) {
                bArr[i2] = (byte) cArr[i2];
            }
            return bArr;
        }
        return new byte[0];
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] cArr) {
        return cArr != null ? Strings.toUTF8ByteArray(cArr) : new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int i2);

    public abstract CipherParameters generateDerivedParameters(int i2);

    public abstract CipherParameters generateDerivedParameters(int i2, int i3);

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void init(byte[] bArr, byte[] bArr2, int i2) {
        this.password = bArr;
        this.salt = bArr2;
        this.iterationCount = i2;
    }
}
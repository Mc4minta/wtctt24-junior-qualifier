package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class TlsAEADCipher implements TlsCipher {
    protected TlsContext context;
    protected AEADBlockCipher decryptCipher;
    protected byte[] decryptImplicitNonce;
    protected AEADBlockCipher encryptCipher;
    protected byte[] encryptImplicitNonce;
    protected int macSize;
    protected int nonce_explicit_length;

    public TlsAEADCipher(TlsContext tlsContext, AEADBlockCipher aEADBlockCipher, AEADBlockCipher aEADBlockCipher2, int i2, int i3) throws IOException {
        if (TlsUtils.isTLSv12(tlsContext)) {
            this.context = tlsContext;
            this.macSize = i3;
            this.nonce_explicit_length = 8;
            int i4 = (i2 * 2) + 8;
            byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, i4);
            KeyParameter keyParameter = new KeyParameter(calculateKeyBlock, 0, i2);
            int i5 = i2 + 0;
            KeyParameter keyParameter2 = new KeyParameter(calculateKeyBlock, i5, i2);
            int i6 = i5 + i2;
            int i7 = i6 + 4;
            byte[] copyOfRange = Arrays.copyOfRange(calculateKeyBlock, i6, i7);
            int i8 = i7 + 4;
            byte[] copyOfRange2 = Arrays.copyOfRange(calculateKeyBlock, i7, i8);
            if (i8 == i4) {
                if (tlsContext.isServer()) {
                    this.encryptCipher = aEADBlockCipher2;
                    this.decryptCipher = aEADBlockCipher;
                    this.encryptImplicitNonce = copyOfRange2;
                    this.decryptImplicitNonce = copyOfRange;
                    keyParameter2 = keyParameter;
                    keyParameter = keyParameter2;
                } else {
                    this.encryptCipher = aEADBlockCipher;
                    this.decryptCipher = aEADBlockCipher2;
                    this.encryptImplicitNonce = copyOfRange;
                    this.decryptImplicitNonce = copyOfRange2;
                }
                byte[] bArr = new byte[this.nonce_explicit_length + 4];
                int i9 = i3 * 8;
                this.encryptCipher.init(true, new AEADParameters(keyParameter, i9, bArr));
                this.decryptCipher.init(false, new AEADParameters(keyParameter2, i9, bArr));
                return;
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        if (getPlaintextLimit(i3) >= 0) {
            byte[] bArr2 = this.decryptImplicitNonce;
            byte[] bArr3 = new byte[bArr2.length + this.nonce_explicit_length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, i2, bArr3, this.decryptImplicitNonce.length, this.nonce_explicit_length);
            int i4 = this.nonce_explicit_length;
            int i5 = i2 + i4;
            int i6 = i3 - i4;
            int outputSize = this.decryptCipher.getOutputSize(i6);
            byte[] bArr4 = new byte[outputSize];
            try {
                this.decryptCipher.init(false, new AEADParameters(null, this.macSize * 8, bArr3, getAdditionalData(j2, s, outputSize)));
                int processBytes = this.decryptCipher.processBytes(bArr, i5, i6, bArr4, 0) + 0;
                if (processBytes + this.decryptCipher.doFinal(bArr4, processBytes) == outputSize) {
                    return bArr4;
                }
                throw new TlsFatalAlert((short) 80);
            } catch (Exception e2) {
                throw new TlsFatalAlert((short) 20, e2);
            }
        }
        throw new TlsFatalAlert((short) 50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        byte[] bArr2 = this.encryptImplicitNonce;
        byte[] bArr3 = new byte[bArr2.length + this.nonce_explicit_length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        TlsUtils.writeUint64(j2, bArr3, this.encryptImplicitNonce.length);
        int outputSize = this.encryptCipher.getOutputSize(i3);
        int i4 = this.nonce_explicit_length;
        int i5 = i4 + outputSize;
        byte[] bArr4 = new byte[i5];
        System.arraycopy(bArr3, this.encryptImplicitNonce.length, bArr4, 0, i4);
        int i6 = this.nonce_explicit_length;
        try {
            this.encryptCipher.init(true, new AEADParameters(null, this.macSize * 8, bArr3, getAdditionalData(j2, s, i3)));
            int processBytes = i6 + this.encryptCipher.processBytes(bArr, i2, i3, bArr4, i6);
            if (processBytes + this.encryptCipher.doFinal(bArr4, processBytes) == i5) {
                return bArr4;
            }
            throw new TlsFatalAlert((short) 80);
        } catch (Exception e2) {
            throw new TlsFatalAlert((short) 80, e2);
        }
    }

    protected byte[] getAdditionalData(long j2, short s, int i2) throws IOException {
        byte[] bArr = new byte[13];
        TlsUtils.writeUint64(j2, bArr, 0);
        TlsUtils.writeUint8(s, bArr, 8);
        TlsUtils.writeVersion(this.context.getServerVersion(), bArr, 9);
        TlsUtils.writeUint16(i2, bArr, 11);
        return bArr;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i2) {
        return (i2 - this.macSize) - this.nonce_explicit_length;
    }
}
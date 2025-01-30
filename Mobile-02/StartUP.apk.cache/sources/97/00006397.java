package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class TlsStreamCipher implements TlsCipher {
    protected TlsContext context;
    protected StreamCipher decryptCipher;
    protected StreamCipher encryptCipher;
    protected TlsMac readMac;
    protected boolean usesNonce;
    protected TlsMac writeMac;

    public TlsStreamCipher(TlsContext tlsContext, StreamCipher streamCipher, StreamCipher streamCipher2, Digest digest, Digest digest2, int i2, boolean z) throws IOException {
        boolean isServer = tlsContext.isServer();
        this.context = tlsContext;
        this.usesNonce = z;
        this.encryptCipher = streamCipher;
        this.decryptCipher = streamCipher2;
        int digestSize = (i2 * 2) + digest.getDigestSize() + digest2.getDigestSize();
        byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, digestSize);
        TlsMac tlsMac = new TlsMac(tlsContext, digest, calculateKeyBlock, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = new TlsMac(tlsContext, digest2, calculateKeyBlock, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        CipherParameters keyParameter = new KeyParameter(calculateKeyBlock, digestSize3, i2);
        int i3 = digestSize3 + i2;
        CipherParameters keyParameter2 = new KeyParameter(calculateKeyBlock, i3, i2);
        if (i3 + i2 == digestSize) {
            if (isServer) {
                this.writeMac = tlsMac2;
                this.readMac = tlsMac;
                this.encryptCipher = streamCipher2;
                this.decryptCipher = streamCipher;
                keyParameter2 = keyParameter;
                keyParameter = keyParameter2;
            } else {
                this.writeMac = tlsMac;
                this.readMac = tlsMac2;
                this.encryptCipher = streamCipher;
                this.decryptCipher = streamCipher2;
            }
            if (z) {
                byte[] bArr = new byte[8];
                CipherParameters parametersWithIV = new ParametersWithIV(keyParameter, bArr);
                keyParameter2 = new ParametersWithIV(keyParameter2, bArr);
                keyParameter = parametersWithIV;
            }
            this.encryptCipher.init(true, keyParameter);
            this.decryptCipher.init(false, keyParameter2);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected void checkMAC(long j2, short s, byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) throws IOException {
        if (!Arrays.constantTimeAreEqual(Arrays.copyOfRange(bArr, i2, i3), this.readMac.calculateMac(j2, s, bArr2, i4, i5))) {
            throw new TlsFatalAlert((short) 20);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        if (this.usesNonce) {
            updateIV(this.decryptCipher, false, j2);
        }
        int size = this.readMac.getSize();
        if (i3 >= size) {
            int i4 = i3 - size;
            byte[] bArr2 = new byte[i3];
            this.decryptCipher.processBytes(bArr, i2, i3, bArr2, 0);
            checkMAC(j2, s, bArr2, i4, i3, bArr2, 0, i4);
            return Arrays.copyOfRange(bArr2, 0, i4);
        }
        throw new TlsFatalAlert((short) 50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j2, short s, byte[] bArr, int i2, int i3) {
        if (this.usesNonce) {
            updateIV(this.encryptCipher, true, j2);
        }
        byte[] bArr2 = new byte[i3 + this.writeMac.getSize()];
        this.encryptCipher.processBytes(bArr, i2, i3, bArr2, 0);
        byte[] calculateMac = this.writeMac.calculateMac(j2, s, bArr, i2, i3);
        this.encryptCipher.processBytes(calculateMac, 0, calculateMac.length, bArr2, i3);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i2) {
        return i2 - this.writeMac.getSize();
    }

    protected void updateIV(StreamCipher streamCipher, boolean z, long j2) {
        byte[] bArr = new byte[8];
        TlsUtils.writeUint64(j2, bArr, 0);
        streamCipher.init(z, new ParametersWithIV(null, bArr));
    }
}
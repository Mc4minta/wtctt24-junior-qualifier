package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class TlsNullCipher implements TlsCipher {
    protected TlsContext context;
    protected TlsMac readMac;
    protected TlsMac writeMac;

    public TlsNullCipher(TlsContext tlsContext) {
        this.context = tlsContext;
        this.writeMac = null;
        this.readMac = null;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        TlsMac tlsMac = this.readMac;
        if (tlsMac == null) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
        int size = tlsMac.getSize();
        if (i3 >= size) {
            int i4 = i3 - size;
            int i5 = i2 + i4;
            if (Arrays.constantTimeAreEqual(Arrays.copyOfRange(bArr, i5, i3 + i2), this.readMac.calculateMac(j2, s, bArr, i2, i4))) {
                return Arrays.copyOfRange(bArr, i2, i5);
            }
            throw new TlsFatalAlert((short) 20);
        }
        throw new TlsFatalAlert((short) 50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        TlsMac tlsMac = this.writeMac;
        if (tlsMac == null) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
        byte[] calculateMac = tlsMac.calculateMac(j2, s, bArr, i2, i3);
        byte[] bArr2 = new byte[calculateMac.length + i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        System.arraycopy(calculateMac, 0, bArr2, i3, calculateMac.length);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i2) {
        TlsMac tlsMac = this.writeMac;
        return tlsMac != null ? i2 - tlsMac.getSize() : i2;
    }

    public TlsNullCipher(TlsContext tlsContext, Digest digest, Digest digest2) throws IOException {
        TlsMac tlsMac;
        if ((digest == null) == (digest2 == null)) {
            this.context = tlsContext;
            TlsMac tlsMac2 = null;
            if (digest != null) {
                int digestSize = digest.getDigestSize() + digest2.getDigestSize();
                byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, digestSize);
                TlsMac tlsMac3 = new TlsMac(tlsContext, digest, calculateKeyBlock, 0, digest.getDigestSize());
                int digestSize2 = digest.getDigestSize() + 0;
                tlsMac = new TlsMac(tlsContext, digest2, calculateKeyBlock, digestSize2, digest2.getDigestSize());
                if (digestSize2 + digest2.getDigestSize() != digestSize) {
                    throw new TlsFatalAlert((short) 80);
                }
                tlsMac2 = tlsMac3;
            } else {
                tlsMac = null;
            }
            if (tlsContext.isServer()) {
                this.writeMac = tlsMac;
                this.readMac = tlsMac2;
                return;
            }
            this.writeMac = tlsMac2;
            this.readMac = tlsMac;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }
}
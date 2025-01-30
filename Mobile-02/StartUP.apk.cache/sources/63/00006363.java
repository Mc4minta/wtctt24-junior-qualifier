package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class TlsBlockCipher implements TlsCipher {
    protected TlsContext context;
    protected BlockCipher decryptCipher;
    protected BlockCipher encryptCipher;
    protected boolean encryptThenMAC;
    protected byte[] randomData = new byte[256];
    protected TlsMac readMac;
    protected boolean useExplicitIV;
    protected TlsMac writeMac;

    public TlsBlockCipher(TlsContext tlsContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i2) throws IOException {
        byte[] copyOfRange;
        byte[] copyOfRange2;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        this.context = tlsContext;
        tlsContext.getNonceRandomGenerator().nextBytes(this.randomData);
        this.useExplicitIV = TlsUtils.isTLSv11(tlsContext);
        this.encryptThenMAC = tlsContext.getSecurityParameters().encryptThenMAC;
        int digestSize = (i2 * 2) + digest.getDigestSize() + digest2.getDigestSize();
        int blockSize = this.useExplicitIV ? digestSize : digestSize + blockCipher.getBlockSize() + blockCipher2.getBlockSize();
        byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, blockSize);
        TlsMac tlsMac = new TlsMac(tlsContext, digest, calculateKeyBlock, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        TlsMac tlsMac2 = new TlsMac(tlsContext, digest2, calculateKeyBlock, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        KeyParameter keyParameter = new KeyParameter(calculateKeyBlock, digestSize3, i2);
        int i3 = digestSize3 + i2;
        KeyParameter keyParameter2 = new KeyParameter(calculateKeyBlock, i3, i2);
        int i4 = i3 + i2;
        if (this.useExplicitIV) {
            copyOfRange = new byte[blockCipher.getBlockSize()];
            copyOfRange2 = new byte[blockCipher2.getBlockSize()];
        } else {
            copyOfRange = Arrays.copyOfRange(calculateKeyBlock, i4, blockCipher.getBlockSize() + i4);
            int blockSize2 = i4 + blockCipher.getBlockSize();
            copyOfRange2 = Arrays.copyOfRange(calculateKeyBlock, blockSize2, blockCipher2.getBlockSize() + blockSize2);
            i4 = blockSize2 + blockCipher2.getBlockSize();
        }
        if (i4 == blockSize) {
            if (tlsContext.isServer()) {
                this.writeMac = tlsMac2;
                this.readMac = tlsMac;
                this.encryptCipher = blockCipher2;
                this.decryptCipher = blockCipher;
                parametersWithIV = new ParametersWithIV(keyParameter2, copyOfRange2);
                parametersWithIV2 = new ParametersWithIV(keyParameter, copyOfRange);
            } else {
                this.writeMac = tlsMac;
                this.readMac = tlsMac2;
                this.encryptCipher = blockCipher;
                this.decryptCipher = blockCipher2;
                parametersWithIV = new ParametersWithIV(keyParameter, copyOfRange);
                parametersWithIV2 = new ParametersWithIV(keyParameter2, copyOfRange2);
            }
            this.encryptCipher.init(true, parametersWithIV);
            this.decryptCipher.init(false, parametersWithIV2);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected int checkPaddingConstantTime(byte[] bArr, int i2, int i3, int i4, int i5) {
        byte b2;
        int i6;
        int i7 = i2 + i3;
        byte b3 = bArr[i7 - 1];
        int i8 = (b3 & 255) + 1;
        if ((!TlsUtils.isSSL(this.context) || i8 <= i4) && i5 + i8 <= i3) {
            int i9 = i7 - i8;
            b2 = 0;
            while (true) {
                int i10 = i9 + 1;
                b2 = (byte) ((bArr[i9] ^ b3) | b2);
                if (i10 >= i7) {
                    break;
                }
                i9 = i10;
            }
            i6 = i8;
            if (b2 != 0) {
                i8 = 0;
            }
        } else {
            i6 = 0;
            b2 = 0;
            i8 = 0;
        }
        byte[] bArr2 = this.randomData;
        while (i6 < 256) {
            b2 = (byte) ((bArr2[i6] ^ b3) | b2);
            i6++;
        }
        bArr2[0] = (byte) (bArr2[0] ^ b2);
        return i8;
    }

    protected int chooseExtraPadBlocks(SecureRandom secureRandom, int i2) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i2);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        byte[] bArr2;
        int i5 = i2;
        int blockSize = this.decryptCipher.getBlockSize();
        int size = this.readMac.getSize();
        int max = this.encryptThenMAC ? blockSize + size : Math.max(blockSize, size + 1);
        if (this.useExplicitIV) {
            max += blockSize;
        }
        if (i3 >= max) {
            boolean z = this.encryptThenMAC;
            int i6 = z ? i3 - size : i3;
            if (i6 % blockSize == 0) {
                if (z) {
                    int i7 = i5 + i3;
                    if (!Arrays.constantTimeAreEqual(this.readMac.calculateMac(j2, s, bArr, i2, i3 - size), Arrays.copyOfRange(bArr, i7 - size, i7))) {
                        throw new TlsFatalAlert((short) 20);
                    }
                }
                if (this.useExplicitIV) {
                    this.decryptCipher.init(false, new ParametersWithIV(null, bArr, i5, blockSize));
                    i5 += blockSize;
                    i6 -= blockSize;
                }
                int i8 = i5;
                int i9 = i6;
                for (int i10 = 0; i10 < i9; i10 += blockSize) {
                    int i11 = i8 + i10;
                    this.decryptCipher.processBlock(bArr, i11, bArr, i11);
                }
                int checkPaddingConstantTime = checkPaddingConstantTime(bArr, i8, i9, blockSize, this.encryptThenMAC ? 0 : size);
                boolean z2 = checkPaddingConstantTime == 0;
                int i12 = i9 - checkPaddingConstantTime;
                if (this.encryptThenMAC) {
                    i4 = i8;
                    bArr2 = bArr;
                } else {
                    i12 -= size;
                    int i13 = i8 + i12;
                    i4 = i8;
                    bArr2 = bArr;
                    z2 |= !Arrays.constantTimeAreEqual(this.readMac.calculateMacConstantTime(j2, s, bArr, i8, i12, i9 - size, this.randomData), Arrays.copyOfRange(bArr, i13, i13 + size));
                }
                if (!z2) {
                    return Arrays.copyOfRange(bArr2, i4, i4 + i12);
                }
                throw new TlsFatalAlert((short) 20);
            }
            throw new TlsFatalAlert((short) 21);
        }
        throw new TlsFatalAlert((short) 50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j2, short s, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        int i4;
        int i5;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        ProtocolVersion serverVersion = this.context.getServerVersion();
        int i6 = (blockSize - 1) - ((!this.encryptThenMAC ? i3 + size : i3) % blockSize);
        if (!serverVersion.isDTLS() && !serverVersion.isSSL()) {
            i6 += chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - i6) / blockSize) * blockSize;
        }
        int i7 = i6;
        int i8 = size + i3 + i7 + 1;
        boolean z = this.useExplicitIV;
        if (z) {
            i8 += blockSize;
        }
        byte[] bArr3 = new byte[i8];
        if (z) {
            byte[] bArr4 = new byte[blockSize];
            this.context.getNonceRandomGenerator().nextBytes(bArr4);
            this.encryptCipher.init(true, new ParametersWithIV(null, bArr4));
            System.arraycopy(bArr4, 0, bArr3, 0, blockSize);
            bArr2 = bArr;
            i4 = i2;
            i5 = blockSize + 0;
        } else {
            bArr2 = bArr;
            i4 = i2;
            i5 = 0;
        }
        System.arraycopy(bArr2, i4, bArr3, i5, i3);
        int i9 = i5 + i3;
        if (!this.encryptThenMAC) {
            byte[] calculateMac = this.writeMac.calculateMac(j2, s, bArr, i2, i3);
            System.arraycopy(calculateMac, 0, bArr3, i9, calculateMac.length);
            i9 += calculateMac.length;
        }
        int i10 = i9;
        int i11 = 0;
        while (i11 <= i7) {
            bArr3[i10] = (byte) i7;
            i11++;
            i10++;
        }
        while (i5 < i10) {
            this.encryptCipher.processBlock(bArr3, i5, bArr3, i5);
            i5 += blockSize;
        }
        if (this.encryptThenMAC) {
            byte[] calculateMac2 = this.writeMac.calculateMac(j2, s, bArr3, 0, i10);
            System.arraycopy(calculateMac2, 0, bArr3, i10, calculateMac2.length);
            return bArr3;
        }
        return bArr3;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public int getPlaintextLimit(int i2) {
        int i3;
        int blockSize = this.encryptCipher.getBlockSize();
        int size = this.writeMac.getSize();
        if (this.useExplicitIV) {
            i2 -= blockSize;
        }
        if (this.encryptThenMAC) {
            int i4 = i2 - size;
            i3 = i4 - (i4 % blockSize);
        } else {
            i3 = (i2 - (i2 % blockSize)) - size;
        }
        return i3 - 1;
    }

    public TlsMac getReadMac() {
        return this.readMac;
    }

    public TlsMac getWriteMac() {
        return this.writeMac;
    }

    protected int lowestBitSet(int i2) {
        if (i2 == 0) {
            return 32;
        }
        int i3 = 0;
        while ((i2 & 1) == 0) {
            i3++;
            i2 >>= 1;
        }
        return i3;
    }
}
package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.Poly1305;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class Chacha20Poly1305 implements TlsCipher {
    protected TlsContext context;
    protected ChaChaEngine decryptCipher;
    protected ChaChaEngine encryptCipher;

    public Chacha20Poly1305(TlsContext tlsContext) throws IOException {
        if (TlsUtils.isTLSv12(tlsContext)) {
            this.context = tlsContext;
            byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsContext, 64);
            KeyParameter keyParameter = new KeyParameter(calculateKeyBlock, 0, 32);
            KeyParameter keyParameter2 = new KeyParameter(calculateKeyBlock, 32, 32);
            this.encryptCipher = new ChaChaEngine(20);
            this.decryptCipher = new ChaChaEngine(20);
            if (tlsContext.isServer()) {
                keyParameter2 = keyParameter;
                keyParameter = keyParameter2;
            }
            byte[] bArr = new byte[8];
            this.encryptCipher.init(true, new ParametersWithIV(keyParameter, bArr));
            this.decryptCipher.init(false, new ParametersWithIV(keyParameter2, bArr));
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected byte[] calculateRecordMAC(KeyParameter keyParameter, byte[] bArr, byte[] bArr2, int i2, int i3) {
        Poly1305 poly1305 = new Poly1305();
        poly1305.init(keyParameter);
        updateRecordMAC(poly1305, bArr, 0, bArr.length);
        updateRecordMAC(poly1305, bArr2, i2, i3);
        byte[] bArr3 = new byte[poly1305.getMacSize()];
        poly1305.doFinal(bArr3, 0);
        return bArr3;
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        if (getPlaintextLimit(i3) >= 0) {
            int i4 = i3 - 16;
            if (Arrays.constantTimeAreEqual(calculateRecordMAC(initRecordMAC(this.decryptCipher, false, j2), getAdditionalData(j2, s, i4), bArr, i2, i4), Arrays.copyOfRange(bArr, i2 + i4, i3 + i2))) {
                byte[] bArr2 = new byte[i4];
                this.decryptCipher.processBytes(bArr, i2, i4, bArr2, 0);
                return bArr2;
            }
            throw new TlsFatalAlert((short) 20);
        }
        throw new TlsFatalAlert((short) 50);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(long j2, short s, byte[] bArr, int i2, int i3) throws IOException {
        KeyParameter initRecordMAC = initRecordMAC(this.encryptCipher, true, j2);
        byte[] bArr2 = new byte[i3 + 16];
        this.encryptCipher.processBytes(bArr, i2, i3, bArr2, 0);
        byte[] calculateRecordMAC = calculateRecordMAC(initRecordMAC, getAdditionalData(j2, s, i3), bArr2, 0, i3);
        System.arraycopy(calculateRecordMAC, 0, bArr2, i3, calculateRecordMAC.length);
        return bArr2;
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
        return i2 - 16;
    }

    protected KeyParameter initRecordMAC(ChaChaEngine chaChaEngine, boolean z, long j2) {
        byte[] bArr = new byte[8];
        TlsUtils.writeUint64(j2, bArr, 0);
        chaChaEngine.init(z, new ParametersWithIV(null, bArr));
        byte[] bArr2 = new byte[64];
        chaChaEngine.processBytes(bArr2, 0, 64, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr2, 32, 16);
        KeyParameter keyParameter = new KeyParameter(bArr2, 16, 32);
        Poly1305KeyGenerator.clamp(keyParameter.getKey());
        return keyParameter;
    }

    protected void updateRecordMAC(Mac mac, byte[] bArr, int i2, int i3) {
        mac.update(bArr, i2, i3);
        byte[] longToLittleEndian = Pack.longToLittleEndian(i3 & 4294967295L);
        mac.update(longToLittleEndian, 0, longToLittleEndian.length);
    }
}
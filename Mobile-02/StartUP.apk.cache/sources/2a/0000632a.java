package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.RC4Engine;
import org.spongycastle.crypto.engines.SEEDEngine;
import org.spongycastle.crypto.engines.Salsa20Engine;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;

/* loaded from: classes3.dex */
public class DefaultTlsCipherFactory extends AbstractTlsCipherFactory {
    protected AEADBlockCipher createAEADBlockCipher_AES_CCM() {
        return new CCMBlockCipher(createAESEngine());
    }

    protected AEADBlockCipher createAEADBlockCipher_AES_GCM() {
        return new GCMBlockCipher(createAESEngine());
    }

    protected AEADBlockCipher createAEADBlockCipher_Camellia_GCM() {
        return new GCMBlockCipher(createCamelliaEngine());
    }

    protected BlockCipher createAESBlockCipher() {
        return new CBCBlockCipher(createAESEngine());
    }

    protected TlsBlockCipher createAESCipher(TlsContext tlsContext, int i2, int i3) throws IOException {
        return new TlsBlockCipher(tlsContext, createAESBlockCipher(), createAESBlockCipher(), createHMACDigest(i3), createHMACDigest(i3), i2);
    }

    protected BlockCipher createAESEngine() {
        return new AESEngine();
    }

    protected BlockCipher createCamelliaBlockCipher() {
        return new CBCBlockCipher(createCamelliaEngine());
    }

    protected TlsBlockCipher createCamelliaCipher(TlsContext tlsContext, int i2, int i3) throws IOException {
        return new TlsBlockCipher(tlsContext, createCamelliaBlockCipher(), createCamelliaBlockCipher(), createHMACDigest(i3), createHMACDigest(i3), i2);
    }

    protected BlockCipher createCamelliaEngine() {
        return new CamelliaEngine();
    }

    protected TlsCipher createChaCha20Poly1305(TlsContext tlsContext) throws IOException {
        return new Chacha20Poly1305(tlsContext);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsCipherFactory, org.spongycastle.crypto.tls.TlsCipherFactory
    public TlsCipher createCipher(TlsContext tlsContext, int i2, int i3) throws IOException {
        if (i2 != 0) {
            if (i2 != 2) {
                switch (i2) {
                    case 7:
                        return createDESedeCipher(tlsContext, i3);
                    case 8:
                        return createAESCipher(tlsContext, 16, i3);
                    case 9:
                        return createAESCipher(tlsContext, 32, i3);
                    case 10:
                        return createCipher_AES_GCM(tlsContext, 16, 16);
                    case 11:
                        return createCipher_AES_GCM(tlsContext, 32, 16);
                    case 12:
                        return createCamelliaCipher(tlsContext, 16, i3);
                    case 13:
                        return createCamelliaCipher(tlsContext, 32, i3);
                    case 14:
                        return createSEEDCipher(tlsContext, i3);
                    case 15:
                        return createCipher_AES_CCM(tlsContext, 16, 16);
                    case 16:
                        return createCipher_AES_CCM(tlsContext, 16, 8);
                    case 17:
                        return createCipher_AES_CCM(tlsContext, 32, 16);
                    case 18:
                        return createCipher_AES_CCM(tlsContext, 32, 8);
                    case 19:
                        return createCipher_Camellia_GCM(tlsContext, 16, 16);
                    case 20:
                        return createCipher_Camellia_GCM(tlsContext, 32, 16);
                    default:
                        switch (i2) {
                            case 100:
                                return createSalsa20Cipher(tlsContext, 12, 32, i3);
                            case 101:
                                return createSalsa20Cipher(tlsContext, 20, 32, i3);
                            case 102:
                                return createChaCha20Poly1305(tlsContext);
                            default:
                                throw new TlsFatalAlert((short) 80);
                        }
                }
            }
            return createRC4Cipher(tlsContext, 16, i3);
        }
        return createNullCipher(tlsContext, i3);
    }

    protected TlsAEADCipher createCipher_AES_CCM(TlsContext tlsContext, int i2, int i3) throws IOException {
        return new TlsAEADCipher(tlsContext, createAEADBlockCipher_AES_CCM(), createAEADBlockCipher_AES_CCM(), i2, i3);
    }

    protected TlsAEADCipher createCipher_AES_GCM(TlsContext tlsContext, int i2, int i3) throws IOException {
        return new TlsAEADCipher(tlsContext, createAEADBlockCipher_AES_GCM(), createAEADBlockCipher_AES_GCM(), i2, i3);
    }

    protected TlsAEADCipher createCipher_Camellia_GCM(TlsContext tlsContext, int i2, int i3) throws IOException {
        return new TlsAEADCipher(tlsContext, createAEADBlockCipher_Camellia_GCM(), createAEADBlockCipher_Camellia_GCM(), i2, i3);
    }

    protected BlockCipher createDESedeBlockCipher() {
        return new CBCBlockCipher(new DESedeEngine());
    }

    protected TlsBlockCipher createDESedeCipher(TlsContext tlsContext, int i2) throws IOException {
        return new TlsBlockCipher(tlsContext, createDESedeBlockCipher(), createDESedeBlockCipher(), createHMACDigest(i2), createHMACDigest(i2), 24);
    }

    protected Digest createHMACDigest(int i2) throws IOException {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                return TlsUtils.createHash((short) 6);
                            }
                            throw new TlsFatalAlert((short) 80);
                        }
                        return TlsUtils.createHash((short) 5);
                    }
                    return TlsUtils.createHash((short) 4);
                }
                return TlsUtils.createHash((short) 2);
            }
            return TlsUtils.createHash((short) 1);
        }
        return null;
    }

    protected TlsNullCipher createNullCipher(TlsContext tlsContext, int i2) throws IOException {
        return new TlsNullCipher(tlsContext, createHMACDigest(i2), createHMACDigest(i2));
    }

    protected TlsStreamCipher createRC4Cipher(TlsContext tlsContext, int i2, int i3) throws IOException {
        return new TlsStreamCipher(tlsContext, createRC4StreamCipher(), createRC4StreamCipher(), createHMACDigest(i3), createHMACDigest(i3), i2, false);
    }

    protected StreamCipher createRC4StreamCipher() {
        return new RC4Engine();
    }

    protected BlockCipher createSEEDBlockCipher() {
        return new CBCBlockCipher(new SEEDEngine());
    }

    protected TlsBlockCipher createSEEDCipher(TlsContext tlsContext, int i2) throws IOException {
        return new TlsBlockCipher(tlsContext, createSEEDBlockCipher(), createSEEDBlockCipher(), createHMACDigest(i2), createHMACDigest(i2), 16);
    }

    protected TlsStreamCipher createSalsa20Cipher(TlsContext tlsContext, int i2, int i3, int i4) throws IOException {
        return new TlsStreamCipher(tlsContext, createSalsa20StreamCipher(i2), createSalsa20StreamCipher(i2), createHMACDigest(i4), createHMACDigest(i4), i3, true);
    }

    protected StreamCipher createSalsa20StreamCipher(int i2) {
        return new Salsa20Engine(i2);
    }
}
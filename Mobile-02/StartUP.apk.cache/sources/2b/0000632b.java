package org.spongycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class DefaultTlsClient extends AbstractTlsClient {
    public DefaultTlsClient() {
    }

    protected TlsKeyExchange createDHEKeyExchange(int i2) {
        return new TlsDHEKeyExchange(i2, this.supportedSignatureAlgorithms, null);
    }

    protected TlsKeyExchange createDHKeyExchange(int i2) {
        return new TlsDHKeyExchange(i2, this.supportedSignatureAlgorithms, null);
    }

    protected TlsKeyExchange createECDHEKeyExchange(int i2) {
        return new TlsECDHEKeyExchange(i2, this.supportedSignatureAlgorithms, this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
    }

    protected TlsKeyExchange createECDHKeyExchange(int i2) {
        return new TlsECDHKeyExchange(i2, this.supportedSignatureAlgorithms, this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
    }

    protected TlsKeyExchange createRSAKeyExchange() {
        return new TlsRSAKeyExchange(this.supportedSignatureAlgorithms);
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public int[] getCipherSuites() {
        return new int[]{CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 64, 50, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 103, 51, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 60, 47};
    }

    @Override // org.spongycastle.crypto.tls.TlsClient
    public TlsKeyExchange getKeyExchange() throws IOException {
        int keyExchangeAlgorithm = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
        if (keyExchangeAlgorithm != 1) {
            if (keyExchangeAlgorithm == 3 || keyExchangeAlgorithm == 5) {
                return createDHEKeyExchange(keyExchangeAlgorithm);
            }
            if (keyExchangeAlgorithm != 7 && keyExchangeAlgorithm != 9) {
                switch (keyExchangeAlgorithm) {
                    case 16:
                    case 18:
                        return createECDHKeyExchange(keyExchangeAlgorithm);
                    case 17:
                    case 19:
                        return createECDHEKeyExchange(keyExchangeAlgorithm);
                    default:
                        throw new TlsFatalAlert((short) 80);
                }
            }
            return createDHKeyExchange(keyExchangeAlgorithm);
        }
        return createRSAKeyExchange();
    }

    public DefaultTlsClient(TlsCipherFactory tlsCipherFactory) {
        super(tlsCipherFactory);
    }
}
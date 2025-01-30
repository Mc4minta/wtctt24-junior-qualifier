package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.agreement.DHStandardGroups;
import org.spongycastle.crypto.params.DHParameters;

/* loaded from: classes3.dex */
public abstract class DefaultTlsServer extends AbstractTlsServer {
    public DefaultTlsServer() {
    }

    protected TlsKeyExchange createDHEKeyExchange(int i2) {
        return new TlsDHEKeyExchange(i2, this.supportedSignatureAlgorithms, getDHParameters());
    }

    protected TlsKeyExchange createDHKeyExchange(int i2) {
        return new TlsDHKeyExchange(i2, this.supportedSignatureAlgorithms, getDHParameters());
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

    @Override // org.spongycastle.crypto.tls.AbstractTlsServer
    protected int[] getCipherSuites() {
        return new int[]{CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 107, 103, 57, 51, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 61, 60, 53, 47};
    }

    @Override // org.spongycastle.crypto.tls.TlsServer
    public TlsCredentials getCredentials() throws IOException {
        int keyExchangeAlgorithm = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
        if (keyExchangeAlgorithm != 1) {
            if (keyExchangeAlgorithm != 3) {
                if (keyExchangeAlgorithm != 5) {
                    if (keyExchangeAlgorithm != 7) {
                        if (keyExchangeAlgorithm != 19) {
                            if (keyExchangeAlgorithm != 16 && keyExchangeAlgorithm != 17) {
                                throw new TlsFatalAlert((short) 80);
                            }
                            return getECDSASignerCredentials();
                        }
                    }
                }
                return getRSASignerCredentials();
            }
            return getDSASignerCredentials();
        }
        return getRSAEncryptionCredentials();
    }

    protected DHParameters getDHParameters() {
        return DHStandardGroups.rfc5114_2048_256;
    }

    protected TlsSignerCredentials getDSASignerCredentials() throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    protected TlsSignerCredentials getECDSASignerCredentials() throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.TlsServer
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

    protected TlsEncryptionCredentials getRSAEncryptionCredentials() throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    protected TlsSignerCredentials getRSASignerCredentials() throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    public DefaultTlsServer(TlsCipherFactory tlsCipherFactory) {
        super(tlsCipherFactory);
    }
}
package org.spongycastle.crypto.tls;

import java.io.IOException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;

/* loaded from: classes3.dex */
public class DefaultTlsEncryptionCredentials extends AbstractTlsEncryptionCredentials {
    protected Certificate certificate;
    protected TlsContext context;
    protected AsymmetricKeyParameter privateKey;

    public DefaultTlsEncryptionCredentials(TlsContext tlsContext, Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate != null) {
            if (certificate.isEmpty()) {
                throw new IllegalArgumentException("'certificate' cannot be empty");
            }
            if (asymmetricKeyParameter != null) {
                if (asymmetricKeyParameter.isPrivate()) {
                    if (asymmetricKeyParameter instanceof RSAKeyParameters) {
                        this.context = tlsContext;
                        this.certificate = certificate;
                        this.privateKey = asymmetricKeyParameter;
                        return;
                    }
                    throw new IllegalArgumentException("'privateKey' type not supported: " + asymmetricKeyParameter.getClass().getName());
                }
                throw new IllegalArgumentException("'privateKey' must be private");
            }
            throw new IllegalArgumentException("'privateKey' cannot be null");
        }
        throw new IllegalArgumentException("'certificate' cannot be null");
    }

    @Override // org.spongycastle.crypto.tls.TlsEncryptionCredentials
    public byte[] decryptPreMasterSecret(byte[] bArr) throws IOException {
        return TlsRSAUtils.safeDecryptPreMasterSecret(this.context, (RSAKeyParameters) this.privateKey, bArr);
    }

    @Override // org.spongycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.certificate;
    }
}
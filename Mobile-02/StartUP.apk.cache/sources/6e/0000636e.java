package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

/* loaded from: classes3.dex */
public class TlsDHKeyExchange extends AbstractTlsKeyExchange {
    protected TlsAgreementCredentials agreementCredentials;
    protected DHPrivateKeyParameters dhAgreePrivateKey;
    protected DHPublicKeyParameters dhAgreePublicKey;
    protected DHParameters dhParameters;
    protected AsymmetricKeyParameter serverPublicKey;
    protected TlsSigner tlsSigner;

    public TlsDHKeyExchange(int i2, Vector vector, DHParameters dHParameters) {
        super(i2, vector);
        if (i2 == 3) {
            this.tlsSigner = new TlsDSSSigner();
        } else if (i2 == 5) {
            this.tlsSigner = new TlsRSASigner();
        } else if (i2 != 7 && i2 != 9) {
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        } else {
            this.tlsSigner = null;
        }
        this.dhParameters = dHParameters;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials == null) {
            this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhParameters, outputStream);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.dhAgreePublicKey);
        }
        DHPrivateKeyParameters dHPrivateKeyParameters = this.dhAgreePrivateKey;
        if (dHPrivateKeyParameters != null) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, dHPrivateKeyParameters);
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected int getMinimumPrimeBits() {
        return 1024;
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void init(TlsContext tlsContext) {
        super.init(tlsContext);
        TlsSigner tlsSigner = this.tlsSigner;
        if (tlsSigner != null) {
            tlsSigner.init(tlsContext);
        }
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCertificate(Certificate certificate) throws IOException {
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientKeyExchange(InputStream inputStream) throws IOException {
        if (this.dhAgreePublicKey != null) {
            return;
        }
        this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(inputStream), this.dhParameters));
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        if (!certificate.isEmpty()) {
            org.spongycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
            try {
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
                this.serverPublicKey = createKey;
                TlsSigner tlsSigner = this.tlsSigner;
                if (tlsSigner == null) {
                    try {
                        DHPublicKeyParameters validateDHPublicKey = TlsDHUtils.validateDHPublicKey((DHPublicKeyParameters) createKey);
                        this.dhAgreePublicKey = validateDHPublicKey;
                        this.dhParameters = validateDHParameters(validateDHPublicKey.getParameters());
                        TlsUtils.validateKeyUsage(certificateAt, 8);
                    } catch (ClassCastException e2) {
                        throw new TlsFatalAlert((short) 46, e2);
                    }
                } else if (tlsSigner.isValidPublicKey(createKey)) {
                    TlsUtils.validateKeyUsage(certificateAt, 128);
                } else {
                    throw new TlsFatalAlert((short) 46);
                }
                super.processServerCertificate(certificate);
                return;
            } catch (RuntimeException e3) {
                throw new TlsFatalAlert((short) 43, e3);
            }
        }
        throw new TlsFatalAlert((short) 42);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public boolean requiresServerKeyExchange() {
        int i2 = this.keyExchange;
        return i2 == 3 || i2 == 5 || i2 == 11;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        short[] certificateTypes;
        for (short s : certificateRequest.getCertificateTypes()) {
            if (s != 1 && s != 2 && s != 3 && s != 4 && s != 64) {
                throw new TlsFatalAlert((short) 47);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DHParameters validateDHParameters(DHParameters dHParameters) throws IOException {
        if (dHParameters.getP().bitLength() >= getMinimumPrimeBits()) {
            return TlsDHUtils.validateDHParameters(dHParameters);
        }
        throw new TlsFatalAlert((short) 71);
    }
}
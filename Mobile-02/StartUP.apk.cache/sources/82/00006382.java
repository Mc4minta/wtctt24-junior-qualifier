package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

/* loaded from: classes3.dex */
public class TlsPSKKeyExchange extends AbstractTlsKeyExchange {
    protected short[] clientECPointFormats;
    protected DHPrivateKeyParameters dhAgreePrivateKey;
    protected DHPublicKeyParameters dhAgreePublicKey;
    protected DHParameters dhParameters;
    protected ECPrivateKeyParameters ecAgreePrivateKey;
    protected ECPublicKeyParameters ecAgreePublicKey;
    protected int[] namedCurves;
    protected byte[] premasterSecret;
    protected byte[] psk;
    protected TlsPSKIdentity pskIdentity;
    protected TlsPSKIdentityManager pskIdentityManager;
    protected byte[] psk_identity_hint;
    protected RSAKeyParameters rsaServerPublicKey;
    protected TlsEncryptionCredentials serverCredentials;
    protected short[] serverECPointFormats;
    protected AsymmetricKeyParameter serverPublicKey;

    public TlsPSKKeyExchange(int i2, Vector vector, TlsPSKIdentity tlsPSKIdentity, TlsPSKIdentityManager tlsPSKIdentityManager, DHParameters dHParameters, int[] iArr, short[] sArr, short[] sArr2) {
        super(i2, vector);
        this.psk_identity_hint = null;
        this.psk = null;
        this.dhAgreePrivateKey = null;
        this.dhAgreePublicKey = null;
        this.ecAgreePrivateKey = null;
        this.ecAgreePublicKey = null;
        this.serverPublicKey = null;
        this.rsaServerPublicKey = null;
        this.serverCredentials = null;
        if (i2 != 24) {
            switch (i2) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        this.pskIdentity = tlsPSKIdentity;
        this.pskIdentityManager = tlsPSKIdentityManager;
        this.dhParameters = dHParameters;
        this.namedCurves = iArr;
        this.clientECPointFormats = sArr;
        this.serverECPointFormats = sArr2;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        byte[] bArr = this.psk_identity_hint;
        if (bArr == null) {
            this.pskIdentity.skipIdentityHint();
        } else {
            this.pskIdentity.notifyIdentityHint(bArr);
        }
        byte[] pSKIdentity = this.pskIdentity.getPSKIdentity();
        if (pSKIdentity != null) {
            byte[] psk = this.pskIdentity.getPSK();
            this.psk = psk;
            if (psk != null) {
                TlsUtils.writeOpaque16(pSKIdentity, outputStream);
                this.context.getSecurityParameters().pskIdentity = Arrays.clone(pSKIdentity);
                int i2 = this.keyExchange;
                if (i2 == 14) {
                    this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhParameters, outputStream);
                    return;
                } else if (i2 == 24) {
                    this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.serverECPointFormats, this.ecAgreePublicKey.getParameters(), outputStream);
                    return;
                } else if (i2 == 15) {
                    this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, outputStream);
                    return;
                } else {
                    return;
                }
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected byte[] generateOtherSecret(int i2) throws IOException {
        int i3 = this.keyExchange;
        if (i3 == 14) {
            DHPrivateKeyParameters dHPrivateKeyParameters = this.dhAgreePrivateKey;
            if (dHPrivateKeyParameters != null) {
                return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, dHPrivateKeyParameters);
            }
            throw new TlsFatalAlert((short) 80);
        } else if (i3 != 24) {
            if (i3 == 15) {
                return this.premasterSecret;
            }
            return new byte[i2];
        } else {
            ECPrivateKeyParameters eCPrivateKeyParameters = this.ecAgreePrivateKey;
            if (eCPrivateKeyParameters != null) {
                return TlsECCUtils.calculateECDHBasicAgreement(this.ecAgreePublicKey, eCPrivateKeyParameters);
            }
            throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        byte[] generateOtherSecret = generateOtherSecret(this.psk.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(generateOtherSecret.length + 4 + this.psk.length);
        TlsUtils.writeOpaque16(generateOtherSecret, byteArrayOutputStream);
        TlsUtils.writeOpaque16(this.psk, byteArrayOutputStream);
        Arrays.fill(this.psk, (byte) 0);
        this.psk = null;
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        byte[] hint = this.pskIdentityManager.getHint();
        this.psk_identity_hint = hint;
        if (hint != null || requiresServerKeyExchange()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = this.psk_identity_hint;
            if (bArr == null) {
                TlsUtils.writeOpaque16(TlsUtils.EMPTY_BYTES, byteArrayOutputStream);
            } else {
                TlsUtils.writeOpaque16(bArr, byteArrayOutputStream);
            }
            int i2 = this.keyExchange;
            if (i2 == 14) {
                if (this.dhParameters != null) {
                    this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, byteArrayOutputStream);
                } else {
                    throw new TlsFatalAlert((short) 80);
                }
            } else if (i2 == 24) {
                this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.namedCurves, this.clientECPointFormats, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientKeyExchange(InputStream inputStream) throws IOException {
        byte[] readOpaque16;
        byte[] readOpaque162 = TlsUtils.readOpaque16(inputStream);
        byte[] psk = this.pskIdentityManager.getPSK(readOpaque162);
        this.psk = psk;
        if (psk != null) {
            this.context.getSecurityParameters().pskIdentity = readOpaque162;
            int i2 = this.keyExchange;
            if (i2 == 14) {
                this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(inputStream), this.dhParameters));
                return;
            } else if (i2 == 24) {
                byte[] readOpaque8 = TlsUtils.readOpaque8(inputStream);
                this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.serverECPointFormats, this.ecAgreePrivateKey.getParameters(), readOpaque8));
                return;
            } else if (i2 == 15) {
                if (TlsUtils.isSSL(this.context)) {
                    readOpaque16 = Streams.readAll(inputStream);
                } else {
                    readOpaque16 = TlsUtils.readOpaque16(inputStream);
                }
                this.premasterSecret = this.serverCredentials.decryptPreMasterSecret(readOpaque16);
                return;
            } else {
                return;
            }
        }
        throw new TlsFatalAlert(AlertDescription.unknown_psk_identity);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        if (this.keyExchange == 15) {
            if (!certificate.isEmpty()) {
                org.spongycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
                try {
                    AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
                    this.serverPublicKey = createKey;
                    if (!createKey.isPrivate()) {
                        this.rsaServerPublicKey = validateRSAPublicKey((RSAKeyParameters) this.serverPublicKey);
                        TlsUtils.validateKeyUsage(certificateAt, 32);
                        super.processServerCertificate(certificate);
                        return;
                    }
                    throw new TlsFatalAlert((short) 80);
                } catch (RuntimeException e2) {
                    throw new TlsFatalAlert((short) 43, e2);
                }
            }
            throw new TlsFatalAlert((short) 42);
        }
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsEncryptionCredentials) {
            processServerCertificate(tlsCredentials.getCertificate());
            this.serverCredentials = (TlsEncryptionCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        this.psk_identity_hint = TlsUtils.readOpaque16(inputStream);
        int i2 = this.keyExchange;
        if (i2 == 14) {
            DHPublicKeyParameters validateDHPublicKey = TlsDHUtils.validateDHPublicKey(ServerDHParams.parse(inputStream).getPublicKey());
            this.dhAgreePublicKey = validateDHPublicKey;
            this.dhParameters = validateDHPublicKey.getParameters();
        } else if (i2 == 24) {
            this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.clientECPointFormats, TlsECCUtils.readECParameters(this.namedCurves, this.clientECPointFormats, inputStream), TlsUtils.readOpaque8(inputStream)));
        }
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public boolean requiresServerKeyExchange() {
        int i2 = this.keyExchange;
        return i2 == 14 || i2 == 24;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        if (this.keyExchange == 15) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        throw new TlsFatalAlert((short) 10);
    }

    protected RSAKeyParameters validateRSAPublicKey(RSAKeyParameters rSAKeyParameters) throws IOException {
        if (rSAKeyParameters.getExponent().isProbablePrime(2)) {
            return rSAKeyParameters;
        }
        throw new TlsFatalAlert((short) 47);
    }
}
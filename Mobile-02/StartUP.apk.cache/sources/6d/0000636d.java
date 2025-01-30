package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.util.io.TeeInputStream;

/* loaded from: classes3.dex */
public class TlsDHEKeyExchange extends TlsDHKeyExchange {
    protected TlsSignerCredentials serverCredentials;

    public TlsDHEKeyExchange(int i2, Vector vector, DHParameters dHParameters) {
        super(i2, vector, dHParameters);
        this.serverCredentials = null;
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        if (this.dhParameters != null) {
            DigestInputBuffer digestInputBuffer = new DigestInputBuffer();
            this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, digestInputBuffer);
            SignatureAndHashAlgorithm signatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(this.context, this.serverCredentials);
            Digest createHash = TlsUtils.createHash(signatureAndHashAlgorithm);
            SecurityParameters securityParameters = this.context.getSecurityParameters();
            byte[] bArr = securityParameters.clientRandom;
            createHash.update(bArr, 0, bArr.length);
            byte[] bArr2 = securityParameters.serverRandom;
            createHash.update(bArr2, 0, bArr2.length);
            digestInputBuffer.updateDigest(createHash);
            byte[] bArr3 = new byte[createHash.getDigestSize()];
            createHash.doFinal(bArr3, 0);
            new DigitallySigned(signatureAndHashAlgorithm, this.serverCredentials.generateCertificateSignature(bArr3)).encode(digestInputBuffer);
            return digestInputBuffer.toByteArray();
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected Signer initVerifyer(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner.createVerifyer(signatureAndHashAlgorithm, this.serverPublicKey);
        byte[] bArr = securityParameters.clientRandom;
        createVerifyer.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.serverRandom;
        createVerifyer.update(bArr2, 0, bArr2.length);
        return createVerifyer;
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsSignerCredentials) {
            processServerCertificate(tlsCredentials.getCertificate());
            this.serverCredentials = (TlsSignerCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.spongycastle.crypto.tls.AbstractTlsKeyExchange, org.spongycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        SignerInputBuffer signerInputBuffer = new SignerInputBuffer();
        ServerDHParams parse = ServerDHParams.parse(new TeeInputStream(inputStream, signerInputBuffer));
        DigitallySigned parseSignature = parseSignature(inputStream);
        Signer initVerifyer = initVerifyer(this.tlsSigner, parseSignature.getAlgorithm(), securityParameters);
        signerInputBuffer.updateSigner(initVerifyer);
        if (initVerifyer.verifySignature(parseSignature.getSignature())) {
            DHPublicKeyParameters validateDHPublicKey = TlsDHUtils.validateDHPublicKey(parse.getPublicKey());
            this.dhAgreePublicKey = validateDHPublicKey;
            this.dhParameters = validateDHParameters(validateDHPublicKey.getParameters());
            return;
        }
        throw new TlsFatalAlert((short) 51);
    }
}
package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;

/* loaded from: classes3.dex */
public class KeyAgreementSpi extends BaseAgreementSpi {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17825g;
    private BigInteger p;
    private BigInteger x;

    /* loaded from: classes3.dex */
    public static class DHwithRFC2631KDF extends KeyAgreementSpi {
        public DHwithRFC2631KDF() {
            super("DHwithRFC2631KDF", new DHKEKGenerator(new SHA1Digest()));
        }
    }

    public KeyAgreementSpi() {
        super("Diffie-Hellman", null);
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    protected byte[] bigIntToBytes(BigInteger bigInteger) {
        int bitLength = (this.p.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == bitLength) {
            return byteArray;
        }
        if (byteArray[0] == 0 && byteArray.length == bitLength + 1) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            return bArr;
        }
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(byteArray, 0, bArr2, bitLength - byteArray.length, byteArray.length);
        return bArr2;
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.x != null) {
            if (key instanceof DHPublicKey) {
                DHPublicKey dHPublicKey = (DHPublicKey) key;
                if (dHPublicKey.getParams().getG().equals(this.f17825g) && dHPublicKey.getParams().getP().equals(this.p)) {
                    if (z) {
                        this.result = dHPublicKey.getY().modPow(this.x, this.p);
                        return null;
                    }
                    BigInteger modPow = dHPublicKey.getY().modPow(this.x, this.p);
                    this.result = modPow;
                    return new BCDHPublicKey(modPow, dHPublicKey.getParams());
                }
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            }
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.x != null) {
            return super.engineGenerateSecret();
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec != null) {
                if (algorithmParameterSpec instanceof DHParameterSpec) {
                    DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                    this.p = dHParameterSpec.getP();
                    this.f17825g = dHParameterSpec.getG();
                } else if (algorithmParameterSpec instanceof UserKeyingMaterialSpec) {
                    this.p = dHPrivateKey.getParams().getP();
                    this.f17825g = dHPrivateKey.getParams().getG();
                    this.ukmParameters = ((UserKeyingMaterialSpec) algorithmParameterSpec).getUserKeyingMaterial();
                } else {
                    throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
                }
            } else {
                this.p = dHPrivateKey.getParams().getP();
                this.f17825g = dHPrivateKey.getParams().getG();
            }
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    public KeyAgreementSpi(String str, DerivationFunction derivationFunction) {
        super(str, derivationFunction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i2) throws IllegalStateException, ShortBufferException {
        if (this.x != null) {
            return super.engineGenerateSecret(bArr, i2);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        if (this.x != null) {
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            if (str.equals("TlsPremasterSecret")) {
                return new SecretKeySpec(BaseAgreementSpi.trimZeroes(bigIntToBytes), str);
            }
            return super.engineGenerateSecret(str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    protected void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.p = dHPrivateKey.getParams().getP();
            this.f17825g = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.result = x;
            this.x = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
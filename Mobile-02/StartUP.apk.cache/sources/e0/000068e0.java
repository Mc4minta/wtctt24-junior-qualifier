package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

/* loaded from: classes3.dex */
public abstract class McElieceKeyPairGeneratorSpi extends KeyPairGenerator {

    /* loaded from: classes3.dex */
    public static class McElieceCCA2 extends McElieceKeyPairGeneratorSpi {
        McElieceCCA2KeyPairGenerator kpg;

        public McElieceCCA2() {
            super("McElieceCCA-2");
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair generateKeyPair = this.kpg.generateKeyPair();
            return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters) generateKeyPair.getPublic()), new BCMcElieceCCA2PrivateKey((McElieceCCA2PrivateKeyParameters) generateKeyPair.getPrivate()));
        }

        @Override // java.security.KeyPairGenerator
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            this.kpg = new McElieceCCA2KeyPairGenerator();
            super.initialize(algorithmParameterSpec);
            ECCKeyGenParameterSpec eCCKeyGenParameterSpec = (ECCKeyGenParameterSpec) algorithmParameterSpec;
            this.kpg.init(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters(eCCKeyGenParameterSpec.getM(), eCCKeyGenParameterSpec.getT())));
        }

        public McElieceCCA2(String str) {
            super(str);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i2, SecureRandom secureRandom) {
            try {
                initialize(new McElieceCCA2ParameterSpec());
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }
    }

    public McElieceKeyPairGeneratorSpi(String str) {
        super(str);
    }

    /* loaded from: classes3.dex */
    public static class McEliece extends McElieceKeyPairGeneratorSpi {
        McElieceKeyPairGenerator kpg;

        public McEliece() {
            super("McEliece");
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair generateKeyPair = this.kpg.generateKeyPair();
            return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters) generateKeyPair.getPublic()), new BCMcEliecePrivateKey((McEliecePrivateKeyParameters) generateKeyPair.getPrivate()));
        }

        @Override // java.security.KeyPairGenerator
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            this.kpg = new McElieceKeyPairGenerator();
            super.initialize(algorithmParameterSpec);
            ECCKeyGenParameterSpec eCCKeyGenParameterSpec = (ECCKeyGenParameterSpec) algorithmParameterSpec;
            this.kpg.init(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters(eCCKeyGenParameterSpec.getM(), eCCKeyGenParameterSpec.getT())));
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i2, SecureRandom secureRandom) {
            try {
                initialize(new ECCKeyGenParameterSpec());
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }
    }
}
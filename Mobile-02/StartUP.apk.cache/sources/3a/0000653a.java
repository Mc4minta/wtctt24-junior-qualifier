package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

/* loaded from: classes3.dex */
public class SHA3 {

    /* loaded from: classes3.dex */
    public static class Digest224 extends DigestSHA3 {
        public Digest224() {
            super(224);
        }
    }

    /* loaded from: classes3.dex */
    public static class Digest256 extends DigestSHA3 {
        public Digest256() {
            super(256);
        }
    }

    /* loaded from: classes3.dex */
    public static class Digest384 extends DigestSHA3 {
        public Digest384() {
            super(384);
        }
    }

    /* loaded from: classes3.dex */
    public static class Digest512 extends DigestSHA3 {
        public Digest512() {
            super(512);
        }
    }

    /* loaded from: classes3.dex */
    public static class DigestSHA3 extends BCMessageDigest implements Cloneable {
        public DigestSHA3(int i2) {
            super(new SHA3Digest(i2));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            BCMessageDigest bCMessageDigest = (BCMessageDigest) super.clone();
            bCMessageDigest.digest = new SHA3Digest((SHA3Digest) this.digest);
            return bCMessageDigest;
        }
    }

    /* loaded from: classes3.dex */
    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = SHA3.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            sb.append(str);
            sb.append("$Digest224");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-224", sb.toString());
            configurableProvider.addAlgorithm("MessageDigest.SHA3-256", str + "$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-384", str + "$Digest384");
            configurableProvider.addAlgorithm("MessageDigest.SHA3-512", str + "$Digest512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha3_224;
            configurableProvider.addAlgorithm("MessageDigest", aSN1ObjectIdentifier, str + "$Digest224");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha3_256;
            configurableProvider.addAlgorithm("MessageDigest", aSN1ObjectIdentifier2, str + "$Digest256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha3_384;
            configurableProvider.addAlgorithm("MessageDigest", aSN1ObjectIdentifier3, str + "$Digest384");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha3_512;
            configurableProvider.addAlgorithm("MessageDigest", aSN1ObjectIdentifier4, str + "$Digest512");
        }
    }

    private SHA3() {
    }
}
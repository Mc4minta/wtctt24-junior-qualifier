package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.kdf.DHKDFParameters;
import org.spongycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Map<String, ASN1ObjectIdentifier> defaultOids;
    private static final Hashtable des;
    private static final Map<String, Integer> keySizes;
    private static final Map<String, String> nameTable;
    private static final Hashtable oids;
    private final String kaAlgorithm;
    private final DerivationFunction kdf;
    protected BigInteger result;
    protected byte[] ukmParameters;

    static {
        HashMap hashMap = new HashMap();
        defaultOids = hashMap;
        HashMap hashMap2 = new HashMap();
        keySizes = hashMap2;
        HashMap hashMap3 = new HashMap();
        nameTable = hashMap3;
        oids = new Hashtable();
        des = new Hashtable();
        Integer valueOf = Integers.valueOf(64);
        Integer valueOf2 = Integers.valueOf(128);
        Integer valueOf3 = Integers.valueOf(192);
        Integer valueOf4 = Integers.valueOf(256);
        hashMap2.put("DES", valueOf);
        hashMap2.put("DESEDE", valueOf3);
        hashMap2.put("BLOWFISH", valueOf2);
        hashMap2.put("AES", valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes256_CBC;
        hashMap2.put(aSN1ObjectIdentifier.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_wrap;
        hashMap2.put(aSN1ObjectIdentifier2.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes128_CCM;
        hashMap2.put(aSN1ObjectIdentifier3.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.id_camellia128_wrap;
        hashMap2.put(aSN1ObjectIdentifier4.getId(), valueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.id_camellia192_wrap;
        hashMap2.put(aSN1ObjectIdentifier5.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.id_camellia256_wrap;
        hashMap2.put(aSN1ObjectIdentifier6.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
        hashMap2.put(aSN1ObjectIdentifier7.getId(), valueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
        hashMap2.put(aSN1ObjectIdentifier8.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.des_EDE3_CBC;
        hashMap2.put(aSN1ObjectIdentifier9.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = OIWObjectIdentifiers.desCBC;
        hashMap2.put(aSN1ObjectIdentifier10.getId(), valueOf);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        hashMap2.put(aSN1ObjectIdentifier11.getId(), Integers.valueOf(CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256));
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        hashMap2.put(aSN1ObjectIdentifier12.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = PKCSObjectIdentifiers.id_hmacWithSHA384;
        hashMap2.put(aSN1ObjectIdentifier13.getId(), Integers.valueOf(384));
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        hashMap2.put(aSN1ObjectIdentifier14.getId(), Integers.valueOf(512));
        hashMap.put("DESEDE", aSN1ObjectIdentifier9);
        hashMap.put("AES", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NTTObjectIdentifiers.id_camellia256_cbc;
        hashMap.put("CAMELLIA", aSN1ObjectIdentifier15);
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = KISAObjectIdentifiers.id_seedCBC;
        hashMap.put("SEED", aSN1ObjectIdentifier16);
        hashMap.put("DES", aSN1ObjectIdentifier10);
        hashMap3.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
        hashMap3.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
        hashMap3.put(OIWObjectIdentifiers.desECB.getId(), "DES");
        hashMap3.put(aSN1ObjectIdentifier10.getId(), "DES");
        hashMap3.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
        hashMap3.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
        hashMap3.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
        hashMap3.put(aSN1ObjectIdentifier9.getId(), "DESede");
        hashMap3.put(aSN1ObjectIdentifier8.getId(), "DESede");
        hashMap3.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
        hashMap3.put(aSN1ObjectIdentifier11.getId(), "HmacSHA1");
        hashMap3.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
        hashMap3.put(aSN1ObjectIdentifier12.getId(), "HmacSHA256");
        hashMap3.put(aSN1ObjectIdentifier13.getId(), "HmacSHA384");
        hashMap3.put(aSN1ObjectIdentifier14.getId(), "HmacSHA512");
        hashMap3.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
        hashMap3.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
        Map<String, String> map = nameTable;
        map.put(aSN1ObjectIdentifier15.getId(), "Camellia");
        map.put(aSN1ObjectIdentifier4.getId(), "Camellia");
        map.put(aSN1ObjectIdentifier5.getId(), "Camellia");
        map.put(aSN1ObjectIdentifier6.getId(), "Camellia");
        map.put(aSN1ObjectIdentifier7.getId(), "SEED");
        map.put(aSN1ObjectIdentifier16.getId(), "SEED");
        map.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
        map.put(CryptoProObjectIdentifiers.gostR28147_gcfb.getId(), "GOST28147");
        map.put(aSN1ObjectIdentifier2.getId(), "AES");
        map.put(aSN1ObjectIdentifier3.getId(), "AES");
        map.put(aSN1ObjectIdentifier3.getId(), "AES");
        Hashtable hashtable = oids;
        hashtable.put("DESEDE", aSN1ObjectIdentifier9);
        hashtable.put("AES", aSN1ObjectIdentifier);
        hashtable.put("DES", aSN1ObjectIdentifier10);
        Hashtable hashtable2 = des;
        hashtable2.put("DES", "DES");
        hashtable2.put("DESEDE", "DES");
        hashtable2.put(aSN1ObjectIdentifier10.getId(), "DES");
        hashtable2.put(aSN1ObjectIdentifier9.getId(), "DES");
        hashtable2.put(aSN1ObjectIdentifier8.getId(), "DES");
    }

    public BaseAgreementSpi(String str, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.kdf = derivationFunction;
    }

    protected static String getAlgorithm(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(NISTObjectIdentifiers.aes.getId())) {
            return "AES";
        }
        if (str.startsWith(GNUObjectIdentifiers.Serpent.getId())) {
            return "Serpent";
        }
        String str2 = nameTable.get(Strings.toUpperCase(str));
        return str2 != null ? str2 : str;
    }

    protected static int getKeySize(String str) {
        if (str.indexOf(91) > 0) {
            return (Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93))) + 7) / 8;
        }
        String upperCase = Strings.toUpperCase(str);
        Map<String, Integer> map = keySizes;
        if (map.containsKey(upperCase)) {
            return map.get(upperCase).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] trimZeroes(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i2 = 0;
        while (i2 < bArr.length && bArr[i2] == 0) {
            i2++;
        }
        int length = bArr.length - i2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, 0, length);
        return bArr2;
    }

    protected abstract byte[] bigIntToBytes(BigInteger bigInteger);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) {
            return bigIntToBytes(this.result);
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i2) throws IllegalStateException, ShortBufferException {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i2 >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i2, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + engineGenerateSecret.length + " bytes");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        byte[] bigIntToBytes = bigIntToBytes(this.result);
        String upperCase = Strings.toUpperCase(str);
        Hashtable hashtable = oids;
        String id = hashtable.containsKey(upperCase) ? ((ASN1ObjectIdentifier) hashtable.get(upperCase)).getId() : str;
        int keySize = getKeySize(id);
        DerivationFunction derivationFunction = this.kdf;
        if (derivationFunction != null) {
            if (keySize >= 0) {
                int i2 = keySize / 8;
                byte[] bArr = new byte[i2];
                if (derivationFunction instanceof DHKEKGenerator) {
                    try {
                        this.kdf.init(new DHKDFParameters(new ASN1ObjectIdentifier(id), keySize, bigIntToBytes, this.ukmParameters));
                    } catch (IllegalArgumentException unused) {
                        throw new NoSuchAlgorithmException("no OID for algorithm: " + id);
                    }
                } else {
                    this.kdf.init(new KDFParameters(bigIntToBytes, this.ukmParameters));
                }
                this.kdf.generateBytes(bArr, 0, i2);
                bigIntToBytes = bArr;
            } else {
                throw new NoSuchAlgorithmException("unknown algorithm encountered: " + id);
            }
        } else if (keySize > 0) {
            int i3 = keySize / 8;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bigIntToBytes, 0, bArr2, 0, i3);
            bigIntToBytes = bArr2;
        }
        if (des.containsKey(id)) {
            DESParameters.setOddParity(bigIntToBytes);
        }
        return new SecretKeySpec(bigIntToBytes, getAlgorithm(str));
    }
}
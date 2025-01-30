package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class DigestFactory {
    private static Set md5 = new HashSet();
    private static Set sha1 = new HashSet();
    private static Set sha224 = new HashSet();
    private static Set sha256 = new HashSet();
    private static Set sha384 = new HashSet();
    private static Set sha512 = new HashSet();
    private static Set sha512_224 = new HashSet();
    private static Set sha512_256 = new HashSet();
    private static Map oids = new HashMap();

    static {
        md5.add("MD5");
        Set set = md5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.md5;
        set.add(aSN1ObjectIdentifier.getId());
        sha1.add("SHA1");
        sha1.add("SHA-1");
        Set set2 = sha1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.idSHA1;
        set2.add(aSN1ObjectIdentifier2.getId());
        sha224.add("SHA224");
        sha224.add("SHA-224");
        Set set3 = sha224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        set3.add(aSN1ObjectIdentifier3.getId());
        sha256.add(McElieceCCA2ParameterSpec.DEFAULT_MD);
        sha256.add("SHA-256");
        Set set4 = sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        set4.add(aSN1ObjectIdentifier4.getId());
        sha384.add("SHA384");
        sha384.add("SHA-384");
        Set set5 = sha384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        set5.add(aSN1ObjectIdentifier5.getId());
        sha512.add("SHA512");
        sha512.add("SHA-512");
        Set set6 = sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        set6.add(aSN1ObjectIdentifier6.getId());
        sha512_224.add("SHA512(224)");
        sha512_224.add("SHA-512(224)");
        Set set7 = sha512_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha512_224;
        set7.add(aSN1ObjectIdentifier7.getId());
        sha512_256.add("SHA512(256)");
        sha512_256.add("SHA-512(256)");
        Set set8 = sha512_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_sha512_256;
        set8.add(aSN1ObjectIdentifier8.getId());
        oids.put("MD5", aSN1ObjectIdentifier);
        oids.put(aSN1ObjectIdentifier.getId(), aSN1ObjectIdentifier);
        oids.put("SHA1", aSN1ObjectIdentifier2);
        oids.put("SHA-1", aSN1ObjectIdentifier2);
        oids.put(aSN1ObjectIdentifier2.getId(), aSN1ObjectIdentifier2);
        oids.put("SHA224", aSN1ObjectIdentifier3);
        oids.put("SHA-224", aSN1ObjectIdentifier3);
        oids.put(aSN1ObjectIdentifier3.getId(), aSN1ObjectIdentifier3);
        oids.put(McElieceCCA2ParameterSpec.DEFAULT_MD, aSN1ObjectIdentifier4);
        oids.put("SHA-256", aSN1ObjectIdentifier4);
        oids.put(aSN1ObjectIdentifier4.getId(), aSN1ObjectIdentifier4);
        oids.put("SHA384", aSN1ObjectIdentifier5);
        oids.put("SHA-384", aSN1ObjectIdentifier5);
        oids.put(aSN1ObjectIdentifier5.getId(), aSN1ObjectIdentifier5);
        oids.put("SHA512", aSN1ObjectIdentifier6);
        oids.put("SHA-512", aSN1ObjectIdentifier6);
        oids.put(aSN1ObjectIdentifier6.getId(), aSN1ObjectIdentifier6);
        oids.put("SHA512(224)", aSN1ObjectIdentifier7);
        oids.put("SHA-512(224)", aSN1ObjectIdentifier7);
        oids.put(aSN1ObjectIdentifier7.getId(), aSN1ObjectIdentifier7);
        oids.put("SHA512(256)", aSN1ObjectIdentifier8);
        oids.put("SHA-512(256)", aSN1ObjectIdentifier8);
        oids.put(aSN1ObjectIdentifier8.getId(), aSN1ObjectIdentifier8);
    }

    public static Digest getDigest(String str) {
        String upperCase = Strings.toUpperCase(str);
        if (sha1.contains(upperCase)) {
            return new SHA1Digest();
        }
        if (md5.contains(upperCase)) {
            return new MD5Digest();
        }
        if (sha224.contains(upperCase)) {
            return new SHA224Digest();
        }
        if (sha256.contains(upperCase)) {
            return new SHA256Digest();
        }
        if (sha384.contains(upperCase)) {
            return new SHA384Digest();
        }
        if (sha512.contains(upperCase)) {
            return new SHA512Digest();
        }
        if (sha512_224.contains(upperCase)) {
            return new SHA512tDigest(224);
        }
        if (sha512_256.contains(upperCase)) {
            return new SHA512tDigest(256);
        }
        return null;
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) oids.get(str);
    }

    public static boolean isSameDigest(String str, String str2) {
        return (sha1.contains(str) && sha1.contains(str2)) || (sha224.contains(str) && sha224.contains(str2)) || ((sha256.contains(str) && sha256.contains(str2)) || ((sha384.contains(str) && sha384.contains(str2)) || ((sha512.contains(str) && sha512.contains(str2)) || ((sha512_224.contains(str) && sha512_224.contains(str2)) || ((sha512_256.contains(str) && sha512_256.contains(str2)) || (md5.contains(str) && md5.contains(str2)))))));
    }
}
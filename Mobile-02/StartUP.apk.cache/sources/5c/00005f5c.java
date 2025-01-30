package org.spongycastle.asn1.bc;

import okhttp3.internal.cache.DiskLruCache;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes3.dex */
public interface BCObjectIdentifiers {
    public static final ASN1ObjectIdentifier bc;
    public static final ASN1ObjectIdentifier bc_pbe;
    public static final ASN1ObjectIdentifier bc_pbe_sha1;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs5;
    public static final ASN1ObjectIdentifier bc_pbe_sha224;
    public static final ASN1ObjectIdentifier bc_pbe_sha256;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc;
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs5;
    public static final ASN1ObjectIdentifier bc_pbe_sha384;
    public static final ASN1ObjectIdentifier bc_pbe_sha512;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        bc = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch(DiskLruCache.VERSION_1);
        bc_pbe = branch;
        ASN1ObjectIdentifier branch2 = branch.branch(DiskLruCache.VERSION_1);
        bc_pbe_sha1 = branch2;
        ASN1ObjectIdentifier branch3 = branch.branch("2.1");
        bc_pbe_sha256 = branch3;
        bc_pbe_sha384 = branch.branch("2.2");
        bc_pbe_sha512 = branch.branch("2.3");
        bc_pbe_sha224 = branch.branch("2.4");
        bc_pbe_sha1_pkcs5 = branch2.branch(DiskLruCache.VERSION_1);
        ASN1ObjectIdentifier branch4 = branch2.branch("2");
        bc_pbe_sha1_pkcs12 = branch4;
        bc_pbe_sha256_pkcs5 = branch3.branch(DiskLruCache.VERSION_1);
        ASN1ObjectIdentifier branch5 = branch3.branch("2");
        bc_pbe_sha256_pkcs12 = branch5;
        bc_pbe_sha1_pkcs12_aes128_cbc = branch4.branch("1.2");
        bc_pbe_sha1_pkcs12_aes192_cbc = branch4.branch("1.22");
        bc_pbe_sha1_pkcs12_aes256_cbc = branch4.branch("1.42");
        bc_pbe_sha256_pkcs12_aes128_cbc = branch5.branch("1.2");
        bc_pbe_sha256_pkcs12_aes192_cbc = branch5.branch("1.22");
        bc_pbe_sha256_pkcs12_aes256_cbc = branch5.branch("1.42");
    }
}
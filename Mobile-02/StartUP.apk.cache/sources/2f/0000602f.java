package org.spongycastle.asn1.misc;

import okhttp3.internal.cache.DiskLruCache;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes3.dex */
public interface MiscObjectIdentifiers {
    public static final ASN1ObjectIdentifier as_sys_sec_alg_ideaCBC;
    public static final ASN1ObjectIdentifier blake2;
    public static final ASN1ObjectIdentifier cast5CBC;
    public static final ASN1ObjectIdentifier cryptlib;
    public static final ASN1ObjectIdentifier cryptlib_algorithm;
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_CBC;
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_CFB;
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_ECB;
    public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_OFB;
    public static final ASN1ObjectIdentifier entrust;
    public static final ASN1ObjectIdentifier entrustVersionExtension;
    public static final ASN1ObjectIdentifier id_blake2b160;
    public static final ASN1ObjectIdentifier id_blake2b256;
    public static final ASN1ObjectIdentifier id_blake2b384;
    public static final ASN1ObjectIdentifier id_blake2b512;
    public static final ASN1ObjectIdentifier netscape;
    public static final ASN1ObjectIdentifier netscapeBaseURL;
    public static final ASN1ObjectIdentifier netscapeCARevocationURL;
    public static final ASN1ObjectIdentifier netscapeCApolicyURL;
    public static final ASN1ObjectIdentifier netscapeCertComment;
    public static final ASN1ObjectIdentifier netscapeCertType;
    public static final ASN1ObjectIdentifier netscapeRenewalURL;
    public static final ASN1ObjectIdentifier netscapeRevocationURL;
    public static final ASN1ObjectIdentifier netscapeSSLServerName;
    public static final ASN1ObjectIdentifier novell;
    public static final ASN1ObjectIdentifier novellSecurityAttribs;
    public static final ASN1ObjectIdentifier verisign;
    public static final ASN1ObjectIdentifier verisignBitString_6_13;
    public static final ASN1ObjectIdentifier verisignCzagExtension;
    public static final ASN1ObjectIdentifier verisignDnbDunsNumber;
    public static final ASN1ObjectIdentifier verisignIssStrongCrypto;
    public static final ASN1ObjectIdentifier verisignOnSiteJurisdictionHash;
    public static final ASN1ObjectIdentifier verisignPrivate_6_9;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113730.1");
        netscape = aSN1ObjectIdentifier;
        netscapeCertType = aSN1ObjectIdentifier.branch(DiskLruCache.VERSION_1);
        netscapeBaseURL = aSN1ObjectIdentifier.branch("2");
        netscapeRevocationURL = aSN1ObjectIdentifier.branch("3");
        netscapeCARevocationURL = aSN1ObjectIdentifier.branch("4");
        netscapeRenewalURL = aSN1ObjectIdentifier.branch("7");
        netscapeCApolicyURL = aSN1ObjectIdentifier.branch("8");
        netscapeSSLServerName = aSN1ObjectIdentifier.branch("12");
        netscapeCertComment = aSN1ObjectIdentifier.branch("13");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.16.840.1.113733.1");
        verisign = aSN1ObjectIdentifier2;
        verisignCzagExtension = aSN1ObjectIdentifier2.branch("6.3");
        verisignPrivate_6_9 = aSN1ObjectIdentifier2.branch("6.9");
        verisignOnSiteJurisdictionHash = aSN1ObjectIdentifier2.branch("6.11");
        verisignBitString_6_13 = aSN1ObjectIdentifier2.branch("6.13");
        verisignDnbDunsNumber = aSN1ObjectIdentifier2.branch("6.15");
        verisignIssStrongCrypto = aSN1ObjectIdentifier2.branch("8.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.16.840.1.113719");
        novell = aSN1ObjectIdentifier3;
        novellSecurityAttribs = aSN1ObjectIdentifier3.branch("1.9.4.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.2.840.113533.7");
        entrust = aSN1ObjectIdentifier4;
        entrustVersionExtension = aSN1ObjectIdentifier4.branch("65.0");
        cast5CBC = aSN1ObjectIdentifier4.branch("66.10");
        as_sys_sec_alg_ideaCBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
        cryptlib = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier5.branch(DiskLruCache.VERSION_1);
        cryptlib_algorithm = branch;
        cryptlib_algorithm_blowfish_ECB = branch.branch("1.1");
        cryptlib_algorithm_blowfish_CBC = branch.branch("1.2");
        cryptlib_algorithm_blowfish_CFB = branch.branch("1.3");
        cryptlib_algorithm_blowfish_OFB = branch.branch("1.4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("1.3.6.1.4.1.1722.12.2");
        blake2 = aSN1ObjectIdentifier6;
        id_blake2b160 = aSN1ObjectIdentifier6.branch("1.5");
        id_blake2b256 = aSN1ObjectIdentifier6.branch("1.8");
        id_blake2b384 = aSN1ObjectIdentifier6.branch("1.12");
        id_blake2b512 = aSN1ObjectIdentifier6.branch("1.16");
    }
}
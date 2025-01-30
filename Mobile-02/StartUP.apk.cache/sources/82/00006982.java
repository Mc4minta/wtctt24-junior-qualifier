package org.spongycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509Extension;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.PKIXPolicyNode;
import org.spongycastle.util.Encodable;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;

/* loaded from: classes3.dex */
class CertPathValidatorUtilities {
    protected static final String ANY_POLICY = "2.5.29.32.0";
    protected static final int CRL_SIGN = 6;
    protected static final int KEY_CERT_SIGN = 5;
    protected static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
    protected static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    protected static final String BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    protected static final String POLICY_MAPPINGS = Extension.policyMappings.getId();
    protected static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    protected static final String NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    protected static final String KEY_USAGE = Extension.keyUsage.getId();
    protected static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    protected static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    protected static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    protected static final String POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    protected static final String FRESHEST_CRL = Extension.freshestCRL.getId();
    protected static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    protected static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    protected static final String CRL_NUMBER = Extension.cRLNumber.getId();
    protected static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    protected static void addAdditionalStoreFromLocation(String str, ExtendedPKIXParameters extendedPKIXParameters) {
        String str2;
        if (extendedPKIXParameters.isAdditionalLocationsEnabled()) {
            try {
                if (str.startsWith("ldap://")) {
                    String substring = str.substring(7);
                    String str3 = null;
                    if (substring.indexOf("/") != -1) {
                        str3 = substring.substring(substring.indexOf("/"));
                        str2 = "ldap://" + substring.substring(0, substring.indexOf("/"));
                    } else {
                        str2 = "ldap://" + substring;
                    }
                    X509LDAPCertStoreParameters build = new X509LDAPCertStoreParameters.Builder(str2, str3).build();
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CERTIFICATE/LDAP", build, BouncyCastleProvider.PROVIDER_NAME));
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CRL/LDAP", build, BouncyCastleProvider.PROVIDER_NAME));
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("ATTRIBUTECERTIFICATE/LDAP", build, BouncyCastleProvider.PROVIDER_NAME));
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CERTIFICATEPAIR/LDAP", build, BouncyCastleProvider.PROVIDER_NAME));
                }
            } catch (Exception unused) {
                throw new RuntimeException("Exception adding X.509 stores.");
            }
        }
    }

    protected static void addAdditionalStoresFromAltNames(X509Certificate x509Certificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertificateParsingException {
        if (x509Certificate.getIssuerAlternativeNames() != null) {
            for (List<?> list : x509Certificate.getIssuerAlternativeNames()) {
                if (list.get(0).equals(Integers.valueOf(6))) {
                    addAdditionalStoreFromLocation((String) list.get(1), extendedPKIXParameters);
                }
            }
        }
    }

    protected static void addAdditionalStoresFromCRLDistributionPoint(CRLDistPoint cRLDistPoint, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        if (cRLDistPoint != null) {
            try {
                for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                    DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                    if (distributionPoint2 != null && distributionPoint2.getType() == 0) {
                        GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                        for (int i2 = 0; i2 < names.length; i2++) {
                            if (names[i2].getTagNo() == 6) {
                                addAdditionalStoreFromLocation(DERIA5String.getInstance(names[i2].getName()).getString(), extendedPKIXParameters);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                throw new AnnotatedException("Distribution points could not be read.", e2);
            }
        }
    }

    protected static Collection findCertificates(X509CertStoreSelector x509CertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        CertificateFactory certificateFactory = new CertificateFactory();
        for (Object obj : list) {
            if (obj instanceof Store) {
                try {
                    for (Object obj2 : ((Store) obj).getMatches(x509CertStoreSelector)) {
                        if (obj2 instanceof Encodable) {
                            hashSet.add(certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(((Encodable) obj2).getEncoded())));
                        } else if (obj2 instanceof Certificate) {
                            hashSet.add(obj2);
                        } else {
                            throw new AnnotatedException("Unknown object found in certificate store.");
                        }
                    }
                    continue;
                } catch (IOException e2) {
                    throw new AnnotatedException("Problem while extracting certificates from X.509 store.", e2);
                } catch (CertificateException e3) {
                    throw new AnnotatedException("Problem while extracting certificates from X.509 store.", e3);
                } catch (StoreException e4) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e4);
                }
            } else {
                try {
                    hashSet.addAll(((CertStore) obj).getCertificates(x509CertStoreSelector));
                } catch (CertStoreException e5) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e5);
                }
            }
        }
        return hashSet;
    }

    static Collection findIssuerCerts(X509Certificate x509Certificate, List list, List list2) throws AnnotatedException {
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(x509Certificate.getIssuerX500Principal().getEncoded());
            PKIXCertStoreSelector<? extends Certificate> build = new PKIXCertStoreSelector.Builder(x509CertSelector).build();
            HashSet hashSet = new HashSet();
            try {
                ArrayList<X509Certificate> arrayList = new ArrayList();
                arrayList.addAll(findCertificates(build, list));
                arrayList.addAll(findCertificates(build, list2));
                for (X509Certificate x509Certificate2 : arrayList) {
                    hashSet.add(x509Certificate2);
                }
                return hashSet;
            } catch (AnnotatedException e2) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e2);
            }
        } catch (IOException e3) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e3);
        }
    }

    protected static TrustAnchor findTrustAnchor(X509Certificate x509Certificate, Set set) throws AnnotatedException {
        return findTrustAnchor(x509Certificate, set, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getAlgorithmId();
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e2);
        }
    }

    protected static void getCRLIssuersFromDistributionPoint(DistributionPoint distributionPoint, Collection collection, X509CRLSelector x509CRLSelector, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        ArrayList<X500Principal> arrayList = new ArrayList();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            for (int i2 = 0; i2 < names.length; i2++) {
                if (names[i2].getTagNo() == 4) {
                    try {
                        arrayList.add(new X500Principal(names[i2].getName().toASN1Primitive().getEncoded()));
                    } catch (IOException e2) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e2);
                    }
                }
            }
        } else if (distributionPoint.getDistributionPoint() != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add((X500Principal) it.next());
            }
        } else {
            throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
        }
        for (X500Principal x500Principal : arrayList) {
            try {
                x509CRLSelector.addIssuerName(x500Principal.getEncoded());
            } catch (IOException e3) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e3);
            }
        }
    }

    protected static void getCertStatus(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        X509CRLEntry revokedCertificate;
        try {
            if (isIndirectCRL(x509crl)) {
                revokedCertificate = x509crl.getRevokedCertificate(getSerialNumber(obj));
                if (revokedCertificate == null) {
                    return;
                }
                X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                if (certificateIssuer == null) {
                    certificateIssuer = getIssuerPrincipal(x509crl);
                }
                if (!getEncodedIssuerPrincipal(obj).equals(certificateIssuer)) {
                    return;
                }
            } else if (!getEncodedIssuerPrincipal(obj).equals(getIssuerPrincipal(x509crl)) || (revokedCertificate = x509crl.getRevokedCertificate(getSerialNumber(obj))) == null) {
                return;
            }
            ASN1Enumerated aSN1Enumerated = null;
            if (revokedCertificate.hasExtensions()) {
                try {
                    aSN1Enumerated = ASN1Enumerated.getInstance(getExtensionValue(revokedCertificate, X509Extension.reasonCode.getId()));
                } catch (Exception e2) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e2);
                }
            }
            if (date.getTime() >= revokedCertificate.getRevocationDate().getTime() || aSN1Enumerated == null || aSN1Enumerated.getValue().intValue() == 0 || aSN1Enumerated.getValue().intValue() == 1 || aSN1Enumerated.getValue().intValue() == 2 || aSN1Enumerated.getValue().intValue() == 8) {
                if (aSN1Enumerated != null) {
                    certStatus.setCertStatus(aSN1Enumerated.getValue().intValue());
                } else {
                    certStatus.setCertStatus(0);
                }
                certStatus.setRevocationDate(revokedCertificate.getRevocationDate());
            }
        } catch (CRLException e3) {
            throw new AnnotatedException("Failed check for indirect CRL.", e3);
        }
    }

    protected static Set getCompleteCRLs(DistributionPoint distributionPoint, Object obj, Date date, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            HashSet hashSet = new HashSet();
            if (obj instanceof X509AttributeCertificate) {
                hashSet.add(((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0]);
            } else {
                hashSet.add(getEncodedIssuerPrincipal(obj));
            }
            getCRLIssuersFromDistributionPoint(distributionPoint, hashSet, x509CRLStoreSelector, extendedPKIXParameters);
            if (obj instanceof X509Certificate) {
                x509CRLStoreSelector.setCertificateChecking((X509Certificate) obj);
            } else if (obj instanceof X509AttributeCertificate) {
                x509CRLStoreSelector.setAttrCertificateChecking((X509AttributeCertificate) obj);
            }
            x509CRLStoreSelector.setCompleteCRLEnabled(true);
            Set findCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, extendedPKIXParameters, date);
            if (findCRLs.isEmpty()) {
                if (obj instanceof X509AttributeCertificate) {
                    throw new AnnotatedException("No CRLs found for issuer \"" + ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0] + "\"");
                }
                throw new AnnotatedException("No CRLs found for issuer \"" + ((X509Certificate) obj).getIssuerX500Principal() + "\"");
            }
            return findCRLs;
        } catch (AnnotatedException e2) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e2);
        }
    }

    protected static Set getDeltaCRLs(Date date, ExtendedPKIXParameters extendedPKIXParameters, X509CRL x509crl) throws AnnotatedException {
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            x509CRLStoreSelector.addIssuerName(getIssuerPrincipal(x509crl).getEncoded());
            try {
                ASN1Primitive extensionValue = getExtensionValue(x509crl, CRL_NUMBER);
                BigInteger positiveValue = extensionValue != null ? ASN1Integer.getInstance(extensionValue).getPositiveValue() : null;
                try {
                    byte[] extensionValue2 = x509crl.getExtensionValue(ISSUING_DISTRIBUTION_POINT);
                    x509CRLStoreSelector.setMinCRLNumber(positiveValue != null ? positiveValue.add(BigInteger.valueOf(1L)) : null);
                    x509CRLStoreSelector.setIssuingDistributionPoint(extensionValue2);
                    x509CRLStoreSelector.setIssuingDistributionPointEnabled(true);
                    x509CRLStoreSelector.setMaxBaseCRLNumber(positiveValue);
                    Set<X509CRL> findCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, extendedPKIXParameters, date);
                    HashSet hashSet = new HashSet();
                    for (X509CRL x509crl2 : findCRLs) {
                        if (isDeltaCRL(x509crl2)) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e2) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e2);
                }
            } catch (Exception e3) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e3);
            }
        } catch (IOException e4) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static X500Principal getEncodedIssuerPrincipal(Object obj) {
        if (obj instanceof X509Certificate) {
            return ((X509Certificate) obj).getIssuerX500Principal();
        }
        return (X500Principal) ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ASN1Primitive getExtensionValue(java.security.cert.X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return getObject(str, extensionValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static X500Principal getIssuerPrincipal(X509CRL x509crl) {
        return x509crl.getIssuerX500Principal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PublicKey getNextWorkingKey(List list, int i2) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i2)).getPublicKey();
        if (publicKey instanceof DSAPublicKey) {
            DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
            if (dSAPublicKey2.getParams() != null) {
                return dSAPublicKey2;
            }
            do {
                i2++;
                if (i2 < list.size()) {
                    PublicKey publicKey2 = ((X509Certificate) list.get(i2)).getPublicKey();
                    if (publicKey2 instanceof DSAPublicKey) {
                        dSAPublicKey = (DSAPublicKey) publicKey2;
                    } else {
                        throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
                    }
                } else {
                    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
                }
            } while (dSAPublicKey.getParams() == null);
            DSAParams params = dSAPublicKey.getParams();
            try {
                return KeyFactory.getInstance("DSA", BouncyCastleProvider.PROVIDER_NAME).generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
            } catch (Exception e2) {
                throw new RuntimeException(e2.getMessage());
            }
        }
        return publicKey;
    }

    private static ASN1Primitive getObject(String str, byte[] bArr) throws AnnotatedException {
        try {
            return new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(bArr).readObject()).getOctets()).readObject();
        } catch (Exception e2) {
            throw new AnnotatedException("exception processing extension " + str, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final Set getQualifierSet(ASN1Sequence aSN1Sequence) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            try {
                aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e2) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e2);
            }
        }
        return hashSet;
    }

    private static BigInteger getSerialNumber(Object obj) {
        if (obj instanceof X509Certificate) {
            return ((X509Certificate) obj).getSerialNumber();
        }
        return ((X509AttributeCertificate) obj).getSerialNumber();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static X500Principal getSubjectPrincipal(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectX500Principal();
    }

    protected static Date getValidCertDateFromValidityModel(ExtendedPKIXParameters extendedPKIXParameters, CertPath certPath, int i2) throws AnnotatedException {
        if (extendedPKIXParameters.getValidityModel() == 1) {
            if (i2 <= 0) {
                return getValidDate(extendedPKIXParameters);
            }
            int i3 = i2 - 1;
            if (i3 == 0) {
                try {
                    byte[] extensionValue = ((X509Certificate) certPath.getCertificates().get(i3)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
                    ASN1GeneralizedTime aSN1GeneralizedTime = extensionValue != null ? ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(extensionValue)) : null;
                    if (aSN1GeneralizedTime != null) {
                        try {
                            return aSN1GeneralizedTime.getDate();
                        } catch (ParseException e2) {
                            throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e2);
                        }
                    }
                    return ((X509Certificate) certPath.getCertificates().get(i3)).getNotBefore();
                } catch (IOException unused) {
                    throw new AnnotatedException("Date of cert gen extension could not be read.");
                } catch (IllegalArgumentException unused2) {
                    throw new AnnotatedException("Date of cert gen extension could not be read.");
                }
            }
            return ((X509Certificate) certPath.getCertificates().get(i3)).getNotBefore();
        }
        return getValidDate(extendedPKIXParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date getValidDate(PKIXParameters pKIXParameters) {
        Date date = pKIXParameters.getDate();
        return date == null ? new Date() : date;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isAnyPolicy(Set set) {
        return set == null || set.contains("2.5.29.32.0") || set.isEmpty();
    }

    private static boolean isDeltaCRL(X509CRL x509crl) {
        Set<String> criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        return criticalExtensionOIDs.contains(Extension.deltaCRLIndicator.getId());
    }

    static boolean isIndirectCRL(X509CRL x509crl) throws CRLException {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(Extension.issuingDistributionPoint.getId());
            if (extensionValue != null) {
                if (IssuingDistributionPoint.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).isIndirectCRL()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            throw new CRLException("Exception reading IssuingDistributionPoint: " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isSelfIssued(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void prepareNextCertB1(int i2, List[] listArr, String str, Map map, X509Certificate x509Certificate) throws AnnotatedException, CertPathValidatorException {
        boolean z;
        Iterator it = listArr[i2].iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) it.next();
            if (pKIXPolicyNode.getValidPolicy().equals(str)) {
                z = true;
                pKIXPolicyNode.setExpectedPolicies((Set) map.get(str));
                break;
            }
        }
        if (z) {
            return;
        }
        for (PKIXPolicyNode pKIXPolicyNode2 : listArr[i2]) {
            if ("2.5.29.32.0".equals(pKIXPolicyNode2.getValidPolicy())) {
                Set set = null;
                try {
                    Enumeration objects = ASN1Sequence.getInstance(getExtensionValue(x509Certificate, CERTIFICATE_POLICIES)).getObjects();
                    while (true) {
                        if (!objects.hasMoreElements()) {
                            break;
                        }
                        try {
                            PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                            if ("2.5.29.32.0".equals(policyInformation.getPolicyIdentifier().getId())) {
                                try {
                                    set = getQualifierSet(policyInformation.getPolicyQualifiers());
                                    break;
                                } catch (CertPathValidatorException e2) {
                                    throw new ExtCertPathValidatorException("Policy qualifier info set could not be built.", e2);
                                }
                            }
                        } catch (Exception e3) {
                            throw new AnnotatedException("Policy information cannot be decoded.", e3);
                        }
                    }
                    Set set2 = set;
                    boolean contains = x509Certificate.getCriticalExtensionOIDs() != null ? x509Certificate.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES) : false;
                    PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
                    if ("2.5.29.32.0".equals(pKIXPolicyNode3.getValidPolicy())) {
                        PKIXPolicyNode pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i2, (Set) map.get(str), pKIXPolicyNode3, set2, str, contains);
                        pKIXPolicyNode3.addChild(pKIXPolicyNode4);
                        listArr[i2].add(pKIXPolicyNode4);
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    throw new AnnotatedException("Certificate policies cannot be decoded.", e4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PKIXPolicyNode prepareNextCertB2(int i2, List[] listArr, String str, PKIXPolicyNode pKIXPolicyNode) {
        int i3;
        Iterator it = listArr[i2].iterator();
        while (it.hasNext()) {
            PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) it.next();
            if (pKIXPolicyNode2.getValidPolicy().equals(str)) {
                ((PKIXPolicyNode) pKIXPolicyNode2.getParent()).removeChild(pKIXPolicyNode2);
                it.remove();
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    List list = listArr[i4];
                    while (i3 < list.size()) {
                        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) list.get(i3);
                        i3 = (pKIXPolicyNode3.hasChildren() || (pKIXPolicyNode = removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode3)) != null) ? i3 + 1 : 0;
                    }
                }
            }
        }
        return pKIXPolicyNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean processCertD1i(int i2, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i2 - 1];
        for (int i3 = 0; i3 < list.size(); i3++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i3);
            if (pKIXPolicyNode.getExpectedPolicies().contains(aSN1ObjectIdentifier.getId())) {
                HashSet hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i2, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i2].add(pKIXPolicyNode2);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void processCertD1ii(int i2, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i2 - 1];
        for (int i3 = 0; i3 < list.size(); i3++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i3);
            if ("2.5.29.32.0".equals(pKIXPolicyNode.getValidPolicy())) {
                HashSet hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i2, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i2].add(pKIXPolicyNode2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PKIXPolicyNode removePolicyNode(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode == null) {
            return null;
        }
        if (pKIXPolicyNode3 == null) {
            for (int i2 = 0; i2 < listArr.length; i2++) {
                listArr[i2] = new ArrayList();
            }
            return null;
        }
        pKIXPolicyNode3.removeChild(pKIXPolicyNode2);
        removePolicyNodeRecurse(listArr, pKIXPolicyNode2);
        return pKIXPolicyNode;
    }

    private static void removePolicyNodeRecurse(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (pKIXPolicyNode.hasChildren()) {
            Iterator children = pKIXPolicyNode.getChildren();
            while (children.hasNext()) {
                removePolicyNodeRecurse(listArr, (PKIXPolicyNode) children.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void verifyX509Certificate(X509Certificate x509Certificate, PublicKey publicKey, String str) throws GeneralSecurityException {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }

    protected static TrustAnchor findTrustAnchor(X509Certificate x509Certificate, Set set, String str) throws AnnotatedException {
        X509CertSelector x509CertSelector = new X509CertSelector();
        X500Principal encodedIssuerPrincipal = getEncodedIssuerPrincipal(x509Certificate);
        try {
            x509CertSelector.setSubject(encodedIssuerPrincipal.getEncoded());
            Iterator it = set.iterator();
            TrustAnchor trustAnchor = null;
            Exception e2 = null;
            PublicKey publicKey = null;
            while (it.hasNext() && trustAnchor == null) {
                trustAnchor = (TrustAnchor) it.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        publicKey = trustAnchor.getTrustedCert().getPublicKey();
                    }
                    trustAnchor = null;
                } else {
                    if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null) {
                        try {
                            if (encodedIssuerPrincipal.equals(new X500Principal(trustAnchor.getCAName()))) {
                                publicKey = trustAnchor.getCAPublicKey();
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    trustAnchor = null;
                }
                if (publicKey != null) {
                    try {
                        verifyX509Certificate(x509Certificate, publicKey, str);
                    } catch (Exception e3) {
                        e2 = e3;
                        trustAnchor = null;
                        publicKey = null;
                    }
                }
            }
            if (trustAnchor != null || e2 == null) {
                return trustAnchor;
            }
            throw new AnnotatedException("TrustAnchor found but certificate validation failed.", e2);
        } catch (IOException e4) {
            throw new AnnotatedException("Cannot set subject search criteria for trust anchor.", e4);
        }
    }

    protected static Collection findCertificates(PKIXCertStoreSelector pKIXCertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof Store) {
                try {
                    hashSet.addAll(((Store) obj).getMatches(pKIXCertStoreSelector));
                } catch (StoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e2);
                }
            } else {
                try {
                    hashSet.addAll(PKIXCertStoreSelector.getCertificates(pKIXCertStoreSelector, (CertStore) obj));
                } catch (CertStoreException e3) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e3);
                }
            }
        }
        return hashSet;
    }

    protected static Collection findCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof X509Store) {
                try {
                    hashSet.addAll(((X509Store) obj).getMatches(x509AttributeCertStoreSelector));
                } catch (StoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e2);
                }
            }
        }
        return hashSet;
    }
}
package org.spongycastle.x509;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.apache.http.HttpHost;
import org.apache.http.message.TokenParser;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.AccessDescription;
import org.spongycastle.asn1.x509.AuthorityInformationAccess;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.asn1.x509.NameConstraints;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.asn1.x509.qualified.ETSIQCObjectIdentifiers;
import org.spongycastle.asn1.x509.qualified.MonetaryValue;
import org.spongycastle.asn1.x509.qualified.QCStatement;
import org.spongycastle.asn1.x509.qualified.RFC3739QCObjectIdentifiers;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.filter.TrustedInput;
import org.spongycastle.i18n.filter.UntrustedInput;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.PKIXNameConstraintValidator;
import org.spongycastle.jce.provider.PKIXNameConstraintValidatorException;
import org.spongycastle.util.Integers;

/* loaded from: classes3.dex */
public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String RESOURCE_NAME = "org.spongycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected List[] errors;
    private boolean initialized;
    protected int n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;
    private static final String QC_STATEMENT = X509Extensions.QCStatements.getId();
    private static final String CRL_DIST_POINTS = X509Extensions.CRLDistributionPoints.getId();
    private static final String AUTH_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();

    public PKIXCertPathReviewer(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath, pKIXParameters);
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 != bArr.length; i2++) {
                stringBuffer.append(Integer.toHexString(bArr[i2] & 255));
                stringBuffer.append(TokenParser.SP);
            }
            return stringBuffer.toString();
        }
    }

    private void checkCriticalExtensions() {
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        for (PKIXCertPathChecker pKIXCertPathChecker : certPathCheckers) {
            try {
                try {
                    pKIXCertPathChecker.init(false);
                } catch (CertPathValidatorException e2) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e2.getMessage(), e2, e2.getClass().getName()}), e2);
                }
            } catch (CertPathReviewerException e3) {
                addError(e3.getErrorMessage(), e3.getIndex());
                return;
            }
        }
        for (int size = this.certs.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty()) {
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.KEY_USAGE);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_MAPPINGS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.DELTA_CRL_INDICATOR);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.BASIC_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.NAME_CONSTRAINTS);
                String str = QC_STATEMENT;
                if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                    criticalExtensionOIDs.remove(str);
                }
                for (PKIXCertPathChecker pKIXCertPathChecker2 : certPathCheckers) {
                    try {
                        pKIXCertPathChecker2.check(x509Certificate, criticalExtensionOIDs);
                    } catch (CertPathValidatorException e4) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e4.getMessage(), e4, e4.getClass().getName()}), e4.getCause(), this.certPath, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it = criticalExtensionOIDs.iterator();
                    while (it.hasNext()) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(it.next())}), size);
                    }
                }
            }
        }
    }

    private void checkNameConstraints() {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
                if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
                    try {
                        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                        try {
                            pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                            try {
                                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                                try {
                                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    if (aSN1Sequence2 != null) {
                                        for (int i2 = 0; i2 < aSN1Sequence2.size(); i2++) {
                                            GeneralName generalName = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i2));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                            } catch (PKIXNameConstraintValidatorException e2) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(generalName)}), e2, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e3) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e3, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e4) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e5) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e5, this.certPath, size);
                        }
                    } catch (IOException e6) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e6, this.certPath, size);
                    }
                }
                try {
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.NAME_CONSTRAINTS);
                    if (aSN1Sequence3 != null) {
                        NameConstraints nameConstraints = NameConstraints.getInstance(aSN1Sequence3);
                        GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
                        if (permittedSubtrees != null) {
                            pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                        }
                        GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
                        if (excludedSubtrees != null) {
                            for (int i3 = 0; i3 != excludedSubtrees.length; i3++) {
                                pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i3]);
                            }
                        }
                    }
                } catch (AnnotatedException e7) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e7, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e8) {
            addError(e8.getErrorMessage(), e8.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int intValue;
        int i2 = this.n;
        int i3 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                if (i2 <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLengthExtended"));
                }
                i2--;
                i3++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (basicConstraints != null && (pathLenConstraint = basicConstraints.getPathLenConstraint()) != null && (intValue = pathLenConstraint.intValue()) < i2) {
                i2 = intValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.valueOf(i3)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x023f A[Catch: CertPathReviewerException -> 0x0607, TryCatch #6 {CertPathReviewerException -> 0x0607, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d4, B:194:0x03e5, B:196:0x03ef, B:207:0x0431, B:199:0x03fb, B:200:0x0409, B:201:0x040a, B:202:0x0418, B:204:0x041a, B:205:0x0428, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0440, B:210:0x044d, B:211:0x044e, B:215:0x045f, B:217:0x0469, B:218:0x046e, B:220:0x0474, B:223:0x0482, B:230:0x049b, B:308:0x05ed, B:309:0x05f9, B:233:0x04a6, B:234:0x04b2, B:235:0x04b3, B:237:0x04b9, B:239:0x04c1, B:241:0x04c7, B:244:0x04d1, B:245:0x04d4, B:247:0x04da, B:249:0x04ea, B:250:0x04ee, B:252:0x04f4, B:253:0x04fc, B:254:0x04ff, B:255:0x0504, B:256:0x0508, B:258:0x050e, B:259:0x051c, B:261:0x0524, B:262:0x0527, B:264:0x052d, B:266:0x0539, B:267:0x053d, B:268:0x0540, B:269:0x0543, B:270:0x054f, B:272:0x0554, B:274:0x055e, B:275:0x0561, B:277:0x0567, B:279:0x0577, B:280:0x057b, B:282:0x0581, B:284:0x0591, B:285:0x0595, B:286:0x0598, B:287:0x059b, B:288:0x05a1, B:290:0x05a7, B:292:0x05b9, B:295:0x05c3, B:297:0x05c9, B:298:0x05cc, B:300:0x05d2, B:302:0x05de, B:303:0x05e2, B:304:0x05e5, B:310:0x05fa, B:311:0x0606), top: B:325:0x006f, inners: #0, #1, #2, #3, #4, #7, #8, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120 A[Catch: CertPathReviewerException -> 0x0607, TryCatch #6 {CertPathReviewerException -> 0x0607, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d4, B:194:0x03e5, B:196:0x03ef, B:207:0x0431, B:199:0x03fb, B:200:0x0409, B:201:0x040a, B:202:0x0418, B:204:0x041a, B:205:0x0428, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0440, B:210:0x044d, B:211:0x044e, B:215:0x045f, B:217:0x0469, B:218:0x046e, B:220:0x0474, B:223:0x0482, B:230:0x049b, B:308:0x05ed, B:309:0x05f9, B:233:0x04a6, B:234:0x04b2, B:235:0x04b3, B:237:0x04b9, B:239:0x04c1, B:241:0x04c7, B:244:0x04d1, B:245:0x04d4, B:247:0x04da, B:249:0x04ea, B:250:0x04ee, B:252:0x04f4, B:253:0x04fc, B:254:0x04ff, B:255:0x0504, B:256:0x0508, B:258:0x050e, B:259:0x051c, B:261:0x0524, B:262:0x0527, B:264:0x052d, B:266:0x0539, B:267:0x053d, B:268:0x0540, B:269:0x0543, B:270:0x054f, B:272:0x0554, B:274:0x055e, B:275:0x0561, B:277:0x0567, B:279:0x0577, B:280:0x057b, B:282:0x0581, B:284:0x0591, B:285:0x0595, B:286:0x0598, B:287:0x059b, B:288:0x05a1, B:290:0x05a7, B:292:0x05b9, B:295:0x05c3, B:297:0x05c9, B:298:0x05cc, B:300:0x05d2, B:302:0x05de, B:303:0x05e2, B:304:0x05e5, B:310:0x05fa, B:311:0x0606), top: B:325:0x006f, inners: #0, #1, #2, #3, #4, #7, #8, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013d A[Catch: CertPathReviewerException -> 0x0607, TRY_LEAVE, TryCatch #6 {CertPathReviewerException -> 0x0607, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d4, B:194:0x03e5, B:196:0x03ef, B:207:0x0431, B:199:0x03fb, B:200:0x0409, B:201:0x040a, B:202:0x0418, B:204:0x041a, B:205:0x0428, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0440, B:210:0x044d, B:211:0x044e, B:215:0x045f, B:217:0x0469, B:218:0x046e, B:220:0x0474, B:223:0x0482, B:230:0x049b, B:308:0x05ed, B:309:0x05f9, B:233:0x04a6, B:234:0x04b2, B:235:0x04b3, B:237:0x04b9, B:239:0x04c1, B:241:0x04c7, B:244:0x04d1, B:245:0x04d4, B:247:0x04da, B:249:0x04ea, B:250:0x04ee, B:252:0x04f4, B:253:0x04fc, B:254:0x04ff, B:255:0x0504, B:256:0x0508, B:258:0x050e, B:259:0x051c, B:261:0x0524, B:262:0x0527, B:264:0x052d, B:266:0x0539, B:267:0x053d, B:268:0x0540, B:269:0x0543, B:270:0x054f, B:272:0x0554, B:274:0x055e, B:275:0x0561, B:277:0x0567, B:279:0x0577, B:280:0x057b, B:282:0x0581, B:284:0x0591, B:285:0x0595, B:286:0x0598, B:287:0x059b, B:288:0x05a1, B:290:0x05a7, B:292:0x05b9, B:295:0x05c3, B:297:0x05c9, B:298:0x05cc, B:300:0x05d2, B:302:0x05de, B:303:0x05e2, B:304:0x05e5, B:310:0x05fa, B:311:0x0606), top: B:325:0x006f, inners: #0, #1, #2, #3, #4, #7, #8, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0216 A[Catch: CertPathReviewerException -> 0x0607, TryCatch #6 {CertPathReviewerException -> 0x0607, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d4, B:194:0x03e5, B:196:0x03ef, B:207:0x0431, B:199:0x03fb, B:200:0x0409, B:201:0x040a, B:202:0x0418, B:204:0x041a, B:205:0x0428, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0440, B:210:0x044d, B:211:0x044e, B:215:0x045f, B:217:0x0469, B:218:0x046e, B:220:0x0474, B:223:0x0482, B:230:0x049b, B:308:0x05ed, B:309:0x05f9, B:233:0x04a6, B:234:0x04b2, B:235:0x04b3, B:237:0x04b9, B:239:0x04c1, B:241:0x04c7, B:244:0x04d1, B:245:0x04d4, B:247:0x04da, B:249:0x04ea, B:250:0x04ee, B:252:0x04f4, B:253:0x04fc, B:254:0x04ff, B:255:0x0504, B:256:0x0508, B:258:0x050e, B:259:0x051c, B:261:0x0524, B:262:0x0527, B:264:0x052d, B:266:0x0539, B:267:0x053d, B:268:0x0540, B:269:0x0543, B:270:0x054f, B:272:0x0554, B:274:0x055e, B:275:0x0561, B:277:0x0567, B:279:0x0577, B:280:0x057b, B:282:0x0581, B:284:0x0591, B:285:0x0595, B:286:0x0598, B:287:0x059b, B:288:0x05a1, B:290:0x05a7, B:292:0x05b9, B:295:0x05c3, B:297:0x05c9, B:298:0x05cc, B:300:0x05d2, B:302:0x05de, B:303:0x05e2, B:304:0x05e5, B:310:0x05fa, B:311:0x0606), top: B:325:0x006f, inners: #0, #1, #2, #3, #4, #7, #8, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkPolicy() {
        /*
            Method dump skipped, instructions count: 1556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkPolicy():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(2:81|82)|(3:(15:84|85|86|(11:88|89|(2:92|90)|93|94|(2:97|95)|98|99|100|101|102)|109|89|(1:90)|93|94|(1:95)|98|99|100|101|102)|101|102)|112|85|86|(0)|109|89|(1:90)|93|94|(1:95)|98|99|100) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:81|82|(3:(15:84|85|86|(11:88|89|(2:92|90)|93|94|(2:97|95)|98|99|100|101|102)|109|89|(1:90)|93|94|(1:95)|98|99|100|101|102)|101|102)|112|85|86|(0)|109|89|(1:90)|93|94|(1:95)|98|99|100) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x032c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x032d, code lost:
        r18 = r4;
        r13 = r6;
        r19 = r7;
        r12 = r8;
        r11 = r9;
        r15 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02b2, code lost:
        addError(new org.spongycastle.i18n.ErrorBundle(org.spongycastle.x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.crlAuthInfoAccError"), r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02f8 A[LOOP:2: B:98:0x02f2->B:100:0x02f8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ad A[Catch: AnnotatedException -> 0x02b2, TRY_LEAVE, TryCatch #17 {AnnotatedException -> 0x02b2, blocks: (B:87:0x02a5, B:89:0x02ad), top: B:173:0x02a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02cf A[LOOP:1: B:94:0x02c9->B:96:0x02cf, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkSignatures() {
        /*
            Method dump skipped, instructions count: 1033
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkSignatures():void");
    }

    private X509CRL getCRL(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME) && !url.getProtocol().equals("https")) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e2) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e2.getMessage(), e2, e2.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i2) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i3 = 0; i3 < aSN1Sequence.size(); i3++) {
                QCStatement qCStatement = QCStatement.getInstance(aSN1Sequence.getObjectAt(i3));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.equals(qCStatement.getStatementId())) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance"), i2);
                } else if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.equals(qCStatement.getStatementId())) {
                    if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.equals(qCStatement.getStatementId())) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD"), i2);
                    } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.equals(qCStatement.getStatementId())) {
                        MonetaryValue monetaryValue = MonetaryValue.getInstance(qCStatement.getStatementInfo());
                        monetaryValue.getCurrency();
                        double doubleValue = monetaryValue.getAmount().doubleValue() * Math.pow(10.0d, monetaryValue.getExponent().doubleValue());
                        if (monetaryValue.getCurrency().isAlphabetic()) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{monetaryValue.getCurrency().getAlphabetic(), new TrustedInput(new Double(doubleValue)), monetaryValue});
                        } else {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(monetaryValue.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), monetaryValue});
                        }
                        addNotification(errorBundle, i2);
                    } else {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{qCStatement.getStatementId(), new UntrustedInput(qCStatement)}), i2);
                        z = true;
                    }
                }
            }
            return true ^ z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i2);
            return false;
        }
    }

    protected void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    protected void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void checkCRLs(java.security.cert.PKIXParameters r22, java.security.cert.X509Certificate r23, java.util.Date r24, java.security.cert.X509Certificate r25, java.security.PublicKey r26, java.util.Vector r27, int r28) throws org.spongycastle.x509.CertPathReviewerException {
        /*
            Method dump skipped, instructions count: 1191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    protected void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i2) throws CertPathReviewerException {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i2);
    }

    protected void doChecks() {
        if (this.initialized) {
            if (this.notifications != null) {
                return;
            }
            int i2 = this.n;
            this.notifications = new List[i2 + 1];
            this.errors = new List[i2 + 1];
            int i3 = 0;
            while (true) {
                List[] listArr = this.notifications;
                if (i3 < listArr.length) {
                    listArr[i3] = new ArrayList();
                    this.errors[i3] = new ArrayList();
                    i3++;
                } else {
                    checkSignatures();
                    checkNameConstraints();
                    checkPathLength();
                    checkPolicy();
                    checkCriticalExtensions();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        }
    }

    protected Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i2 = 0; i2 < names.length; i2++) {
                        if (names[i2].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i2].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    protected Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i2 = 0; i2 < accessDescriptions.length; i2++) {
                if (accessDescriptions[i2].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i2].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    protected Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(authorityKeyIdentifier.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = authorityKeyIdentifier.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor = (TrustAnchor) it.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        arrayList.add(trustAnchor);
                    }
                } else if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null && CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor.getCAName()))) {
                    arrayList.add(trustAnchor);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (!this.initialized) {
            this.initialized = true;
            Objects.requireNonNull(certPath, "certPath was null");
            this.certPath = certPath;
            List<? extends Certificate> certificates = certPath.getCertificates();
            this.certs = certificates;
            this.n = certificates.size();
            if (!this.certs.isEmpty()) {
                PKIXParameters pKIXParameters2 = (PKIXParameters) pKIXParameters.clone();
                this.pkixParams = pKIXParameters2;
                this.validDate = CertPathValidatorUtilities.getValidDate(pKIXParameters2);
                this.notifications = null;
                this.errors = null;
                this.trustAnchor = null;
                this.subjectPublicKey = null;
                this.policyTree = null;
                return;
            }
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
        }
        throw new IllegalStateException("object is already initialized!");
    }

    public boolean isValidCertPath() {
        doChecks();
        int i2 = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i2 >= listArr.length) {
                return true;
            }
            if (!listArr[i2].isEmpty()) {
                return false;
            }
            i2++;
        }
    }

    protected void addError(ErrorBundle errorBundle, int i2) {
        if (i2 >= -1 && i2 < this.n) {
            this.errors[i2 + 1].add(errorBundle);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    protected void addNotification(ErrorBundle errorBundle, int i2) {
        if (i2 >= -1 && i2 < this.n) {
            this.notifications[i2 + 1].add(errorBundle);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public PKIXCertPathReviewer() {
    }

    public List getErrors(int i2) {
        doChecks();
        return this.errors[i2 + 1];
    }

    public List getNotifications(int i2) {
        doChecks();
        return this.notifications[i2 + 1];
    }
}
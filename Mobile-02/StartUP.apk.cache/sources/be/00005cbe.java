package org.apache.http.conn.ssl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.util.DomainType;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.conn.util.PublicSuffixMatcher;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes3.dex */
public final class DefaultHostnameVerifier implements HostnameVerifier {
    private final a log;
    private final PublicSuffixMatcher publicSuffixMatcher;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.apache.http.conn.ssl.DefaultHostnameVerifier$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$http$conn$ssl$DefaultHostnameVerifier$HostNameType;

        static {
            int[] iArr = new int[HostNameType.values().length];
            $SwitchMap$org$apache$http$conn$ssl$DefaultHostnameVerifier$HostNameType = iArr;
            try {
                iArr[HostNameType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$http$conn$ssl$DefaultHostnameVerifier$HostNameType[HostNameType.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum HostNameType {
        IPv4(7),
        IPv6(7),
        DNS(2);
        
        final int subjectType;

        HostNameType(int i2) {
            this.subjectType = i2;
        }
    }

    public DefaultHostnameVerifier(PublicSuffixMatcher publicSuffixMatcher) {
        this.log = h.n(DefaultHostnameVerifier.class);
        this.publicSuffixMatcher = publicSuffixMatcher;
    }

    static HostNameType determineHostFormat(String str) {
        if (InetAddressUtils.isIPv4Address(str)) {
            return HostNameType.IPv4;
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
        }
        if (InetAddressUtils.isIPv6Address(str)) {
            return HostNameType.IPv6;
        }
        return HostNameType.DNS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String extractCN(String str) throws SSLException {
        if (str == null) {
            return null;
        }
        try {
            List rdns = new LdapName(str).getRdns();
            for (int size = rdns.size() - 1; size >= 0; size--) {
                Attribute attribute = ((Rdn) rdns.get(size)).toAttributes().get("cn");
                if (attribute != null) {
                    try {
                        Object obj = attribute.get();
                        if (obj != null) {
                            return obj.toString();
                        }
                        continue;
                    } catch (NoSuchElementException | NamingException unused) {
                        continue;
                    }
                }
            }
            return null;
        } catch (InvalidNameException unused2) {
            throw new SSLException(str + " is not a valid X500 distinguished name");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<SubjectName> getSubjectAltNames(X509Certificate x509Certificate) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                Integer num = list.size() >= 2 ? (Integer) list.get(0) : null;
                if (num != null) {
                    Object obj = list.get(1);
                    if (obj instanceof String) {
                        arrayList.add(new SubjectName((String) obj, num.intValue()));
                    } else {
                        boolean z = obj instanceof byte[];
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    static void matchCN(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) throws SSLException {
        Locale locale = Locale.ROOT;
        if (matchIdentityStrict(str.toLowerCase(locale), str2.toLowerCase(locale), publicSuffixMatcher)) {
            return;
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match common name of the certificate subject: " + str2);
    }

    static void matchDNSName(String str, List<SubjectName> list, PublicSuffixMatcher publicSuffixMatcher) throws SSLException {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        for (int i2 = 0; i2 < list.size(); i2++) {
            SubjectName subjectName = list.get(i2);
            if (subjectName.getType() == 2 && matchIdentityStrict(lowerCase, subjectName.getValue().toLowerCase(Locale.ROOT), publicSuffixMatcher)) {
                return;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    static boolean matchDomainRoot(String str, String str2) {
        if (str2 != null && str.endsWith(str2)) {
            return str.length() == str2.length() || str.charAt((str.length() - str2.length()) - 1) == '.';
        }
        return false;
    }

    static void matchIPAddress(String str, List<SubjectName> list) throws SSLException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            SubjectName subjectName = list.get(i2);
            if (subjectName.getType() == 7 && str.equals(subjectName.getValue())) {
                return;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    static void matchIPv6Address(String str, List<SubjectName> list) throws SSLException {
        String normaliseAddress = normaliseAddress(str);
        for (int i2 = 0; i2 < list.size(); i2++) {
            SubjectName subjectName = list.get(i2);
            if (subjectName.getType() == 7 && normaliseAddress.equals(normaliseAddress(subjectName.getValue()))) {
                return;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    private static boolean matchIdentity(String str, String str2, PublicSuffixMatcher publicSuffixMatcher, boolean z) {
        if (publicSuffixMatcher == null || !str.contains(".") || matchDomainRoot(str, publicSuffixMatcher.getDomainRoot(str2, DomainType.ICANN))) {
            int indexOf = str2.indexOf(42);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                String substring2 = str2.substring(indexOf + 1);
                if (substring.isEmpty() || str.startsWith(substring)) {
                    if (substring2.isEmpty() || str.endsWith(substring2)) {
                        return (z && str.substring(substring.length(), str.length() - substring2.length()).contains(".")) ? false : true;
                    }
                    return false;
                }
                return false;
            }
            return str.equalsIgnoreCase(str2);
        }
        return false;
    }

    static boolean matchIdentityStrict(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) {
        return matchIdentity(str, str2, publicSuffixMatcher, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String normaliseAddress(String str) {
        if (str == null) {
            return str;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return str;
        }
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e2) {
            if (this.log.d()) {
                this.log.b(e2.getMessage(), e2);
            }
            return false;
        }
    }

    static boolean matchIdentityStrict(String str, String str2) {
        return matchIdentity(str, str2, null, true);
    }

    public DefaultHostnameVerifier() {
        this(null);
    }

    public void verify(String str, X509Certificate x509Certificate) throws SSLException {
        HostNameType determineHostFormat = determineHostFormat(str);
        List<SubjectName> subjectAltNames = getSubjectAltNames(x509Certificate);
        if (subjectAltNames != null && !subjectAltNames.isEmpty()) {
            int i2 = AnonymousClass1.$SwitchMap$org$apache$http$conn$ssl$DefaultHostnameVerifier$HostNameType[determineHostFormat.ordinal()];
            if (i2 == 1) {
                matchIPAddress(str, subjectAltNames);
                return;
            } else if (i2 != 2) {
                matchDNSName(str, subjectAltNames, this.publicSuffixMatcher);
                return;
            } else {
                matchIPv6Address(str, subjectAltNames);
                return;
            }
        }
        String extractCN = extractCN(x509Certificate.getSubjectX500Principal().getName("RFC2253"));
        if (extractCN != null) {
            matchCN(str, extractCN, this.publicSuffixMatcher);
            return;
        }
        throw new SSLException("Certificate subject for <" + str + "> doesn't contain a common name and does not have alternative names");
    }

    static boolean matchIdentity(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) {
        return matchIdentity(str, str2, publicSuffixMatcher, false);
    }

    static boolean matchIdentity(String str, String str2) {
        return matchIdentity(str, str2, null, false);
    }
}
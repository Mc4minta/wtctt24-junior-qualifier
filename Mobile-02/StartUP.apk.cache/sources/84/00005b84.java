package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* compiled from: OkHostnameVerifier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ#\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\n\u0010\fJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\bJ\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "", "ipAddress", "Ljava/security/cert/X509Certificate;", "certificate", "", "verifyIpAddress", "(Ljava/lang/String;Ljava/security/cert/X509Certificate;)Z", "hostname", "verifyHostname", "pattern", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "type", "", "getSubjectAltNames", "(Ljava/security/cert/X509Certificate;I)Ljava/util/List;", "host", "Ljavax/net/ssl/SSLSession;", "session", "verify", "(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "allSubjectAltNames", "(Ljava/security/cert/X509Certificate;)Ljava/util/List;", "ALT_IPA_NAME", "I", "ALT_DNS_NAME", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i2) {
        List<String> g2;
        List<String> g3;
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && !(!m.c(list.get(0), Integer.valueOf(i2))) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
            g3 = r.g();
            return g3;
        } catch (CertificateParsingException unused) {
            g2 = r.g();
            return g2;
        }
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        m.d(locale, "Locale.US");
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            m.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
            if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
                return false;
            }
            for (String str2 : subjectAltNames) {
                if (INSTANCE.verifyHostname(lowerCase, str2)) {
                    return true;
                }
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        for (String str2 : subjectAltNames) {
            if (m.c(canonicalHost, HostnamesKt.toCanonicalHost(str2))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate certificate) {
        List<String> t0;
        m.h(certificate, "certificate");
        t0 = z.t0(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
        return t0;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        m.h(host, "host");
        m.h(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(host, (X509Certificate) certificate);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String host, X509Certificate certificate) {
        m.h(host, "host");
        m.h(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        boolean Q;
        boolean z;
        boolean Q2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean V;
        boolean Q3;
        int h0;
        boolean z5;
        int m0;
        if (!(str == null || str.length() == 0)) {
            Q = x.Q(str, ".", false, 2, null);
            if (!Q) {
                z = x.z(str, "..", false, 2, null);
                if (!z) {
                    if (!(str2 == null || str2.length() == 0)) {
                        Q2 = x.Q(str2, ".", false, 2, null);
                        if (!Q2) {
                            z2 = x.z(str2, "..", false, 2, null);
                            if (!z2) {
                                z3 = x.z(str, ".", false, 2, null);
                                if (!z3) {
                                    str = str + ".";
                                }
                                String str3 = str;
                                z4 = x.z(str2, ".", false, 2, null);
                                if (!z4) {
                                    str2 = str2 + ".";
                                }
                                Locale locale = Locale.US;
                                m.d(locale, "Locale.US");
                                if (str2 != null) {
                                    String lowerCase = str2.toLowerCase(locale);
                                    m.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                    V = y.V(lowerCase, "*", false, 2, null);
                                    if (!V) {
                                        return m.c(str3, lowerCase);
                                    }
                                    Q3 = x.Q(lowerCase, "*.", false, 2, null);
                                    if (Q3) {
                                        h0 = y.h0(lowerCase, '*', 1, false, 4, null);
                                        if (h0 == -1 && str3.length() >= lowerCase.length() && !m.c("*.", lowerCase)) {
                                            String substring = lowerCase.substring(1);
                                            m.d(substring, "(this as java.lang.String).substring(startIndex)");
                                            z5 = x.z(str3, substring, false, 2, null);
                                            if (z5) {
                                                int length = str3.length() - substring.length();
                                                if (length > 0) {
                                                    m0 = y.m0(str3, '.', length - 1, false, 4, null);
                                                    if (m0 != -1) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
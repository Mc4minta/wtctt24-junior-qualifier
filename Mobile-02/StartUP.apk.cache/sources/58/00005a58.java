package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import org.apache.http.HttpHost;

/* compiled from: Address.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010F\u001a\u000209\u0012\u0006\u0010G\u001a\u000202\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\b\u0010-\u001a\u0004\u0018\u00010*\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010!\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010%\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\b#\u0010$J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b'\u0010(J\u0011\u0010-\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b+\u0010,J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00108\u001a\u00020/2\u0006\u00105\u001a\u00020\u0000H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128G@\u0006¢\u0006\f\n\u0004\b\u0019\u0010<\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u001d\u001a\u00020\u001a8\u0007@\u0006¢\u0006\f\n\u0004\b\u001d\u0010=\u001a\u0004\b\u001d\u0010\u001cR\u001b\u0010-\u001a\u0004\u0018\u00010*8\u0007@\u0006¢\u0006\f\n\u0004\b-\u0010>\u001a\u0004\b-\u0010,R\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010?\u001a\u0004\b\r\u0010\fR\u001b\u0010%\u001a\u0004\u0018\u00010\"8\u0007@\u0006¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\b%\u0010$R\u001b\u0010)\u001a\u0004\u0018\u00010&8\u0007@\u0006¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\b)\u0010(R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128G@\u0006¢\u0006\f\n\u0004\b\u0016\u0010<\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010B\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b\u0005\u0010C\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010D\u001a\u0004\b\t\u0010\bR\u001b\u0010!\u001a\u0004\u0018\u00010\u001e8\u0007@\u0006¢\u0006\f\n\u0004\b!\u0010E\u001a\u0004\b!\u0010 ¨\u0006J"}, d2 = {"Lokhttp3/Address;", "", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Lokhttp3/Authenticator;", "-deprecated_proxyAuthenticator", "()Lokhttp3/Authenticator;", "proxyAuthenticator", "", "Lokhttp3/Protocol;", "-deprecated_protocols", "()Ljava/util/List;", "protocols", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "that", "equalsNonHost$okhttp", "(Lokhttp3/Address;)Z", "equalsNonHost", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "Ljava/net/ProxySelector;", "Lokhttp3/CertificatePinner;", "Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/Authenticator;", "Lokhttp3/HttpUrl;", "Lokhttp3/Dns;", "Ljava/net/Proxy;", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String uriHost, int i2, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator proxyAuthenticator, Proxy proxy, List<? extends Protocol> protocols, List<ConnectionSpec> connectionSpecs, ProxySelector proxySelector) {
        m.h(uriHost, "uriHost");
        m.h(dns, "dns");
        m.h(socketFactory, "socketFactory");
        m.h(proxyAuthenticator, "proxyAuthenticator");
        m.h(protocols, "protocols");
        m.h(connectionSpecs, "connectionSpecs");
        m.h(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).host(uriHost).port(i2).build();
        this.protocols = Util.toImmutableList(protocols);
        this.connectionSpecs = Util.toImmutableList(connectionSpecs);
    }

    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m2221deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m2222deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m2223deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m2224deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m2225deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m2226deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m2227deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m2228deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m2229deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m2230deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m2231deprecated_url() {
        return this.url;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (m.c(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address that) {
        m.h(that, "that");
        return m.c(this.dns, that.dns) && m.c(this.proxyAuthenticator, that.proxyAuthenticator) && m.c(this.protocols, that.protocols) && m.c(this.connectionSpecs, that.connectionSpecs) && m.c(this.proxySelector, that.proxySelector) && m.c(this.proxy, that.proxy) && m.c(this.sslSocketFactory, that.sslSocketFactory) && m.c(this.hostnameVerifier, that.hostnameVerifier) && m.c(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }
}
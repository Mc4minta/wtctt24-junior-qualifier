package okhttp3;

import com.appsflyer.internal.referrer.Payload;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 H2\u00020\u0001:\u0002HIB\u0007¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J!\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J1\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J9\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010-J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0006J\u001f\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u0010\u0006J\u001f\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b;\u0010\u0006J\u001f\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b@\u0010\u0006J\u001f\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\bA\u00108J\u001f\u0010B\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bB\u0010:J\u0017\u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bC\u0010\u0006J\u001f\u0010D\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bD\u0010:J\u0017\u0010E\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bE\u0010\u0006¨\u0006J"}, d2 = {"Lokhttp3/EventListener;", "", "Lokhttp3/Call;", "call", "Lkotlin/x;", "callStart", "(Lokhttp3/Call;)V", "Lokhttp3/HttpUrl;", "url", "proxySelectStart", "(Lokhttp3/Call;Lokhttp3/HttpUrl;)V", "", "Ljava/net/Proxy;", "proxies", "proxySelectEnd", "(Lokhttp3/Call;Lokhttp3/HttpUrl;Ljava/util/List;)V", "", "domainName", "dnsStart", "(Lokhttp3/Call;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "(Lokhttp3/Call;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "connectStart", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "(Lokhttp3/Call;Lokhttp3/Handshake;)V", "Lokhttp3/Protocol;", "protocol", "connectEnd", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", "connectFailed", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Lokhttp3/Connection;", "connection", "connectionAcquired", "(Lokhttp3/Call;Lokhttp3/Connection;)V", "connectionReleased", "requestHeadersStart", "Lokhttp3/Request;", "request", "requestHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Request;)V", "requestBodyStart", "", "byteCount", "requestBodyEnd", "(Lokhttp3/Call;J)V", "requestFailed", "(Lokhttp3/Call;Ljava/io/IOException;)V", "responseHeadersStart", "Lokhttp3/Response;", Payload.RESPONSE, "responseHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Response;)V", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "<init>", "()V", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: EventListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/EventListener$Companion;", "", "Lokhttp3/EventListener;", "NONE", "Lokhttp3/EventListener;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EventListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/EventListener$Factory;", "", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "create", "(Lokhttp3/Call;)Lokhttp3/EventListener;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public void callEnd(Call call) {
        m.h(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        m.h(call, "call");
        m.h(ioe, "ioe");
    }

    public void callStart(Call call) {
        m.h(call, "call");
    }

    public void canceled(Call call) {
        m.h(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        m.h(call, "call");
        m.h(inetSocketAddress, "inetSocketAddress");
        m.h(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        m.h(call, "call");
        m.h(inetSocketAddress, "inetSocketAddress");
        m.h(proxy, "proxy");
        m.h(ioe, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        m.h(call, "call");
        m.h(inetSocketAddress, "inetSocketAddress");
        m.h(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        m.h(call, "call");
        m.h(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        m.h(call, "call");
        m.h(connection, "connection");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        m.h(call, "call");
        m.h(domainName, "domainName");
        m.h(inetAddressList, "inetAddressList");
    }

    public void dnsStart(Call call, String domainName) {
        m.h(call, "call");
        m.h(domainName, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        m.h(call, "call");
        m.h(url, "url");
        m.h(proxies, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        m.h(call, "call");
        m.h(url, "url");
    }

    public void requestBodyEnd(Call call, long j2) {
        m.h(call, "call");
    }

    public void requestBodyStart(Call call) {
        m.h(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        m.h(call, "call");
        m.h(ioe, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        m.h(call, "call");
        m.h(request, "request");
    }

    public void requestHeadersStart(Call call) {
        m.h(call, "call");
    }

    public void responseBodyEnd(Call call, long j2) {
        m.h(call, "call");
    }

    public void responseBodyStart(Call call) {
        m.h(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        m.h(call, "call");
        m.h(ioe, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        m.h(call, "call");
        m.h(response, "response");
    }

    public void responseHeadersStart(Call call) {
        m.h(call, "call");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        m.h(call, "call");
    }

    public void secureConnectStart(Call call) {
        m.h(call, "call");
    }
}
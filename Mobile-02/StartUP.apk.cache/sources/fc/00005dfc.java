package org.apache.http.impl.execchain;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.Args;
import org.apache.http.util.VersionInfo;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes3.dex */
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final a log = h.n(getClass());
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "org.apache.http.client", getClass())));
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    static void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper, HttpRoute httpRoute) throws ProtocolException {
        URI rewriteURI;
        try {
            URI uri = httpRequestWrapper.getURI();
            if (uri != null) {
                if (uri.isAbsolute()) {
                    rewriteURI = URIUtils.rewriteURI(uri, null, true);
                } else {
                    rewriteURI = URIUtils.rewriteURI(uri);
                }
                httpRequestWrapper.setURI(rewriteURI);
            }
        } catch (URISyntaxException e2) {
            throw new ProtocolException("Invalid URI: " + httpRequestWrapper.getRequestLine().getUri(), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac A[Catch: RuntimeException -> 0x0108, IOException -> 0x010d, HttpException -> 0x0112, ConnectionShutdownException -> 0x0117, TryCatch #3 {IOException -> 0x010d, RuntimeException -> 0x0108, HttpException -> 0x0112, ConnectionShutdownException -> 0x0117, blocks: (B:17:0x004f, B:19:0x0055, B:20:0x0059, B:21:0x0061, B:22:0x0062, B:24:0x0068, B:28:0x0072, B:29:0x007a, B:31:0x0080, B:32:0x0083, B:34:0x008b, B:36:0x0097, B:39:0x00ac, B:40:0x00b0, B:42:0x00dc, B:44:0x00ec, B:46:0x00f2, B:49:0x00f9, B:51:0x00ff, B:43:0x00e9), top: B:77:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc A[Catch: RuntimeException -> 0x0108, IOException -> 0x010d, HttpException -> 0x0112, ConnectionShutdownException -> 0x0117, TryCatch #3 {IOException -> 0x010d, RuntimeException -> 0x0108, HttpException -> 0x0112, ConnectionShutdownException -> 0x0117, blocks: (B:17:0x004f, B:19:0x0055, B:20:0x0059, B:21:0x0061, B:22:0x0062, B:24:0x0068, B:28:0x0072, B:29:0x007a, B:31:0x0080, B:32:0x0083, B:34:0x008b, B:36:0x0097, B:39:0x00ac, B:40:0x00b0, B:42:0x00dc, B:44:0x00ec, B:46:0x00f2, B:49:0x00f9, B:51:0x00ff, B:43:0x00e9), top: B:77:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9 A[Catch: RuntimeException -> 0x0108, IOException -> 0x010d, HttpException -> 0x0112, ConnectionShutdownException -> 0x0117, TryCatch #3 {IOException -> 0x010d, RuntimeException -> 0x0108, HttpException -> 0x0112, ConnectionShutdownException -> 0x0117, blocks: (B:17:0x004f, B:19:0x0055, B:20:0x0059, B:21:0x0061, B:22:0x0062, B:24:0x0068, B:28:0x0072, B:29:0x007a, B:31:0x0080, B:32:0x0083, B:34:0x008b, B:36:0x0097, B:39:0x00ac, B:40:0x00b0, B:42:0x00dc, B:44:0x00ec, B:46:0x00f2, B:49:0x00f9, B:51:0x00ff, B:43:0x00e9), top: B:77:0x004f }] */
    @Override // org.apache.http.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.http.client.methods.CloseableHttpResponse execute(org.apache.http.conn.routing.HttpRoute r9, org.apache.http.client.methods.HttpRequestWrapper r10, org.apache.http.client.protocol.HttpClientContext r11, org.apache.http.client.methods.HttpExecutionAware r12) throws java.io.IOException, org.apache.http.HttpException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.execchain.MinimalClientExec.execute(org.apache.http.conn.routing.HttpRoute, org.apache.http.client.methods.HttpRequestWrapper, org.apache.http.client.protocol.HttpClientContext, org.apache.http.client.methods.HttpExecutionAware):org.apache.http.client.methods.CloseableHttpResponse");
    }
}
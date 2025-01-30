package okhttp3.internal.http;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.k;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;

/* compiled from: RetryAndFollowUpInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J/\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/Request;", "userRequest", "", "requestSendStarted", "recover", "(Ljava/io/IOException;Lokhttp3/internal/connection/RealCall;Lokhttp3/Request;Z)Z", "requestIsOneShot", "(Ljava/io/IOException;Lokhttp3/Request;)Z", "isRecoverable", "(Ljava/io/IOException;Z)Z", "Lokhttp3/Response;", "userResponse", "Lokhttp3/internal/connection/Exchange;", "exchange", "followUpRequest", "(Lokhttp3/Response;Lokhttp3/internal/connection/Exchange;)Lokhttp3/Request;", "", "method", "buildRedirectRequest", "(Lokhttp3/Response;Ljava/lang/String;)Lokhttp3/Request;", "", "defaultDelay", "retryAfter", "(Lokhttp3/Response;I)I", "Lokhttp3/Interceptor$Chain;", "chain", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    /* compiled from: RetryAndFollowUpInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "", "MAX_FOLLOW_UPS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        m.h(client, "client");
        this.client = client;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, org.apache.http.HttpHeaders.LOCATION, null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (m.c(resolve.scheme(), response.request().url().scheme()) || this.client.followSslRedirects()) {
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(str)) {
                HttpMethod httpMethod = HttpMethod.INSTANCE;
                boolean redirectsWithBody = httpMethod.redirectsWithBody(str);
                if (httpMethod.redirectsToGet(str)) {
                    newBuilder.method(HttpGet.METHOD_NAME, null);
                } else {
                    newBuilder.method(str, redirectsWithBody ? response.request().body() : null);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader("Transfer-Encoding");
                    newBuilder.removeHeader("Content-Length");
                    newBuilder.removeHeader("Content-Type");
                }
            }
            if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        return null;
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int code = response.code();
        String method = response.request().method();
        if (code == 307 || code == 308) {
            if ((!m.c(method, HttpGet.METHOD_NAME)) && (!m.c(method, HttpHead.METHOD_NAME))) {
                return null;
            }
            return buildRedirectRequest(response, method);
        } else if (code != 401) {
            if (code == 421) {
                RequestBody body = response.request().body();
                if ((body == null || !body.isOneShot()) && exchange != null && exchange.isCoalescedConnection$okhttp()) {
                    exchange.getConnection$okhttp().noCoalescedConnections();
                    return response.request();
                }
                return null;
            } else if (code == 503) {
                Response priorResponse = response.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO) == 0) {
                    return response.request();
                }
                return null;
            } else if (code == 407) {
                if (route == null) {
                    m.q();
                }
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            } else if (code != 408) {
                switch (code) {
                    case HttpStatus.SC_MULTIPLE_CHOICES /* 300 */:
                    case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
                    case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
                    case HttpStatus.SC_SEE_OTHER /* 303 */:
                        return buildRedirectRequest(response, method);
                    default:
                        return null;
                }
            } else if (this.client.retryOnConnectionFailure()) {
                RequestBody body2 = response.request().body();
                if (body2 == null || !body2.isOneShot()) {
                    Response priorResponse2 = response.priorResponse();
                    if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                        return response.request();
                    }
                    return null;
                }
                return null;
            } else {
                return null;
            }
        } else {
            return this.client.authenticator().authenticate(route, response);
        }
    }

    private final boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z) {
        if (this.client.retryOnConnectionFailure()) {
            return !(z && requestIsOneShot(iOException, request)) && isRecoverable(iOException, z) && realCall.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i2) {
        String header$default = Response.header$default(response, org.apache.http.HttpHeaders.RETRY_AFTER, null, 2, null);
        if (header$default != null) {
            if (new k("\\d+").d(header$default)) {
                Integer valueOf = Integer.valueOf(header$default);
                m.d(valueOf, "Integer.valueOf(header)");
                return valueOf.intValue();
            }
            return RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        return i2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        List g2;
        Exchange interceptorScopedExchange$okhttp;
        Request followUpRequest;
        m.h(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        g2 = r.g();
        Response response = null;
        boolean z = true;
        int i2 = 0;
        while (true) {
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z);
            try {
                if (!call$okhttp.isCanceled()) {
                    try {
                        Response proceed = realInterceptorChain.proceed(request$okhttp);
                        if (response != null) {
                            proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                        }
                        response = proceed;
                        interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
                        followUpRequest = followUpRequest(response, interceptorScopedExchange$okhttp);
                    } catch (IOException e2) {
                        if (recover(e2, call$okhttp, request$okhttp, !(e2 instanceof ConnectionShutdownException))) {
                            g2 = z.u0(g2, e2);
                            call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                            z = false;
                        } else {
                            throw Util.withSuppressed(e2, g2);
                        }
                    } catch (RouteException e3) {
                        if (recover(e3.getLastConnectException(), call$okhttp, request$okhttp, false)) {
                            g2 = z.u0(g2, e3.getFirstConnectException());
                            call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                            z = false;
                        } else {
                            throw Util.withSuppressed(e3.getFirstConnectException(), g2);
                        }
                    }
                    if (followUpRequest == null) {
                        if (interceptorScopedExchange$okhttp != null && interceptorScopedExchange$okhttp.isDuplex$okhttp()) {
                            call$okhttp.timeoutEarlyExit();
                        }
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    RequestBody body = followUpRequest.body();
                    if (body != null && body.isOneShot()) {
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    ResponseBody body2 = response.body();
                    if (body2 != null) {
                        Util.closeQuietly(body2);
                    }
                    i2++;
                    if (i2 <= 20) {
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                        request$okhttp = followUpRequest;
                        z = true;
                    } else {
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } catch (Throwable th) {
                call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                throw th;
            }
        }
    }
}
package okhttp3.internal.connection;

import j.d;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;

/* compiled from: RealCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001]\u0018\u00002\u00020\u0001:\u0002uvB\u001f\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010N\u001a\u00020\u001c\u0012\u0006\u0010b\u001a\u00020\b¢\u0006\u0004\bs\u0010tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010!J\u000f\u0010+\u001a\u00020\"H\u0000¢\u0006\u0004\b*\u0010$J\u001d\u0010-\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0017\u00104\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b2\u00103J\u0015\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J;\u0010>\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0000¢\u0006\u0004\b<\u0010=J\u001b\u0010@\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b?\u0010\u000eJ\u0011\u0010D\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ\r\u0010E\u001a\u00020\u0002¢\u0006\u0004\bE\u0010\u0004J\u0017\u0010I\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\bH\u0000¢\u0006\u0004\bG\u0010HJ\r\u0010J\u001a\u00020\b¢\u0006\u0004\bJ\u0010!J\u000f\u0010L\u001a\u00020\u0014H\u0000¢\u0006\u0004\bK\u0010\u0016R\u0018\u00109\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010MR\u0019\u0010N\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u001eR\u0019\u0010R\u001a\u00020Q8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010WR\u0016\u0010E\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010WR(\u0010Z\u001a\u0004\u0018\u0001012\b\u0010Y\u001a\u0004\u0018\u0001018\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bZ\u0010M\u001a\u0004\b[\u0010\\R\u0016\u0010\u0018\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010^R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010WR\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0019\u0010b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010W\u001a\u0004\bc\u0010!R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u00108R\u0016\u0010h\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010WR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010W¨\u0006w"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "Lkotlin/x;", "callStart", "()V", "Ljava/io/IOException;", "E", "e", "", "force", "maybeReleaseConnection", "(Ljava/io/IOException;Z)Ljava/io/IOException;", "cause", "timeoutExit", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Address;", "createAddress", "(Lokhttp3/HttpUrl;)Lokhttp3/Address;", "", "toLoggableString", "()Ljava/lang/String;", "Lj/d;", "timeout", "()Lj/d;", "clone", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "cancel", "isCanceled", "()Z", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "enqueue", "(Lokhttp3/Callback;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "exchange", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "redactedUrl$okhttp", "redactedUrl", "Lokhttp3/internal/connection/Exchange;", "originalRequest", "Lokhttp3/Request;", "getOriginalRequest", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "canceled", "Z", "exchangeResponseDone", "<set-?>", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "forWebSocket", "getForWebSocket", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "setConnection", "exchangeRequestDone", "", "callStackTrace", "Ljava/lang/Object;", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "executed", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class RealCall implements Call {
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean executed;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private boolean noMoreExchanges;
    private final Request originalRequest;
    private final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    /* compiled from: RealCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u00020\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0019\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001d\u001a\u00020\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/RealCall;", "other", "Lkotlin/x;", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", "call", "", "getHost", "()Ljava/lang/String;", "host", "Lokhttp3/Callback;", "responseCallback", "Lokhttp3/Callback;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback responseCallback) {
            m.h(responseCallback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(ExecutorService executorService) {
            m.h(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                m.d(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(dispatcher);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall other) {
            m.h(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Throwable th;
            IOException e2;
            Dispatcher dispatcher;
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName("OkHttp " + this.this$0.redactedUrl$okhttp());
            try {
                enter();
                try {
                    z = true;
                    try {
                        this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());
                        dispatcher = this.this$0.getClient().dispatcher();
                    } catch (IOException e3) {
                        e2 = e3;
                        if (z) {
                            Platform.Companion.get().log("Callback failure for " + this.this$0.toLoggableString(), 4, e2);
                        } else {
                            this.responseCallback.onFailure(this.this$0, e2);
                        }
                        dispatcher = this.this$0.getClient().dispatcher();
                        dispatcher.finished$okhttp(this);
                    } catch (Throwable th2) {
                        th = th2;
                        this.this$0.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.responseCallback.onFailure(this.this$0, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    z = false;
                    e2 = e4;
                } catch (Throwable th3) {
                    z = false;
                    th = th3;
                }
                dispatcher.finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* compiled from: RealCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "", "callStackTrace", "Ljava/lang/Object;", "getCallStackTrace", "()Ljava/lang/Object;", "referent", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object obj) {
            super(referent);
            m.h(referent, "referent");
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [j.f0, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(OkHttpClient client, Request originalRequest, boolean z) {
        m.h(client, "client");
        m.h(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z;
        this.connectionPool = client.connectionPool().getDelegate$okhttp();
        this.eventListener = client.eventListenerFactory().create(this);
        ?? r4 = new d() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // j.d
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        r4.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r4;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:6:0x000c, B:14:0x0019, B:16:0x0020, B:19:0x0026, B:21:0x002a, B:23:0x0030, B:25:0x0034, B:26:0x0036, B:28:0x003a, B:32:0x0041, B:53:0x0078, B:54:0x0083), top: B:57:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0078 A[Catch: all -> 0x0013, TRY_ENTER, TryCatch #0 {all -> 0x0013, blocks: (B:6:0x000c, B:14:0x0019, B:16:0x0020, B:19:0x0026, B:21:0x002a, B:23:0x0030, B:25:0x0034, B:26:0x0036, B:28:0x003a, B:32:0x0041, B:53:0x0078, B:54:0x0083), top: B:57:0x000c }] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, okhttp3.internal.connection.RealConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <E extends java.io.IOException> E maybeReleaseConnection(E r7, boolean r8) {
        /*
            r6 = this;
            kotlin.jvm.internal.d0 r0 = new kotlin.jvm.internal.d0
            r0.<init>()
            okhttp3.internal.connection.RealConnectionPool r1 = r6.connectionPool
            monitor-enter(r1)
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L16
            okhttp3.internal.connection.Exchange r4 = r6.exchange     // Catch: java.lang.Throwable -> L13
            if (r4 != 0) goto L11
            goto L16
        L11:
            r4 = r2
            goto L17
        L13:
            r7 = move-exception
            goto L84
        L16:
            r4 = r3
        L17:
            if (r4 == 0) goto L78
            okhttp3.internal.connection.RealConnection r4 = r6.connection     // Catch: java.lang.Throwable -> L13
            r0.a = r4     // Catch: java.lang.Throwable -> L13
            r5 = 0
            if (r4 == 0) goto L2f
            okhttp3.internal.connection.Exchange r4 = r6.exchange     // Catch: java.lang.Throwable -> L13
            if (r4 != 0) goto L2f
            if (r8 != 0) goto L2a
            boolean r8 = r6.noMoreExchanges     // Catch: java.lang.Throwable -> L13
            if (r8 == 0) goto L2f
        L2a:
            java.net.Socket r8 = r6.releaseConnectionNoEvents$okhttp()     // Catch: java.lang.Throwable -> L13
            goto L30
        L2f:
            r8 = r5
        L30:
            okhttp3.internal.connection.RealConnection r4 = r6.connection     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L36
            r0.a = r5     // Catch: java.lang.Throwable -> L13
        L36:
            boolean r4 = r6.noMoreExchanges     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L40
            okhttp3.internal.connection.Exchange r4 = r6.exchange     // Catch: java.lang.Throwable -> L13
            if (r4 != 0) goto L40
            r4 = r3
            goto L41
        L40:
            r4 = r2
        L41:
            kotlin.x r5 = kotlin.x.a     // Catch: java.lang.Throwable -> L13
            monitor-exit(r1)
            if (r8 == 0) goto L49
            okhttp3.internal.Util.closeQuietly(r8)
        L49:
            T r8 = r0.a
            r0 = r8
            okhttp3.Connection r0 = (okhttp3.Connection) r0
            if (r0 == 0) goto L5c
            okhttp3.EventListener r0 = r6.eventListener
            okhttp3.Connection r8 = (okhttp3.Connection) r8
            if (r8 != 0) goto L59
            kotlin.jvm.internal.m.q()
        L59:
            r0.connectionReleased(r6, r8)
        L5c:
            if (r4 == 0) goto L77
            if (r7 == 0) goto L61
            r2 = r3
        L61:
            java.io.IOException r7 = r6.timeoutExit(r7)
            if (r2 == 0) goto L72
            okhttp3.EventListener r8 = r6.eventListener
            if (r7 != 0) goto L6e
            kotlin.jvm.internal.m.q()
        L6e:
            r8.callFailed(r6, r7)
            goto L77
        L72:
            okhttp3.EventListener r8 = r6.eventListener
            r8.callEnd(r6)
        L77:
            return r7
        L78:
            java.lang.String r7 = "cannot release connection while it is in use"
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L13
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L13
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L13
            throw r8     // Catch: java.lang.Throwable -> L13
        L84:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.maybeReleaseConnection(java.io.IOException, boolean):java.io.IOException");
    }

    private final <E extends IOException> E timeoutExit(E e2) {
        if (!this.timeoutEarlyExit && exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (e2 != null) {
                interruptedIOException.initCause(e2);
            }
            return interruptedIOException;
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection connection) {
        m.h(connection, "connection");
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnectionPool)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnectionPool);
            throw new AssertionError(sb.toString());
        }
        if (this.connection == null) {
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public void cancel() {
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            if (this.canceled) {
                return;
            }
            this.canceled = true;
            Exchange exchange = this.exchange;
            ExchangeFinder exchangeFinder = this.exchangeFinder;
            if (exchangeFinder == null || (realConnection = exchangeFinder.connectingConnection()) == null) {
                realConnection = this.connection;
            }
            x xVar = x.a;
            if (exchange != null) {
                exchange.cancel();
            } else if (realConnection != null) {
                realConnection.cancel();
            }
            this.eventListener.canceled(this);
        }
    }

    @Override // okhttp3.Call
    public void enqueue(Callback responseCallback) {
        m.h(responseCallback, "responseCallback");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                x xVar = x.a;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z) {
        m.h(request, "request");
        if (this.interceptorScopedExchange == null) {
            if (!(this.exchange == null)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (z) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public Response execute() {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                x xVar = x.a;
            } else {
                throw new IllegalStateException("Already Executed".toString());
            }
        }
        enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        if (!this.noMoreExchanges) {
            if (z) {
                Exchange exchange = this.exchange;
                if (exchange != null) {
                    exchange.detachWithViolence();
                }
                if (!(this.exchange == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            this.interceptorScopedExchange = null;
            return;
        }
        throw new IllegalStateException("released".toString());
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.interceptors()
            kotlin.a0.p.y(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            okhttp3.CookieJar r1 = r1.cookieJar()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            okhttp3.Cache r1 = r1.cache()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r11.forWebSocket
            if (r0 != 0) goto L46
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.networkInterceptors()
            kotlin.a0.p.y(r2, r0)
        L46:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r11.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r11.originalRequest
            okhttp3.OkHttpClient r0 = r11.client
            int r6 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r7 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r8 = r0.writeTimeoutMillis()
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r11.originalRequest     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            okhttp3.Response r2 = r9.proceed(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            boolean r3 = r11.isCanceled()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            if (r3 != 0) goto L7f
            r11.noMoreExchanges$okhttp(r1)
            return r2
        L7f:
            okhttp3.internal.Util.closeQuietly(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            throw r2     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
        L8a:
            r2 = move-exception
            goto La1
        L8c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r11.noMoreExchanges$okhttp(r0)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L9c
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9d
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9c:
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9d:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
        La1:
            if (r0 != 0) goto La6
            r11.noMoreExchanges$okhttp(r1)
        La6:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain chain) {
        m.h(chain, "chain");
        synchronized (this.connectionPool) {
            boolean z = true;
            if (!this.noMoreExchanges) {
                if (this.exchange != null) {
                    z = false;
                }
                if (z) {
                    x xVar = x.a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        if (exchangeFinder == null) {
            m.q();
        }
        ExchangeCodec find = exchangeFinder.find(this.client, chain);
        EventListener eventListener = this.eventListener;
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        if (exchangeFinder2 == null) {
            m.q();
        }
        Exchange exchange = new Exchange(this, eventListener, exchangeFinder2, find);
        this.interceptorScopedExchange = exchange;
        synchronized (this.connectionPool) {
            this.exchange = exchange;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public final <E extends IOException> E messageDone$okhttp(Exchange exchange, boolean z, boolean z2, E e2) {
        boolean z3;
        m.h(exchange, "exchange");
        synchronized (this.connectionPool) {
            boolean z4 = true;
            if (!m.c(exchange, this.exchange)) {
                return e2;
            }
            if (z) {
                z3 = !this.exchangeRequestDone;
                this.exchangeRequestDone = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.exchangeResponseDone) {
                    z3 = true;
                }
                this.exchangeResponseDone = true;
            }
            if (this.exchangeRequestDone && this.exchangeResponseDone && z3) {
                Exchange exchange2 = this.exchange;
                if (exchange2 == null) {
                    m.q();
                }
                RealConnection connection$okhttp = exchange2.getConnection$okhttp();
                connection$okhttp.setSuccessCount$okhttp(connection$okhttp.getSuccessCount$okhttp() + 1);
                this.exchange = null;
            } else {
                z4 = false;
            }
            x xVar = x.a;
            return z4 ? (E) maybeReleaseConnection(e2, false) : e2;
        }
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
            x xVar = x.a;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnectionPool)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnectionPool);
            throw new AssertionError(sb.toString());
        }
        RealConnection realConnection = this.connection;
        if (realConnection == null) {
            m.q();
        }
        Iterator<Reference<RealCall>> it = realConnection.getCalls().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (m.c(it.next().get(), this)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            RealConnection realConnection2 = this.connection;
            if (realConnection2 == null) {
                m.q();
            }
            realConnection2.getCalls().remove(i2);
            this.connection = null;
            if (realConnection2.getCalls().isEmpty()) {
                realConnection2.setIdleAtNs$okhttp(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(realConnection2)) {
                    return realConnection2.socket();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        if (exchangeFinder == null) {
            m.q();
        }
        return exchangeFinder.retryAfterFailure();
    }

    public final void setConnection(RealConnection realConnection) {
        this.connection = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    public d timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
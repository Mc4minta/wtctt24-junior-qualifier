package com.coinbase.wallet.http.websocket;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import com.coinbase.wallet.http.exceptions.WebSocketException;
import com.coinbase.wallet.http.models.WebConnectionState;
import com.coinbase.wallet.http.models.WebIncomingDataType;
import h.c.b0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import j.i;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import org.spongycastle.i18n.TextBundle;

/* compiled from: WebSocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010H\u001a\u00020G\u0012\b\b\u0002\u00106\u001a\u000203\u0012\b\b\u0002\u0010P\u001a\u000203\u0012\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\bT\u0010UJ\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010$\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010'J\u001f\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u000bH\u0016¢\u0006\u0004\b+\u0010\rR$\u0010/\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010-0-0,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001f\u0010:\u001a\b\u0012\u0004\u0012\u00020-098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00102R\u0016\u0010?\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020D098\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010;\u001a\u0004\bF\u0010=R\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u00105R$\u0010R\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010D0D0Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006V"}, d2 = {"Lcom/coinbase/wallet/http/websocket/WebSocket;", "Lokhttp3/WebSocketListener;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "", "t", "Lkotlin/x;", "onDisconnect", "(Ljava/lang/Throwable;)V", "connectSocket", "()V", "disconnectSocket", "Lh/c/b0;", "connect", "()Lh/c/b0;", "disconnect", "", "string", "sendString", "(Ljava/lang/String;)Lh/c/b0;", "", "data", "sendData", "([B)Lh/c/b0;", "Lokhttp3/WebSocket;", "webSocket", "", "code", "reason", "onClosed", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "Lokhttp3/Response;", Payload.RESPONSE, "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "Lj/i;", "bytes", "onMessage", "(Lokhttp3/WebSocket;Lj/i;)V", TextBundle.TEXT_ENTRY, "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "destroy", "Lh/c/v0/c;", "Lcom/coinbase/wallet/http/models/WebConnectionState;", "kotlin.jvm.PlatformType", "connectionStateSubject", "Lh/c/v0/c;", "isConnected", "Z", "", "maxReconnectDelay", "J", "connectionTimeout", "socket", "Lokhttp3/WebSocket;", "Lh/c/s;", "connectionStateObservable", "Lh/c/s;", "getConnectionStateObservable", "()Lh/c/s;", "isManualClose", "reconnectAttempts", "I", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/http/models/WebIncomingDataType;", "incomingObservable", "getIncomingObservable", "Ljava/net/URL;", "url", "Ljava/net/URL;", "Ljava/util/concurrent/locks/ReentrantLock;", "accessQueue", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "minReconnectDelay", "Lh/c/v0/b;", "incomingSubject", "Lh/c/v0/b;", "<init>", "(Ljava/net/URL;JJJ)V", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WebSocket extends WebSocketListener implements Destroyable {
    private final ReentrantLock accessQueue;
    private final OkHttpClient client;
    private final s<WebConnectionState> connectionStateObservable;
    private final h.c.v0.c<WebConnectionState> connectionStateSubject;
    private final long connectionTimeout;
    private final h.c.k0.a disposeBag;
    private final s<WebIncomingDataType> incomingObservable;
    private final h.c.v0.b<WebIncomingDataType> incomingSubject;
    private boolean isConnected;
    private boolean isManualClose;
    private final long maxReconnectDelay;
    private final long minReconnectDelay;
    private int reconnectAttempts;
    private okhttp3.WebSocket socket;
    private final URL url;

    public /* synthetic */ WebSocket(URL url, long j2, long j3, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, (i2 & 2) != 0 ? 15L : j2, (i2 & 4) != 0 ? 1L : j3, (i2 & 8) != 0 ? 5L : j4);
    }

    public static /* synthetic */ void a(WebSocket webSocket, h.c.k0.b bVar) {
        m1566disconnect$lambda5(webSocket, bVar);
    }

    public static /* synthetic */ boolean b(ConnectionStatus connectionStatus) {
        return m1569onDisconnect$lambda9(connectionStatus);
    }

    public static /* synthetic */ boolean c(WebConnectionState webConnectionState) {
        return m1565connect$lambda3(webConnectionState);
    }

    /* renamed from: connect$lambda-2 */
    public static final void m1564connect$lambda2(WebSocket this$0, h.c.k0.b bVar) {
        m.g(this$0, "this$0");
        this$0.connectSocket();
    }

    /* renamed from: connect$lambda-3 */
    public static final boolean m1565connect$lambda3(WebConnectionState it) {
        m.g(it, "it");
        return it.isConnected();
    }

    private final void connectSocket() {
        Request build = new Request.Builder().url(this.url).header("Origin", "").build();
        this.client.dispatcher().cancelAll();
        this.socket = this.client.newWebSocket(build, this);
    }

    public static /* synthetic */ void d(WebSocket webSocket, h.c.k0.b bVar) {
        m1564connect$lambda2(webSocket, bVar);
    }

    /* renamed from: disconnect$lambda-5 */
    public static final void m1566disconnect$lambda5(WebSocket this$0, h.c.k0.b bVar) {
        m.g(this$0, "this$0");
        this$0.disconnectSocket();
    }

    /* renamed from: disconnect$lambda-6 */
    public static final boolean m1567disconnect$lambda6(WebConnectionState it) {
        m.g(it, "it");
        return !it.isConnected();
    }

    private final void disconnectSocket() {
        this.client.dispatcher().cancelAll();
        this.socket = null;
    }

    public static /* synthetic */ boolean e(WebConnectionState webConnectionState) {
        return m1567disconnect$lambda6(webConnectionState);
    }

    public static /* synthetic */ x f(WebSocket webSocket, ConnectionStatus connectionStatus) {
        return m1568onDisconnect$lambda11(webSocket, connectionStatus);
    }

    private final void onDisconnect(Throwable th) {
        ReentrantLock reentrantLock = this.accessQueue;
        reentrantLock.lock();
        try {
            boolean z = this.isManualClose;
            int i2 = this.reconnectAttempts + 1;
            this.reconnectAttempts = i2;
            long j2 = this.minReconnectDelay * i2;
            long j3 = this.maxReconnectDelay;
            if (j2 > j3) {
                j2 = j3;
            }
            this.isConnected = false;
            x xVar = x.a;
            reentrantLock.unlock();
            this.connectionStateSubject.onNext(new WebConnectionState.Disconnected(th));
            if (z) {
                return;
            }
            h.c.k0.b subscribe = Internet.INSTANCE.getStatusChanges().filter(new p() { // from class: com.coinbase.wallet.http.websocket.b
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return WebSocket.b((ConnectionStatus) obj);
                }
            }).take(1L).delay(j2, TimeUnit.SECONDS).map(new n() { // from class: com.coinbase.wallet.http.websocket.f
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WebSocket.f(WebSocket.this, (ConnectionStatus) obj);
                }
            }).subscribe();
            m.f(subscribe, "Internet.statusChanges\n                .filter { it.isOnline }\n                .take(1)\n                .delay(delay, TimeUnit.SECONDS)\n                .map {\n                    accessQueue.withLock {\n                        if (this.isManualClose) {\n                            disconnectSocket()\n                        } else {\n                            connectSocket()\n                        }\n                    }\n                }\n                .subscribe()");
            h.c.t0.a.a(subscribe, this.disposeBag);
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    static /* synthetic */ void onDisconnect$default(WebSocket webSocket, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        webSocket.onDisconnect(th);
    }

    /* renamed from: onDisconnect$lambda-11 */
    public static final x m1568onDisconnect$lambda11(WebSocket this$0, ConnectionStatus it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        ReentrantLock reentrantLock = this$0.accessQueue;
        reentrantLock.lock();
        try {
            if (this$0.isManualClose) {
                this$0.disconnectSocket();
            } else {
                this$0.connectSocket();
            }
            return x.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: onDisconnect$lambda-9 */
    public static final boolean m1569onDisconnect$lambda9(ConnectionStatus it) {
        m.g(it, "it");
        return it.isOnline();
    }

    public final b0<x> connect() {
        this.accessQueue.lock();
        try {
            boolean z = this.isConnected;
            this.isManualClose = false;
            x xVar = x.a;
            if (z) {
                b0<x> just = b0.just(xVar);
                m.f(just, "just(Unit)");
                return just;
            }
            ReentrantLock reentrantLock = this.accessQueue;
            reentrantLock.lock();
            try {
                this.reconnectAttempts = 0;
                reentrantLock.unlock();
                s<WebConnectionState> filter = this.connectionStateObservable.doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.http.websocket.d
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        WebSocket.d(WebSocket.this, (h.c.k0.b) obj);
                    }
                }).filter(new p() { // from class: com.coinbase.wallet.http.websocket.c
                    @Override // h.c.m0.p
                    public final boolean test(Object obj) {
                        return WebSocket.c((WebConnectionState) obj);
                    }
                });
                m.f(filter, "connectionStateObservable\n            .doOnSubscribe { connectSocket() }\n            .filter { it.isConnected }");
                b0 timeout = Observable_CoreKt.takeSingle(filter).timeout(this.connectionTimeout, TimeUnit.SECONDS);
                m.f(timeout, "connectionStateObservable\n            .doOnSubscribe { connectSocket() }\n            .filter { it.isConnected }\n            .takeSingle()\n            .timeout(connectionTimeout, TimeUnit.SECONDS)");
                return Single_CoreKt.asUnit(timeout);
            } finally {
            }
        } finally {
        }
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        this.disposeBag.d();
        b0<Boolean> just = b0.just(Boolean.TRUE);
        m.f(just, "just(true)");
        return just;
    }

    public final b0<x> disconnect() {
        ReentrantLock reentrantLock = this.accessQueue;
        reentrantLock.lock();
        try {
            boolean z = this.isConnected;
            this.isManualClose = true;
            x xVar = x.a;
            if (!z) {
                b0<x> just = b0.just(xVar);
                m.f(just, "just(Unit)");
                return just;
            }
            s<WebConnectionState> filter = this.connectionStateObservable.doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.http.websocket.a
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    WebSocket.a(WebSocket.this, (h.c.k0.b) obj);
                }
            }).filter(new p() { // from class: com.coinbase.wallet.http.websocket.e
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return WebSocket.e((WebConnectionState) obj);
                }
            });
            m.f(filter, "connectionStateObservable\n            .doOnSubscribe { disconnectSocket() }\n            .filter { !it.isConnected }");
            return Single_CoreKt.asUnit(Observable_CoreKt.takeSingle(filter));
        } finally {
            reentrantLock.unlock();
        }
    }

    public final s<WebConnectionState> getConnectionStateObservable() {
        return this.connectionStateObservable;
    }

    public final s<WebIncomingDataType> getIncomingObservable() {
        return this.incomingObservable;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(okhttp3.WebSocket webSocket, int i2, String reason) {
        m.g(webSocket, "webSocket");
        m.g(reason, "reason");
        onDisconnect$default(this, null, 1, null);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        m.g(webSocket, "webSocket");
        m.g(t, "t");
        onDisconnect(t);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, i bytes) {
        m.g(webSocket, "webSocket");
        m.g(bytes, "bytes");
        this.incomingSubject.onNext(new WebIncomingDataType.WebIncomingData(bytes.T()));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        m.g(webSocket, "webSocket");
        m.g(response, "response");
        ReentrantLock reentrantLock = this.accessQueue;
        reentrantLock.lock();
        try {
            boolean z = this.isManualClose;
            this.isConnected = true;
            this.reconnectAttempts = 0;
            x xVar = x.a;
            reentrantLock.unlock();
            this.connectionStateSubject.onNext(WebConnectionState.Connected.INSTANCE);
            if (z) {
                disconnectSocket();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final b0<x> sendData(byte[] data) {
        m.g(data, "data");
        boolean z = false;
        i f2 = i.f17151b.f(data, 0, data.length);
        okhttp3.WebSocket webSocket = this.socket;
        if (webSocket != null && webSocket.send(f2)) {
            z = true;
        }
        if (z) {
            b0<x> just = b0.just(x.a);
            m.f(just, "just(Unit)");
            return just;
        }
        b0<x> error = b0.error(WebSocketException.UnableToSendData.INSTANCE);
        m.f(error, "error(WebSocketException.UnableToSendData)");
        return error;
    }

    public final b0<x> sendString(String string) {
        m.g(string, "string");
        okhttp3.WebSocket webSocket = this.socket;
        boolean z = false;
        if (webSocket != null && webSocket.send(string)) {
            z = true;
        }
        if (z) {
            b0<x> just = b0.just(x.a);
            m.f(just, "just(Unit)");
            return just;
        }
        b0<x> error = b0.error(WebSocketException.UnableToSendData.INSTANCE);
        m.f(error, "error(WebSocketException.UnableToSendData)");
        return error;
    }

    public WebSocket(URL url, long j2, long j3, long j4) {
        m.g(url, "url");
        this.url = url;
        this.connectionTimeout = j2;
        this.minReconnectDelay = j3;
        this.maxReconnectDelay = j4;
        this.disposeBag = new h.c.k0.a();
        this.accessQueue = new ReentrantLock();
        h.c.v0.b<WebIncomingDataType> d2 = h.c.v0.b.d();
        m.f(d2, "create<WebIncomingDataType>()");
        this.incomingSubject = d2;
        h.c.v0.c<WebConnectionState> d3 = h.c.v0.c.d(1);
        m.f(d3, "createWithSize<WebConnectionState>(1)");
        this.connectionStateSubject = d3;
        this.client = new OkHttpClient.Builder().pingInterval(10L, TimeUnit.SECONDS).retryOnConnectionFailure(false).build();
        s<WebIncomingDataType> hide = d2.hide();
        m.f(hide, "incomingSubject.hide()");
        this.incomingObservable = hide;
        s<WebConnectionState> hide2 = d3.hide();
        m.f(hide2, "connectionStateSubject.hide()");
        this.connectionStateObservable = hide2;
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, String text) {
        m.g(webSocket, "webSocket");
        m.g(text, "text");
        this.incomingSubject.onNext(new WebIncomingDataType.WebIncomingText(text));
    }
}
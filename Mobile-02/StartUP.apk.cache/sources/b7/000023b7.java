package com.coinbase.wallet.http.connectivity;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import h.c.s;
import h.c.t0.g;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.x;

/* compiled from: Internet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B\t\b\u0002¢\u0006\u0004\b9\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\n\u0010\u001fR$\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\r0\r0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\t0\t0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010+\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\r0\r0*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0013\u00102\u001a\u00020\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00103R=\u00105\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\t0\t !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\t0\t\u0018\u000104048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/Internet;", "Landroid/content/BroadcastReceiver;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lh/c/b0;", "", "isServerReachable", "()Lh/c/b0;", "Landroid/net/NetworkCapabilities;", "capabilities", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "getStatus", "(Landroid/net/NetworkCapabilities;)Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "isForced", "Lkotlin/x;", "refresh", "(Z)Lh/c/b0;", "Landroid/app/Application;", "application", "startMonitoring", "(Landroid/app/Application;)V", "stopMonitoring", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<set-?>", "status", "Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "()Lcom/coinbase/wallet/http/connectivity/ConnectionStatus;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "refreshSubject", "Lh/c/v0/b;", "Lh/c/a0;", "serialScheduler", "Lh/c/a0;", "Lh/c/v0/a;", "changes", "Lh/c/v0/a;", "Lh/c/v0/c;", "networkUpdatesSubject", "Lh/c/v0/c;", "app", "Landroid/app/Application;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "isOnline", "()Z", "Lh/c/s;", "statusChanges", "Lh/c/s;", "getStatusChanges", "()Lh/c/s;", "<init>", "NetworkNotReachableException", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Internet extends BroadcastReceiver implements Refreshable {
    private static Application app;
    private static final h.c.v0.a<ConnectionStatus> changes;
    private static final h.c.v0.c<x> networkUpdatesSubject;
    private static final h.c.v0.b<x> refreshSubject;
    private static ConnectionStatus status;
    private static final s<ConnectionStatus> statusChanges;
    public static final Internet INSTANCE = new Internet();
    private static final h.c.k0.a disposeBag = new h.c.k0.a();
    private static final a0 serialScheduler = RxSchedulers.INSTANCE.newSerialScheduler();

    /* compiled from: Internet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/http/connectivity/Internet$NetworkNotReachableException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NetworkNotReachableException extends Exception {
    }

    static {
        h.c.v0.c<x> d2 = h.c.v0.c.d(1);
        m.f(d2, "createWithSize<Unit>(1)");
        networkUpdatesSubject = d2;
        h.c.v0.b<x> d3 = h.c.v0.b.d();
        m.f(d3, "create<Unit>()");
        refreshSubject = d3;
        ConnectionStatus.Unknown unknown = ConnectionStatus.Unknown.INSTANCE;
        h.c.v0.a<ConnectionStatus> e2 = h.c.v0.a.e(unknown);
        m.f(e2, "createDefault<ConnectionStatus>(ConnectionStatus.Unknown)");
        changes = e2;
        status = unknown;
        statusChanges = e2.hide();
    }

    private Internet() {
    }

    public static /* synthetic */ Boolean b() {
        return m1559isServerReachable$lambda5();
    }

    public static /* synthetic */ Boolean c(Throwable th) {
        return m1560isServerReachable$lambda6(th);
    }

    public static /* synthetic */ ConnectionStatus d(Throwable th) {
        return m1563startMonitoring$lambda2(th);
    }

    public static /* synthetic */ ConnectionStatus e(boolean z, ConnectivityManager connectivityManager, Network network, Boolean bool) {
        return m1562startMonitoring$lambda1$lambda0(z, connectivityManager, network, bool);
    }

    public static /* synthetic */ h0 f(Application application, o oVar) {
        return m1561startMonitoring$lambda1(application, oVar);
    }

    private final b0<Boolean> isServerReachable() {
        b0 fromCallable = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.http.connectivity.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Internet.b();
            }
        });
        m.f(fromCallable, "fromCallable {\n            try {\n                val connection: HttpURLConnection = URL(\"https://www.google.com\")\n                    .openConnection()\n                    .let { it as HttpURLConnection }\n                    .apply {\n                        instanceFollowRedirects = false\n                        setRequestProperty(\"Connection\", \"close\")\n                        connectTimeout = 15000\n                        connect()\n                    }\n\n                val responseCode = connection.responseCode\n                connection.inputStream.close()\n                if (responseCode !in 200..299) {\n                    throw NetworkNotReachableException()\n                }\n\n                true\n            } catch (e: Throwable) {\n                throw NetworkNotReachableException()\n            }\n        }");
        b0<Boolean> onErrorReturn = Single_CoreKt.retryWithBackoffDelay(fromCallable, 3, 500L, TimeUnit.MILLISECONDS, Internet$isServerReachable$2.INSTANCE).onErrorReturn(new n() { // from class: com.coinbase.wallet.http.connectivity.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Internet.c((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "fromCallable {\n            try {\n                val connection: HttpURLConnection = URL(\"https://www.google.com\")\n                    .openConnection()\n                    .let { it as HttpURLConnection }\n                    .apply {\n                        instanceFollowRedirects = false\n                        setRequestProperty(\"Connection\", \"close\")\n                        connectTimeout = 15000\n                        connect()\n                    }\n\n                val responseCode = connection.responseCode\n                connection.inputStream.close()\n                if (responseCode !in 200..299) {\n                    throw NetworkNotReachableException()\n                }\n\n                true\n            } catch (e: Throwable) {\n                throw NetworkNotReachableException()\n            }\n        }\n        .retryWithBackoffDelay(3, 500L, TimeUnit.MILLISECONDS) { it != NetworkNotReachableException() }\n        .onErrorReturn { error ->\n            if (error is NetworkNotReachableException) {\n                false\n            } else {\n                throw error\n            }\n        }");
        return onErrorReturn;
    }

    /* renamed from: isServerReachable$lambda-5 */
    public static final Boolean m1559isServerReachable$lambda5() {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://www.google.com").openConnection());
        if (uRLConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            boolean z = false;
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.getInputStream().close();
            if (200 <= responseCode && responseCode <= 299) {
                z = true;
            }
            if (z) {
                return Boolean.TRUE;
            }
            throw new NetworkNotReachableException();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }

    /* renamed from: isServerReachable$lambda-6 */
    public static final Boolean m1560isServerReachable$lambda6(Throwable error) {
        m.g(error, "error");
        if (error instanceof NetworkNotReachableException) {
            return Boolean.FALSE;
        }
        throw error;
    }

    /* renamed from: startMonitoring$lambda-1 */
    public static final h0 m1561startMonitoring$lambda1(Application application, o it) {
        m.g(application, "$application");
        m.g(it, "it");
        Object systemService = application.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        final ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        final Network activeNetwork = connectivityManager.getActiveNetwork();
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        final boolean isConnected = activeNetworkInfo == null ? false : activeNetworkInfo.isConnected();
        return INSTANCE.isServerReachable().map(new n() { // from class: com.coinbase.wallet.http.connectivity.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Internet.e(isConnected, connectivityManager, activeNetwork, (Boolean) obj);
            }
        });
    }

    /* renamed from: startMonitoring$lambda-1$lambda-0 */
    public static final ConnectionStatus m1562startMonitoring$lambda1$lambda0(boolean z, ConnectivityManager cm, Network network, Boolean isReachable) {
        m.g(cm, "$cm");
        m.g(isReachable, "isReachable");
        if (z && isReachable.booleanValue()) {
            return INSTANCE.getStatus(cm.getNetworkCapabilities(network));
        }
        if (isReachable.booleanValue()) {
            return new ConnectionStatus.Connected(ConnectionKind.UNKNOWN);
        }
        return ConnectionStatus.Offline.INSTANCE;
    }

    /* renamed from: startMonitoring$lambda-2 */
    public static final ConnectionStatus m1563startMonitoring$lambda2(Throwable it) {
        m.g(it, "it");
        l.a.a.f(it, "Unable to determine internet status", new Object[0]);
        return ConnectionStatus.Unknown.INSTANCE;
    }

    public final ConnectionStatus getStatus() {
        return status;
    }

    public final s<ConnectionStatus> getStatusChanges() {
        return statusChanges;
    }

    public final boolean isOnline() {
        return status.isOnline();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m.g(context, "context");
        m.g(intent, "intent");
        if (m.c(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            networkUpdatesSubject.onNext(x.a);
        }
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public b0<x> refresh(boolean z) {
        if (!isOnline()) {
            refreshSubject.onNext(x.a);
        }
        b0<x> just = b0.just(x.a);
        m.f(just, "just(Unit)");
        return just;
    }

    public final void startMonitoring(final Application application) {
        m.g(application, "application");
        app = application;
        s onErrorReturn = h.c.t0.c.a.a(networkUpdatesSubject, refreshSubject).throttleLatest(2L, TimeUnit.SECONDS).observeOn(serialScheduler).switchMapSingle(new n() { // from class: com.coinbase.wallet.http.connectivity.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Internet.f(application, (o) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.wallet.http.connectivity.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Internet.d((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "Observables.combineLatest(networkUpdatesSubject, refreshSubject)\n            .throttleLatest(2L, TimeUnit.SECONDS)\n            .observeOn(serialScheduler)\n            .switchMapSingle {\n                val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager\n                val activeNetwork: Network? = cm.activeNetwork\n                val activeNetworkInfo: NetworkInfo? = cm.activeNetworkInfo\n                val activeNetworkConnected = activeNetworkInfo?.isConnected ?: false\n\n                isServerReachable()\n                    .map { isReachable ->\n                        if (activeNetworkConnected && isReachable) {\n                            getStatus(cm.getNetworkCapabilities(activeNetwork))\n                        } else if (isReachable) {\n                            Connected(UNKNOWN)\n                        } else {\n                            ConnectionStatus.Offline\n                        }\n                    }\n            }\n            .onErrorReturn {\n                Timber.e(it, \"Unable to determine internet status\")\n                ConnectionStatus.Unknown\n            }");
        h.c.t0.a.a(g.h(onErrorReturn, null, null, Internet$startMonitoring$3.INSTANCE, 3, null), disposeBag);
    }

    public final void stopMonitoring() {
        disposeBag.d();
    }

    private final ConnectionStatus getStatus(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return new ConnectionStatus.Connected(ConnectionKind.UNKNOWN);
        }
        boolean hasTransport = networkCapabilities.hasTransport(0);
        boolean hasTransport2 = networkCapabilities.hasTransport(1);
        if (!hasTransport || hasTransport2) {
            if (hasTransport2) {
                return new ConnectionStatus.Connected(ConnectionKind.WIFI);
            }
            return new ConnectionStatus.Connected(ConnectionKind.UNKNOWN);
        }
        return new ConnectionStatus.Connected(ConnectionKind.CELL);
    }
}
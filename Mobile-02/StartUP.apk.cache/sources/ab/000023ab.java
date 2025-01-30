package com.coinbase.wallet.http;

import com.appsflyer.internal.referrer.Payload;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import h.c.b0;
import h.c.e0;
import h.c.k0.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: CallEnqueueSingle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/http/CallEnqueueSingle;", "Lh/c/b0;", "Lokhttp3/Response;", "Lh/c/e0;", "observer", "Lkotlin/x;", "subscribeActual", "(Lh/c/e0;)V", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "originalRequest", "Lokhttp3/Request;", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;)V", "CallCallback", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CallEnqueueSingle extends b0<Response> {
    private final OkHttpClient client;
    private final Request originalRequest;

    /* compiled from: CallEnqueueSingle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u001e\u0010\u001a\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/http/CallEnqueueSingle$CallCallback;", "Lh/c/k0/b;", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Lokhttp3/Response;", Payload.RESPONSE, "Lkotlin/x;", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "Ljava/io/IOException;", "e", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "dispose", "()V", "", "isDisposed", "()Z", "terminated", "Z", "getTerminated", "setTerminated", "(Z)V", "Lokhttp3/Call;", "Lh/c/e0;", "observer", "Lh/c/e0;", "<init>", "(Lokhttp3/Call;Lh/c/e0;)V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class CallCallback implements b, Callback {
        private final Call call;
        private final e0<? super Response> observer;
        private boolean terminated;

        public CallCallback(Call call, e0<? super Response> observer) {
            m.g(call, "call");
            m.g(observer, "observer");
            this.call = call;
            this.observer = observer;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.call.cancel();
        }

        public final boolean getTerminated() {
            return this.terminated;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.call.isCanceled();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e2) {
            m.g(call, "call");
            m.g(e2, "e");
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(e2);
            } catch (Throwable th) {
                a.b(th);
                h.c.r0.a.u(new CompositeException(e2, th));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            m.g(call, "call");
            m.g(response, "response");
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onSuccess(response);
                this.terminated = true;
            } catch (Throwable th) {
                if (this.terminated) {
                    h.c.r0.a.u(th);
                } else if (call.isCanceled()) {
                } else {
                    try {
                        this.observer.onError(th);
                    } catch (Throwable th2) {
                        a.b(th2);
                        h.c.r0.a.u(new CompositeException(th, th2));
                    }
                }
            }
        }

        public final void setTerminated(boolean z) {
            this.terminated = z;
        }
    }

    public CallEnqueueSingle(OkHttpClient client, Request originalRequest) {
        m.g(client, "client");
        m.g(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
    }

    @Override // h.c.b0
    protected void subscribeActual(e0<? super Response> observer) {
        m.g(observer, "observer");
        Call newCall = this.client.newCall(this.originalRequest);
        CallCallback callCallback = new CallCallback(newCall, observer);
        observer.onSubscribe(callCallback);
        FirebasePerfOkHttpClient.enqueue(newCall, callCallback);
    }
}
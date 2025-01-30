package com.coinbase.network;

import com.coinbase.network.ApiCall;
import java.io.IOException;
import java.util.concurrent.Executor;
import retrofit2.d;
import retrofit2.f;
import retrofit2.s;

/* loaded from: classes.dex */
public class ApiCall<T> {
    private Executor callbackExecutor;
    private d<T> originalCall;

    /* renamed from: com.coinbase.network.ApiCall$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements f<T> {
        final /* synthetic */ Callback val$callback;

        AnonymousClass1(Callback callback) {
            ApiCall.this = r1;
            this.val$callback = callback;
        }

        public static /* synthetic */ void lambda$onFailure$1(Callback callback, Throwable th) {
            callback.onFailure(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void lambda$onResponse$0(Callback callback, s sVar) {
            callback.onSuccess(sVar.a());
        }

        @Override // retrofit2.f
        public void onFailure(d<T> dVar, final Throwable th) {
            Executor executor = ApiCall.this.callbackExecutor;
            final Callback callback = this.val$callback;
            executor.execute(new Runnable() { // from class: com.coinbase.network.b
                @Override // java.lang.Runnable
                public final void run() {
                    ApiCall.AnonymousClass1.lambda$onFailure$1(Callback.this, th);
                }
            });
        }

        @Override // retrofit2.f
        public void onResponse(d<T> dVar, final s<T> sVar) {
            Executor executor = ApiCall.this.callbackExecutor;
            final Callback callback = this.val$callback;
            executor.execute(new Runnable() { // from class: com.coinbase.network.a
                @Override // java.lang.Runnable
                public final void run() {
                    ApiCall.AnonymousClass1.lambda$onResponse$0(Callback.this, sVar);
                }
            });
        }
    }

    public ApiCall(d<T> dVar, Executor executor) {
        this.originalCall = dVar;
        this.callbackExecutor = executor;
    }

    public void cancel() {
        this.originalCall.cancel();
    }

    public void enqueue(Callback<T> callback) {
        this.originalCall.d0(new AnonymousClass1(callback));
    }

    public T execute() throws IOException {
        return this.originalCall.execute().a();
    }

    public boolean isCanceled() {
        return this.originalCall.isCanceled();
    }

    public boolean isExecuted() {
        return this.originalCall.isExecuted();
    }
}
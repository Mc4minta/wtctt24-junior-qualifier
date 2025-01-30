package com.coinbase.wallet.wallets.models;

import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.m0.f;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RxTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00018\u00008\u00000\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/wallets/models/RxTask;", "T", "", "Lh/c/b0;", "execute", "()Lh/c/b0;", "single", "Lh/c/b0;", "Lh/c/v0/c;", "kotlin.jvm.PlatformType", "subject", "Lh/c/v0/c;", "onCompletion", "getOnCompletion", "<init>", "(Lh/c/b0;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RxTask<T> {
    private final b0<T> onCompletion;
    private final b0<T> single;
    private final h.c.v0.c<T> subject;

    public RxTask(b0<T> single) {
        m.g(single, "single");
        this.single = single;
        h.c.v0.c<T> d2 = h.c.v0.c.d(1);
        m.f(d2, "createWithSize<T>(1)");
        this.subject = d2;
        s<T> hide = d2.hide();
        m.f(hide, "subject.hide()");
        this.onCompletion = Observable_CoreKt.takeSingle(hide);
    }

    public static /* synthetic */ void a(RxTask rxTask, d0 d0Var) {
        m1848execute$lambda2(rxTask, d0Var);
    }

    public static /* synthetic */ void b(d0 d0Var, RxTask rxTask, Throwable th) {
        m1850execute$lambda2$lambda1(d0Var, rxTask, th);
    }

    public static /* synthetic */ void c(d0 d0Var, RxTask rxTask, Object obj) {
        m1849execute$lambda2$lambda0(d0Var, rxTask, obj);
    }

    /* renamed from: execute$lambda-2 */
    public static final void m1848execute$lambda2(final RxTask this$0, final d0 emitter) {
        m.g(this$0, "this$0");
        m.g(emitter, "emitter");
        this$0.single.subscribe(new f() { // from class: com.coinbase.wallet.wallets.models.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                RxTask.c(d0.this, this$0, obj);
            }
        }, new f() { // from class: com.coinbase.wallet.wallets.models.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                RxTask.b(d0.this, this$0, (Throwable) obj);
            }
        });
    }

    /* renamed from: execute$lambda-2$lambda-0 */
    public static final void m1849execute$lambda2$lambda0(d0 emitter, RxTask this$0, Object obj) {
        m.g(emitter, "$emitter");
        m.g(this$0, "this$0");
        emitter.onSuccess(obj);
        this$0.subject.onNext(obj);
        this$0.subject.onComplete();
    }

    /* renamed from: execute$lambda-2$lambda-1 */
    public static final void m1850execute$lambda2$lambda1(d0 emitter, RxTask this$0, Throwable th) {
        m.g(emitter, "$emitter");
        m.g(this$0, "this$0");
        emitter.onError(th);
        this$0.subject.onError(th);
    }

    public final b0<T> execute() {
        b0<T> create = b0.create(new f0() { // from class: com.coinbase.wallet.wallets.models.a
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                RxTask.a(RxTask.this, d0Var);
            }
        });
        m.f(create, "create { emitter ->\n        single.subscribe(\n            { result ->\n                emitter.onSuccess(result)\n                subject.onNext(result)\n                subject.onComplete()\n            },\n            { error ->\n                emitter.onError(error)\n                subject.onError(error)\n            }\n        )\n    }");
        return create;
    }

    public final b0<T> getOnCompletion() {
        return this.onCompletion;
    }
}
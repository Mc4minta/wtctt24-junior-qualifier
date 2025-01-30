package com.coinbase.wallet.appreview.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.appreview.extensions.StoreKeys_AppReviewKt;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import h.c.s;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AppReviewRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/appreview/repositories/AppReviewRepository;", "", "Lkotlin/x;", "requestAppReview", "()V", "", "count", "getAppReviewSuccessActionCount", "()I", "setAppReviewSuccessActionCount", "(I)V", "appReviewSuccessActionCount", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "appReviewSubject", "Lh/c/v0/b;", "Lh/c/s;", "appReviewObservable", "Lh/c/s;", "getAppReviewObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "appreview_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppReviewRepository {
    private final s<x> appReviewObservable;
    private final b<x> appReviewSubject;
    private final StoreInterface store;

    public AppReviewRepository(StoreInterface store) {
        m.g(store, "store");
        this.store = store;
        b<x> d2 = b.d();
        m.f(d2, "create<Unit>()");
        this.appReviewSubject = d2;
        s<x> hide = d2.hide();
        m.f(hide, "appReviewSubject.hide()");
        this.appReviewObservable = hide;
    }

    private final int getAppReviewSuccessActionCount() {
        Integer num = (Integer) this.store.get(StoreKeys_AppReviewKt.getAppReviewSuccessActionCount(StoreKeys.INSTANCE));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void setAppReviewSuccessActionCount(int i2) {
        this.store.set(StoreKeys_AppReviewKt.getAppReviewSuccessActionCount(StoreKeys.INSTANCE), Integer.valueOf(i2));
    }

    public final s<x> getAppReviewObservable() {
        return this.appReviewObservable;
    }

    public final void requestAppReview() {
        int appReviewSuccessActionCount = getAppReviewSuccessActionCount();
        if (appReviewSuccessActionCount == 2 || appReviewSuccessActionCount == 8 || appReviewSuccessActionCount == 19) {
            this.appReviewSubject.onNext(x.a);
        }
        setAppReviewSuccessActionCount(getAppReviewSuccessActionCount() + 1);
        if (getAppReviewSuccessActionCount() > 19) {
            setAppReviewSuccessActionCount(0);
        }
    }
}
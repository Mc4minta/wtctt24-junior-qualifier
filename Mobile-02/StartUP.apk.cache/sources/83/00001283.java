package com.coinbase.wallet.application.viewmodel;

import androidx.lifecycle.b0;
import h.c.s;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LoadingPillViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R$\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR=\u0010\f\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u000b0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/application/viewmodel/LoadingPillViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "showLoadingPill", "()V", "hideLoadingPill", "Lh/c/v0/b;", "", "kotlin.jvm.PlatformType", "loadingPillShownSubject", "Lh/c/v0/b;", "Lh/c/s;", "loadingPillShownObservable", "Lh/c/s;", "getLoadingPillShownObservable", "()Lh/c/s;", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LoadingPillViewModel extends b0 {
    private final s<Boolean> loadingPillShownObservable;
    private final b<Boolean> loadingPillShownSubject;

    public LoadingPillViewModel() {
        b<Boolean> d2 = b.d();
        m.f(d2, "create<Boolean>()");
        this.loadingPillShownSubject = d2;
        this.loadingPillShownObservable = d2.hide();
    }

    public final s<Boolean> getLoadingPillShownObservable() {
        return this.loadingPillShownObservable;
    }

    public final void hideLoadingPill() {
        this.loadingPillShownSubject.onNext(Boolean.FALSE);
    }

    public final void showLoadingPill() {
        this.loadingPillShownSubject.onNext(Boolean.TRUE);
    }
}
package com.coinbase.wallet.application.viewmodel;

import androidx.lifecycle.b0;
import h.c.s;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ScrolledToTopViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006R$\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "Landroidx/lifecycle/b0;", "", "isTop", "Lkotlin/x;", "scrolledToTop", "(Z)V", "touched", "isTouched", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "scrolledToTopSubject", "Lh/c/v0/b;", "Lh/c/s;", "scrolledToTopObservable", "Lh/c/s;", "getScrolledToTopObservable", "()Lh/c/s;", "isTouchedSubject", "isTouchedObservable", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ScrolledToTopViewModel extends b0 {
    private final s<Boolean> isTouchedObservable;
    private final b<Boolean> isTouchedSubject;
    private final s<Boolean> scrolledToTopObservable;
    private final b<Boolean> scrolledToTopSubject;

    public ScrolledToTopViewModel() {
        b<Boolean> d2 = b.d();
        m.f(d2, "create<Boolean>()");
        this.scrolledToTopSubject = d2;
        b<Boolean> d3 = b.d();
        m.f(d3, "create<Boolean>()");
        this.isTouchedSubject = d3;
        s<Boolean> hide = d2.hide();
        m.f(hide, "scrolledToTopSubject.hide()");
        this.scrolledToTopObservable = hide;
        s<Boolean> hide2 = d3.hide();
        m.f(hide2, "isTouchedSubject.hide()");
        this.isTouchedObservable = hide2;
    }

    public final s<Boolean> getScrolledToTopObservable() {
        return this.scrolledToTopObservable;
    }

    public final void isTouched(boolean z) {
        this.isTouchedSubject.onNext(Boolean.valueOf(z));
    }

    public final s<Boolean> isTouchedObservable() {
        return this.isTouchedObservable;
    }

    public final void scrolledToTop(boolean z) {
        this.scrolledToTopSubject.onNext(Boolean.valueOf(z));
    }
}
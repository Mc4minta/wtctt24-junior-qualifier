package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFeeSharedViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR=\u0010\f\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u0002 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u000b0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeSharedViewModel;", "Landroidx/lifecycle/b0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "selection", "Lkotlin/x;", "sendResult", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;)V", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "adjustableMinerFeesResultSubject", "Lh/c/v0/b;", "Lh/c/s;", "adjustableMinerFeeResultObservable", "Lh/c/s;", "getAdjustableMinerFeeResultObservable", "()Lh/c/s;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeSharedViewModel extends androidx.lifecycle.b0 {
    private final h.c.s<AdjustableMinerFeeSelection> adjustableMinerFeeResultObservable;
    private final h.c.v0.b<AdjustableMinerFeeSelection> adjustableMinerFeesResultSubject;

    public AdjustableMinerFeeSharedViewModel() {
        h.c.v0.b<AdjustableMinerFeeSelection> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<AdjustableMinerFeeSelection>()");
        this.adjustableMinerFeesResultSubject = d2;
        this.adjustableMinerFeeResultObservable = d2.hide();
    }

    public final h.c.s<AdjustableMinerFeeSelection> getAdjustableMinerFeeResultObservable() {
        return this.adjustableMinerFeeResultObservable;
    }

    public final void sendResult(AdjustableMinerFeeSelection selection) {
        kotlin.jvm.internal.m.g(selection, "selection");
        this.adjustableMinerFeesResultSubject.onNext(selection);
    }
}
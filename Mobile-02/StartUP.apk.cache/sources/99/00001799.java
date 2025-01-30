package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.appreview.repositories.AppReviewRepository;
import kotlin.Metadata;

/* compiled from: ConsumerTransferInitiatedViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferInitiatedViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "requestAppReview", "()V", "Lcom/coinbase/wallet/appreview/repositories/AppReviewRepository;", "appReviewRepository", "Lcom/coinbase/wallet/appreview/repositories/AppReviewRepository;", "<init>", "(Lcom/coinbase/wallet/appreview/repositories/AppReviewRepository;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferInitiatedViewModel extends androidx.lifecycle.b0 {
    private final AppReviewRepository appReviewRepository;

    public ConsumerTransferInitiatedViewModel(AppReviewRepository appReviewRepository) {
        kotlin.jvm.internal.m.g(appReviewRepository, "appReviewRepository");
        this.appReviewRepository = appReviewRepository;
    }

    public final void requestAppReview() {
        this.appReviewRepository.requestAppReview();
    }
}
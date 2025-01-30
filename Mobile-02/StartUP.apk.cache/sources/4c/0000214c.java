package com.coinbase.wallet.features.signer.viewmodel;

import android.os.Bundle;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.send.viewmodels.CompleteViewModel;
import com.coinbase.wallet.features.send.views.CompleteFragment;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkCompleteViewModel;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParentRequestEthereumAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ParentRequestEthereumAccountsViewModel$approve$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<x, x> {
    final /* synthetic */ ParentRequestEthereumAccountsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentRequestEthereumAccountsViewModel$approve$2(ParentRequestEthereumAccountsViewModel parentRequestEthereumAccountsViewModel) {
        super(1);
        this.this$0 = parentRequestEthereumAccountsViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        h.c.v0.b bVar;
        h.c.v0.b signatureRequestEventSubject;
        String dappName = this.this$0.getViewState().getHostRequestId().getDappName();
        if (dappName == null) {
            dappName = LocalizedStrings.INSTANCE.get(R.string.walletlink_dapp_name);
        }
        CompleteFragment completeFragment = new CompleteFragment();
        Bundle createArgs = WalletLinkCompleteArgs.INSTANCE.createArgs(dappName);
        createArgs.putSerializable(CompleteViewModel.class.getName(), WalletLinkCompleteViewModel.class);
        x xVar2 = x.a;
        completeFragment.setArguments(createArgs);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.webExtensionApproved(AnalyticsEvent.Companion));
        bVar = this.this$0.navigationSubject;
        bVar.onNext(kotlin.u.a(completeFragment, CompleteFragment.Companion.getTAG()));
        signatureRequestEventSubject = this.this$0.getSignatureRequestEventSubject();
        signatureRequestEventSubject.onNext(new SigningSessionEvent.RequestEthereumAccountsApproved(this.this$0.getViewState().getUuid()));
    }
}
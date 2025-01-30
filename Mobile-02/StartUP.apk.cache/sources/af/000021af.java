package com.coinbase.wallet.features.signer.views;

import android.view.View;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.EventFeature_ApplicationKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SignatureRequest;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SignerViewFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewFragment$subscribeToSessionEvents$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SigningSessionEvent, x> {
    final /* synthetic */ RequestSigningDialog<SignatureRequestViewState, StackedRequestItem<SignatureRequestViewState>> $view;
    final /* synthetic */ SignerViewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignerViewFragment$subscribeToSessionEvents$1(SignerViewFragment signerViewFragment, RequestSigningDialog<SignatureRequestViewState, StackedRequestItem<SignatureRequestViewState>> requestSigningDialog) {
        super(1);
        this.this$0 = signerViewFragment;
        this.$view = requestSigningDialog;
    }

    private static final void invoke$handleSignerCompletion(RequestSigningDialog<SignatureRequestViewState, StackedRequestItem<SignatureRequestViewState>> requestSigningDialog, SignerViewFragment signerViewFragment, SigningSessionEvent event, CurrencyCode currencyCode) {
        SignerViewModel signerViewModel;
        Set set;
        if (currencyCode != null) {
            set = signerViewFragment.approvedCurrencyCodes;
            set.add(currencyCode);
        }
        View view = requestSigningDialog.getView();
        if (view != null) {
            signerViewFragment.hideActivityOverlay(view);
        }
        signerViewModel = signerViewFragment.viewModel;
        if (signerViewModel != null) {
            kotlin.jvm.internal.m.f(event, "event");
            signerViewModel.publishEvent(event);
            signerViewFragment.dismissCurrentPageView();
            signerViewFragment.presentNextRequest();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SigningSessionEvent signingSessionEvent) {
        invoke2(signingSessionEvent);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SigningSessionEvent event) {
        SignerViewModel signerViewModel;
        EventFeature walletLink;
        SignerViewModel signerViewModel2;
        SignerViewModel signerViewModel3;
        signerViewModel = this.this$0.viewModel;
        if (signerViewModel != null) {
            SignatureRequest currentRequest = signerViewModel.getCurrentRequest();
            if ((currentRequest == null ? null : currentRequest.getHostRequestId()) == null) {
                walletLink = EventFeature_ApplicationKt.getDApps(EventFeature.Companion);
            } else {
                walletLink = EventFeature_ApplicationKt.getWalletLink(EventFeature.Companion);
            }
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            kotlin.jvm.internal.m.f(event, "event");
            analytics.log(AnalyticsEvent_ApplicationKt.signerEvent(companion, event, walletLink));
            if (event instanceof SigningSessionEvent.SignedAndSubmittedTx) {
                invoke$handleSignerCompletion(this.$view, this.this$0, event, ((SigningSessionEvent.SignedAndSubmittedTx) event).getTx().getCurrencyCode());
                return;
            } else if (event instanceof SigningSessionEvent.SignedTx) {
                invoke$handleSignerCompletion(this.$view, this.this$0, event, ((SigningSessionEvent.SignedTx) event).getTx().getCurrencyCode());
                return;
            } else {
                if (event instanceof SigningSessionEvent.SwitchEthereumChainApproved ? true : event instanceof SigningSessionEvent.Cancelled ? true : event instanceof SigningSessionEvent.SignedMessage ? true : event instanceof SigningSessionEvent.RequestEthereumAccountsApproved) {
                    invoke$handleSignerCompletion(this.$view, this.this$0, event, null);
                    return;
                } else if (event instanceof SigningSessionEvent.Signing) {
                    View view = this.$view.getView();
                    if (view != null) {
                        this.this$0.showActivityOverlay(view);
                    }
                    signerViewModel3 = this.this$0.viewModel;
                    if (signerViewModel3 != null) {
                        signerViewModel3.publishEvent(event);
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                } else if (event instanceof SigningSessionEvent.Failure) {
                    View view2 = this.$view.getView();
                    if (view2 != null) {
                        this.this$0.hideActivityOverlay(view2);
                    }
                    signerViewModel2 = this.this$0.viewModel;
                    if (signerViewModel2 != null) {
                        signerViewModel2.publishEvent(event);
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                } else {
                    return;
                }
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}
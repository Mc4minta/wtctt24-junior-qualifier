package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "kotlin.jvm.PlatformType", "signedTx", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$signAndSubmit$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SignedTx, x> {
    final /* synthetic */ String $mnemonic;
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$signAndSubmit$3(TxSignerViewModel txSignerViewModel, String str) {
        super(1);
        this.this$0 = txSignerViewModel;
        this.$mnemonic = str;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SignedTx signedTx) {
        invoke2(signedTx);
        return x.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if ((r2 == null ? false : kotlin.jvm.internal.m.c(r2.isParent(), java.lang.Boolean.TRUE)) != false) goto L20;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(com.coinbase.wallet.blockchains.interfaces.SignedTx r7) {
        /*
            r6 = this;
            com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel r0 = r6.this$0
            com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState$SignAndSubmitTxViewState r0 = r0.getViewState()
            com.coinbase.walletlink.models.HostRequestId r0 = r0.getHostRequestId()
            if (r0 != 0) goto Ld
            goto L63
        Ld:
            com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel r1 = r6.this$0
            com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository r1 = com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel.access$getWalletLinkRepository$p(r1)
            java.util.List r1 = r1.getSessions()
            java.util.Iterator r1 = r1.iterator()
        L1b:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L38
            java.lang.Object r2 = r1.next()
            r4 = r2
            com.coinbase.walletlink.models.Session r4 = (com.coinbase.walletlink.models.Session) r4
            java.lang.String r4 = r4.getId()
            java.lang.String r5 = r0.getSessionId()
            boolean r4 = kotlin.jvm.internal.m.c(r4, r5)
            if (r4 == 0) goto L1b
            goto L39
        L38:
            r2 = r3
        L39:
            com.coinbase.walletlink.models.Session r2 = (com.coinbase.walletlink.models.Session) r2
            if (r2 != 0) goto L3e
            goto L42
        L3e:
            java.lang.String r3 = r2.getParentSessionId()
        L42:
            r0 = 0
            if (r3 != 0) goto L55
            if (r2 != 0) goto L49
            r1 = r0
            goto L53
        L49:
            java.lang.Boolean r1 = r2.isParent()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.m.c(r1, r2)
        L53:
            if (r1 == 0) goto L56
        L55:
            r0 = 1
        L56:
            if (r0 == 0) goto L63
            com.coinbase.wallet.analytics.Analytics r0 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r1 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r1 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.txSubmittedViaExtension(r1)
            r0.log(r1)
        L63:
            com.coinbase.wallet.analytics.Analytics r0 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r1 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r1 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.confirmTransactionTxSubmitted(r1)
            r0.log(r1)
            com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel r0 = r6.this$0
            h.c.v0.b r0 = com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel.access$getSignatureRequestEventSubject(r0)
            com.coinbase.wallet.features.signer.models.SigningSessionEvent$SignedAndSubmittedTx r1 = new com.coinbase.wallet.features.signer.models.SigningSessionEvent$SignedAndSubmittedTx
            com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel r2 = r6.this$0
            com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState$SignAndSubmitTxViewState r2 = r2.getViewState()
            java.lang.String r2 = r2.getUuid()
            java.lang.String r3 = "signedTx"
            kotlin.jvm.internal.m.f(r7, r3)
            java.lang.String r3 = r6.$mnemonic
            r1.<init>(r2, r7, r3)
            r0.onNext(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel$signAndSubmit$3.invoke2(com.coinbase.wallet.blockchains.interfaces.SignedTx):void");
    }
}
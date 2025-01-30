package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.signer.views.RequestSigningDialog;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SignerViewFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "kotlin.jvm.PlatformType", "viewStateOptional", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewFragment$presentNextRequest$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends SignatureRequestViewState>, x> {
    final /* synthetic */ SignerViewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignerViewFragment$presentNextRequest$2(SignerViewFragment signerViewFragment) {
        super(1);
        this.this$0 = signerViewFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Optional<? extends SignatureRequestViewState> optional) {
        invoke2(optional);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Optional<? extends SignatureRequestViewState> optional) {
        SignatureRequestViewState nullable = optional.toNullable();
        if (nullable == null) {
            this.this$0.completeSigningFlow();
        } else if (nullable instanceof SignatureRequestViewState.RequestEthereumAccountsViewState) {
            if (((SignatureRequestViewState.RequestEthereumAccountsViewState) nullable).isParent()) {
                this.this$0.swapCurrentPageView((ParentRequestEthereumAccountsFragment) RequestSigningDialog.Companion.getInstance(nullable, ParentRequestEthereumAccountsFragment.class, true));
                return;
            }
            this.this$0.swapCurrentPageView((RequestEthereumAccountsFragment) RequestSigningDialog.Companion.getInstance$default(RequestSigningDialog.Companion, nullable, RequestEthereumAccountsFragment.class, false, 4, null));
        } else if (nullable instanceof SignatureRequestViewState.SwitchEthereumChainViewState) {
            this.this$0.swapCurrentPageView((SwitchEthereumChainFragment) RequestSigningDialog.Companion.getInstance$default(RequestSigningDialog.Companion, nullable, SwitchEthereumChainFragment.class, false, 4, null));
        } else if (nullable instanceof SignatureRequestViewState.SignMessageViewState) {
            this.this$0.swapCurrentPageView((MessageSignerFragment) RequestSigningDialog.Companion.getInstance$default(RequestSigningDialog.Companion, nullable, MessageSignerFragment.class, false, 4, null));
        } else if (nullable instanceof SignatureRequestViewState.SignAndSubmitTxViewState) {
            this.this$0.swapCurrentPageView((TxSignerFragment) RequestSigningDialog.Companion.getInstance$default(RequestSigningDialog.Companion, nullable, TxSignerFragment.class, false, 4, null));
        }
    }
}
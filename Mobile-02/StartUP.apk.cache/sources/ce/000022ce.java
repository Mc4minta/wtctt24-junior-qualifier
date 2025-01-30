package com.coinbase.wallet.features.swap.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import com.coinbase.wallet.features.commonui.views.TokenAvatarView;
import com.coinbase.wallet.features.swap.models.SwapConfirmationViewState;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import com.coinbase.wallet.swap.models.AmountBase;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapConfirmationViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationFragment$setupObservables$1 extends o implements l<SwapConfirmationViewState, x> {
    final /* synthetic */ SwapConfirmationFragment this$0;

    /* compiled from: SwapConfirmationFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SwapCurrencyType.values().length];
            iArr[SwapCurrencyType.FIAT.ordinal()] = 1;
            iArr[SwapCurrencyType.CRYPTO.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationFragment$setupObservables$1(SwapConfirmationFragment swapConfirmationFragment) {
        super(1);
        this.this$0 = swapConfirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SwapConfirmationViewState swapConfirmationViewState) {
        invoke2(swapConfirmationViewState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapConfirmationViewState state) {
        AmountBase amountBase = state.getAmountBase();
        if (amountBase instanceof AmountBase.Source) {
            View view = this.this$0.getView();
            View sourceAmountShimmerPlaceholder = view == null ? null : view.findViewById(e.j.a.sourceAmountShimmerPlaceholder);
            m.f(sourceAmountShimmerPlaceholder, "sourceAmountShimmerPlaceholder");
            sourceAmountShimmerPlaceholder.setVisibility(8);
            View view2 = this.this$0.getView();
            View targetAmountShimmerPlaceholder = view2 == null ? null : view2.findViewById(e.j.a.targetAmountShimmerPlaceholder);
            m.f(targetAmountShimmerPlaceholder, "targetAmountShimmerPlaceholder");
            targetAmountShimmerPlaceholder.setVisibility(state.isLoading() ? 0 : 8);
        } else if (amountBase instanceof AmountBase.Target) {
            View view3 = this.this$0.getView();
            View sourceAmountShimmerPlaceholder2 = view3 == null ? null : view3.findViewById(e.j.a.sourceAmountShimmerPlaceholder);
            m.f(sourceAmountShimmerPlaceholder2, "sourceAmountShimmerPlaceholder");
            sourceAmountShimmerPlaceholder2.setVisibility(state.isLoading() ? 0 : 8);
            View view4 = this.this$0.getView();
            View targetAmountShimmerPlaceholder2 = view4 == null ? null : view4.findViewById(e.j.a.targetAmountShimmerPlaceholder);
            m.f(targetAmountShimmerPlaceholder2, "targetAmountShimmerPlaceholder");
            targetAmountShimmerPlaceholder2.setVisibility(8);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[state.getCurrencyType().ordinal()];
        if (i2 == 1) {
            View view5 = this.this$0.getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.sourceAmountBig))).setText(state.getSourceFiatAmount());
            View view6 = this.this$0.getView();
            ((TextView) (view6 == null ? null : view6.findViewById(e.j.a.sourceAmountSmall))).setText(state.getSourceCryptoAmount());
        } else if (i2 == 2) {
            View view7 = this.this$0.getView();
            ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.sourceAmountBig))).setText(state.getSourceCryptoAmount());
            View view8 = this.this$0.getView();
            ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.sourceAmountSmall))).setText(state.getSourceFiatAmount());
        }
        View view9 = this.this$0.getView();
        ((TokenAvatarView) (view9 == null ? null : view9.findViewById(e.j.a.targetAssetAvatar))).load(state.getTargetCurrencyCode(), state.getTargetImageURL());
        View view10 = this.this$0.getView();
        ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.targetCryptoAmount))).setText(state.getTargetCryptoAmount());
        View view11 = this.this$0.getView();
        ((TextView) (view11 == null ? null : view11.findViewById(e.j.a.k4))).setText(state.getCardTitle());
        View view12 = this.this$0.getView();
        ((TextView) (view12 == null ? null : view12.findViewById(e.j.a.minerFeeCrypto))).setText(state.getMinerFeeCryptoAmount());
        View view13 = this.this$0.getView();
        ((TextView) (view13 == null ? null : view13.findViewById(e.j.a.minerFeeFiat))).setText(state.getMinerFeeFiatAmount());
        View view14 = this.this$0.getView();
        ((TextView) (view14 == null ? null : view14.findViewById(e.j.a.coinbaseFeeCrypto))).setText(state.getCoinbaseFeeCryptoAmount());
        View view15 = this.this$0.getView();
        ((TextView) (view15 == null ? null : view15.findViewById(e.j.a.coinbaseFeeFiat))).setText(state.getCoinbaseFeeFiatAmount());
        View view16 = this.this$0.getView();
        View convertButton = view16 == null ? null : view16.findViewById(e.j.a.convertButton);
        m.f(convertButton, "convertButton");
        convertButton.setVisibility(true ^ state.isConvertButtonVisible() ? 4 : 0);
        View view17 = this.this$0.getView();
        ((ProgressBarButton) (view17 == null ? null : view17.findViewById(e.j.a.convertButton))).setClickable(state.isConvertButtonVisible());
        View view18 = this.this$0.getView();
        ((ProgressBarButton) (view18 == null ? null : view18.findViewById(e.j.a.convertButton))).setProgressBarIsVisible(state.isConverting());
        View view19 = this.this$0.getView();
        View chevronImageView = view19 == null ? null : view19.findViewById(e.j.a.p0);
        m.f(chevronImageView, "chevronImageView");
        chevronImageView.setVisibility(state.isLoading() ? 4 : 0);
        View view20 = this.this$0.getView();
        View activityIndicator = view20 != null ? view20.findViewById(e.j.a.f13509h) : null;
        m.f(activityIndicator, "activityIndicator");
        activityIndicator.setVisibility(state.isLoading() ? 0 : 8);
        SwapConfirmationFragment swapConfirmationFragment = this.this$0;
        m.f(state, "state");
        swapConfirmationFragment.handleErrorState(state);
    }
}
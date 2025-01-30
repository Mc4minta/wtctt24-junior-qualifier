package com.coinbase.wallet.features.signer.views;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.d0;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel;
import h.c.b0;
import h.c.s;
import java.net.URL;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* compiled from: TxSignerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u00042\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0011J-\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006R(\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020%8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030$8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b2\u0010'\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00038\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/TxSignerFragment;", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignAndSubmitTxViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/TxSignerViewModel;", "Lkotlin/x;", "onPay", "()V", "onCancel", "onDetails", "onMinerFeeButton", "", "willExpand", "showDetails", "(Z)V", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "result", "handleConfirmationResult", "(Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;)V", "Lcom/coinbase/wallet/core/util/Optional;", "", ApiConstants.MESSAGE, "handleError", "(Lcom/coinbase/wallet/core/util/Optional;Ljava/lang/String;)V", "handleSufficientBalance", "updateAmounts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "setUpViewModel", "setup", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeSharedViewModel;", "adjustableMinerFeesFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getAdjustableMinerFeesFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setAdjustableMinerFeesFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "resultViewModel", "Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeSharedViewModel;", "getResultViewModel$app_productionRelease", "()Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeSharedViewModel;", "setResultViewModel$app_productionRelease", "(Lcom/coinbase/wallet/features/send/viewmodels/AdjustableMinerFeeSharedViewModel;)V", "viewModelFactory", "getViewModelFactory$app_productionRelease", "setViewModelFactory$app_productionRelease", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "detailsExpanded", "Z", "viewModel", "Lcom/coinbase/wallet/features/signer/viewmodel/TxSignerViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/signer/viewmodel/TxSignerViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/signer/viewmodel/TxSignerViewModel;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerFragment extends RequestSigningDialog<SignatureRequestViewState.SignAndSubmitTxViewState, TxSignerViewModel> {
    public GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> adjustableMinerFeesFactory;
    private boolean detailsExpanded;
    private final h.c.k0.a disposeBag = new h.c.k0.a();
    public AdjustableMinerFeeSharedViewModel resultViewModel;
    protected TxSignerViewModel viewModel;
    public GenericViewModelFactory<TxSignerViewModel> viewModelFactory;

    public static /* synthetic */ void h(TxSignerFragment txSignerFragment, View view) {
        m1463setup$lambda6(txSignerFragment, view);
    }

    public final void handleConfirmationResult(SendConfirmationResult sendConfirmationResult) {
        View totalContainer;
        View view = getView();
        View adjustableMinerFeeButton = view == null ? null : view.findViewById(e.j.a.adjustableMinerFeeButton);
        kotlin.jvm.internal.m.f(adjustableMinerFeeButton, "adjustableMinerFeeButton");
        adjustableMinerFeeButton.setVisibility(getViewModel().isAdjustableMinerFeeEnabled() ? 0 : 8);
        SendConfirmationState state = sendConfirmationResult.getState();
        if (state instanceof SendConfirmationState.SufficientBalance) {
            handleSufficientBalance(sendConfirmationResult);
            return;
        }
        if (state instanceof SendConfirmationState.InsufficientFee ? true : state instanceof SendConfirmationState.InsufficientBalance) {
            View view2 = getView();
            View feeContainer = view2 == null ? null : view2.findViewById(e.j.a.feeContainer);
            kotlin.jvm.internal.m.f(feeContainer, "feeContainer");
            feeContainer.setVisibility(0);
            View view3 = getView();
            View hairline = view3 == null ? null : view3.findViewById(e.j.a.hairline);
            kotlin.jvm.internal.m.f(hairline, "hairline");
            hairline.setVisibility(0);
            View view4 = getView();
            View detailsButton = view4 == null ? null : view4.findViewById(e.j.a.F1);
            kotlin.jvm.internal.m.f(detailsButton, "detailsButton");
            detailsButton.setVisibility(0);
            View view5 = getView();
            totalContainer = view5 != null ? view5.findViewById(e.j.a.totalContainer) : null;
            kotlin.jvm.internal.m.f(totalContainer, "totalContainer");
            totalContainer.setVisibility(8);
            handleError(new Optional<>(sendConfirmationResult), sendConfirmationResult.getState().getMessage());
            return;
        }
        if (state instanceof SendConfirmationState.FeeCalculationFailed ? true : state instanceof SendConfirmationState.Error) {
            View view6 = getView();
            View feeContainer2 = view6 == null ? null : view6.findViewById(e.j.a.feeContainer);
            kotlin.jvm.internal.m.f(feeContainer2, "feeContainer");
            feeContainer2.setVisibility(8);
            View view7 = getView();
            View hairline2 = view7 == null ? null : view7.findViewById(e.j.a.hairline);
            kotlin.jvm.internal.m.f(hairline2, "hairline");
            hairline2.setVisibility(8);
            View view8 = getView();
            View detailsTitle = view8 == null ? null : view8.findViewById(e.j.a.K1);
            kotlin.jvm.internal.m.f(detailsTitle, "detailsTitle");
            detailsTitle.setVisibility(8);
            View view9 = getView();
            View detailsButton2 = view9 == null ? null : view9.findViewById(e.j.a.F1);
            kotlin.jvm.internal.m.f(detailsButton2, "detailsButton");
            detailsButton2.setVisibility(8);
            View view10 = getView();
            totalContainer = view10 != null ? view10.findViewById(e.j.a.totalContainer) : null;
            kotlin.jvm.internal.m.f(totalContainer, "totalContainer");
            totalContainer.setVisibility(8);
            handleError(new Optional<>(sendConfirmationResult), sendConfirmationResult.getState().getMessage());
        }
    }

    private final void handleError(Optional<SendConfirmationResult> optional, String str) {
        SendConfirmationResult nullable = optional.toNullable();
        if (nullable != null) {
            updateAmounts(nullable);
        }
        View view = getView();
        View feeCalculationProgressBar = view == null ? null : view.findViewById(e.j.a.feeCalculationProgressBar);
        kotlin.jvm.internal.m.f(feeCalculationProgressBar, "feeCalculationProgressBar");
        feeCalculationProgressBar.setVisibility(8);
        View view2 = getView();
        View error = view2 == null ? null : view2.findViewById(e.j.a.error);
        kotlin.jvm.internal.m.f(error, "error");
        error.setVisibility(0);
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.error))).setText(str);
        View view4 = getView();
        ((ImageButton) (view4 == null ? null : view4.findViewById(e.j.a.F1))).setEnabled(false);
        View view5 = getView();
        ((ImageButton) (view5 == null ? null : view5.findViewById(e.j.a.minerFeeButton))).setBackgroundTintList(androidx.core.content.a.e(requireContext(), R.color.primary_red));
        View view6 = getView();
        ((TextView) (view6 == null ? null : view6.findViewById(e.j.a.minerFeeTitle))).setTextColor(androidx.core.content.a.e(requireContext(), R.color.primary_red));
        View view7 = getView();
        ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.feeFiat))).setTextColor(androidx.core.content.a.e(requireContext(), R.color.primary_red));
        View view8 = getView();
        ((Button) (view8 != null ? view8.findViewById(e.j.a.payButton) : null)).setEnabled(false);
        showDetails(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleError$default(TxSignerFragment txSignerFragment, Optional optional, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            optional = new Optional(null);
        }
        txSignerFragment.handleError(optional, str);
    }

    private final void handleSufficientBalance(SendConfirmationResult sendConfirmationResult) {
        updateAmounts(sendConfirmationResult);
        View view = getView();
        View feeCalculationProgressBar = view == null ? null : view.findViewById(e.j.a.feeCalculationProgressBar);
        kotlin.jvm.internal.m.f(feeCalculationProgressBar, "feeCalculationProgressBar");
        feeCalculationProgressBar.setVisibility(8);
        View view2 = getView();
        View detailsButton = view2 == null ? null : view2.findViewById(e.j.a.F1);
        kotlin.jvm.internal.m.f(detailsButton, "detailsButton");
        detailsButton.setVisibility(0);
        View view3 = getView();
        View feeContainer = view3 == null ? null : view3.findViewById(e.j.a.feeContainer);
        kotlin.jvm.internal.m.f(feeContainer, "feeContainer");
        feeContainer.setVisibility(0);
        View view4 = getView();
        View totalContainer = view4 == null ? null : view4.findViewById(e.j.a.totalContainer);
        kotlin.jvm.internal.m.f(totalContainer, "totalContainer");
        totalContainer.setVisibility(getViewModel().isAmountZero() ^ true ? 0 : 8);
        View view5 = getView();
        View error = view5 == null ? null : view5.findViewById(e.j.a.error);
        kotlin.jvm.internal.m.f(error, "error");
        error.setVisibility(8);
        View view6 = getView();
        ((ImageButton) (view6 == null ? null : view6.findViewById(e.j.a.F1))).setEnabled(true);
        View view7 = getView();
        ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.minerFeeTitle))).setTextColor(androidx.core.content.a.e(requireContext(), R.color.grey_30));
        View view8 = getView();
        ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.feeFiat))).setTextColor(androidx.core.content.a.e(requireContext(), R.color.primary_black));
        View view9 = getView();
        ((Button) (view9 != null ? view9.findViewById(e.j.a.payButton) : null)).setEnabled(true);
        showDetails(true);
    }

    public static /* synthetic */ void i(TxSignerFragment txSignerFragment, View view) {
        m1462setup$lambda5(txSignerFragment, view);
    }

    public static /* synthetic */ void j(TxSignerFragment txSignerFragment, View view) {
        m1461setup$lambda4(txSignerFragment, view);
    }

    public static /* synthetic */ void k(TxSignerFragment txSignerFragment, View view) {
        m1460setup$lambda3(txSignerFragment, view);
    }

    private final void onCancel() {
        getViewModel().reject();
    }

    private final void onDetails() {
        View view = getView();
        View detailsContainer = view == null ? null : view.findViewById(e.j.a.detailsContainer);
        kotlin.jvm.internal.m.f(detailsContainer, "detailsContainer");
        showDetails(!(detailsContainer.getVisibility() == 0));
    }

    private final void onMinerFeeButton() {
        getViewModel().presentMinerFee();
    }

    private final void onPay() {
        getViewModel().approve();
    }

    /* renamed from: setup$lambda-3 */
    public static final void m1460setup$lambda3(TxSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.onPay();
    }

    /* renamed from: setup$lambda-4 */
    public static final void m1461setup$lambda4(TxSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.onCancel();
    }

    /* renamed from: setup$lambda-5 */
    public static final void m1462setup$lambda5(TxSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.onDetails();
    }

    /* renamed from: setup$lambda-6 */
    public static final void m1463setup$lambda6(TxSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.onMinerFeeButton();
    }

    private final void showDetails(boolean z) {
        b0 collapse$default;
        if (z == this.detailsExpanded) {
            return;
        }
        this.detailsExpanded = z;
        View view = getView();
        ((ImageButton) (view == null ? null : view.findViewById(e.j.a.F1))).setEnabled(false);
        View view2 = getView();
        if (z) {
            View detailsContainer = view2 == null ? null : view2.findViewById(e.j.a.detailsContainer);
            kotlin.jvm.internal.m.f(detailsContainer, "detailsContainer");
            collapse$default = View_CommonKt.expand$default(detailsContainer, getShown(), null, 0, 0L, 14, null);
        } else {
            View detailsContainer2 = view2 == null ? null : view2.findViewById(e.j.a.detailsContainer);
            kotlin.jvm.internal.m.f(detailsContainer2, "detailsContainer");
            collapse$default = View_CommonKt.collapse$default(detailsContainer2, getShown(), 0L, 2, null);
        }
        h.c.t0.a.a(h.c.t0.g.i(collapse$default, null, new TxSignerFragment$showDetails$1(this), 1, null), this.disposeBag);
        View view3 = getView();
        ((ImageButton) (view3 != null ? view3.findViewById(e.j.a.F1) : null)).animate().rotation(z ? 180.0f : 0.0f).setDuration(100L).start();
    }

    private final void updateAmounts(SendConfirmationResult sendConfirmationResult) {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.amountFiat))).setText(sendConfirmationResult.getFiatAmount());
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.amountCrypto))).setText(sendConfirmationResult.getCryptoAmount());
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.feeFiat))).setText(sendConfirmationResult.getFiatFee());
        View view4 = getView();
        ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.feeCrypto))).setText(sendConfirmationResult.getCryptoFee());
        View view5 = getView();
        ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.totalFiat))).setText(sendConfirmationResult.getFiatTotal());
        View view6 = getView();
        ((TextView) (view6 != null ? view6.findViewById(e.j.a.totalCrypto) : null)).setText(sendConfirmationResult.getCryptoTotal());
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> getAdjustableMinerFeesFactory() {
        GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory = this.adjustableMinerFeesFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("adjustableMinerFeesFactory");
        throw null;
    }

    public final AdjustableMinerFeeSharedViewModel getResultViewModel$app_productionRelease() {
        AdjustableMinerFeeSharedViewModel adjustableMinerFeeSharedViewModel = this.resultViewModel;
        if (adjustableMinerFeeSharedViewModel != null) {
            return adjustableMinerFeeSharedViewModel;
        }
        kotlin.jvm.internal.m.w("resultViewModel");
        throw null;
    }

    public final GenericViewModelFactory<TxSignerViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<TxSignerViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.view_tx_signer, viewGroup, false);
    }

    public final void setAdjustableMinerFeesFactory(GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.adjustableMinerFeesFactory = genericViewModelFactory;
    }

    public final void setResultViewModel$app_productionRelease(AdjustableMinerFeeSharedViewModel adjustableMinerFeeSharedViewModel) {
        kotlin.jvm.internal.m.g(adjustableMinerFeeSharedViewModel, "<set-?>");
        this.resultViewModel = adjustableMinerFeeSharedViewModel;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setUpViewModel() {
        androidx.lifecycle.b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(TxSignerViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        setViewModel((TxSignerViewModel) a);
        androidx.lifecycle.b0 a2 = new d0(requireActivity(), getAdjustableMinerFeesFactory()).a(AdjustableMinerFeeSharedViewModel.class);
        kotlin.jvm.internal.m.f(a2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        setResultViewModel$app_productionRelease((AdjustableMinerFeeSharedViewModel) a2);
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<TxSignerViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setup() {
        String string;
        x xVar;
        View view = getView();
        Button button = (Button) (view == null ? null : view.findViewById(e.j.a.payButton));
        if (getViewModel().isAmountZero()) {
            string = getString(R.string.confirm);
        } else {
            string = getString(R.string.send_confirmation_pay_button);
        }
        button.setText(string);
        View view2 = getView();
        ((ProgressBar) (view2 == null ? null : view2.findViewById(e.j.a.feeCalculationProgressBar))).setVisibility(0);
        View view3 = getView();
        ((Button) (view3 == null ? null : view3.findViewById(e.j.a.payButton))).setEnabled(false);
        View view4 = getView();
        ((ImageButton) (view4 == null ? null : view4.findViewById(e.j.a.F1))).setEnabled(false);
        View view5 = getView();
        View detailsButton = view5 == null ? null : view5.findViewById(e.j.a.F1);
        kotlin.jvm.internal.m.f(detailsButton, "detailsButton");
        detailsButton.setVisibility(8);
        View view6 = getView();
        View error = view6 == null ? null : view6.findViewById(e.j.a.error);
        kotlin.jvm.internal.m.f(error, "error");
        error.setVisibility(8);
        View view7 = getView();
        View feeContainer = view7 == null ? null : view7.findViewById(e.j.a.feeContainer);
        kotlin.jvm.internal.m.f(feeContainer, "feeContainer");
        feeContainer.setVisibility(8);
        View view8 = getView();
        View totalContainer = view8 == null ? null : view8.findViewById(e.j.a.totalContainer);
        kotlin.jvm.internal.m.f(totalContainer, "totalContainer");
        totalContainer.setVisibility(8);
        View view9 = getView();
        TextView textView = (TextView) (view9 == null ? null : view9.findViewById(e.j.a.hostLabel));
        Uri requesterURL = getViewModel().getViewState().getRequesterURL();
        String uri = requesterURL == null ? null : requesterURL.toString();
        if (uri == null) {
            uri = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        textView.setText(uri);
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(getViewModel().getViewState().getWallet().getNetwork());
        if (asEthereumChain != null) {
            View view10 = getView();
            ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.chainValue))).setText(asEthereumChain.getDisplayName());
        }
        View view11 = getView();
        View amountContainer = view11 == null ? null : view11.findViewById(e.j.a.amountContainer);
        kotlin.jvm.internal.m.f(amountContainer, "amountContainer");
        amountContainer.setVisibility(getViewModel().isAmountZero() ^ true ? 0 : 8);
        View view12 = getView();
        View noAmountLabel = view12 == null ? null : view12.findViewById(e.j.a.noAmountLabel);
        kotlin.jvm.internal.m.f(noAmountLabel, "noAmountLabel");
        noAmountLabel.setVisibility(getViewModel().isAmountZero() ? 0 : 8);
        URL imageUrl = getViewModel().getImageUrl();
        if (imageUrl == null) {
            xVar = null;
        } else {
            View view13 = getView();
            View dappIcon = view13 == null ? null : view13.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon, "dappIcon");
            loadImageInto$app_productionRelease(imageUrl, (ImageView) dappIcon);
            xVar = x.a;
        }
        if (xVar == null) {
            View view14 = getView();
            View dappIcon2 = view14 == null ? null : view14.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon2, "dappIcon");
            dappIcon2.setVisibility(8);
        }
        View view15 = getView();
        ((Button) (view15 == null ? null : view15.findViewById(e.j.a.payButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view16) {
                TxSignerFragment.k(TxSignerFragment.this, view16);
            }
        });
        View view16 = getView();
        ((Button) (view16 == null ? null : view16.findViewById(e.j.a.cancelButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view17) {
                TxSignerFragment.j(TxSignerFragment.this, view17);
            }
        });
        View view17 = getView();
        ((ImageButton) (view17 == null ? null : view17.findViewById(e.j.a.F1))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view18) {
                TxSignerFragment.i(TxSignerFragment.this, view18);
            }
        });
        View view18 = getView();
        ((ImageButton) (view18 == null ? null : view18.findViewById(e.j.a.minerFeeButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view19) {
                TxSignerFragment.h(TxSignerFragment.this, view19);
            }
        });
        View view19 = getView();
        View adjustableMinerFeeButton = view19 == null ? null : view19.findViewById(e.j.a.adjustableMinerFeeButton);
        kotlin.jvm.internal.m.f(adjustableMinerFeeButton, "adjustableMinerFeeButton");
        View_CommonKt.setOnSingleClickListener$default(adjustableMinerFeeButton, 0L, new TxSignerFragment$setup$8(this), 1, null);
        s<SigningSessionEvent> observeOn = getViewModel().getSignatureRequestEvents().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "viewModel.signatureRequestEvents\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null), null, null, new TxSignerFragment$setup$9(this), 3, null), this.disposeBag);
        s<SendConfirmationResult> observeOn2 = getViewModel().getSignConfirmationObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn2, "viewModel.signConfirmationObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(observeOn2, null, null, 3, null), null, null, new TxSignerFragment$setup$10(this), 3, null), this.disposeBag);
        s<PromptDialogHelper.Properties> observeOn3 = getViewModel().getPromptObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn3, "viewModel.promptObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn3, null, null, new TxSignerFragment$setup$11(this), 3, null), this.disposeBag);
        s<androidx.fragment.app.c> observeOn4 = getViewModel().getNavigationObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn4, "viewModel.navigationObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn4, null, null, new TxSignerFragment$setup$12(this), 3, null), this.disposeBag);
        s<AdjustableMinerFeeSelection> observeOn5 = getResultViewModel$app_productionRelease().getAdjustableMinerFeeResultObservable().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn5, "resultViewModel.adjustableMinerFeeResultObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(observeOn5, null, null, new TxSignerFragment$setup$13(this), 3, null), this.disposeBag);
        getViewModel().fetchReceiptInformation();
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public TxSignerViewModel getViewModel() {
        TxSignerViewModel txSignerViewModel = this.viewModel;
        if (txSignerViewModel != null) {
            return txSignerViewModel;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setViewModel(TxSignerViewModel txSignerViewModel) {
        kotlin.jvm.internal.m.g(txSignerViewModel, "<set-?>");
        this.viewModel = txSignerViewModel;
    }
}
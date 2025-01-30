package com.coinbase.wallet.features.swap.views;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.coinbase.wallet.application.view.custom.ProgressBarButtonWithSubtitle;
import com.coinbase.wallet.application.view.custom.ViewPagerHeader;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.models.SwapCurrencyType;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u000226\u0010\u0004\u001a2\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0018\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", "Lkotlin/x;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerFragment$setupObservers$1 extends o implements l<kotlin.o<? extends SwapAmountPickerViewState, ? extends x>, x> {
    final /* synthetic */ SwapAmountPickerFragment this$0;

    /* compiled from: SwapAmountPickerFragment.kt */
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
    public SwapAmountPickerFragment$setupObservers$1(SwapAmountPickerFragment swapAmountPickerFragment) {
        super(1);
        this.this$0 = swapAmountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends SwapAmountPickerViewState, ? extends x> oVar) {
        invoke2((kotlin.o<SwapAmountPickerViewState, x>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<SwapAmountPickerViewState, x> oVar) {
        SwapAmountPickerAdapter swapAmountPickerAdapter;
        long shortAnimDuration;
        SwapAmountPickerViewState a = oVar.a();
        swapAmountPickerAdapter = this.this$0.adapter;
        if (swapAmountPickerAdapter != null) {
            swapAmountPickerAdapter.updateFromModel(a);
            View view = this.this$0.getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.leftButtonText))).setText(a.getPickerItems().get(0));
            View view2 = this.this$0.getView();
            ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.rightButtonText))).setText(a.getPickerItems().get(1));
            View view3 = this.this$0.getView();
            ((NumberKeyboardInputView) (view3 == null ? null : view3.findViewById(e.j.a.h3))).setLocale(a.getNumpadLocale());
            View view4 = this.this$0.getView();
            View keyboard = view4 == null ? null : view4.findViewById(e.j.a.h3);
            m.f(keyboard, "keyboard");
            keyboard.setVisibility(a.isNumpadVisible() ^ true ? 4 : 0);
            View view5 = this.this$0.getView();
            ((ProgressBarButtonWithSubtitle) (view5 == null ? null : view5.findViewById(e.j.a.s4))).setTitleText(a.getNextButtonTitle());
            View view6 = this.this$0.getView();
            ((ProgressBarButtonWithSubtitle) (view6 == null ? null : view6.findViewById(e.j.a.s4))).setProgressBarIsVisible(a.isLoading());
            SwapAmountPickerFragment.updateNextButton$default(this.this$0, a.isNextButtonVisible(), false, 2, null);
            View view7 = this.this$0.getView();
            ((AppCompatButton) (view7 == null ? null : view7.findViewById(e.j.a.convertAll))).setEnabled(a.isConvertAllVisible());
            float f2 = a.isConvertAllVisible() ? 1.0f : 0.0f;
            View view8 = this.this$0.getView();
            ViewPropertyAnimator alpha = ((AppCompatButton) (view8 == null ? null : view8.findViewById(e.j.a.convertAll))).animate().alpha(f2);
            shortAnimDuration = this.this$0.getShortAnimDuration();
            alpha.setDuration(shortAnimDuration).start();
            int i2 = WhenMappings.$EnumSwitchMapping$0[a.getActiveCurrencyCard().ordinal()];
            if (i2 == 1) {
                View view9 = this.this$0.getView();
                if (((ViewPagerHeader) (view9 == null ? null : view9.findViewById(e.j.a.twoButtonSlider))).isTransitioning()) {
                    return;
                }
                View view10 = this.this$0.getView();
                ((ViewPagerHeader) (view10 != null ? view10.findViewById(e.j.a.twoButtonSlider) : null)).setProgress(0.0f);
                return;
            } else if (i2 != 2) {
                return;
            } else {
                View view11 = this.this$0.getView();
                if (((ViewPagerHeader) (view11 == null ? null : view11.findViewById(e.j.a.twoButtonSlider))).isTransitioning()) {
                    return;
                }
                View view12 = this.this$0.getView();
                ((ViewPagerHeader) (view12 != null ? view12.findViewById(e.j.a.twoButtonSlider) : null)).setProgress(1.0f);
                return;
            }
        }
        m.w("adapter");
        throw null;
    }
}
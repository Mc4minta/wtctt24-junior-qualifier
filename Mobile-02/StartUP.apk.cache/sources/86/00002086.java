package com.coinbase.wallet.features.send.views;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.CurrencyPickerView;
import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/o;", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupObservers$5 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Boolean, ? extends Boolean>, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupObservers$5(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    public static /* synthetic */ void a(AmountPickerFragment amountPickerFragment, boolean z) {
        m1403invoke$lambda1(amountPickerFragment, z);
    }

    public static /* synthetic */ void b(AmountPickerFragment amountPickerFragment, boolean z) {
        m1402invoke$lambda0(amountPickerFragment, z);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1402invoke$lambda0(AmountPickerFragment this$0, boolean z) {
        c.s.b autoTransition;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((CurrencyPickerView) (view == null ? null : view.findViewById(e.j.a.k1))).setInsufficientBalance(!z);
        View view2 = this$0.getView();
        View findViewById = view2 != null ? view2.findViewById(e.j.a.e1) : null;
        autoTransition = this$0.getAutoTransition();
        c.s.a0.b((ViewGroup) findViewById, autoTransition);
    }

    /* renamed from: invoke$lambda-1 */
    public static final void m1403invoke$lambda1(AmountPickerFragment this$0, boolean z) {
        c.s.b autoTransition;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((CurrencyPickerView) (view == null ? null : view.findViewById(e.j.a.k1))).setInsufficientBalance(!z);
        View view2 = this$0.getView();
        View findViewById = view2 != null ? view2.findViewById(e.j.a.e1) : null;
        autoTransition = this$0.getAutoTransition();
        c.s.a0.b((ViewGroup) findViewById, autoTransition);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends Boolean, ? extends Boolean> oVar) {
        invoke2((kotlin.o<Boolean, Boolean>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(kotlin.o<Boolean, Boolean> oVar) {
        long shortAnimDuration;
        ViewPropertyAnimator translationY;
        long shortAnimDuration2;
        long shortAnimDuration3;
        float nextButtonTranslateAmount;
        final boolean booleanValue = oVar.a().booleanValue();
        boolean booleanValue2 = oVar.b().booleanValue();
        View view = this.this$0.getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.s4))).setEnabled(!booleanValue2);
        if (booleanValue2) {
            View view2 = this.this$0.getView();
            View nextButton = view2 == null ? null : view2.findViewById(e.j.a.s4);
            kotlin.jvm.internal.m.f(nextButton, "nextButton");
            shortAnimDuration3 = this.this$0.getShortAnimDuration();
            View_CommonKt.animateOpacity$default(nextButton, 0.0f, shortAnimDuration3, null, 4, null);
            View view3 = this.this$0.getView();
            ViewPropertyAnimator animate = ((LinearLayout) (view3 != null ? view3.findViewById(e.j.a.e1) : null)).animate();
            final AmountPickerFragment amountPickerFragment = this.this$0;
            ViewPropertyAnimator withEndAction = animate.withEndAction(new Runnable() { // from class: com.coinbase.wallet.features.send.views.u
                @Override // java.lang.Runnable
                public final void run() {
                    AmountPickerFragment$setupObservers$5.b(AmountPickerFragment.this, booleanValue);
                }
            });
            nextButtonTranslateAmount = this.this$0.getNextButtonTranslateAmount();
            translationY = withEndAction.translationY(nextButtonTranslateAmount);
        } else {
            View view4 = this.this$0.getView();
            View nextButton2 = view4 == null ? null : view4.findViewById(e.j.a.s4);
            kotlin.jvm.internal.m.f(nextButton2, "nextButton");
            shortAnimDuration = this.this$0.getShortAnimDuration();
            View_CommonKt.animateOpacity$default(nextButton2, 1.0f, shortAnimDuration, null, 4, null);
            View view5 = this.this$0.getView();
            ViewPropertyAnimator animate2 = ((LinearLayout) (view5 != null ? view5.findViewById(e.j.a.e1) : null)).animate();
            final AmountPickerFragment amountPickerFragment2 = this.this$0;
            translationY = animate2.withStartAction(new Runnable() { // from class: com.coinbase.wallet.features.send.views.t
                @Override // java.lang.Runnable
                public final void run() {
                    AmountPickerFragment$setupObservers$5.a(AmountPickerFragment.this, booleanValue);
                }
            }).translationY(0.0f);
        }
        shortAnimDuration2 = this.this$0.getShortAnimDuration();
        translationY.setDuration(shortAnimDuration2).start();
    }
}
package com.coinbase.wallet.features.send.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.wallet.features.commonui.views.AmountSliderView;
import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "interestText", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupObservers$8 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupObservers$8(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    public static /* synthetic */ void a(AmountPickerFragment amountPickerFragment, String str) {
        m1405invoke$lambda2$lambda1(amountPickerFragment, str);
    }

    public static /* synthetic */ void b(AmountPickerFragment amountPickerFragment, String str) {
        m1404invoke$lambda2$lambda0(amountPickerFragment, str);
    }

    /* renamed from: invoke$lambda-2$lambda-0 */
    public static final void m1404invoke$lambda2$lambda0(AmountPickerFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.sendInterestText))).setText(str);
    }

    /* renamed from: invoke$lambda-2$lambda-1 */
    public static final void m1405invoke$lambda2$lambda1(AmountPickerFragment this$0, String interestText) {
        AmountSliderView amountSliderView;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.sendInterestText))).setText(interestText);
        amountSliderView = this$0.amountSliderView;
        if (amountSliderView == null) {
            return;
        }
        kotlin.jvm.internal.m.f(interestText, "interestText");
        amountSliderView.setDescriptionText(interestText);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x005f, code lost:
        r0 = r7.this$0.amountSliderView;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x006c  */
    /* renamed from: invoke */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(final java.lang.String r8) {
        /*
            r7 = this;
            com.coinbase.wallet.features.send.views.AmountPickerFragment r0 = r7.this$0
            com.coinbase.wallet.features.commonui.views.AmountSliderView r0 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getAmountSliderView$p(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r0 = r2
            goto L18
        Lc:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L14
            r0 = r1
            goto L15
        L14:
            r0 = r2
        L15:
            if (r0 != r1) goto La
            r0 = r1
        L18:
            r3 = 0
            java.lang.String r4 = "interestText"
            r5 = 0
            if (r0 == 0) goto L6c
            com.coinbase.wallet.features.send.views.AmountPickerFragment r0 = r7.this$0
            android.view.View r0 = r0.getView()
            if (r0 != 0) goto L28
            r0 = r5
            goto L2e
        L28:
            int r6 = e.j.a.sendInterestText
            android.view.View r0 = r0.findViewById(r6)
        L2e:
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.coinbase.wallet.features.send.views.AmountPickerFragment r6 = r7.this$0
            com.coinbase.wallet.features.commonui.views.AmountSliderView r6 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getAmountSliderView$p(r6)
            if (r6 != 0) goto L39
            goto L41
        L39:
            float r5 = r6.getCurrentValue()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
        L41:
            boolean r3 = kotlin.jvm.internal.m.b(r5, r3)
            if (r3 == 0) goto L4e
            com.coinbase.wallet.core.extensions.Strings r3 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r3 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r3)
            goto L4f
        L4e:
            r3 = r8
        L4f:
            r0.setText(r3)
            kotlin.jvm.internal.m.f(r8, r4)
            int r0 = r8.length()
            if (r0 <= 0) goto L5c
            goto L5d
        L5c:
            r1 = r2
        L5d:
            if (r1 == 0) goto Lc0
            com.coinbase.wallet.features.send.views.AmountPickerFragment r0 = r7.this$0
            com.coinbase.wallet.features.commonui.views.AmountSliderView r0 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getAmountSliderView$p(r0)
            if (r0 != 0) goto L68
            goto Lc0
        L68:
            r0.setDescriptionText(r8)
            goto Lc0
        L6c:
            kotlin.jvm.internal.m.f(r8, r4)
            int r0 = r8.length()
            if (r0 != 0) goto L77
            r0 = r1
            goto L78
        L77:
            r0 = r2
        L78:
            if (r0 == 0) goto L7b
            goto L7d
        L7b:
            r3 = 1065353216(0x3f800000, float:1.0)
        L7d:
            com.coinbase.wallet.features.send.views.AmountPickerFragment r0 = r7.this$0
            android.view.View r0 = r0.getView()
            if (r0 != 0) goto L86
            goto L8c
        L86:
            int r4 = e.j.a.sendInterestText
            android.view.View r5 = r0.findViewById(r4)
        L8c:
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.view.ViewPropertyAnimator r0 = r5.animate()
            android.view.ViewPropertyAnimator r0 = r0.alpha(r3)
            com.coinbase.wallet.features.send.views.AmountPickerFragment r3 = r7.this$0
            long r3 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getShortAnimDuration(r3)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r3)
            com.coinbase.wallet.features.send.views.AmountPickerFragment r3 = r7.this$0
            int r4 = r8.length()
            if (r4 != 0) goto La9
            goto Laa
        La9:
            r1 = r2
        Laa:
            if (r1 == 0) goto Lb5
            com.coinbase.wallet.features.send.views.w r1 = new com.coinbase.wallet.features.send.views.w
            r1.<init>()
            r0.withEndAction(r1)
            goto Lbd
        Lb5:
            com.coinbase.wallet.features.send.views.v r1 = new com.coinbase.wallet.features.send.views.v
            r1.<init>()
            r0.withStartAction(r1)
        Lbd:
            r0.start()
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.AmountPickerFragment$setupObservers$8.invoke2(java.lang.String):void");
    }
}
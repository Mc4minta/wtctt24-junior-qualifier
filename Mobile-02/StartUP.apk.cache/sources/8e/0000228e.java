package com.coinbase.wallet.features.swap.views;

import android.view.View;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(J)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerAdapter$resetCursorAnimations$1 extends o implements l<Long, x> {
    final /* synthetic */ SwapAmountPickerAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerAdapter$resetCursorAnimations$1(SwapAmountPickerAdapter swapAmountPickerAdapter) {
        super(1);
        this.this$0 = swapAmountPickerAdapter;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Long l2) {
        invoke2(l2);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Long l2) {
        View view;
        boolean z;
        View view2;
        boolean z2;
        view = this.this$0.cryptoItemView;
        if (view != null) {
            View findViewById = view.findViewById(e.j.a.topCursor);
            m.f(findViewById, "cryptoItemView.topCursor");
            z = this.this$0.isSourceCursorAnimating;
            boolean z3 = true;
            findViewById.setVisibility(z && ((l2.longValue() % 2) > 0L ? 1 : ((l2.longValue() % 2) == 0L ? 0 : -1)) == 0 ? 0 : 8);
            view2 = this.this$0.cryptoItemView;
            if (view2 != null) {
                View findViewById2 = view2.findViewById(e.j.a.bottomCursor);
                m.f(findViewById2, "cryptoItemView.bottomCursor");
                z2 = this.this$0.isTargetCursorAnimating;
                if (!z2 || l2.longValue() % 2 != 0) {
                    z3 = false;
                }
                findViewById2.setVisibility(z3 ? 0 : 8);
                return;
            }
            m.w("cryptoItemView");
            throw null;
        }
        m.w("cryptoItemView");
        throw null;
    }
}
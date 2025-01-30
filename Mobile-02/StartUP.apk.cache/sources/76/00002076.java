package com.coinbase.wallet.features.send.views;

import android.view.View;
import kotlin.Metadata;

/* compiled from: AmountFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountFragment$setupObservables$9 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
    final /* synthetic */ AmountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountFragment$setupObservables$9(AmountFragment amountFragment) {
        super(1);
        this.this$0 = amountFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
        invoke2(bool);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        View view = this.this$0.getView();
        View secondaryTextView = view == null ? null : view.findViewById(e.j.a.S5);
        kotlin.jvm.internal.m.f(secondaryTextView, "secondaryTextView");
        secondaryTextView.setVisibility(bool.booleanValue() ^ true ? 4 : 0);
    }
}
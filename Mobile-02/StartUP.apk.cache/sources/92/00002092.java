package com.coinbase.wallet.features.send.views;

import android.view.View;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/util/Locale;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/util/Locale;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$setupSendAmountView$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Locale, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupSendAmountView$1(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Locale locale) {
        invoke2(locale);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Locale it) {
        View view = this.this$0.getView();
        View findViewById = view == null ? null : view.findViewById(e.j.a.h3);
        kotlin.jvm.internal.m.f(it, "it");
        ((NumberKeyboardInputView) findViewById).setLocale(it);
    }
}
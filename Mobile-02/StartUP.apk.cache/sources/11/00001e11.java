package com.coinbase.wallet.features.commonui.views;

import android.widget.TextView;
import com.coinbase.wallet.commonui.utilities.Colors;
import com.coinbase.wallet.commonui.utilities.ColorsKt;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: AmountSliderView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountSliderView$onAttachedToWindow$1 extends o implements l<kotlin.o<? extends Float, ? extends Boolean>, x> {
    final /* synthetic */ AmountSliderView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountSliderView$onAttachedToWindow$1(AmountSliderView amountSliderView) {
        super(1);
        this.this$0 = amountSliderView;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends Float, ? extends Boolean> oVar) {
        invoke2((kotlin.o<Float, Boolean>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<Float, Boolean> oVar) {
        int i2;
        if (oVar.a().floatValue() > 0.0f) {
            i2 = ColorsKt.get(Colors.INSTANCE, R.color.primary_blue);
        } else {
            i2 = ColorsKt.get(Colors.INSTANCE, R.color.grey_50);
        }
        ((TextView) this.this$0.findViewById(e.j.a.sliderInterestText)).setTextColor(i2);
    }
}
package com.coinbase.wallet.features.send.views.adapters;

import android.view.View;
import android.widget.EditText;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFee1559PresetAdapter;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdjustableMinerFee1559PresetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559PresetAdapter$MinerFeeCustomHolder$bind$1 extends o implements l<View, x> {
    final /* synthetic */ AdjustableMinerFee1559PresetAdapter.MinerFeeCustomHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFee1559PresetAdapter$MinerFeeCustomHolder$bind$1(AdjustableMinerFee1559PresetAdapter.MinerFeeCustomHolder minerFeeCustomHolder) {
        super(1);
        this.this$0 = minerFeeCustomHolder;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        EditText editText;
        m.g(it, "it");
        editText = this.this$0.maxPriorityFeeField;
        editText.setText(Strings_CoreKt.getEmpty(Strings.INSTANCE));
    }
}
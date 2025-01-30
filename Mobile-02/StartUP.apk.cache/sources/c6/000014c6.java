package com.coinbase.wallet.commonui.utilities;

import android.content.DialogInterface;
import android.view.View;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: PromptDialogHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class PromptDialogHelper$create$2 extends o implements l<View, x> {
    final /* synthetic */ d0<DialogInterface> $dialogInterface;
    final /* synthetic */ PromptDialogHelper.Properties $properties;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptDialogHelper$create$2(PromptDialogHelper.Properties properties, d0<DialogInterface> d0Var) {
        super(1);
        this.$properties = properties;
        this.$dialogInterface = d0Var;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        m.g(it, "it");
        l<DialogInterface, x> shareClickListener$commonui_productionRelease = this.$properties.getShareClickListener$commonui_productionRelease();
        DialogInterface dialogInterface = this.$dialogInterface.a;
        if (dialogInterface != null) {
            shareClickListener$commonui_productionRelease.invoke(dialogInterface);
        } else {
            m.w("dialogInterface");
            throw null;
        }
    }
}
package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAssetPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAssetPickerFragment$onViewCreated$6 extends o implements l<kotlin.o<? extends String, ? extends SwapAsset>, x> {
    final /* synthetic */ SwapAssetPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerFragment$onViewCreated$6(SwapAssetPickerFragment swapAssetPickerFragment) {
        super(1);
        this.this$0 = swapAssetPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends String, ? extends SwapAsset> oVar) {
        invoke2((kotlin.o<String, SwapAsset>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<String, SwapAsset> oVar) {
        Fragment_CommonKt.hideKeyboard(this.this$0);
        Fragment_CommonKt.setNavigationResult(this.this$0, oVar.a(), oVar.b());
        Fragment_CommonKt.navigateUp(this.this$0);
    }
}
package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import java.math.BigInteger;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$AssetAndBalance;", "kotlin.jvm.PlatformType", "it", "", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel$AssetAndBalance;)Ljava/lang/Comparable;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$preselectAsset$1$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SwapAmountPickerViewModel.AssetAndBalance, Comparable<?>> {
    public static final SwapAmountPickerViewModel$preselectAsset$1$1 INSTANCE = new SwapAmountPickerViewModel$preselectAsset$1$1();

    SwapAmountPickerViewModel$preselectAsset$1$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final Comparable<?> invoke(SwapAmountPickerViewModel.AssetAndBalance assetAndBalance) {
        return Boolean.valueOf(assetAndBalance.getBalanceInFiat().compareTo(BigInteger.ZERO) > 0);
    }
}
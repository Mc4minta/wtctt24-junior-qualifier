package com.coinbase.wallet.features.swap.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapTrade;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: SwapConfirmationArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationArgs;", "", "Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;", SwapConfirmationArgs.currencyTypeKey, "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "sourceAsset", "targetAsset", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "Lcom/coinbase/wallet/swap/models/SwapTrade;", SwapConfirmationArgs.swapTradeKey, "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/features/swap/models/SwapCurrencyType;Lcom/coinbase/wallet/swap/models/AmountBase;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/blockchains/models/TransferValue;Lcom/coinbase/wallet/swap/models/SwapTrade;)Landroid/os/Bundle;", "", "sourceAssetKey", "Ljava/lang/String;", "amountKey", "swapTradeKey", "currencyTypeKey", "targetAssetKey", "amountBaseKey", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationArgs {
    public static final SwapConfirmationArgs INSTANCE = new SwapConfirmationArgs();
    public static final String amountBaseKey = "amountBase";
    public static final String amountKey = "amount";
    public static final String currencyTypeKey = "currencyType";
    public static final String sourceAssetKey = "sourceAsset";
    public static final String swapTradeKey = "swapTrade";
    public static final String targetAssetKey = "targetAsset";

    private SwapConfirmationArgs() {
    }

    public final Bundle createArguments(SwapCurrencyType currencyType, AmountBase amountBase, SwapAsset sourceAsset, SwapAsset targetAsset, TransferValue amount, SwapTrade swapTrade) {
        m.g(currencyType, "currencyType");
        m.g(amountBase, "amountBase");
        m.g(sourceAsset, "sourceAsset");
        m.g(targetAsset, "targetAsset");
        m.g(amount, "amount");
        m.g(swapTrade, "swapTrade");
        return b.a(u.a(currencyTypeKey, currencyType), u.a("amountBase", amountBase), u.a("sourceAsset", sourceAsset), u.a("targetAsset", targetAsset), u.a("amount", amount), u.a(swapTradeKey, swapTrade));
    }
}
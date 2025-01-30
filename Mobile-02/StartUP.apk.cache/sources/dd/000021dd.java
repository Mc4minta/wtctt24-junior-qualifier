package com.coinbase.wallet.features.swap.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.swap.models.AmountBase;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: SwapAssetPickerArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerArgs;", "", "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/swap/models/AmountBase;)Landroid/os/Bundle;", "", "amountBaseKey", "Ljava/lang/String;", "<init>", "()V", "Result", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerArgs {
    public static final SwapAssetPickerArgs INSTANCE = new SwapAssetPickerArgs();
    public static final String amountBaseKey = "amountBase";

    /* compiled from: SwapAssetPickerArgs.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerArgs$Result;", "", "", Result.targetSwapAssetKey, "Ljava/lang/String;", Result.sourceSwapAssetKey, "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Result {
        public static final Result INSTANCE = new Result();
        public static final String sourceSwapAssetKey = "sourceSwapAssetKey";
        public static final String targetSwapAssetKey = "targetSwapAssetKey";

        private Result() {
        }
    }

    private SwapAssetPickerArgs() {
    }

    public final Bundle createArguments(AmountBase amountBase) {
        m.g(amountBase, "amountBase");
        return b.a(u.a("amountBase", amountBase));
    }
}
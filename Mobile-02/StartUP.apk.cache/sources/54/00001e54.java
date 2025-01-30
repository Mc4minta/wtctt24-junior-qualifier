package com.coinbase.wallet.features.lend.extensions;

import com.toshi.model.local.room.Prompt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: PromptId+Lend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0017\u0010\b\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/toshi/model/local/room/Prompt$Id;", "", "getLendAssetsUnderCustodyInfo", "(Lcom/toshi/model/local/room/Prompt$Id;)Ljava/lang/String;", "lendAssetsUnderCustodyInfo", "getLendUtilizationInfo", "lendUtilizationInfo", "getLendMinCollateralInfo", "lendMinCollateralInfo", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PromptId_LendKt {
    public static final String getLendAssetsUnderCustodyInfo(Prompt.Id id) {
        m.g(id, "<this>");
        return "lendAssetsUnderCustodyInfoPrompt";
    }

    public static final String getLendMinCollateralInfo(Prompt.Id id) {
        m.g(id, "<this>");
        return "lendMinCollateralInfoPrompt";
    }

    public static final String getLendUtilizationInfo(Prompt.Id id) {
        m.g(id, "<this>");
        return "lendUtilizationInfoPrompt";
    }
}
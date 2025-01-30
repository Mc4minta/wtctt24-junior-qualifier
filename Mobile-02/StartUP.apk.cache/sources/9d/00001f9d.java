package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFee1559ViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "component1", "()Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "component2", "component3", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "component4", "()Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "slowPresetInfo", "normalPresetInfo", "fastPresetInfo", "customPresetInfo", "copy", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "getFastPresetInfo", "getNormalPresetInfo", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "getCustomPresetInfo", "getSlowPresetInfo", "<init>", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559ViewState {
    private final AdjustableMinerFee1559CustomViewInfoState customPresetInfo;
    private final AdjustableMinerFee1559ViewInfoState fastPresetInfo;
    private final AdjustableMinerFee1559ViewInfoState normalPresetInfo;
    private final AdjustableMinerFee1559ViewInfoState slowPresetInfo;

    public AdjustableMinerFee1559ViewState() {
        this(null, null, null, null, 15, null);
    }

    public AdjustableMinerFee1559ViewState(AdjustableMinerFee1559ViewInfoState slowPresetInfo, AdjustableMinerFee1559ViewInfoState normalPresetInfo, AdjustableMinerFee1559ViewInfoState fastPresetInfo, AdjustableMinerFee1559CustomViewInfoState customPresetInfo) {
        m.g(slowPresetInfo, "slowPresetInfo");
        m.g(normalPresetInfo, "normalPresetInfo");
        m.g(fastPresetInfo, "fastPresetInfo");
        m.g(customPresetInfo, "customPresetInfo");
        this.slowPresetInfo = slowPresetInfo;
        this.normalPresetInfo = normalPresetInfo;
        this.fastPresetInfo = fastPresetInfo;
        this.customPresetInfo = customPresetInfo;
    }

    public static /* synthetic */ AdjustableMinerFee1559ViewState copy$default(AdjustableMinerFee1559ViewState adjustableMinerFee1559ViewState, AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState, AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState2, AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState3, AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adjustableMinerFee1559ViewInfoState = adjustableMinerFee1559ViewState.slowPresetInfo;
        }
        if ((i2 & 2) != 0) {
            adjustableMinerFee1559ViewInfoState2 = adjustableMinerFee1559ViewState.normalPresetInfo;
        }
        if ((i2 & 4) != 0) {
            adjustableMinerFee1559ViewInfoState3 = adjustableMinerFee1559ViewState.fastPresetInfo;
        }
        if ((i2 & 8) != 0) {
            adjustableMinerFee1559CustomViewInfoState = adjustableMinerFee1559ViewState.customPresetInfo;
        }
        return adjustableMinerFee1559ViewState.copy(adjustableMinerFee1559ViewInfoState, adjustableMinerFee1559ViewInfoState2, adjustableMinerFee1559ViewInfoState3, adjustableMinerFee1559CustomViewInfoState);
    }

    public final AdjustableMinerFee1559ViewInfoState component1() {
        return this.slowPresetInfo;
    }

    public final AdjustableMinerFee1559ViewInfoState component2() {
        return this.normalPresetInfo;
    }

    public final AdjustableMinerFee1559ViewInfoState component3() {
        return this.fastPresetInfo;
    }

    public final AdjustableMinerFee1559CustomViewInfoState component4() {
        return this.customPresetInfo;
    }

    public final AdjustableMinerFee1559ViewState copy(AdjustableMinerFee1559ViewInfoState slowPresetInfo, AdjustableMinerFee1559ViewInfoState normalPresetInfo, AdjustableMinerFee1559ViewInfoState fastPresetInfo, AdjustableMinerFee1559CustomViewInfoState customPresetInfo) {
        m.g(slowPresetInfo, "slowPresetInfo");
        m.g(normalPresetInfo, "normalPresetInfo");
        m.g(fastPresetInfo, "fastPresetInfo");
        m.g(customPresetInfo, "customPresetInfo");
        return new AdjustableMinerFee1559ViewState(slowPresetInfo, normalPresetInfo, fastPresetInfo, customPresetInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFee1559ViewState) {
            AdjustableMinerFee1559ViewState adjustableMinerFee1559ViewState = (AdjustableMinerFee1559ViewState) obj;
            return m.c(this.slowPresetInfo, adjustableMinerFee1559ViewState.slowPresetInfo) && m.c(this.normalPresetInfo, adjustableMinerFee1559ViewState.normalPresetInfo) && m.c(this.fastPresetInfo, adjustableMinerFee1559ViewState.fastPresetInfo) && m.c(this.customPresetInfo, adjustableMinerFee1559ViewState.customPresetInfo);
        }
        return false;
    }

    public final AdjustableMinerFee1559CustomViewInfoState getCustomPresetInfo() {
        return this.customPresetInfo;
    }

    public final AdjustableMinerFee1559ViewInfoState getFastPresetInfo() {
        return this.fastPresetInfo;
    }

    public final AdjustableMinerFee1559ViewInfoState getNormalPresetInfo() {
        return this.normalPresetInfo;
    }

    public final AdjustableMinerFee1559ViewInfoState getSlowPresetInfo() {
        return this.slowPresetInfo;
    }

    public int hashCode() {
        return (((((this.slowPresetInfo.hashCode() * 31) + this.normalPresetInfo.hashCode()) * 31) + this.fastPresetInfo.hashCode()) * 31) + this.customPresetInfo.hashCode();
    }

    public String toString() {
        return "AdjustableMinerFee1559ViewState(slowPresetInfo=" + this.slowPresetInfo + ", normalPresetInfo=" + this.normalPresetInfo + ", fastPresetInfo=" + this.fastPresetInfo + ", customPresetInfo=" + this.customPresetInfo + ')';
    }

    public /* synthetic */ AdjustableMinerFee1559ViewState(AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState, AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState2, AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState3, AdjustableMinerFee1559CustomViewInfoState adjustableMinerFee1559CustomViewInfoState, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? AdjustableMinerFee1559ViewInfoState.Companion.loading(PresetSpeed.SLOW) : adjustableMinerFee1559ViewInfoState, (i2 & 2) != 0 ? AdjustableMinerFee1559ViewInfoState.Companion.loading(PresetSpeed.NORMAL) : adjustableMinerFee1559ViewInfoState2, (i2 & 4) != 0 ? AdjustableMinerFee1559ViewInfoState.Companion.loading(PresetSpeed.FAST) : adjustableMinerFee1559ViewInfoState3, (i2 & 8) != 0 ? (AdjustableMinerFee1559CustomViewInfoState) AdjustableMinerFee1559ViewInfoState.Companion.loading(PresetSpeed.CUSTOM) : adjustableMinerFee1559CustomViewInfoState);
    }
}
package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\t¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "component1", "()Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "component2", "component3", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "component4", "()Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "", "component5", "()Ljava/lang/String;", "slowPresetInfo", "normalPresetInfo", "fastPresetInfo", "customPresetInfo", "warningMessage", "copy", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;Ljava/lang/String;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getWarningMessage", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "getSlowPresetInfo", "getFastPresetInfo", "getNormalPresetInfo", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "getCustomPresetInfo", "<init>", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeViewState {
    private final AdjustableMinerFeeCustomViewInfoState customPresetInfo;
    private final AdjustableMinerFeeViewInfoState fastPresetInfo;
    private final AdjustableMinerFeeViewInfoState normalPresetInfo;
    private final AdjustableMinerFeeViewInfoState slowPresetInfo;
    private final String warningMessage;

    public AdjustableMinerFeeViewState() {
        this(null, null, null, null, null, 31, null);
    }

    public AdjustableMinerFeeViewState(AdjustableMinerFeeViewInfoState slowPresetInfo, AdjustableMinerFeeViewInfoState normalPresetInfo, AdjustableMinerFeeViewInfoState fastPresetInfo, AdjustableMinerFeeCustomViewInfoState customPresetInfo, String str) {
        m.g(slowPresetInfo, "slowPresetInfo");
        m.g(normalPresetInfo, "normalPresetInfo");
        m.g(fastPresetInfo, "fastPresetInfo");
        m.g(customPresetInfo, "customPresetInfo");
        this.slowPresetInfo = slowPresetInfo;
        this.normalPresetInfo = normalPresetInfo;
        this.fastPresetInfo = fastPresetInfo;
        this.customPresetInfo = customPresetInfo;
        this.warningMessage = str;
    }

    public static /* synthetic */ AdjustableMinerFeeViewState copy$default(AdjustableMinerFeeViewState adjustableMinerFeeViewState, AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState, AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState2, AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState3, AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adjustableMinerFeeViewInfoState = adjustableMinerFeeViewState.slowPresetInfo;
        }
        if ((i2 & 2) != 0) {
            adjustableMinerFeeViewInfoState2 = adjustableMinerFeeViewState.normalPresetInfo;
        }
        AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState4 = adjustableMinerFeeViewInfoState2;
        if ((i2 & 4) != 0) {
            adjustableMinerFeeViewInfoState3 = adjustableMinerFeeViewState.fastPresetInfo;
        }
        AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState5 = adjustableMinerFeeViewInfoState3;
        if ((i2 & 8) != 0) {
            adjustableMinerFeeCustomViewInfoState = adjustableMinerFeeViewState.customPresetInfo;
        }
        AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState2 = adjustableMinerFeeCustomViewInfoState;
        if ((i2 & 16) != 0) {
            str = adjustableMinerFeeViewState.warningMessage;
        }
        return adjustableMinerFeeViewState.copy(adjustableMinerFeeViewInfoState, adjustableMinerFeeViewInfoState4, adjustableMinerFeeViewInfoState5, adjustableMinerFeeCustomViewInfoState2, str);
    }

    public final AdjustableMinerFeeViewInfoState component1() {
        return this.slowPresetInfo;
    }

    public final AdjustableMinerFeeViewInfoState component2() {
        return this.normalPresetInfo;
    }

    public final AdjustableMinerFeeViewInfoState component3() {
        return this.fastPresetInfo;
    }

    public final AdjustableMinerFeeCustomViewInfoState component4() {
        return this.customPresetInfo;
    }

    public final String component5() {
        return this.warningMessage;
    }

    public final AdjustableMinerFeeViewState copy(AdjustableMinerFeeViewInfoState slowPresetInfo, AdjustableMinerFeeViewInfoState normalPresetInfo, AdjustableMinerFeeViewInfoState fastPresetInfo, AdjustableMinerFeeCustomViewInfoState customPresetInfo, String str) {
        m.g(slowPresetInfo, "slowPresetInfo");
        m.g(normalPresetInfo, "normalPresetInfo");
        m.g(fastPresetInfo, "fastPresetInfo");
        m.g(customPresetInfo, "customPresetInfo");
        return new AdjustableMinerFeeViewState(slowPresetInfo, normalPresetInfo, fastPresetInfo, customPresetInfo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFeeViewState) {
            AdjustableMinerFeeViewState adjustableMinerFeeViewState = (AdjustableMinerFeeViewState) obj;
            return m.c(this.slowPresetInfo, adjustableMinerFeeViewState.slowPresetInfo) && m.c(this.normalPresetInfo, adjustableMinerFeeViewState.normalPresetInfo) && m.c(this.fastPresetInfo, adjustableMinerFeeViewState.fastPresetInfo) && m.c(this.customPresetInfo, adjustableMinerFeeViewState.customPresetInfo) && m.c(this.warningMessage, adjustableMinerFeeViewState.warningMessage);
        }
        return false;
    }

    public final AdjustableMinerFeeCustomViewInfoState getCustomPresetInfo() {
        return this.customPresetInfo;
    }

    public final AdjustableMinerFeeViewInfoState getFastPresetInfo() {
        return this.fastPresetInfo;
    }

    public final AdjustableMinerFeeViewInfoState getNormalPresetInfo() {
        return this.normalPresetInfo;
    }

    public final AdjustableMinerFeeViewInfoState getSlowPresetInfo() {
        return this.slowPresetInfo;
    }

    public final String getWarningMessage() {
        return this.warningMessage;
    }

    public int hashCode() {
        int hashCode = ((((((this.slowPresetInfo.hashCode() * 31) + this.normalPresetInfo.hashCode()) * 31) + this.fastPresetInfo.hashCode()) * 31) + this.customPresetInfo.hashCode()) * 31;
        String str = this.warningMessage;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AdjustableMinerFeeViewState(slowPresetInfo=" + this.slowPresetInfo + ", normalPresetInfo=" + this.normalPresetInfo + ", fastPresetInfo=" + this.fastPresetInfo + ", customPresetInfo=" + this.customPresetInfo + ", warningMessage=" + ((Object) this.warningMessage) + ')';
    }

    public /* synthetic */ AdjustableMinerFeeViewState(AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState, AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState2, AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState3, AdjustableMinerFeeCustomViewInfoState adjustableMinerFeeCustomViewInfoState, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? AdjustableMinerFeeViewInfoState.Companion.loading(PresetSpeed.SLOW) : adjustableMinerFeeViewInfoState, (i2 & 2) != 0 ? AdjustableMinerFeeViewInfoState.Companion.loading(PresetSpeed.NORMAL) : adjustableMinerFeeViewInfoState2, (i2 & 4) != 0 ? AdjustableMinerFeeViewInfoState.Companion.loading(PresetSpeed.FAST) : adjustableMinerFeeViewInfoState3, (i2 & 8) != 0 ? (AdjustableMinerFeeCustomViewInfoState) AdjustableMinerFeeViewInfoState.Companion.loading(PresetSpeed.CUSTOM) : adjustableMinerFeeCustomViewInfoState, (i2 & 16) != 0 ? null : str);
    }
}
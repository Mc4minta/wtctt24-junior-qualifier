package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAccountViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JB\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "readyToTransferText", "readyToTransferExplanationText", "startTransferBtnText", "transferLaterBtnText", "subtitleText", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerSplashScreenState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReadyToTransferExplanationText", "getReadyToTransferText", "getSubtitleText", "getStartTransferBtnText", "getTransferLaterBtnText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSplashScreenState {
    private final String readyToTransferExplanationText;
    private final String readyToTransferText;
    private final String startTransferBtnText;
    private final String subtitleText;
    private final String transferLaterBtnText;

    public ConsumerSplashScreenState() {
        this(null, null, null, null, null, 31, null);
    }

    public ConsumerSplashScreenState(String readyToTransferText, String readyToTransferExplanationText, String startTransferBtnText, String transferLaterBtnText, String subtitleText) {
        m.g(readyToTransferText, "readyToTransferText");
        m.g(readyToTransferExplanationText, "readyToTransferExplanationText");
        m.g(startTransferBtnText, "startTransferBtnText");
        m.g(transferLaterBtnText, "transferLaterBtnText");
        m.g(subtitleText, "subtitleText");
        this.readyToTransferText = readyToTransferText;
        this.readyToTransferExplanationText = readyToTransferExplanationText;
        this.startTransferBtnText = startTransferBtnText;
        this.transferLaterBtnText = transferLaterBtnText;
        this.subtitleText = subtitleText;
    }

    public static /* synthetic */ ConsumerSplashScreenState copy$default(ConsumerSplashScreenState consumerSplashScreenState, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerSplashScreenState.readyToTransferText;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerSplashScreenState.readyToTransferExplanationText;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = consumerSplashScreenState.startTransferBtnText;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = consumerSplashScreenState.transferLaterBtnText;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = consumerSplashScreenState.subtitleText;
        }
        return consumerSplashScreenState.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.readyToTransferText;
    }

    public final String component2() {
        return this.readyToTransferExplanationText;
    }

    public final String component3() {
        return this.startTransferBtnText;
    }

    public final String component4() {
        return this.transferLaterBtnText;
    }

    public final String component5() {
        return this.subtitleText;
    }

    public final ConsumerSplashScreenState copy(String readyToTransferText, String readyToTransferExplanationText, String startTransferBtnText, String transferLaterBtnText, String subtitleText) {
        m.g(readyToTransferText, "readyToTransferText");
        m.g(readyToTransferExplanationText, "readyToTransferExplanationText");
        m.g(startTransferBtnText, "startTransferBtnText");
        m.g(transferLaterBtnText, "transferLaterBtnText");
        m.g(subtitleText, "subtitleText");
        return new ConsumerSplashScreenState(readyToTransferText, readyToTransferExplanationText, startTransferBtnText, transferLaterBtnText, subtitleText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerSplashScreenState) {
            ConsumerSplashScreenState consumerSplashScreenState = (ConsumerSplashScreenState) obj;
            return m.c(this.readyToTransferText, consumerSplashScreenState.readyToTransferText) && m.c(this.readyToTransferExplanationText, consumerSplashScreenState.readyToTransferExplanationText) && m.c(this.startTransferBtnText, consumerSplashScreenState.startTransferBtnText) && m.c(this.transferLaterBtnText, consumerSplashScreenState.transferLaterBtnText) && m.c(this.subtitleText, consumerSplashScreenState.subtitleText);
        }
        return false;
    }

    public final String getReadyToTransferExplanationText() {
        return this.readyToTransferExplanationText;
    }

    public final String getReadyToTransferText() {
        return this.readyToTransferText;
    }

    public final String getStartTransferBtnText() {
        return this.startTransferBtnText;
    }

    public final String getSubtitleText() {
        return this.subtitleText;
    }

    public final String getTransferLaterBtnText() {
        return this.transferLaterBtnText;
    }

    public int hashCode() {
        return (((((((this.readyToTransferText.hashCode() * 31) + this.readyToTransferExplanationText.hashCode()) * 31) + this.startTransferBtnText.hashCode()) * 31) + this.transferLaterBtnText.hashCode()) * 31) + this.subtitleText.hashCode();
    }

    public String toString() {
        return "ConsumerSplashScreenState(readyToTransferText=" + this.readyToTransferText + ", readyToTransferExplanationText=" + this.readyToTransferExplanationText + ", startTransferBtnText=" + this.startTransferBtnText + ", transferLaterBtnText=" + this.transferLaterBtnText + ", subtitleText=" + this.subtitleText + ')';
    }

    public /* synthetic */ ConsumerSplashScreenState(String str, String str2, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (i2 & 2) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2, (i2 & 4) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str3, (i2 & 8) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str4, (i2 & 16) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str5);
    }
}